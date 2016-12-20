package com.zorigt.e_wheel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.vungle.publisher.AdConfig;
import com.vungle.publisher.Orientation;
import com.vungle.publisher.VunglePub;

public class HappyActivity extends AppCompatActivity {
    // get the VunglePub instance
    final VunglePub vunglePub = VunglePub.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy);

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

        final Switch s_joyful = (Switch) findViewById(R.id.switch_joyful);
        final CheckBox cb_liberated = (CheckBox) findViewById(R.id.checkBox_liberated);
        final CheckBox cb_ecstatic = (CheckBox) findViewById(R.id.checkBox_ecstatic);

        final Switch s_proud = (Switch) findViewById(R.id.switch_proud);
        final CheckBox cb_important = (CheckBox) findViewById(R.id.checkBox_important);
        final CheckBox cb_confident = (CheckBox) findViewById(R.id.checkBox_confident);

        final Button btn_next = (Button) findViewById(R.id.btn_next);

        /** To Be Worked on Later

        if (mApp.getPrimary("happy") & mApp.getSecondary("joyful")){
            s_joyful.setChecked(true);
        } else {
            mApp.unsetSecondary("joyful");
        }
         **/

        s_joyful.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("boolean value: ", valueOf(mApp.getSecondary("joyful")));
                if (!mApp.getSecondary("joyful")){
                    mApp.setSecondary("joyful");
                    cb_liberated.setVisibility(View.VISIBLE);
                    cb_ecstatic.setVisibility(View.VISIBLE);
                    s_joyful.setTextColor(Color.parseColor("#33cccc"));
                } else {
                    mApp.unsetSecondary("joyful");
                    cb_liberated.setVisibility(View.INVISIBLE);
                    cb_ecstatic.setVisibility(View.INVISIBLE);
                    if (cb_liberated.isChecked()) {
                        cb_liberated.toggle();
                        mApp.unsetSecondary("liberated");
                    }
                    if (cb_ecstatic.isChecked()) {
                        cb_ecstatic.toggle();
                        mApp.unsetSecondary("ecstatic");
                    }
                    s_joyful.setTextColor( Color.BLACK );
                }

                Log.d("json obj: ", mApp.getSecondaryJson().toString());
            }
        });


        cb_liberated.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb_liberated.isChecked()) {
                    mApp.setSecondary("liberated");
                    Log.d("json obj: ", mApp.getSecondaryJson().toString());
                } else {
                    mApp.unsetSecondary("liberated");
                    Log.d("json obj: ", mApp.getSecondaryJson().toString());
                }
            }
        });

        cb_ecstatic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb_ecstatic.isChecked()) {
                    mApp.setSecondary("ecstatic");
                    Log.d("json obj: ", mApp.getSecondaryJson().toString());
                } else {
                    mApp.unsetSecondary("ecstatic");
                }
            }
        });

        s_proud.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("boolean value: ", valueOf(mApp.getSecondary("proud")));
                if (!mApp.getSecondary("proud")){
                    mApp.setSecondary("proud");
                    cb_important.setVisibility(View.VISIBLE);
                    cb_confident.setVisibility(View.VISIBLE);
                    s_proud.setTextColor(Color.parseColor("#33cccc"));
                } else {
                    mApp.unsetSecondary("proud");
                    cb_important.setVisibility(View.INVISIBLE);
                    cb_confident.setVisibility(View.INVISIBLE);
                    if (cb_important.isChecked()) {
                        cb_important.toggle();
                        mApp.unsetSecondary("important");
                    }
                    if (cb_confident.isChecked()) {
                        cb_confident.toggle();
                        mApp.unsetSecondary("confident");
                    }
                    s_proud.setTextColor( Color.BLACK );
                }

                Log.d("json obj: ", mApp.getSecondaryJson().toString());
            }
        });


        cb_important.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb_important.isChecked()) {
                    mApp.setSecondary("important");
                    Log.d("json obj: ", mApp.getSecondaryJson().toString());
                } else {
                    mApp.unsetSecondary("important");
                    Log.d("json obj: ", mApp.getSecondaryJson().toString());
                }
            }
        });

        cb_confident.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb_confident.isChecked()) {
                    mApp.setSecondary("confident");
                    Log.d("json obj: ", mApp.getSecondaryJson().toString());
                } else {
                    mApp.unsetSecondary("confident");
                }
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondPage(v);
            }
        });
    }

    public static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString();
    }

    public void secondPage(View view){

        final Initializer mApp = ((Initializer) getApplicationContext());

        if (mApp.getPrimary("surprise")){
            Intent secondAct = new Intent(this, SurpriseActivity.class);
            startActivity(secondAct);
        }
        else if (mApp.getPrimary("fear")){
            Intent secondAct = new Intent(this, FearActivity.class);
            startActivity(secondAct);
        }
        else if (mApp.getPrimary("anger")){
            Intent secondAct = new Intent(this, AngerActivity.class);
            startActivity(secondAct);
        }
        else if (mApp.getPrimary("disgust")){
            Intent secondAct = new Intent(this, DisgustActivity.class);
            startActivity(secondAct);
        }
        else if (mApp.getPrimary("sad")){
            Intent secondAct = new Intent(this, SadActivity.class);
            startActivity(secondAct);
        }
        else {
            Intent summaryAct = new Intent(this, SummaryActivity.class);
            startActivity(summaryAct);
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
