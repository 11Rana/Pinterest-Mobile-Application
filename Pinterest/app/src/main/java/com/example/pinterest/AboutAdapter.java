package com.example.pinterest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private String[] maintitle= new String[1000];
    private Integer[] imgid= new Integer[1000];

    public AboutAdapter(Activity context, String[] maintitle, Integer[] imgid) {
        super(context, R.layout.about_row, maintitle);

        this.context=context;
        this.maintitle=maintitle;
        this.imgid=imgid;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.about_row, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        titleText.setText(maintitle[position]);
        imageView.setImageResource(imgid[position]);

        return rowView;

    };

}


