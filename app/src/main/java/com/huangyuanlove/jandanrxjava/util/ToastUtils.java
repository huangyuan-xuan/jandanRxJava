package com.huangyuanlove.jandanrxjava.util;


import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.Toast;

public class ToastUtils {

    public static void show(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void show(Context context, int resource) {
        Toast.makeText(context, resource, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void showLong(Context context, int resource) {
        Toast.makeText(context, resource, Toast.LENGTH_LONG).show();
    }

    public static void showToast(Context context, View comtentView, int location, int height) {

        Toast toast = new Toast(context);
        toast.setView(comtentView);

        toast.setGravity(location, 0, height);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }


}
