package activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.bombiahorro.R;


/**
 * BombiAhorro
 * Developed by Deyvid Martinez on 9/17/15.
 */
public class ScreenLoaderActivity extends Activity {

    private static final int WAIT_TIME = 2000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_screen_loader);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent);
            }
        }
                , WAIT_TIME);
    }
}
