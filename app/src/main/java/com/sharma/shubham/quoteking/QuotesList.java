package com.sharma.shubham.quoteking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.Firebase;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubham on 12/31/2015.
 */
public class QuotesList extends AppCompatActivity {

    private List<Quote> quotesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private QuoteAdapter quotesAdapter;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_list);

        Firebase.setAndroidContext(this);

        getSupportActionBar().setElevation(0f);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        quotesAdapter = new QuoteAdapter(quotesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(quotesAdapter);


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Quote quote = quotesList.get(position);
                        String msg = quote.getQuote();
                        String author = quote.getAuthor();
                        Bundle bundle = new Bundle();
                        bundle.putString("quote",msg);
                        bundle.putString("author",author);
                        Intent intent = new Intent(QuotesList.this,QuoteInfo.class);
                        intent.putExtra("quoteInfo",bundle);
                        startActivity(intent);
                    }
                })
        );

        String cat = getIntent().getStringExtra("cat").toLowerCase();

        Firebase mDatabase = new Firebase("https://shubham-project.firebaseio.com/quotes");

        mDatabase.child(cat).addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Quote quote = dataSnapshot.getValue(Quote.class);
                quotesList.add(quote);
                quotesAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });

        //mDatabase.keepSynced(true);


        // Use Firebase to populate the list.
//        mDatabase.child("quotes").child(cat).addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                Quote quote = new Quote((String) dataSnapshot.child("quote").getValue(),
//                                        (String) dataSnapshot.child("author").getValue());
//                quotesList.add(quote);
//                quotesAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                quotesList.remove((String) dataSnapshot.child("quote").getValue());
//                quotesAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

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

}
