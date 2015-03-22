package activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.bombiahorro.R;

public class Menu extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button StartGameButton = (Button) findViewById(R.id.StartGame);
        StartGameButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent StartGameIntent = new Intent(Menu.this, Slt.class);
                startActivity(StartGameIntent);
                finish();

            }
        });

        Button HelpButton = (Button) findViewById(R.id.Help);
        HelpButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent HelpIntent = new Intent(Menu.this, Ayuda.class);
                startActivity(HelpIntent);
            }
        });


        Button CreditsButton = (Button) findViewById(R.id.Credits);
        CreditsButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent CreditsIntent = new Intent(Menu.this, Creditos.class);
                startActivity(CreditsIntent);
            }
        });
    }

    public Activity getActivity() {

        return this.getActivity();
    }
}
