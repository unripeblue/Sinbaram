package com.tje.sinbaram.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by the on 2017-12-07.
 */

public class MyFCMIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Log.d("새 토큰값", FirebaseInstanceId.getInstance().getToken());
    }
}
