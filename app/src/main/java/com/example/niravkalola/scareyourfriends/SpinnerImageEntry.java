// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.niravkalola.scareyourfriends;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SpinnerImageEntry
{

    private Bitmap image;
    private String text;

    public SpinnerImageEntry(String s, int i, Resources resources)
    {
        text = s;
        image = BitmapFactory.decodeResource(resources, i);
    }

    public Bitmap getImage()
    {
        return image;
    }

    public String getText()
    {
        return text;
    }

    public void setImage(Bitmap bitmap)
    {
        image = bitmap;
    }

    public void setText(String s)
    {
        text = s;
    }
}
