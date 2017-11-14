package com.foldingapplication.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.foldingapplication.R;

/**
 * Created by shijie.yang on 2017/11/14.
 */

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button alpha, scale, transcale, rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        this.setTitle("Animation");
        imageView = (ImageView) findViewById(R.id.imageView);
        alpha = (Button) findViewById(R.id.alpha);
        scale = (Button) findViewById(R.id.scale);
        transcale = (Button) findViewById(R.id.transcale);
        rotate = (Button) findViewById(R.id.rotate);

        alpha.setOnClickListener(this);
        scale.setOnClickListener(this);
        transcale.setOnClickListener(this);
        rotate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alpha://渐变
                AnimationSet set = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
                alphaAnimation.setDuration(3000);
                set.addAnimation(alphaAnimation);
                imageView.startAnimation(set);
                break;
            case R.id.scale://伸缩
                AnimationSet set1 = new AnimationSet(true);
                ScaleAnimation scale = new ScaleAnimation(
                        1, 0.0f,                          //x轴从满屏缩小到无
                        1, 0.0f,                          //y轴从满屏缩小到无
                        Animation.RELATIVE_TO_SELF, 0.5f, //以自身0.5宽度为轴缩放
                        Animation.RELATIVE_TO_SELF, 0.5f);//以自身0.5高度为轴缩放
                scale.setDuration(3000);   //几秒完成动画
                set1.addAnimation(scale);  //增加动画

                imageView.startAnimation(set1);
                break;

            case R.id.transcale://平移
                AnimationSet set2 = new AnimationSet(true);
                TranslateAnimation tran = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0.0f, //x轴开始位置
                        Animation.RELATIVE_TO_SELF, 0.5f, //x轴结束位置
                        Animation.RELATIVE_TO_SELF, 0.0f, //y轴开始位置
                        Animation.RELATIVE_TO_SELF, 1.5f  //y轴结束位置
                );

                tran.setDuration(3000);
                set2.addAnimation(tran);

                imageView.startAnimation(set2);
                break;
            case R.id.rotate://旋转
                AnimationSet set3 = new AnimationSet(true);
                RotateAnimation rotate=new RotateAnimation(
                        0,360,         //旋转角度
                        Animation.RELATIVE_TO_SELF, 0.5f, //x轴位置为半个屏幕宽度
                        Animation.RELATIVE_TO_SELF, 0.0f  //y轴从原点计算
                );

                rotate.setDuration(3000);
                set3.addAnimation(rotate);

                imageView.startAnimation(set3);
                break;


            default:
                break;

        }
    }
}
