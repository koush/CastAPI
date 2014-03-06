package com.koushikdutta.cast.api;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by koush on 3/4/14.
 */
public abstract class AllCastRSSProvider extends AllCastProvider {
    public AllCastRSSProvider() {
        super(AllCastProviderType.VIDEO);
    }

    private static class AllCastRSSItem extends AllCastMediaItem {
        Node node;
        public AllCastRSSItem(Node node) {
            this.node = node;

            setTitle(getChildText("title"));
            setDescription(getChildText("itunes:subtitle"));
            setContentUrl(getChildText("link"));
            setDurationMs(getChildText("itunes:duration"));
        }

        String getChildText(String child) {
            return AllCastRSSProvider.getChildText(node, child);
        }
    }

    protected Collection<AllCastMediaItem> parseDocument(Document document) {
        Node rss = findNode(document, "rss");
        Node channel = findNode(rss, "channel");
        ArrayList<AllCastMediaItem> items = new ArrayList<AllCastMediaItem>();
        Node image = findNode(channel, "image");
        String imageUrl = getChildText(image, "url");
        for (int i = 0; i < channel.getChildNodes().getLength(); i++) {
            Node item = channel.getChildNodes().item(i);
            if (TextUtils.equals(item.getNodeName(), "item"))
                items.add(new AllCastRSSItem(item)
                .setThumbnailUrl(imageUrl));
        }
        return items;
    }

    private static String getChildText(Node node, String child) throws DOMException {
        Node childNode = findNode(node, child);
        if (childNode == null)
            return null;
        return childNode.getTextContent();
    }

    private static Node findNode(Node node, String name) {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node child = node.getChildNodes().item(i);
            if (TextUtils.equals(child.getNodeName(), name))
                return child;
        }
        return null;
    }

    protected abstract String getRssUrlFromContentUri(Uri uri);

    @Override
    protected Collection<AllCastMediaItem> getMediaItems(Uri uri) {
        try {
            URL url = new URL(getRssUrlFromContentUri(uri));
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            InputStream inputStream = connection.getInputStream();
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                return parseDocument(db.parse(inputStream));
            }
            finally {
                inputStream.close();
            }
        }
        catch (ParserConfigurationException e) {
            throw new AssertionError("failed to create xml doc");
        }
        catch (SAXException e) {
            Log.e(getClass().getName(), "Failed to parse RSS");
            return null;
        }
        catch (IOException e) {
            Log.e(getClass().getName(), "Failed to load RSS");
            return null;
        }
    }
}
