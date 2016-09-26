package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by root on 9/24/16.
 */

public class BaseActivity extends AppCompatActivity {

    Context mContext;
    ProgressDialog mProgressDialog;
    EndpointAsyncTask mendpointAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(getResources().getString(R.string.loadingjoke));
    }

    protected void loadJoke() {
        mProgressDialog.show();
        mendpointAsyncTask = new EndpointAsyncTask();
        mendpointAsyncTask.execute(mContext);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mendpointAsyncTask.cancel(true);
    }
}
