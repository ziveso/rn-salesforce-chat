package com.rn.salesforce.chat;

import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.salesforce.android.chat.ui.AppLinkClickListener;
import com.salesforce.android.chat.ui.ChatUIClient;

public class ChatAppLinkClickListener implements AppLinkClickListener {
    private ChatUIClient mUIClient;
    private ReactApplicationContext reactContext;

    public ChatAppLinkClickListener(ReactApplicationContext reactContext) {
        this.reactContext = reactContext;
    }

    @Override
    public void didReceiveAppEventWithURL(@NonNull String url) {
        mUIClient.minimize();
        Intent intent = new Intent(reactContext, reactContext.getCurrentActivity().getClass());
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("rms://" + url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        reactContext.getApplicationContext().startActivity(intent);
    }

    public void setUIClient(ChatUIClient uiClient) {
        this.mUIClient = uiClient;
    }
}
