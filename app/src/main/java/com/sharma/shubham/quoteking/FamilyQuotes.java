package com.sharma.shubham.quoteking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Shubham on 12/31/2015.
 */
public class FamilyQuotes extends Activity {

    private ListView listView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_quotes);

        this.listView=(ListView) findViewById(R.id.listViewfam);
        DatabaseAccess databaseAccess=DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> mquotes=databaseAccess.getQuotes3();
        databaseAccess.close();

        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.home_list,mquotes);
        this.listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String qinfo=adapter.getItem(position);
                Intent intent=new Intent(FamilyQuotes.this,QuoteInfo.class);
                intent.putExtra("message",qinfo);
                startActivity(intent);
            }
        });

    }

}
