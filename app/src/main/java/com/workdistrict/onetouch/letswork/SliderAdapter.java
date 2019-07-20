package com.workdistrict.onetouch.letswork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter{


    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;

    }

    public int[] slide_images = {


            R.drawable.splash2,
            R.drawable.splash1,
            R.drawable.splash6
    };


    public String [] slide_headings = {

            "Find a Space",
            "Get to work",
            "Be inspired"


    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.splashing_main_screen, container, false);


        RelativeLayout imageView = view.findViewById(R.id.slide_back_image);

        TextView slideHeading = view.findViewById(R.id.slide_heading);


        slideHeading.setText(slide_headings[position]);
        imageView.setBackgroundResource(slide_images[position]);

        container.addView(view);

        return view;




    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {


        container.removeView((RelativeLayout) object);


    }
}
