package com.koushikdutta.cast.api;

import android.provider.MediaStore;

import java.util.Hashtable;

/**
 * Created by koush on 3/4/14.
 */
public class AllCastMediaItem {
    public static final String COLUMN_TITLE = MediaStore.Video.Media.TITLE;
    public static final String COLUMN_DESCRIPTION = MediaStore.Video.Media.DESCRIPTION;
    public static final String COLUMN_THUMBNAIL_URL = "thumbnail";
    public static final String COLUMN_CONTENT_URL = MediaStore.Video.Media.DATA;
    public static final String COLUMN_DURATION = MediaStore.Video.Media.DURATION;

    // use content values instead?
    Hashtable<String, String> values = new Hashtable<String, String>();

    public String getThumbnailUrl() {
        return values.get(COLUMN_THUMBNAIL_URL);
    }
    public AllCastMediaItem setThumbnailUrl(String thumbnailUrl) {
        values.put(COLUMN_THUMBNAIL_URL, thumbnailUrl);
        return this;
    }
    public String getContentUrl() {
        return values.get(COLUMN_CONTENT_URL);
    }
    public AllCastMediaItem setContentUrl(String contentUrl) {
        values.put(COLUMN_CONTENT_URL, contentUrl);
        return this;
    }
    public String getTitle() {
        return values.get(COLUMN_TITLE);
    }
    public AllCastMediaItem setTitle(String title) {
        values.put(COLUMN_TITLE, title);
        return this;
    }
    public String getDuration() {
        return values.get(COLUMN_DURATION);
    }
    public AllCastMediaItem setDurationMs(String duration) {
        values.put(COLUMN_DURATION, duration);
        return this;
    }
    public String getDescription() {
        return values.get(COLUMN_DESCRIPTION);
    }
    public AllCastMediaItem setDescription(String description) {
        values.put(COLUMN_DESCRIPTION, description);
        return this;
    }
}
