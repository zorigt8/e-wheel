package com.zorigt.e_wheel;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SurpriseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surprise);

        final Initializer mApp = ((Initializer) getApplicationContext());

        final Switch s_startled = (Switch) findViewById(R.id.switch_startled);
        final CheckBox cb_shocked = (CheckBox) findViewById(R.id.checkBox_shocked);
        final CheckBox cb_dismayed = (CheckBox) findViewById(R.id.checkBox_dismayed);
        final Switch s_excited = (Switch) findViewById(R.id.switch_excited);
        final CheckBox cb_eager = (CheckBox) findViewById(R.id.checkBox_eager);
        final CheckBox cb_energetic = (CheckBox) findViewById(R.id.checkBox_energetic);
        final Button btn_next = (Button) findViewById(R.id.btn_next);

        s_startled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!mApp.getSecondary("startled")){
                    mApp.setSecondary("startled");
                    cb_shocked.setVisibility(View.VISIBLE);
                    cb_dismayed.setVisibility(View.VISIBLE);
                    s_startled.setTextColor(Color.parseColor("#33cccc"));
                } else {
                    mApp.unsetSecondary("startled");
                    cb_shocked.setVisibility(View.INVISIBLE);
                    cb_dismayed.setVisibility(View.INVISIBLE);
                    if (cb_shocked.isChecked()) {
                        cb_shocked.toggle();
                        mApp.unsetSecondary("shocked");
                    }
                    if (cb_dismayed.isChecked()) {
                        cb_dismayed.toggle();
                        mApp.unsetSecondary("dismayed");
                    }
                    s_startled.setTextColor( Color.BLACK );
                }

                Log.d("json obj: ", mApp.getSecondaryJson().toString());
            }
        });


        cb_shocked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb_shocked.isChecked()) {
                    mApp.setSecondary("shocked");
                    Log.d("json obj: ", mApp.getSecondaryJson().toString());
                } else {
                    mApp.unsetSecondary("shocked");
                    Log.d("json obj: ", mApp.getSecondaryJson().toString());
                }
            }
        });

        cb_dismayed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb_dismayed.isChecked()) {
                    mApp.setSecondary("dismayed");
                    Log.d("json obj: ", mApp.getSecondaryJson().toString());
                } else {
                    mApp.unsetSecondary("dismayed");
                }
            }
        });

        s_excited.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!mApp.getSecondary("excited")){
                    mApp.setSecondary("excited");
                    cb_eager.setVisibility(View.VISIBLE);
                    cb_energetic.setVisibility(View.VISIBLE);
                    s_excited.setTextColor(Color.parseColor("#33cccc"));
                } else {
                    mApp.unsetSecondary("excited");
                    cb_eager.setVisibility(View.INVISIBLE);
                    cb_energetic.setVisibility(View.INVISIBLE);
                    if (cb_eager.isChecked()) {
                        cb_eager.toggle();
                        mApp.unsetSecondary("eager");
                    }
                    if (cb_energetic.isChecked()) {
                        cb_energetic.toggle();
                        mApp.unsetSecondary("energetic");
                    }
                    s_excited.setTextColor( Color.BLACK );
                }

                Log.d("json obj: ", mApp.getSecondaryJson().toString());
            }
        });


        cb_eager.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb_eager.isChecked()) {
                    mApp.setSecondary("eager");
                    Log.d("json obj: ", mApp.getSecondaryJson().toString());
                } else {
                    mApp.unsetSecondary("eager");
                    Log.d("json obj: ", mApp.getSecondaryJson().toString());
                }
            }
        });

        cb_energetic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb_energetic.isChecked()) {
                    mApp.setSecondary("energetic");
                    Log.d("json obj: ", mApp.getSecondaryJson().toString());
                } else {
                    mApp.unsetSecondary("energetic");
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

    public void secondPage(View view){

        Intent summaryAct = new Intent(this, SummaryActivity.class);
        startActivity(summaryAct);
    }
}
