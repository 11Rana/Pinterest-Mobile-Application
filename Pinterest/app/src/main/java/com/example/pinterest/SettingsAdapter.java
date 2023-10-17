package com.example.pinterest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SettingsAdapter extends ArrayAdapter<String> {

    private final Activity context1;
    private String[] Title= new String[1000];

    public SettingsAdapter(Activity context1, String[] Title) {
        super(context1, R.layout.setting_row, Title);

        this.context1=context1;
        this.Title=Title;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context1.getLayoutInflater();
        View rowView1=inflater.inflate(R.layout.setting_row, null,true);

        TextView titleText = (TextView) rowView1.findViewById(R.id.title1);

        titleText.setText(Title[position]);

        return rowView1;

    };

}
