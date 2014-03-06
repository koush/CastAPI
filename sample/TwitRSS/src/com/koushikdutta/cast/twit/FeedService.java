package com.koushikdutta.cast.twit;

import android.net.Uri;

import com.koushikdutta.cast.api.AllCastMediaService;

/**
 * Created by koush on 3/4/14.
 */
public class FeedService extends AllCastMediaService {
    public FeedService() {
        super(Uri.parse("content://com.koushikdutta.cast.twit"));
    }
}
