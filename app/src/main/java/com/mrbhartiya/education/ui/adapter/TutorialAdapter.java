package com.mrbhartiya.education.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mrbhartiya.education.PilotApplication;
import com.mrbhartiya.education.R;
import com.mrbhartiya.education.ui.fragments.TutorialPagerFragment;

public class TutorialAdapter extends FragmentPagerAdapter {

    private int[] imgArray = {R.drawable.tutorial_first_bg, R.drawable.tutorial_second_bg, R.drawable.tutorial_third_bg, R.drawable.tutorial_fourth_bg, R.drawable.tutorial_fifth_bg};
    private int[] imgTourArray = {R.drawable.home_tutorial_first, R.drawable.tutorial_login, R.drawable.tutorial_chapters_listing, R.drawable.tutorial_video_description, R.drawable.tutorial_need_help};
    private String[] titleArray = {PilotApplication.getInstance().getString(R.string.str_tut_one_tittle),
            PilotApplication.getInstance().getString(R.string.str_tut_two_tittle),
            PilotApplication.getInstance().getString(R.string.str_tut_third_tittle),
            PilotApplication.getInstance().getString(R.string.str_tut_four_tittle),
            PilotApplication.getInstance().getString(R.string.str_tut_fifth_tittle)};

    private String[] descArray = {PilotApplication.getInstance().getString(R.string.str_tutorial_first_msg),
            PilotApplication.getInstance().getString(R.string.str_tutorial_second_msg),
            PilotApplication.getInstance().getString(R.string.str_tutorial_third_msg),
            PilotApplication.getInstance().getString(R.string.str_tutorial_fourth_msg),
            PilotApplication.getInstance().getString(R.string.str_tutorial_fifth_msg)};

    public TutorialAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }


    @Override
    public Fragment getItem(int position) {
        return TutorialPagerFragment.newInstance(titleArray[position], descArray[position], imgArray[position], imgTourArray[position]);
    }

    @Override
    public int getCount() {
        return imgArray.length;
    }
}