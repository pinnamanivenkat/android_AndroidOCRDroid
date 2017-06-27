package com.venkat.projects.androidocrdroid;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.venkat.projects.androidocrdroid.R;

/**
 * Created by Shripal17 on 26-06-2017.
 */

public class CustomToast {
    public static void create(Activity ctx, int icon, String text){
        LayoutInflater inflater = ctx.getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) ctx.findViewById(R.id.toast_container));

        TextView textView = (TextView) layout.findViewById(R.id.toast_text);
        textView.setText(text);

        ImageView imageView = (ImageView) layout.findViewById(R.id.toast_icon);

        if (icon != 0) {
            imageView.setImageResource(icon);
        } else {
            imageView.setVisibility(View.GONE);
        }

        Toast toast = new Toast(ctx);
        //toast.setGravity(Gravity., 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}