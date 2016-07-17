package com.patryk1007.viewheader;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_frag, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragFirst);
        tv.setText(getArguments().getString("msg"));

        v.findViewById(R.id.root_view).setBackgroundColor(Color.parseColor(getArguments().getString("color")));
        return v;
    }

    public static PageFragment newInstance(String text, String color) {
        PageFragment f = new PageFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);
        b.putString("color", color);
        f.setArguments(b);
        return f;
    }
}