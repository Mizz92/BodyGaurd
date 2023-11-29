package com.collective.bodyguard;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class MyAdminReceiver extends DeviceAdminReceiver {

    private static final String KEY_ATTEMPTS_NO = "attempts_no";
    private static final int LIMIT = 3;

    @Override
    public void onPasswordFailed(Context context, Intent intent) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        int attempts = sharedPrefs.getInt(KEY_ATTEMPTS_NO, 0) + 1;

        if (attempts == LIMIT) {
            // Reset the counter
            sharedPrefs.edit().putInt(KEY_ATTEMPTS_NO, 0).apply();

            // Launch your activity
            context.startActivity(new Intent(context, test.class));
            Toast.makeText(context, "start activity", Toast.LENGTH_LONG).show();
        } else {
            // Save the new attempts number
            sharedPrefs.edit().putInt(KEY_ATTEMPTS_NO, attempts).apply();
        }
    }

    @Override
    public void onPasswordSucceeded(Context context, Intent intent) {
        // Reset number of attempts
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPrefs.edit().putInt(KEY_ATTEMPTS_NO, 0).apply();
    }


    @Override
    public void onReceive(Context arg0, Intent arg1) {
        // TODO Auto-generated method stub

        // TODO Auto-generated method stub
        Toast.makeText(arg0, "here", Toast.LENGTH_LONG).show();

        /*Intent i = new Intent();
        i.setClassName("com.bew.locksmith","com.bew.locksmith.test");
        arg0.startActivity(i);*/

        //String action = arg1.getAction();


    }




}
