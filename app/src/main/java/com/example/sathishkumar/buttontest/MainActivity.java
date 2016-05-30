package com.example.sathishkumar.buttontest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;



public class MainActivity extends Activity implements OnClickListener {
    //public static final String DEFAULT="N/A";
    int i;
    TextView number;//number1;
    Button button;
    String getString;
    RelativeLayout bgc;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        i = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_main);
        }
        else
        {
            setContentView(R.layout.activity_main_l);
        }
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        number = (TextView) findViewById(R.id.textView);
        bgc = (RelativeLayout) findViewById(R.id.RelativeLayout);

        //number.setOnClickListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
   /* public void functionSave(View v){
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("textView",number.getText().toString());
        editor.commit();

    }

    public void functionLoad(View v){
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String number=sharedPreferences.getString("number",DEFAULT);
        number1.setText(number);
    }*/
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        getString = number.getText().toString();
        outState.putString("textView", getString);
        outState.putInt("i", i);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        number.setText(savedInstanceState.getString("textView"));
        i = savedInstanceState.getInt("i");
        color(i);
    }

    public int count()
    {
        i++;
        return i;
    }


    @Override
    public void onClick(View v)
    {

        number.setText("" + count());
        color(i);
    }

     public void color(int i)
     {
         if (i <= 5) {
            if (i == 1) {
                bgc.setBackgroundColor(Color.BLUE);
            }
            if (i == 2) {
                bgc.setBackgroundColor(Color.RED);
            }
            if (i == 3) {
                bgc.setBackgroundColor(Color.GREEN);
            }
            if (i == 4) {
                bgc.setBackgroundColor(Color.YELLOW);
            }
            if (i == 5) {
                bgc.setBackgroundColor(Color.GRAY);
            }
        } else {
            if (i % 6 == 0) bgc.setBackgroundColor(Color.WHITE);
            if (i % 6 == 1) bgc.setBackgroundColor(Color.BLUE);
            if (i % 6 == 2) bgc.setBackgroundColor(Color.RED);
            if (i % 6 == 3) bgc.setBackgroundColor(Color.GREEN);
            if (i % 6 == 4) bgc.setBackgroundColor(Color.YELLOW);
            if (i % 6 == 5) bgc.setBackgroundColor(Color.GRAY);
        }
    }


    public void functionReset(View v)
    {
        i=0;
        number.setText("0");

    }


    @Override
    public void onStart()
    {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.sathishkumar.buttontest/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop()
    {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.sathishkumar.buttontest/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    // number.setText("hi baby");}

}


