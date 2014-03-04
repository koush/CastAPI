package com.koushikdutta.cast.api;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by koush on 3/4/14.
 */
public class AllCastProvider extends ContentProvider {
    private AllCastProviderType type;
    public AllCastProvider(AllCastProviderType type) {
        if (type == null)
            throw new IllegalArgumentException("must provide an AllCastProviderType");
        this.type = type;
    }

    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/com.koushikdutta.cast." + type.toString();
    }

    // provider is read only
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    // provider is read only
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    // provider is read only
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
