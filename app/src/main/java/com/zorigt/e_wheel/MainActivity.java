package com.zorigt.e_wheel;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.vungle.publisher.VunglePub;


public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    // get the VunglePub instance
    final VunglePub vunglePub = VunglePub.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();



        // get your App ID from the app's main page on the Vungle Dashboard after setting up your app
        //final String app_id = "58542b8f49704450630001b8";

        // initialize the Publisher SDK
        //vunglePub.init(this, app_id);

        //onLevelComplete();



        final Initializer mApp = ((Initializer) getApplicationContext());
        mApp.initPrimary();
        mApp.initSecondary();

        //Log.d("json obj: ", mApp.getPrimary().toString());

        final Button btn_happy = (Button) findViewById(R.id.happy);
        final Button btn_sad = (Button) findViewById(R.id.sad);
        final Button btn_anger = (Button) findViewById(R.id.anger);
        final Button btn_fear = (Button) findViewById(R.id.fear);
        final Button btn_surprise = (Button) findViewById(R.id.surprise);
        final Button btn_disgust = (Button) findViewById(R.id.disgust);
        Button btn_next = (Button) findViewById(R.id.next1);


        btn_happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imgView = (ImageView)findViewById(R.id.happy_check);
                if (mApp.setPrimary("happy")){
                    imgView.setVisibility(View.VISIBLE);
                    btn_happy.setTextColor(Color.parseColor("#33cccc"));
                } else {
                    imgView.setVisibility(View.INVISIBLE);
                    btn_happy.setTextColor( Color.BLACK );
                }
            }
        });
        btn_sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imgView = (ImageView)findViewById(R.id.sad_check);
                if (mApp.setPrimary("sad")){
                    imgView.setVisibility(View.VISIBLE);
                    btn_sad.setTextColor(Color.parseColor("#33cccc"));
                } else {
                    imgView.setVisibility(View.INVISIBLE);
                    btn_sad.setTextColor( Color.BLACK );
                }
            }
        });
        btn_anger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imgView = (ImageView)findViewById(R.id.anger_check);
                if (mApp.setPrimary("anger")) {
                    imgView.setVisibility(View.VISIBLE);
                    btn_anger.setTextColor(Color.parseColor("#33cccc"));
                } else {
                    imgView.setVisibility(View.INVISIBLE);
                    btn_anger.setTextColor( Color.BLACK );
                }
            }
        });
        btn_fear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imgView = (ImageView)findViewById(R.id.fear_check);
                if (mApp.setPrimary("fear")){
                    imgView.setVisibility(View.VISIBLE);
                    btn_fear.setTextColor(Color.parseColor("#33cccc"));
                } else {
                    imgView.setVisibility(View.INVISIBLE);
                    btn_fear.setTextColor( Color.BLACK );
                }
            }
        });
        btn_surprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imgView = (ImageView)findViewById(R.id.surprise_check);
                if (mApp.setPrimary("surprise")){
                    imgView.setVisibility(View.VISIBLE);
                    btn_surprise.setTextColor(Color.parseColor("#33cccc"));
                } else {
                    imgView.setVisibility(View.INVISIBLE);
                    btn_surprise.setTextColor( Color.BLACK );
                }
            }
        });
        btn_disgust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imgView = (ImageView)findViewById(R.id.disgust_check);
                if (mApp.setPrimary("disgust")){
                    imgView.setVisibility(View.VISIBLE);
                    //btn_disgust.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
                    btn_disgust.setTextColor(Color.parseColor("#33cccc"));
                } else {
                    imgView.setVisibility(View.INVISIBLE);
                    btn_disgust.setTextColor( Color.BLACK );
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

        final Initializer mApp = ((Initializer) getApplicationContext());

        if (mApp.getPrimary("happy")) {
            Intent secondAct = new Intent(this, HappyActivity.class);
            startActivity(secondAct);
            Log.d("pimary", " happy");
        }
        else if (mApp.getPrimary("surprise")){
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
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    private void onLevelComplete() {
        vunglePub.playAd();
    }

}
