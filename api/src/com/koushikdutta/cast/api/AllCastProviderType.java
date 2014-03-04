package com.koushikdutta.cast.api;

/**
 * Created by koush on 3/4/14.
 */
public enum AllCastProviderType {
    /**
     * Provider type that contains only vidoes. This provider will
     * have a list presentation within AllCast.
     */
    VIDEO,
    /**
     * Provider type that is mixed media: pictures and videos.
     * This provider type will have a grid presentation within AllCast.
     */
    GALLERY,
    /**
     * Provider type that is only audio. This provider will have
     * the media player presentation within AllCast.
     */
    AUDIO;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
