// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.niravkalola.scareyourfriends;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import java.util.Date;
import java.util.GregorianCalendar;

// Referenced classes of package scare.your.friends.prank.maze.halloween:
//            ScareYourFriendActivity, MusicManager

public class ScaryActivity extends Activity
{

    public static boolean isScaryChristmasAd = false;
    private AdView adViewBottom;
    Handler mAnimationHandler;

    public ScaryActivity()
    {
    }

    public void back(View view)
    {
        startActivity(new Intent(getApplicationContext(), scare/your/friends/prank/maze/halloween/ScareYourFriendActivity));
    }

    public void exit(View view)
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(0x10000000);
        startActivity(intent);
    }

    public void onCreate(Bundle bundle)
    {
        overridePendingTransition(0, 0);
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030001);
        MusicManager.playSound(getApplicationContext(), ScareYourFriendActivity.soundResId);
        Vibrator vibrator = (Vibrator)getSystemService("vibrator");
        long al[] = new long[7];
        al[1] = 2000L;
        al[2] = 1000L;
        al[3] = 1000L;
        al[4] = 500L;
        al[5] = 500L;
        vibrator.vibrate(al, -1);
        RelativeLayout relativelayout = (RelativeLayout)findViewById(0x7f0a0007);
        android.view.animation.Animation animation = AnimationUtils.loadAnimation(this, 0x7f040003);
        relativelayout.setBackgroundDrawable(new BitmapDrawable(ScareYourFriendActivity.imageResBitmap));
        relativelayout.startAnimation(animation);
        mAnimationHandler = new Handler();
        mAnimationHandler.postDelayed(new Runnable() {

            final ScaryActivity this$0;

            public void run()
            {
                if ((new GregorianCalendar()).getTime().getMonth() == 11)
                {
                    ScaryActivity.isScaryChristmasAd = true;
                }
                ImageView imageview = (ImageView)findViewById(0x7f0a000a);
                if (ScaryActivity.isScaryChristmasAd)
                {
                    imageview.setImageResource(0x7f02000e);
                } else
                {
                    imageview.setImageResource(0x7f020001);
                }
                imageview.setVisibility(0);
            }

            
            {
                this$0 = ScaryActivity.this;
                super();
            }
        }, 400L);
        mAnimationHandler = new Handler();
        mAnimationHandler.postDelayed(new Runnable() {

            final ScaryActivity this$0;
            private final Activity val$scaryActivity;

            public void run()
            {
                adViewBottom = new AdView(scaryActivity, AdSize.BANNER, "a14fb95e291593a");
                ((RelativeLayout)findViewById(0x7f0a0009)).addView(adViewBottom);
                adViewBottom.loadAd(new AdRequest());
            }

            
            {
                this$0 = ScaryActivity.this;
                scaryActivity = activity;
                super();
            }
        }, 500L);
    }

    public void onDestroy()
    {
        if (adViewBottom != null)
        {
            adViewBottom.destroy();
        }
        super.onDestroy();
    }

    protected void onResume()
    {
        overridePendingTransition(0, 0);
        super.onResume();
    }

    protected void onStart()
    {
        overridePendingTransition(0, 0);
        super.onStart();
    }

    public void promo(View view)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=logos.quiz.companies.game"));
        if (isScaryChristmasAd)
        {
            intent.setData(Uri.parse("market://details?id=scary.christmas.santa.friends"));
        }
        intent.addFlags(0x40000000);
        startActivity(intent);
    }



}
