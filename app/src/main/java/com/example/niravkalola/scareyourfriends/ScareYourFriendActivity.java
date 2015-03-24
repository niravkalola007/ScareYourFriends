
package com.example.niravkalola.scareyourfriends;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.ads.AdView;

import java.util.LinkedList;
import java.util.List;


public class ScareYourFriendActivity extends Activity
    implements Handler.Callback
{

    public static Bitmap imageResBitmap;
    public static int soundResId;
    public static int timeMiliSec;
    AdView adView;
    private Handler handler;
    private ScaryThread scaryThread;

    public ScareYourFriendActivity()
    {
        handler = new Handler(this);
    }

    public boolean handleMessage(Message message)
    {
        handler.removeCallbacks(scaryThread);
        do
        {
            if (scaryThread == null)
            {
                scaryThread = new ScaryThread(handler);
                Intent intent = new Intent(getApplicationContext(), ScaryActivity.class);
                intent.addFlags(0x10000000);
                getApplicationContext().startActivity(intent);
                return true;
            }
            try
            {
                scaryThread.join();
                scaryThread = null;
            }
            catch (InterruptedException interruptedexception) { }
        } while (true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.);
        scaryThread = new ScaryThread(handler);
        AudioManager audiomanager = (AudioManager)getSystemService("audio");
        audiomanager.setStreamVolume(3, audiomanager.getStreamMaxVolume(3), 8);
        Spinner spinner = (Spinner)findViewById(0x7f0a0002);
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(new SpinnerImageEntry("Classic", 0x7f020005, getResources()));
        linkedlist.add(new SpinnerImageEntry("Big mouth", 0x7f020006, getResources()));
        linkedlist.add(new SpinnerImageEntry("Angry dog", 0x7f020007, getResources()));
        linkedlist.add(new SpinnerImageEntry("Big mouth 2", 0x7f020008, getResources()));
        linkedlist.add(new SpinnerImageEntry("Child", 0x7f020009, getResources()));
        linkedlist.add(new SpinnerImageEntry("Dr House", 0x7f02000a, getResources()));
        linkedlist.add(new SpinnerImageEntry("Clown", 0x7f02000b, getResources()));
        linkedlist.add(new SpinnerImageEntry("Blind", 0x7f02000c, getResources()));
        linkedlist.add(new SpinnerImageEntry("Real scary", 0x7f02000d, getResources()));
        spinner.setAdapter(new ImageSpinnerAdapter(linkedlist, this));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            final ScareYourFriendActivity this$0;

            public void onItemSelected(AdapterView adapterview, View view, int i, long l)
            {
                ScareYourFriendActivity.imageResBitmap = ((SpinnerImageEntry)adapterview.getItemAtPosition(i)).getImage();
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = ScareYourFriendActivity.this;
                super();
            }
        });
        Spinner spinner1 = (Spinner)findViewById(0x7f0a0003);
        ArrayAdapter arrayadapter = ArrayAdapter.createFromResource(this, 0x7f060000, 0x1090008);
        arrayadapter.setDropDownViewResource(0x1090009);
        spinner1.setAdapter(arrayadapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            final ScareYourFriendActivity this$0;

            public void onItemSelected(AdapterView adapterview, View view, int i, long l)
            {
                int j = (new Integer(((String)adapterview.getItemAtPosition(i)).split(" ")[0])).intValue();
                ScareYourFriendActivity.timeMiliSec = 1000 * (j * 60);
                if (j == 15)
                {
                    ScareYourFriendActivity.timeMiliSec = 15000;
                } else
                if (j == 30)
                {
                    ScareYourFriendActivity.timeMiliSec = 30000;
                    return;
                }
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = ScareYourFriendActivity.this;
                super();
            }
        });
        Spinner spinner2 = (Spinner)findViewById(0x7f0a0004);
        ArrayAdapter arrayadapter1 = ArrayAdapter.createFromResource(this, 0x7f060001, 0x1090008);
        arrayadapter1.setDropDownViewResource(0x1090009);
        spinner2.setAdapter(arrayadapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            final ScareYourFriendActivity this$0;

            public void onItemSelected(AdapterView adapterview, View view, int i, long l)
            {
                String s = (String)adapterview.getItemAtPosition(i);
                ScareYourFriendActivity.soundResId = getResources().getIdentifier((new StringBuilder("scary_sound")).append(s.split(" ")[2]).toString(), "raw", getPackageName());
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = ScareYourFriendActivity.this;
                super();
            }
        });
    }

    public void playSound(View view)
    {
        MusicManager.playSound(getApplicationContext(), soundResId);
    }

    public void rate(View view)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=scare.your.friends.prank.maze.halloween"));
        startActivity(intent);
    }

    public void startScary(View view)
    {
        scaryThread.start();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(0x10000000);
        startActivity(intent);
    }
}
