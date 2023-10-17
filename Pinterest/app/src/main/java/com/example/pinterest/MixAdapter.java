package com.example.pinterest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import java.util.ArrayList;



public class MixAdapter extends BaseAdapter {

    Context context;
    ArrayList<ImageModel> arrayList;
    public MixAdapter(Context context, ArrayList<ImageModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public  View getView(int position, View convertView, ViewGroup parent) {
        if (convertView ==  null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.mix_list, parent, false);
        }
        ImageView imageView;
        imageView = (ImageView) convertView.findViewById(R.id.image);
        imageView.setImageResource(arrayList.get(position).getimgIds());


        return convertView;
    }
}

