package com.harvey.suhongwei.myandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.harvey.suhongwei.myandroid.EventBus.SubscriberActivity;

public class MainActivity extends AppCompatActivity {
    private static final String MMKV = "MMKV";
    private static final String PROTOBUF = "protobuf";
    private static final String EVENTBUS = "eventbus";

    private ListView lvMain;

    private static final String[] itemList = new String[]{
            MMKV,PROTOBUF,EVENTBUS
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = findViewById(R.id.lvMain);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,itemList);
        lvMain.setAdapter(arrayAdapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemName = itemList[i];
                if (MMKV.equals(itemName)){

                }else if (PROTOBUF.equals(itemName)){

                }else if (EVENTBUS.equals(itemName)){
                    MainActivity.this.startActivity(new Intent(MainActivity.this,SubscriberActivity.class));
                }
            }
        });
    }



}
