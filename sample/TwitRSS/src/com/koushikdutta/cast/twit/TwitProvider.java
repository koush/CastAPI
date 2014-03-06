package com.koushikdutta.cast.twit;

import android.net.Uri;

import com.koushikdutta.cast.api.AllCastRSSProvider;

/**
 * Created by koush on 3/4/14.
 */
public class TwitProvider extends AllCastRSSProvider {
    @Override
    protected String getRssUrlFromContentUri(Uri uri) {
        // parse out the twit code
        String code = uri.getPath().replace("/", "");
        return String.format("http://feeds.twit.tv/%s_video_hd.xml", code);
    }
}
