package com.koushikdutta.cast.twit;

import android.net.Uri;

import com.koushikdutta.cast.api.AllCastMediaItem;
import com.koushikdutta.cast.api.AllCastProvider;
import com.koushikdutta.cast.api.AllCastProviderCategory;
import com.koushikdutta.cast.api.AllCastProviderLayout;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by koush on 3/5/14.
 */
public class FeedDirectory extends AllCastProvider {
    @Override
    protected AllCastProviderLayout getLayout() {
        return AllCastProviderLayout.GRID;
    }

    @Override
    protected AllCastProviderCategory getCategory() {
        return AllCastProviderCategory.RSS;
    }

    final static ArrayList<String> feeds = new ArrayList<String>();
    static {
        feeds.add("aaa");
        feeds.add("byb");
        feeds.add("code");
        feeds.add("dgw");
        feeds.add("floss");
        feeds.add("fr");
        feeds.add("hn");
        feeds.add("htg");
        feeds.add("ifive");
        feeds.add("kh");
        feeds.add("mbw");
        feeds.add("nsfw");
        feeds.add("omgcraft");
        feeds.add("sn");
        feeds.add("tnt");
        feeds.add("tn2n");
        feeds.add("tsh");
        feeds.add("ttg");
        feeds.add("twich");
        feeds.add("twiet");
        feeds.add("twig");
        feeds.add("twil");
        feeds.add("twit");
        feeds.add("tri");
        feeds.add("specials");
        feeds.add("ww");
    }

    @Override
    protected Collection<AllCastMediaItem> getMediaItems(Uri uri) {
        ArrayList<AllCastMediaItem> feeds = new ArrayList<AllCastMediaItem>();
        for (String twit: FeedDirectory.feeds) {
            feeds.add(new AllCastMediaItem()
            .setContentUrl("content://com.koushikdutta.cast.twit.show/" + twit)
            .setThumbnailUrl(String.format("http://feeds.twit.tv/coverart/%s300.jpg", twit)));
        }
        return feeds;
    }
}
