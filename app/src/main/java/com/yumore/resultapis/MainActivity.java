package com.yumore.resultapis;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private final ActivityResultLauncher<String> activityResultLauncher = registerForActivityResult(new CustomActivityResultContract(), result -> {
        Log.v(MainActivity.class.getSimpleName(), result);
        textView.setText(String.format("第二个页面回传的值：%s", result));
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.receive_data);
        findViewById(R.id.launch_second).setOnClickListener(view -> activityResultLauncher.launch("第一个页面传过去的值"));
    }
}