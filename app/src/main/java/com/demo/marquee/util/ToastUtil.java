package com.demo.marquee.util;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.marquee.APP;
import com.demo.marquee.R;

/**
 * 显示消息，多次点击, 只显示一次（防止用户多次点击）
 */
public final class ToastUtil {

    private static View root;
    private static Toast toast;

    private static void showToast(CharSequence message) {

        if (null == toast) {
            toast = new Toast(APP.getInstance());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            root = LayoutInflater.from(APP.getInstance()).inflate(R.layout.layout_custom_toast, null);
            toast.setView(root);
        }

        ((TextView) root.findViewById(R.id.txt_hint)).setText(message);
        toast.show();
    }

    private static void showToast(int message) {
        if (null == toast) {
            toast = new Toast(APP.getInstance());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            root = LayoutInflater.from(APP.getInstance()).inflate(R.layout.layout_custom_toast, null);
            toast.setView(root);
        }

        ((TextView) root.findViewById(R.id.txt_hint)).setText(message);
        toast.show();
    }

    private static void showToast(CharSequence message, int duration) {
        if (null == toast) {
            toast = new Toast(APP.getInstance());
            toast.setDuration(duration);
            toast.setGravity(Gravity.CENTER, 0, 0);
            root = LayoutInflater.from(APP.getInstance()).inflate(R.layout.layout_custom_toast, null);
            toast.setView(root);
        }

        ((TextView) root.findViewById(R.id.txt_hint)).setText(message);
        toast.show();
    }

    private static void showToast(int message, int duration) {
        if (null == toast) {
            toast = new Toast(APP.getInstance());
            toast.setDuration(duration);
            toast.setGravity(Gravity.CENTER, 0, 0);
            root = LayoutInflater.from(APP.getInstance()).inflate(R.layout.layout_custom_toast, null);
            toast.setView(root);
        }

        ((TextView) root.findViewById(R.id.txt_hint)).setText(message);
        toast.show();
    }

    /**
     * 短时间显示Toast
     */
    public static void showShort(CharSequence message) {
        showToast(message);
    }

    /**
     * 短时间显示Toast
     */
    public static void showShort(int message) {
        showToast(message);
    }

    /**
     * 长时间显示Toast
     */
    public static void showLong(CharSequence message) {
        showToast(message);
    }

    /**
     * 长时间显示Toast
     */
    public static void showLong(int message) {
        showToast(message);
    }

    /**
     * 自定义显示Toast时间
     */
    public static void showTime(CharSequence message, int duration) {
        showToast(message, duration);
    }

    /**
     * 自定义显示Toast时间
     */
    public static void showTime(int message, int duration) {
        showToast(message, duration);
    }
}