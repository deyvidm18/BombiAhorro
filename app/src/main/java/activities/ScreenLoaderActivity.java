package activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import com.example.bombiahorro.R;

public class ScreenLoaderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_loader);
        Thread screenTimer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    startActivity(
                            (new Intent(getApplication(),
                                    MainActivity.class)),
                            ActivityOptions.makeCustomAnimation(
                                    getApplicationContext(), R.anim.animation,
                                    R.anim.animation2).toBundle());
                } catch (InterruptedException e) {
                    // TODO Manejo de Excepciones
                } finally {
                    finish();
                }
            }
        };
        screenTimer.start();
    }
}
