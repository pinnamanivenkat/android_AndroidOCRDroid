package com.venkat.projects.androidocrdroid;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.venkat.projects.androidocrdroid.CustomToast;
import com.venkat.projects.androidocrdroid.R;

/**
 * Created by venkat on 27/6/17.
 */

public class SplashScreen extends AppCompatActivity {

    private static final int REQUEST_PERM = 2;
    private android.hardware.Camera mCameraDevice;

    @Override
    protected void onCreate(Bundle splashactivity) {
        super.onCreate(splashactivity);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_screen);

        final int write_permission_check = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        final int read_permission_check = ContextCompat.checkSelfPermission(this,
                        Manifest.permission.READ_EXTERNAL_STORAGE);
        findViewById(R.id.grant).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(write_permission_check == PackageManager.PERMISSION_GRANTED && read_permission_check== PackageManager.PERMISSION_GRANTED) {
                    CustomToast.create(SplashScreen.this, R.drawable.ic_done_black, "Permissions enabled by default");
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(),CameraActivity.class);
                    SplashScreen.this.finish();
                    startActivity(intent);
                } else {
                    ActivityCompat.requestPermissions(SplashScreen.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_PERM);
                }
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if(requestCode == REQUEST_PERM) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                CustomToast.create(SplashScreen.this, R.drawable.ic_done_black, "Permissions grant successful");
                SplashScreen.this.finish();
            } else {
                CustomToast.create(SplashScreen.this, R.drawable.ic_alert, "Permissions couldn't be granted");
                finish();
            }
        }
    }
}
