package com.yumore.resultapis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String receive = getIntent().getStringExtra(ContractConstants.CONTRACT_EXTRA_NAME);
        TextView textView = findViewById(R.id.receive_data);
        textView.setText(String.format("接收到的数据：%s", receive));

        findViewById(R.id.result_data).setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra(ContractConstants.CONTRACT_EXTRA_RESULT, SecondActivity.class.getSimpleName() + "页面返回的数据");
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

    }
}