package com.foldingapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.foldingapplication.R;
import com.foldingapplication.commons.views.FoldingCell;

import butterknife.ButterKnife;

/**
 * Created by shijie.yang on 2017/10/31.
 */

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        ButterKnife.bind(this);
        this.setTitle("测试");

        // get our folding cell
        final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);

        // attach click listener to toast btn
        final Button toggleInstantlyBtn = (Button) findViewById(R.id.toggle_instant_btn);
        toggleInstantlyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(true);
            }
        });

        // attach click listener to fold btn
        final Button toggleBtn = (Button) findViewById(R.id.toggle_btn);
        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });
    }

}
