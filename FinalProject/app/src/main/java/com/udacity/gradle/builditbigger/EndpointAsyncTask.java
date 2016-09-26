package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import builditbigger.gradle.udacity.com.jokeandroidlibrary.DisplayJokeActivity;

/**
 * Created by root on 9/20/16.
 */

public class EndpointAsyncTask extends AsyncTask<Context, Void, String> {

    private MyApi myApiService = null;
    Context mContext;

    public  EndpointAsyncTask() {
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Context... params) {

        mContext = params[0];
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null);
            builder.setRootUrl(mContext.getResources().getString(R.string.localhostIP));
            builder.setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                @Override
                public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClinetRequest) throws IOException {
                    abstractGoogleClinetRequest.setDisableGZipContent(true);
                }
            });
            myApiService = builder.build();
        }
        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException ex) {
            Log.e(mContext.getResources().getString(R.string.endpointtask), ex.getMessage());
            return mContext.getResources().getString(R.string.loadjokeerror);
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        super.onPostExecute(joke);
        String jokeStr = mContext.getResources().getString(R.string.joke);
        Intent intent = new Intent(mContext, DisplayJokeActivity.class);
        intent.putExtra(jokeStr, joke);
        mContext.startActivity(intent);
    }
}
