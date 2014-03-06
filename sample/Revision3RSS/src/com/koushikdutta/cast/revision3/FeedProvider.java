package com.koushikdutta.cast.revision3;

import android.net.Uri;

import com.koushikdutta.cast.api.AllCastRSSProvider;

/**
 * Created by koush on 3/4/14.
 */
public class FeedProvider extends AllCastRSSProvider {
    @Override
    protected String getRssUrlFromContentUri(Uri uri) {
        // parse out the twit code
        String code = uri.getPath().replace("/", "");
        return String.format("http://revision3.com/%s/feed/mp4-large", code);
    }
}
