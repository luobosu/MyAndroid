package com.harvey.suhongwei.myandroid.EventBus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.harvey.suhongwei.myandroid.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SubscriberActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriber);
        EventBus.getDefault().register(this);
        textView = findViewById(R.id.tvTest);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubscriberActivity.this.startActivity(new Intent(SubscriberActivity.this,ObservableActivity.class));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTestEvent(TestEvent testEvent){
        int number = testEvent.getNumber();
        textView.setText(String.valueOf(number));
        Toast.makeText(this, ""+number, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
