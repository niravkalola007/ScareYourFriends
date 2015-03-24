// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.niravkalola.scareyourfriends;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MusicManager
{

    public static final int MUSIC_END_GAME = 2;
    public static final int MUSIC_GAME = 1;
    public static final int MUSIC_MENU = 0;
    private static final String TAG = "MusicManager";
    public static boolean isActivityChanging = false;
    private static Map musicPlayers = new HashMap();
    private static Map soundPlayers = new HashMap();

    public MusicManager()
    {
    }

    private static boolean isMusicOn(Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("MUSIC", true);
    }

    private static boolean isSoundOn(Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("SOUND", true);
    }

    public static void pauseMusic()
    {
        if (isActivityChanging) goto _L2; else goto _L1
_L1:
        Iterator iterator = musicPlayers.values().iterator();
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        MediaPlayer mediaplayer = (MediaPlayer)iterator.next();
        if (mediaplayer.isPlaying())
        {
            mediaplayer.pause();
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void playSound(Context context, int i)
    {
        if (isSoundOn(context))
        {
            MediaPlayer mediaplayer = (MediaPlayer)soundPlayers.get(Integer.valueOf(i));
            if (mediaplayer != null)
            {
                if (mediaplayer.isPlaying())
                {
                    mediaplayer.seekTo(0);
                }
                mediaplayer.start();
            } else
            {
                MediaPlayer mediaplayer1 = MediaPlayer.create(context, i);
                soundPlayers.put(Integer.valueOf(i), mediaplayer1);
                if (mediaplayer1 != null)
                {
                    try
                    {
                        mediaplayer1.start();
                        return;
                    }
                    catch (Exception exception)
                    {
                        Log.e("MusicManager", exception.getMessage(), exception);
                    }
                    return;
                }
            }
        }
    }

    public static void putPrefBoolean(String s, boolean flag, Context context)
    {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(s, flag);
        editor.commit();
    }

    public static void setMusicOff(Context context)
    {
        putPrefBoolean("MUSIC", false, context);
    }

    public static void setMusicOn(Context context)
    {
        putPrefBoolean("MUSIC", true, context);
    }

    public static void setSoundOff(Context context)
    {
        putPrefBoolean("SOUND", false, context);
    }

    public static void setSoundOn(Context context)
    {
        putPrefBoolean("SOUND", true, context);
    }

    public static void startMusic(Context context, int i)
    {
        if (isMusicOn(context))
        {
            stopMusic();
            MediaPlayer mediaplayer = (MediaPlayer)musicPlayers.get(Integer.valueOf(i));
            if (mediaplayer != null)
            {
                if (!mediaplayer.isPlaying())
                {
                    mediaplayer.start();
                }
            } else
            {
                MediaPlayer mediaplayer1 = MediaPlayer.create(context, i);
                musicPlayers.put(Integer.valueOf(i), mediaplayer1);
                if (mediaplayer1 != null)
                {
                    try
                    {
                        mediaplayer1.start();
                        return;
                    }
                    catch (Exception exception)
                    {
                        Log.e("MusicManager", exception.getMessage(), exception);
                    }
                    return;
                }
            }
        }
    }

    public static void stopMusic()
    {
        Iterator iterator = musicPlayers.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            MediaPlayer mediaplayer = (MediaPlayer)iterator.next();
            if (mediaplayer.isPlaying())
            {
                mediaplayer.pause();
            }
            mediaplayer.seekTo(0);
        } while (true);
    }

}
