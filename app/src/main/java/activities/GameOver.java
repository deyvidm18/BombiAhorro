package activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.bombiahorro.R;

public class GameOver extends Activity {
    /**
     * Called when the activity is first created.
     */


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);
        Button RestartGameButton = (Button) findViewById(R.id.restart);
        RestartGameButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent RestartGameIntent = new Intent(GameOver.this, Menu.class);
                startActivity(RestartGameIntent);

            }
        });

        Button QuitButton = (Button) findViewById(R.id.quit);
        QuitButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
                //mg.getActivity().moveTaskToBack(true);
                //      android.os.Process.sendSignal(pid, 3);


            }
        });

    }

}
