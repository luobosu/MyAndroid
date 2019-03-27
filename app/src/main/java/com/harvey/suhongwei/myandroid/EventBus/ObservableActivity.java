package com.harvey.suhongwei.myandroid.EventBus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.harvey.suhongwei.myandroid.R;

import org.greenrobot.eventbus.EventBus;

public class ObservableActivity extends AppCompatActivity {
    private TextView tvOb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observable);
        tvOb = findViewById(R.id.tvOb);
        tvOb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new TestEvent(123));
            }
        });
    }
}
