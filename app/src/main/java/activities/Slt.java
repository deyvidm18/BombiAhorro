package activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

import com.example.bombiahorro.R;

import logic.ImageAdapter;
import logic.JuegoProcess;
import model.Bombillo;
import model.Hueco;

public class Slt extends Activity {

    private ImageAdapter ima;
    private int bombipos = -1;
    private int puntuacion = 0;
    private int vidas = 3;
    private Handler step;
    private Handler Update;
    private JuegoProcess jp;
    private boolean posbombi = true;
    private Bombillo bombi = new Bombillo();
    private double prob = 0.7;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startgame);
        final TextView scoreTview = (TextView) findViewById(R.id.Score);
        final TextView lifeTview = (TextView) findViewById(R.id.Life);
        final GridView gw = (GridView) findViewById(R.id.gridview);
        step = new ChangeImage();
        Update = new Handler();
        ima = new ImageAdapter(this);
        gw.setAdapter(ima);

        gw.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View v, int position, long id) {
                if (bombipos == position) {

                    Update.post(new Runnable() {

                        @Override
                        public void run() {

                            if (posbombi == true) {
                                puntuacion = puntuacion + 1;
                                scoreTview.setText("Score: " + puntuacion);
                                scoreTview.refreshDrawableState();
                                if (puntuacion == 20) {
                                    setProbability(0.60);
                                    jp.setTimeToWait(700);

                                } else if (puntuacion == 50) {
                                    setProbability(0.45);
                                    jp.setTimeToWait(500);
                                }
                            } else {
                                vidas = vidas - 1;
                                lifeTview.setText("Life: " + vidas);
                                lifeTview.refreshDrawableState();
                                if (vidas == 0) {
                                    jp.stopThread();

                                    Intent gameOverIntent = new Intent(Slt.this, GameOver.class);
                                    startActivity(gameOverIntent);
                                    finish();

                                }
                            }

                        }
                    });
                }
            }
        });
        jp = new JuegoProcess(step);
        jp.start();

    }

    public Activity getActivity() {

        return this.getActivity();
    }

    public void setProbability(double prob) {
        this.prob = prob;
    }

    private class ChangeImage extends Handler {

        Hueco hueco = new Hueco();
        private int posanterior = -1;

        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();

            bombipos = bundle.getInt("newPosition");
            if (Math.random() < prob) {
                ima.setItem(bombipos, bombi.getBombi());
                posbombi = true;
            } else {
                ima.setItem(bombipos, bombi.getMariposa());

                posbombi = false;
            }

            if (posanterior != -1 && bombipos != posanterior) {
                ima.setItem(posanterior, hueco.getHueco());
            }

            posanterior = bombipos;
            ima.notifyDataSetChanged();
        }

    }

}
