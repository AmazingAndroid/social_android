package com.example.lovekeshkumar.projectmvpbase.activity.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.font.RobotoTextView;
import com.example.lovekeshkumar.projectmvpbase.model.CommonMethod;

public class SplashIntoduction extends AppCompatActivity {

    ImageView wahho_logo,image_dog;
    RobotoTextView main_text,btn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_intoduction);
        wahho_logo=(ImageView)findViewById(R.id.wahho_logo);
        image_dog=(ImageView)findViewById(R.id.image_dog);
        main_text=(RobotoTextView)findViewById(R.id.main_text);
        btn_start=(RobotoTextView)findViewById(R.id.btn_start);


        CommonMethod.animation2(wahho_logo, SplashIntoduction.this);
        CommonMethod.animation3(main_text);
       // CommonMethod.animation2(btn_start, this);
/*        YoYo.with(Techniques.SlideInDown)
                .duration(2500)
                .playOn(wahho_logo);*/


        YoYo.with(Techniques.Shake)
                .duration(1000)
                .playOn(image_dog);
        YoYo.with(Techniques.Bounce)
                .duration(1000)
                .playOn(btn_start);
    }
}
