package com.zwl.studytoucheventdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.blankj.utilcode.util.KeyboardUtils;

public class MainActivity extends AppCompatActivity {

    private ScrollEditText editText;
    private NestedScrollView scrollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        scrollview = findViewById(R.id.scrollview);


        KeyboardUtils.registerSoftInputChangedListener(this, new KeyboardUtils.OnSoftInputChangedListener() {
            @Override
            public void onSoftInputChanged(int height) {
                if(height>0){
                    scrollview.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            scrollview.requestFocus();
                            scrollview.smoothScrollTo(0,editText.getTop());
                        }
                    },300);
                }

            }
        });
    }


}
