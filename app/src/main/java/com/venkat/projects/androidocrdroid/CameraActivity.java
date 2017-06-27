package com.venkat.projects.androidocrdroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;

/**
 * Created by venkat on 27/6/17.
 */

public class CameraActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA = 0;
    private Uri imageuri;

    @Override
    protected void onCreate(Bundle cameraactivity) {
        super.onCreate(cameraactivity);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        String filename = Environment.getExternalStorageDirectory().toString() + File.separator + System.currentTimeMillis() + ".jpg";
        imageuri = Uri.fromFile(new File(filename));
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageuri);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CAMERA) {
                if (resultCode == RESULT_OK) {
                    if (imageuri != null) {
                        Intent intent = new Intent();
                        intent.setClass(CameraActivity.this,MainActivity.class);
                        intent.putExtra("imageuri",imageuri.toString());
                        startActivity(intent);
                        CameraActivity.this.finish();
                    }
                    else
                        Log.e("CameraActivity","Cannot create path");
                }
                else
                    super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
