package com.mrbhartiya.education.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mrbhartiya.education.R;

public class NavigationAdapter extends BaseAdapter {
    Context mContext;
    String arrNavTittle[];

    private ViewClickListener mViewClickListener;

    public NavigationAdapter(Context context, String[] stringArray, ViewClickListener clickListener) {
        this.mContext = context;
        this.arrNavTittle = stringArray;
        this.mViewClickListener = clickListener;

    }

    public void setViewClickListener(ViewClickListener viewClickListener) {
        mViewClickListener = viewClickListener;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.item_navigation, viewGroup, false);
        Log.e("on get view", "adapter===" + arrNavTittle[i]);
        TextView txtTittle = view.findViewById(R.id.txt_nav_tittle);
        txtTittle.setText(arrNavTittle[i]);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mViewClickListener.onImageClicked(i);
            }
        });
        return view;
    }


    @Override
    public int getCount() {
        return arrNavTittle.length;
    }

    @Override
    public Object getItem(int i) {
        return arrNavTittle[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public interface ViewClickListener {
        void onImageClicked(int position);
    }
}
