package com.example.aarshad.android_self.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aarshad.android_self.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aarshad on 6/8/17.
 */

public class BodyPartFragment extends Fragment {


    public static final String TAG = "BodyPartFragment" ;
    private List<Integer> mImageIds ;
    private int mListIndex ;
    public static final String KEY_IMAGE_IDS_LIST = "image_ids_list";
    public static final String KEY_LIST_INDEX = "list_index";

    public BodyPartFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState!=null){
            mImageIds = savedInstanceState.getIntegerArrayList(KEY_IMAGE_IDS_LIST);
            mListIndex = savedInstanceState.getInt(KEY_LIST_INDEX);
        }
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageBodyPart);

        if (mImageIds != null){
            imageView.setImageResource(mImageIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (mListIndex < mImageIds.size()-1){
                        mListIndex++;
                    } else {
                        mListIndex = 0 ;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));

                }
            });

        } else {
            Log.v(TAG, "This Fragment has list of null ImageIds ");
        }
        return rootView;
    }

    public void setImageIds(List<Integer> imageIds){
        mImageIds = imageIds ;
    }
    public void setListIndex(int index){
        mListIndex = index;
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putIntegerArrayList(KEY_IMAGE_IDS_LIST, (ArrayList<Integer>) mImageIds);
        bundle.putInt(KEY_LIST_INDEX,mListIndex);
    }


}
