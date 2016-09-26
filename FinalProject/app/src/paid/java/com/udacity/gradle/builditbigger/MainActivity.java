package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.View;


public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void tellJoke(View view) {
        loadJoke();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
