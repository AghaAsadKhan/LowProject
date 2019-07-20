package com.workdistrict.onetouch.letswork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSliderPage;
    private SliderAdapter sliderAdapter;
    private LinearLayout mDotsLayout;
    private LinearLayout mLogin;
    private LinearLayout mSignUp;
    private LinearLayout mSkip;


    private TextView[] mDots;

    private static final String TAG = "MainActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSkip = findViewById(R.id.id_skip);

        mLogin = findViewById(R.id.id_login);
        mSignUp = findViewById(R.id.id_signUp);

        mSliderPage = findViewById(R.id.slidePage);
        mDotsLayout =findViewById(R.id.dotsLayout);

        sliderAdapter = new SliderAdapter(this);
        mSliderPage.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSliderPage.addOnPageChangeListener(viewListener);
        logIn();
        signUp();

        if(isServicesOk()){
            init();
        }
    }

    private void init() {



        mSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityMap();
            }
        });


    }


    private void logIn(){

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityLogin();
            }
        });
    }

    private void signUp(){

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySignUp();
            }
        });
    }



    public void openActivityLogin(){

        Intent intent = new Intent(this,  Login_Form.class);
        startActivity(intent);

    }
    public  void openActivitySignUp(){

        Intent intent = new Intent(this,  Signup_Form.class);
        startActivity(intent);
    }
    public void openActivityMap(){

        Intent intent = new Intent(this,  MapActivity.class);
        startActivity(intent);
    }

    public boolean isServicesOk(){

        Log.d(TAG, "isServicesOk: checking google services version ");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if (available == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServicesOk: google lay services is working");
            return true;

        }

        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG, "isServicesOk: on error occured but we can fix it");

            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();

        }

        else {
            Toast.makeText(this, "You can't make map request", Toast.LENGTH_SHORT).show();
        }

        return false;
    }


    public void addDotsIndicator(int position){

        mDots = new TextView[3];
        mDotsLayout.removeAllViews();
        for (int i = 0; i < mDots.length; i ++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(55);
            mDots[i].setTextColor(getResources().getColor(R.color.background));

            mDotsLayout.addView(mDots[i]);

        }

        if (mDots.length > 0){

            mDots[position].setTextColor(getResources().getColor(R.color.trans));


        }
    }



    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}






