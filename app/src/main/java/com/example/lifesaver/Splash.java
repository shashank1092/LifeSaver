package com.example.lifesaver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class Splash extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
                public void run() {
                     Intent i=new Intent(Splash.this,LifeSaver.class);
                     startActivity(i);
                        finish();
                }
        }, secondsDelayed *100);
    }
}
	


