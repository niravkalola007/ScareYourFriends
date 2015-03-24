// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.niravkalola.scareyourfriends;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.view.Display;
import android.view.WindowManager;

public class DeviceUtil
{

    private static final String TAG = "ScaryActivity";

    public DeviceUtil()
    {
    }

    public static Point getDeviceSize(Context context)
    {
        Display display = getDisplayDevice(context);
        return new Point(display.getWidth(), display.getHeight());
    }

    private static Display getDisplayDevice(Context context)
    {
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
    }

    public static void playSound(Context context, int i)
    {
        MediaPlayer.create(context, i).start();
    }
}
