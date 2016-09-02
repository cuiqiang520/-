package com.example.cuiqiang123.day29drawerlayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    DrawerLayout drawerLayout;
    ListView listView;
    ImageView imageView;
    List<String> datas;
    ArrayAdapter<String> adapter;
    int[] images={R.drawable.jiahe,R.drawable.jianghaokun,R.drawable.jianglai};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        drawerLayout= (DrawerLayout) findViewById(R.id.drawId);
        listView= (ListView) findViewById(R.id.listviewId);
        imageView= (ImageView) findViewById(R.id.imageId);
        initData();
        adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.item_listview,datas);
        listView.setAdapter(adapter);

        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.app_name,R.string.app_name){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText(getApplicationContext(),"---isClosed", 1).show();
                Log.d("cq","---isClosed");
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(getApplicationContext(),"---isOpened", 1).show();
                Log.d("cq","---isOpened");
            }

        };
        drawerLayout.addDrawerListener(drawerToggle);
        listView.setOnItemClickListener(this);
    }

    private void initData() {
        datas=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            datas.add("图片"+i);
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        imageView.setImageResource(images[i]);
        drawerLayout.closeDrawers();
    }
}
