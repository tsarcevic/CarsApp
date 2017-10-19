package com.example.cobeosijek.carsapp.car_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cobeosijek.carsapp.constants.Constants;
import com.example.cobeosijek.carsapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class CarsActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_MAIL_CARS_ACTIVITY = "mail";

    TextView eMailText;
    TextView toolbarText;
    ImageView backButtonImage;
    ImageView launcherImage;

    TabLayout menuTabLayout;
    ViewPager carPager;

    private String userMail;

    public static Intent getLaunchIntent(Context from, String mail) {
        Intent intent = new Intent(from, CarsActivity.class);
        intent.putExtra(KEY_MAIL_CARS_ACTIVITY, mail);

        return intent;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        getExtras();
        setUI();
        setText();
    }

    private void setUI() {
        List<String> tabMenuList = new ArrayList<>();
        tabMenuList.add("All");
        tabMenuList.add("Favorite");

        eMailText = findViewById(R.id.mail_text);
        toolbarText = findViewById(R.id.toolbar_text);
        backButtonImage = findViewById(R.id.back_button);
        launcherImage = findViewById(R.id.small_picture);
        menuTabLayout = findViewById(R.id.tab_menu);
        carPager = findViewById(R.id.car_pager);

        SimpleFragmentPagerAdapter simpleFragmentPagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        simpleFragmentPagerAdapter.addTitles(tabMenuList);
        simpleFragmentPagerAdapter.addFragment(CarListFragment.newInstance(Constants.ALL_CARS));
        simpleFragmentPagerAdapter.addFragment(CarListFragment.newInstance(Constants.FAVORITE_CARS));

        carPager.setAdapter(simpleFragmentPagerAdapter);
        menuTabLayout.setupWithViewPager(carPager);

        backButtonImage.setOnClickListener(this);
    }

    private void getExtras() {
        if (getIntent().hasExtra(KEY_MAIL_CARS_ACTIVITY)) {
            userMail = getIntent().getStringExtra(KEY_MAIL_CARS_ACTIVITY);
        } else {
            userMail = "invalid@email.com";
        }
    }

    private void setText() {
        eMailText.setText(userMail);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            onBackPressed();
        }
    }
}