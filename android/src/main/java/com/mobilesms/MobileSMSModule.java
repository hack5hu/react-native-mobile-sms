package com.mobilesms;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import android.telephony.SmsManager;
import android.util.Log;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MobileSMSModule extends ReactContextBaseJavaModule {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    public MobileSMSModule(ReactApplicationContext reactContext) {
        super(reactContext); // required by React Native
    }

    @Override
    public String getName() {
        return "MobileSms";
    }

    @ReactMethod
    public void sendDirectSms(String phoneNumber, String msg, Promise promise) {
        if (ContextCompat.checkSelfPermission(getCurrentActivity(), android.Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            Log.d("MobileSMSModule", "Permission not granted. Requesting permission.");
            promise.reject("PERMISSION_NOT_GRANTED", "Permission not granted");
            ActivityCompat.requestPermissions(getCurrentActivity(), new String[]{android.Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
            return;
        }

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, msg, null, null);
            Log.d("MobileSMSModule", "Message sent successfully to " + phoneNumber);
            promise.resolve("Message sent successfully");
        } catch (IllegalArgumentException e) {
            Log.e("MobileSMSModule", "Invalid phone number or message: " + e.getMessage());
            promise.reject("INVALID_INPUT", "Invalid phone number or message: " + e.getMessage());
        } catch (Exception ex) {
            Log.e("MobileSMSModule", "Couldn't send message: " + ex.getMessage());
            promise.reject("SEND_ERROR", "Couldn't send message: " + ex.getMessage());
        }
    }
}
