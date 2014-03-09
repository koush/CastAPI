package com.koushikdutta.cast.api;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by koush on 3/4/14.
 */
public abstract class AllCastProvider extends ContentProvider {
    public static final String[] DEFAULT_PROJECTION = new String[] {
        AllCastMediaItem.COLUMN_TITLE,
        AllCastMediaItem.COLUMN_DESCRIPTION,
        AllCastMediaItem.COLUMN_THUMBNAIL_URL,
        AllCastMediaItem.COLUMN_CONTENT_URL,
        AllCastMediaItem.COLUMN_MIME_TYPE,
        AllCastMediaItem.COLUMN_DURATION,
    };

    protected abstract AllCastProviderLayout getLayout();
    protected AllCastProviderLayout getLayout(Uri uri) {
        return getLayout();
    }

    protected AllCastProviderCategory getCategory() {
        return AllCastProviderCategory.OTHER;
    }

    @Override
    public Bundle call(String method, String arg, Bundle extras) {
        if (AllCastProviderMethod.valueOf(method) == AllCastProviderMethod.GET_PROVIDER_INFO) {
            Bundle ret = new Bundle();
            ret.putString(AllCastProviderMethod.EXTRA_TYPE, getLayout((Uri)extras.getParcelable("uri")).toString());
            ret.putBoolean(AllCastProviderMethod.EXTRA_ENABLED, isEnabled());
            ret.putString(AllCastProviderMethod.EXTRA_CATEGORY, getCategory().toString());
            return ret;
        }

        return super.call(method, arg, extras);
    }

    protected boolean isEnabled() {
        return true;
    }

    @Override
    final public boolean onCreate() {
        return true;
    }

    protected abstract Collection<AllCastMediaItem> getMediaItems(Uri uri);

    @Override
    final public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (projection == null)
            projection = DEFAULT_PROJECTION;
        MatrixCursor cursor = new MatrixCursor(projection);
        for (AllCastMediaItem item: getMediaItems(uri)) {
            ArrayList<String> projectionValues = new ArrayList<String>();
            for (String column: projection) {
                projectionValues.add(item.values.get(column));
            }
            cursor.addRow(projectionValues);
        }
        return cursor;
    }

    @Override
    final public String getType(Uri uri) {
        return "vnd.android.cursor.dir/com.koushikdutta.cast";
    }

    // provider is read only
    @Override
    final public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    // provider is read only
    @Override
    final public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    // provider is read only
    @Override
    final public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
