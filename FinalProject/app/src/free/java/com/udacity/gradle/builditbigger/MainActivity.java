package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends BaseActivity {

    InterstitialAd mInterstitialAd;
    AdRequest mRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.banner_interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                mInterstitialAd.loadAd(mRequest);
                loadJoke();
            }
        });
        mRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(mRequest);
    }

    public void tellJoke(View view) {
        if(mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
}
