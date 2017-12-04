package com.trianglewallpaper;

import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.setAction(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
                String p = com.trianglewallpaper.LiveWallpaper.class.getPackage().getName();
                String c = com.trianglewallpaper.LiveWallpaper.class.getCanonicalName();
                i.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT, new ComponentName(p, c));
                startActivityForResult(i, 0);
                finish();
            }
        });
        ((Button)findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager p = getPackageManager();
                p.setComponentEnabledSetting(new ComponentName(MainActivity.this,MainActivity.class), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
                Toast.makeText(getApplicationContext(),getString(R.string.hide_clicked),Toast.LENGTH_LONG).show();
                finish();
            }
        });

        MoPubView moPubView = (MoPubView) findViewById(R.id.adview);
        moPubView.setAdUnitId("81c07473bba14ae4b97c1f755397d8af"); // Enter your Ad Unit ID from www.mopub.com
        moPubView.loadAd();

       /* moPubView.setBannerAdListener(new MoPubView.BannerAdListener() {
            @Override
            public void onBannerLoaded(MoPubView banner) {
                showLog("=======onBannerLoaded====");
            }

            @Override
            public void onBannerFailed(MoPubView banner, MoPubErrorCode errorCode) {
                showLog("=======onBannerFailed====");
            }

            @Override
            public void onBannerClicked(MoPubView banner) {
                showLog("=======onBannerClicked====");
            }

            @Override
            public void onBannerExpanded(MoPubView banner) {
                showLog("=======onBannerExpanded====");
            }

            @Override
            public void onBannerCollapsed(MoPubView banner) {
                showLog("=======onBannerCollapsed====");
            }
        });*/
    }

    private void showLog(String m1)
    {
        Log.i("Main","==msg=="+m1);


    }

}
