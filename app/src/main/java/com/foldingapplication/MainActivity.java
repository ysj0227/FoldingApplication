package com.foldingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.foldingapplication.activity.ExampleActivity;
import com.foldingapplication.activity.ListviewActivity;
import com.foldingapplication.activity.TestActivity;
import com.foldingapplication.activity.myListview.MyTestListViewActivity;
import com.foldingapplication.animation.AnimationActivity;
import com.foldingapplication.pulltorefresh.PullToRefreshActivity;
import com.foldingapplication.recyclerview.RecylerViewActivcity;
import com.foldingapplication.recyclerview.Tint_Clip_elevationAy;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnListView, btnExample, btnTest, btnTestListView,
            btnRecyclerView, btnOther, btnPullToRefresh, btnAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListView = (Button) findViewById(R.id.btnListView);
        btnExample = (Button) findViewById(R.id.btnExample);
        btnTest = (Button) findViewById(R.id.btnTest);
        btnTestListView = (Button) findViewById(R.id.btnTestListView);
        btnRecyclerView = (Button) findViewById(R.id.btnRecyclerView);
        btnOther = (Button) findViewById(R.id.btnOther);
        btnPullToRefresh = (Button) findViewById(R.id.btnPullToRefresh);
        btnAnimation = (Button) findViewById(R.id.btnAnimation);

        btnListView.setOnClickListener(this);
        btnExample.setOnClickListener(this);
        btnTest.setOnClickListener(this);
        btnTestListView.setOnClickListener(this);
        btnRecyclerView.setOnClickListener(this);
        btnOther.setOnClickListener(this);
        btnPullToRefresh.setOnClickListener(this);
        btnAnimation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnListView:
                Intent i = new Intent(this, ListviewActivity.class);
                startActivity(i);
                break;
            case R.id.btnExample:
                Intent r = new Intent(this, ExampleActivity.class);
                startActivity(r);
                break;
            case R.id.btnTest:
                Intent k = new Intent(this, TestActivity.class);
                startActivity(k);
                break;
            case R.id.btnTestListView:
                Intent h = new Intent(this, MyTestListViewActivity.class);
                startActivity(h);
                break;
            case R.id.btnRecyclerView:
                Intent rv = new Intent(this, RecylerViewActivcity.class);
                startActivity(rv);
                break;
            case R.id.btnOther:
                Intent vs = new Intent(this, Tint_Clip_elevationAy.class);
                startActivity(vs);
                break;
            case R.id.btnPullToRefresh:
                Intent t = new Intent(this, PullToRefreshActivity.class);
                startActivity(t);
                break;
            case R.id.btnAnimation:
                Intent ts = new Intent(this, AnimationActivity.class);
                startActivity(ts);
                break;

            default:
                break;

        }

    }
}
