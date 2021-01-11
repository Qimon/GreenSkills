package fr.ssml.greenskills.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import fr.ssml.template.R;

public class LoadingActivity extends AppCompatActivity {

    private final long INIT_LOADING_TIMEOUT = 2000;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        progressBar = findViewById(R.id.loadingProgressBar);

        ValueAnimator animator = ValueAnimator.ofInt(0, progressBar.getMax());
        animator.setDuration(INIT_LOADING_TIMEOUT);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation){
                progressBar.setProgress((Integer)animation.getAnimatedValue());
            }
        });

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent initLoading = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(initLoading);
                finish();
            }
        });
            animator.start();
    }
}