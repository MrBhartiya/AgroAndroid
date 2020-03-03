package com.mrbhartiya.education.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.mrbhartiya.education.R;

public class TutorialPagerFragment extends BaseFragment {
    TextView txtTittle, txtDescriptions;
    ImageView imgTutorial;
    RelativeLayout rlParent;
    private String pageTitle;
    private String pageDesc;
    private int imgResource, imgTourResource;

    public static TutorialPagerFragment newInstance(String title, String desc, int resource, int imgTourArray) {
        TutorialPagerFragment pageFragment = new TutorialPagerFragment();
        Bundle args = new Bundle();
        args.putString("KeyTitle", title);
        args.putString("KeyDesc", desc);
        args.putInt("KeyImage", resource);
        args.putInt("KeyTour", imgTourArray);
        pageFragment.setArguments(args);
        return pageFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        pageTitle = b.getString("KeyTitle");
        pageDesc = b.getString("KeyDesc");
        imgResource = b.getInt("KeyImage");
        imgTourResource = b.getInt("KeyTour");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmnet_tutorial, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        rlParent = view.findViewById(R.id.rl_parent);
        txtTittle = view.findViewById(R.id.txt_title);
        txtDescriptions = view.findViewById(R.id.txt_description);
        imgTutorial = view.findViewById(R.id.img_tour);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        txtTittle.setText(pageTitle);
        txtDescriptions.setText(pageDesc);
        imgTutorial.setImageResource(imgTourResource);
        rlParent.setBackgroundResource(imgResource);
    }

}
