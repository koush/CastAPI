package com.koushikdutta.cast.api;

import android.content.ContentValues;
import android.provider.MediaStore;

/**
 * Created by koush on 3/4/14.
 */
public class AllCastMediaItem {
    public static final String MIMETYPE_ALBUM = "x-application/album";

    public static final String COLUMN_TITLE = MediaStore.Video.Media.TITLE;
    public static final String COLUMN_DESCRIPTION = MediaStore.Video.Media.DESCRIPTION;
    public static final String COLUMN_THUMBNAIL_URL = "thumbnail";
    public static final String COLUMN_BACKDROP_URL = "backdrop";
    public static final String COLUMN_CONTENT_URL = MediaStore.Video.Media.DATA;
    public static final String COLUMN_DURATION = MediaStore.Video.Media.DURATION;
    public static final String COLUMN_SIZE = MediaStore.Video.Media.SIZE;
    public static final String COLUMN_MIME_TYPE = MediaStore.Video.Media.MIME_TYPE;
    public static final String COLUMN_SUBTITLES = "subtitles";
    public static final String COLUMN_SERIES = "series";

    ContentValues values = new ContentValues();

    private void put(String key, String value) {
        if (value == null)
            values.remove(key);
        else
            values.put(key, value);
    }

    private void put(String key, Long value) {
        if (value == null)
            values.remove(key);
        else
            values.put(key, value);
    }

    public String getThumbnailUrl() {
        return values.getAsString(COLUMN_THUMBNAIL_URL);
    }
    public AllCastMediaItem setThumbnailUrl(String thumbnailUrl) {
        put(COLUMN_THUMBNAIL_URL, thumbnailUrl);
        return this;
    }
    public String getBackdropUrl() {
        return values.getAsString(COLUMN_BACKDROP_URL);
    }
    public AllCastMediaItem setBackdropUrl(String backdropUrl) {
        put(COLUMN_BACKDROP_URL, backdropUrl);
        return this;
    }
    public String getContentUrl() {
        return values.getAsString(COLUMN_CONTENT_URL);
    }
    public AllCastMediaItem setContentUrl(String contentUrl) {
        put(COLUMN_CONTENT_URL, contentUrl);
        return this;
    }
    public String getTitle() {
        return values.getAsString(COLUMN_TITLE);
    }
    public AllCastMediaItem setTitle(String title) {
        put(COLUMN_TITLE, title);
        return this;
    }
    public String getDuration() {
        return values.getAsString(COLUMN_DURATION);
    }
    public AllCastMediaItem setDuration(String duration) {
        put(COLUMN_DURATION, duration);
        return this;
    }
    public Long getSize() {
        return values.getAsLong(COLUMN_SIZE);
    }
    public AllCastMediaItem setSize(Long size) {
        put(COLUMN_SIZE, size);
        return this;
    }
    public String getDescription() {
        return values.getAsString(COLUMN_DESCRIPTION);
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
        return values.getAsString(COLUMN_MIME_TYPE);
    }
    public AllCastMediaItem setSubtitles(String subtitles) {
        put(COLUMN_SUBTITLES, subtitles);
        return this;
    }
    public String getSubtitles() {
        return values.getAsString(COLUMN_SUBTITLES);
    }
    public AllCastMediaItem setSeries(String series) {
        put(COLUMN_SERIES, series);
        return this;
    }
    public String getSeries() {
        return values.getAsString(COLUMN_SERIES);
    }

    public static AllCastMediaItem fromContentValues(ContentValues values) {
        AllCastMediaItem item = new AllCastMediaItem();
        item.values.putAll(values);
        return item;
    }
    public ContentValues toContentValues() {
        return values;
    }
}
