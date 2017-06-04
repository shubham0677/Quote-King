package com.sharma.shubham.quoteking;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hp on 9/28/2016.
 */

public class CategoryAdapter extends ArrayAdapter<Category> {

    private ArrayList<Category> data;
    private static LayoutInflater layoutInflater = null;

    public CategoryAdapter(Context context,int textViewResourceId, ArrayList<Category> data) {
        super(context,textViewResourceId,data);
        this.data = data;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if(v == null) {
           v = layoutInflater.inflate(R.layout.home_list, null);
        }
            Category category = data.get(i);

            TextView catLabel = (TextView) v.findViewById(R.id.cat_label);
            ImageView catImg = (ImageView) v.findViewById(R.id.cat_img);

            Log.d("TEST: ",category.getName());
            catLabel.setText(category.getName());

        return v;
    }
}
