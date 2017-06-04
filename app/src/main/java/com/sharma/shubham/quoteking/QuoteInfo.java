package com.sharma.shubham.quoteking;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class QuoteInfo extends AppCompatActivity {

    private ClipboardManager myClipboard;
    private ClipData myClip;
    //private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_info);

        //MobileAds.initialize(getApplicationContext(), "ca-app-pub-6732968655816813~9633647682");

       //mInterstitialAd = new InterstitialAd(this);
        // mInterstitialAd.setAdUnitId("ca-app-pub-6732968655816813/7083807280");

        /*AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("0C5A165E606F9A407A2C5D36FEF2A240")
                .build();
        mInterstitialAd.loadAd(adRequest);*/

        TextView textView=(TextView) findViewById(R.id.textView2);
        Intent i=getIntent();
        Bundle bundle = i.getBundleExtra("quoteInfo");
        final String quote=bundle.getString("quote");
        final String author = bundle.getString("author");
        final String data = quote + "\n" + "-" + author;
        textView.setText(quote);

        /*mInterstitialAd.setAdListener(new AdListener() {
          @Override
          public void onAdLoaded() {

              if (mInterstitialAd.isLoaded()) {
                  mInterstitialAd.show();
              }

          }
      });*/

        myClipboard=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        Button btn=(Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClip=ClipData.newPlainText("quote",data);
                myClipboard.setPrimaryClip(myClip);
                Toast.makeText(getApplicationContext(),"Quote Copied",Toast.LENGTH_SHORT).show();
            }
        });

       }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quote_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

}
