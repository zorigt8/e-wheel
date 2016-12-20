package com.zorigt.e_wheel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
        final TextView txt_eager = (TextView) findViewById(R.id.textView_eager);
        final TextView txt_energetic = (TextView) findViewById(R.id.textView_energetic);

        final Button btn_restart = (Button) findViewById(R.id.restart);

        JSONObject secondary = mApp.getSecondaryJson();

        try {
            if (mApp.getPrimary("happy")){
                txt_happy.setVisibility(View.VISIBLE);
            }
            if (mApp.getPrimary("surprise")){
                txt_surprise.setVisibility(View.VISIBLE);
            }
            if (secondary.getBoolean("joyful")) {
                txt_joyful.setVisibility(View.VISIBLE);
            }
            if (secondary.getBoolean("liberated")) {
                txt_liberated.setVisibility(View.VISIBLE);
            }
            if (secondary.getBoolean("ecstatic")) {
                txt_ecstatic.setVisibility(View.VISIBLE);
            }
            if (secondary.getBoolean("proud")) {
                txt_proud.setVisibility(View.VISIBLE);
            }
            if (secondary.getBoolean("important")) {
                txt_important.setVisibility(View.VISIBLE);
            }
            if (secondary.getBoolean("confident")) {
                txt_confident.setVisibility(View.VISIBLE);
            }
            if (secondary.getBoolean("startled")) {
                txt_startled.setVisibility(View.VISIBLE);
            }
            if (secondary.getBoolean("shocked")) {
                txt_shocked.setVisibility(View.VISIBLE);
            }
            if (secondary.getBoolean("dismayed")) {
                txt_dismayed.setVisibility(View.VISIBLE);
            }
            if (secondary.getBoolean("excited")) {
                txt_excited.setVisibility(View.VISIBLE);
            }
            if (secondary.getBoolean("eager")) {
                txt_eager.setVisibility(View.VISIBLE);
            }
            if (secondary.getBoolean("energetic")) {
                txt_energetic.setVisibility(View.VISIBLE);
            }
        } catch (JSONException e) {
            Log.e("e-wheel", "unexpected JSON exception", e);
        }

        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartApp(v);
            }
        });
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

    public void restartApp(View view) {

        final Initializer mApp = ((Initializer) getApplicationContext());
        mApp.initPrimary();
        mApp.initSecondary();

        Intent restartAct = new Intent(this, MainActivity.class);
        startActivity(restartAct);
    }

    private void onLevelComplete() {
        vunglePub.playAd();
    }
}
