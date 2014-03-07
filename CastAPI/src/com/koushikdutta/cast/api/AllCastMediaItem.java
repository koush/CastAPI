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
    public static final String COLUMN_MIME_TYPE = MediaStore.Video.Media.MIME_TYPE;

    // use content values instead?
    Hashtable<String, String> values = new Hashtable<String, String>();

    private void put(String key, String value) {
        if (value == null)
            values.remove(key);
        else
            values.put(key, value);
    }

    public String getThumbnailUrl() {
        return values.get(COLUMN_THUMBNAIL_URL);
    }
    public AllCastMediaItem setThumbnailUrl(String thumbnailUrl) {
        put(COLUMN_THUMBNAIL_URL, thumbnailUrl);
        return this;
    }
    public String getContentUrl() {
        return values.get(COLUMN_CONTENT_URL);
    }
    public AllCastMediaItem setContentUrl(String contentUrl) {
        put(COLUMN_CONTENT_URL, contentUrl);
        return this;
    }
    public String getTitle() {
        return values.get(COLUMN_TITLE);
    }
    public AllCastMediaItem setTitle(String title) {
        put(COLUMN_TITLE, title);
        return this;
    }
    public String getDuration() {
        return values.get(COLUMN_DURATION);
    }
    public AllCastMediaItem setDuration(String duration) {
        put(COLUMN_DURATION, duration);
        return this;
    }
    public String getDescription() {
        return values.get(COLUMN_DESCRIPTION);
    }
    public AllCastMediaItem setDescription(String description) {
        put(COLUMN_DESCRIPTION, description);
        return this;
    }
    public AllCastMediaItem setMimeType(String mimeType) {
        put(COLUMN_MIME_TYPE, mimeType);
        return this;
    }
    public String getMimeType() {
        return values.get(COLUMN_MIME_TYPE);
    }
}
