package com.example.aarshad.android_self.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by aarshad on 6/8/17.
 */

public class MasterListAdapter extends BaseAdapter {

    Context mContext;
    List<Integer> mImageIds ;

    public MasterListAdapter(Context context, List<Integer> imageIds){
        mContext = context;
        mImageIds = imageIds;
    }
    @Override
    public int getCount() {
        return mImageIds.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ImageView imageView;
        // Check if the View is regenerated or new
        if (view == null){
            imageView = new ImageView(mContext);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        } else {
            imageView = (ImageView) view;
        }

        imageView.setImageResource(mImageIds.get(position));

        return imageView;
    }
}
