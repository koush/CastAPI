package com.koushikdutta.cast.revision3;

import android.net.Uri;

import com.koushikdutta.cast.api.AllCastMediaItem;
import com.koushikdutta.cast.api.AllCastProvider;
import com.koushikdutta.cast.api.AllCastProviderType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

/**
 * Created by koush on 3/5/14.
 */
public class FeedDirectory extends AllCastProvider {
    public FeedDirectory() {
        super(AllCastProviderType.GALLERY);
    }

    final static ArrayList<String> feeds = new ArrayList<String>();
    static {
        feeds.add("technobuffalo");
        feeds.add("geekbeattv");
        feeds.add("variant");
        feeds.add("philipdefranco");
        feeds.add("sourcefednerd");
        feeds.add("rev3gamesoriginals");
        feeds.add("geekbeattv");
        feeds.add("androidauthority");
        feeds.add("sourcefednerd");
        feeds.add("hak5");
        feeds.add("technobuffalo");
        feeds.add("whatsthebigdeal");
        feeds.add("philipdefranco");
        feeds.add("sourcefednerd");
        feeds.add("philipdefranco");
        feeds.add("sourcefednerd");
        feeds.add("internetrabbithole");
        feeds.add("rev3gamesreviews");
        feeds.add("technobuffalo");
        feeds.add("geekbeattv");
        feeds.add("sesslerssomething");
        feeds.add("filmriot");
        feeds.add("sourcefednerd");
        feeds.add("amplified");
        feeds.add("sourcefednerd");

    }

    @Override
    protected Collection<AllCastMediaItem> getMediaItems(Uri uri) {
        ArrayList<AllCastMediaItem> feeds = new ArrayList<AllCastMediaItem>();
        for (String feed: FeedDirectory.feeds) {
            feeds.add(new AllCastMediaItem()
            .setContentUrl("content://com.koushikdutta.cast.revision3.show/" + feed)
            .setThumbnailUrl(String.format("http://feeds.twit.tv/coverart/%s300.jpg", feed)));
        }
        return feeds;
    }
}
