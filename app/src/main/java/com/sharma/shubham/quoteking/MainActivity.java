package com.sharma.shubham.quoteking;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private InterstitialAd mInterstitialAd;
    private static Context mContext;
    ListView listView;
    CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

//        if(!isNetworkAvailable()) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//            builder.setMessage("Please Connect To Internet")
//                    .setTitle("Connection Not Available")
//                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            finish();
//                        }
//                    });
//            AlertDialog dialog = builder.create();
//            dialog.show();
//        }

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6732968655816813~9633647682");

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("0C5A165E606F9A407A2C5D36FEF2A240")
                .build();

//        String[] categories = {"Motivation","Inspiration","Love","Family","Success","Friendship"};
//        String[] images = {"love","love","love","love","love","love"};
//        ArrayList<String> a1 = new ArrayList<String>();
//        ArrayList<String> a2 = new ArrayList<String>();
//        for(int i=0;i<categories.length;i++) {
//            a1.add(categories[i]);
//            a2.add(images[i]);
//        }

        ArrayList<Category> cat = new ArrayList<Category>();
        cat.add(new Category("Motivation","love"));
        cat.add(new Category("Friendship","love"));
        cat.add(new Category("Love","love"));
        cat.add(new Category("Family","love"));


        adapter = new CategoryAdapter(this,R.layout.home_list,cat);

        listView=(ListView) findViewById(R.id.category_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        /*Display display = ((WindowManager) getSystemService(WINDOW_SERVICE))
                .getDefaultDisplay();

        int orientation = display.getRotation();

        if (orientation == Surface.ROTATION_90
                || orientation == Surface.ROTATION_270) {
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-6732968655816813/7083807280");
            mInterstitialAd.loadAd(adRequest);
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {

                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }

                }
            });
        }
        else {
            AdView mAdView = (AdView) findViewById(R.id.adView);
            mAdView.loadAd(adRequest);
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Category category = (Category) parent.getItemAtPosition(position);
        String selectedCat = category.getName().toLowerCase();
        Intent intent = new Intent(this,QuotesList.class);
        intent.putExtra("cat",selectedCat);
        startActivity(intent);
    }

    // Check all connectivities whether available or not
    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }
}
