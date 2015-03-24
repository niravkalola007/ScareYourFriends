// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.niravkalola.scareyourfriends;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package scare.your.friends.prank.maze.halloween:
//            ScareYourFriendActivity

public class ScaryThread extends Thread
{

    private Handler handler;

    public ScaryThread(Handler handler1)
    {
        handler = handler1;
    }

    public void run()
    {
        try
        {
            sleep(ScareYourFriendActivity.timeMiliSec);
            Bundle bundle = new Bundle();
            bundle.putString("status", "ok");
            Message message = new Message();
            message.setData(bundle);
            handler.sendMessage(message);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }
}
