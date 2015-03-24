
package com.example.niravkalola.scareyourfriends;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import java.util.List;


public class ImageSpinnerAdapter extends BaseAdapter
    implements SpinnerAdapter
{

    private final Activity activity;
    private final List content;

    public ImageSpinnerAdapter(List list, Activity activity1)
    {
        content = list;
        activity = activity1;
    }

    public int getCount()
    {
        return content.size();
    }

    public Object getItem(int i)
    {
        return content.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = activity.getLayoutInflater().inflate(, null);
        TextView textview = (TextView)view1.findViewById(0x7f0a000c);
        ImageView imageview = (ImageView)view1.findViewById(0x7f0a000b);
        SpinnerImageEntry spinnerimageentry = (SpinnerImageEntry)content.get(i);
        textview.setText(spinnerimageentry.getText());
        imageview.setImageBitmap(spinnerimageentry.getImage());
        return view1;
    }
}
