package com.foldingapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.foldingapplication.R;
import com.foldingapplication.commons.views.FoldingCell;


public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cell_example);
        this.setTitle("例子");

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
