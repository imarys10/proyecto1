package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        private TextView text;
        private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       image = (ImageView)findViewById(R.id.image) ;
        text = (TextView) findViewById(R.id.text);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(image,"translationY",-1000,0),
                ObjectAnimator.ofFloat(image,"alpha",0,1),
                ObjectAnimator.ofFloat(text,"translationX",-200,0)
        );
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(2000);
        animatorSet.addListener(new AnimatorListenerAdapter(){
            @Override public void onAnimationEnd(Animator animation) {

                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(
                        ObjectAnimator.ofFloat(image,"scaleX", 1f, 0.5f, 1f),
                        ObjectAnimator.ofFloat(image,"scaleY", 1f, 0.5f, 1f)
                );
                animatorSet2.setInterpolator(new AccelerateInterpolator());
                animatorSet2.setDuration(1000);
                animatorSet2.start();

            }
        });
        animatorSet.start();



    }
}