package com.koushikdutta.cast.api;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * Created by koush on 3/4/14.
 */
public class AllCastMediaService extends Service {
    Uri providerUri;
    public AllCastMediaService(Uri providerUri) {
        this.providerUri = providerUri;
    }

    public Uri getProviderUri() {
        return providerUri;
    }

    IAllCastMediaService stub = new IAllCastMediaService.Stub() {
        @Override
        public Uri getProviderUri() throws RemoteException {
            return providerUri;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return stub.asBinder();
    }
}
