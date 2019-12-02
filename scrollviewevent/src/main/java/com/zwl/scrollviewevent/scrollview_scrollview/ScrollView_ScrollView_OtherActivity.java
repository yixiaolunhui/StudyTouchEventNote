package com.zwl.scrollviewevent.scrollview_scrollview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zwl.scrollviewevent.R;
import com.zwl.scrollviewevent.utils.ResourceUtil;

/**
 * @author zwl
 * @describe 优化拦截demo
 * @date on 2019-11-29
 */
public class ScrollView_ScrollView_OtherActivity extends AppCompatActivity implements View.OnClickListener {


    public static void start(Context context) {
        context.startActivity(new Intent(context, ScrollView_ScrollView_OtherActivity.class));
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview_scrollview_other);

        for (int i = 1; i <= 30; i++) {
            int outIndex = ResourceUtil.getId(this, "out_tv" + i);
            if (findViewById(outIndex) != null) {
                findViewById(outIndex).setOnClickListener(this);
            }
            int inIndex = ResourceUtil.getId(this, "in_tv" + i);
            if (findViewById(inIndex) != null) {
                findViewById(inIndex).setOnClickListener(this);
            }
        }

    }


    @Override
    public void onClick(View v) {
        if (v instanceof TextView) {
            Toast.makeText(this, ((TextView) v).getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
