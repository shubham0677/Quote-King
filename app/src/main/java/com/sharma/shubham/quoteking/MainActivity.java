package com.sharma.shubham.quoteking;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String[] categories={"Motivational","Success","Love","Family","Job","Friendship","Humour","Relationship"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.home_list,categories);

        ListView listView=(ListView) findViewById(R.id.category_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

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
        Intent intent;
    switch (position){
        case 0:
            intent=new Intent(MainActivity.this,MotivationalQuotes.class);
            startActivity(intent);
            break;
        case 1:
            intent=new Intent(MainActivity.this,SuccessQuotes.class);
            startActivity(intent);
            break;
        case 2:
            intent=new Intent(MainActivity.this,LoveQuotes.class);
            startActivity(intent);
            break;
        case 3:
            intent=new Intent(MainActivity.this,FamilyQuotes.class);
            startActivity(intent);
            break;
        case 4:
            intent=new Intent(MainActivity.this,JobQuotes.class);
            startActivity(intent);
            break;
        case 5:
            intent=new Intent(MainActivity.this,FriendshipQuotes.class);
            startActivity(intent);
            break;
        case 6:
            intent=new Intent(MainActivity.this,HumorQuotes.class);
            startActivity(intent);
            break;
        case 7:
            intent=new Intent(MainActivity.this,RelationshipQuotes.class);
            startActivity(intent);
            break;
        default:
            Toast.makeText(this,"ERROR OCCURED",Toast.LENGTH_SHORT).show();
            break;
    }
    }
}
