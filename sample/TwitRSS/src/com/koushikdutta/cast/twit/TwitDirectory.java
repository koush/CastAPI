package com.koushikdutta.cast.twit;

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
public class TwitDirectory extends AllCastProvider {
    public TwitDirectory() {
        super(AllCastProviderType.GALLERY);
    }

    final static Hashtable<String, String> twits = new Hashtable<String, String>();
    static {
        twits.put("aaa", "All About Android (Video-HD)");
        twits.put("byb", "Before You Buy (Video-HD)");
        twits.put("code", "Coding 101 (Video-HD)");
        twits.put("dgw", "The Giz Wiz (Video-HD)");
        twits.put("floss", "FLOSS Weekly (Video-HD)");
        twits.put("fr", "Frame Rate (Video-HD)");
        twits.put("hn", "Ham Nation (Video-HD)");
        twits.put("htg", "Home Theater Geeks (Video-HD)");
        twits.put("ifive", "iFive for the iPhone (Video-HD)");
        twits.put("kh", "Know How... (Video-HD)");
        twits.put("mbw", "MacBreak Weekly (Video-HD)");
        twits.put("nsfw", "NSFW (Video-HD)");
        twits.put("omgcraft", "OMGcraft (Video-HD)");
        twits.put("sn", "Security Now (Video-HD)");
        twits.put("tnt", "Tech News Today (Video-HD)");
        twits.put("tn2n", "Tech News 2Night (Video-HD)");
        twits.put("tsh", "The Social Hour (Video-HD)");
        twits.put("ttg", "The Tech Guy (Video-HD)");
        twits.put("twich", "This Week in Computer Hardware (Video-HD)");
        twits.put("twiet", "This Week in Enterprise Tech (Video-HD)");
        twits.put("twig", "This Week in Google (Video-HD)");
        twits.put("twil", "This Week in Law (Video-HD)");
        twits.put("twit", "This Week in Tech (Video-HD)");
        twits.put("tri", "Triangulation (Video-HD)");
        twits.put("specials", "TWiT Live Specials (Video-HD)");
        twits.put("ww", "Windows Weekly (Video-HD)");
    }

    @Override
    protected Collection<AllCastMediaItem> getMediaItems(Uri uri) {
        ArrayList<AllCastMediaItem> feeds = new ArrayList<AllCastMediaItem>();
        for (String twit: twits.keySet()) {
            feeds.add(new AllCastMediaItem()
            .setTitle(twits.get(twit))
            .setContentUrl("content://com.koushikdutta.cast.twit.show/" + twit)
            .setThumbnailUrl(String.format("http://feeds.twit.tv/coverart/%s300.jpg", twit)));
        }
        return feeds;
    }
}
