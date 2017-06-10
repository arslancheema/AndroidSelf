package com.example.aarshad.android_self.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.aarshad.android_self.R;
import com.example.aarshad.android_self.data.AndroidImageAssets;

/**
 * Created by aarshad on 6/8/17.
 */

public class MasterListFragment extends Fragment {

    OnImageClickListener mCallBack;

    // OnImageClickListener Interface, calls a method in host Activity called onImageClicked
    public interface OnImageClickListener{
        void onImageClicked (int position);
    }

    public MasterListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_master_list,container,false);

        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        MasterListAdapter masterListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(masterListAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mCallBack.onImageClicked(position);
            }
        });
        return rootView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // This makes sure that the host Activity has implemented the callback Interface
        // Else it will throw an exception
        try {
            mCallBack = (OnImageClickListener) context;
        } catch (ClassCastException e ){
            throw new ClassCastException(context.toString() + " must implement OnImageClickListener");
        }
    }
}
