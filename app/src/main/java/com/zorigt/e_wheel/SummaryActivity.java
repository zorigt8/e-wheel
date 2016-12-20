package com.zorigt.e_wheel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.vungle.publisher.AdConfig;
import com.vungle.publisher.Orientation;
import com.vungle.publisher.VunglePub;

import org.json.JSONException;
import org.json.JSONObject;


public class SummaryActivity extends AppCompatActivity {
    private TextView myText = null;
    // get the VunglePub instance
    final VunglePub vunglePub = VunglePub.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // get a reference to the global AdConfig object
        final AdConfig globalAdConfig = vunglePub.getGlobalAdConfig();

        // set any configuration options you like.
        // For a full description of available options, see the
        // 'Configuration Options' section.
        globalAdConfig.setSoundEnabled(true);
        globalAdConfig.setOrientation(Orientation.autoRotate);

        // indicates if an ad is ready to play
        if (vunglePub.isAdPlayable()) {
            onLevelComplete();
        }

        final Initializer mApp = ((Initializer) getApplicationContext());

        final TextView txt_happy = (TextView) findViewById(R.id.textView_happy);
        final TextView txt_joyful = (TextView) findViewById(R.id.textView_joyful);
        final TextView txt_liberated = (TextView) findViewById(R.id.textView_liberated);
        final TextView txt_ecstatic = (TextView) findViewById(R.id.textView_ecstatic);
        final TextView txt_proud = (TextView) findViewById(R.id.textView_proud);
        final TextView txt_important = (TextView) findViewById(R.id.textView_important);
        final TextView txt_confident = (TextView) findViewById(R.id.textView_confident);

        final TextView txt_surprise = (TextView) findViewById(R.id.textView_surprise);
        final TextView txt_startled = (TextView) findViewById(R.id.textView_startled);
        final TextView txt_shocked = (TextView) findViewById(R.id.textView_shocked);
        final TextView txt_dismayed = (TextView) findViewById(R.id.textView_dismayed);
        final TextView txt_excited = (TextView) findViewById(R.id.textView_excited);

        JSONObject temp = mApp.getSecondaryJson();

        try {
            if (temp.getBoolean("joyful")) {
                txt_joyful.setVisibility(View.VISIBLE);
            }
            if (temp.getBoolean("liberated")) {
                txt_liberated.setVisibility(View.VISIBLE);
            }
            if (temp.getBoolean("ecstatic")) {
               txt_ecstatic.setVisibility(View.VISIBLE);
            }
            if (temp.getBoolean("proud")) {
                txt_proud.setVisibility(View.VISIBLE);
            }
            if (temp.getBoolean("important")) {
                txt_important.setVisibility(View.VISIBLE);
            }
            if (temp.getBoolean("confident")) {
                txt_confident.setVisibility(View.VISIBLE);
            }
            if (temp.getBoolean("startled")) {
                txt_startled.setVisibility(View.VISIBLE);
            }
            if (temp.getBoolean("shocked")) {
                txt_shocked.setVisibility(View.VISIBLE);
            }
            if (temp.getBoolean("dismayed")) {
                txt_dismayed.setVisibility(View.VISIBLE);
            }
            if (temp.getBoolean("excited")) {
                txt_excited.setVisibility(View.VISIBLE);
            }
        } catch (JSONException e) {
            Log.e("e-wheel", "unexpected JSON exception", e);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        vunglePub.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        vunglePub.onResume();
    }

    private void onLevelComplete() {
        vunglePub.playAd();
    }
}
