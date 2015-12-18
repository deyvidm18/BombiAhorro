package activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

import com.example.bombiahorro.R;

import dao.GameDAO;
import logic.ImageAdapter;
import logic.JuegoProcess;
import model.BombilloModel;
import model.HuecoModel;

public class Slt extends Fragment {

    private FragmentTransaction transaction;
    private ImageAdapter ima;
    private int bombipos = -1;
    private int puntuacion = 0;
    private int vidas = 3;
    private Handler step;
    private Handler step2;
    private Handler step3;
    private Handler Update;
    private Handler Update2;
    private JuegoProcess jp;
    private JuegoProcess pruebahilo;
    private JuegoProcess pruebahilo2;
    private boolean posbombi = true;
    private BombilloModel bombi = new BombilloModel();
    private double prob = 0.60;
    private GameDAO gameDAO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameDAO = new GameDAO(getActivity());
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //setContentView(R.layout.startgame);

        final View juegoView = inflater.inflate(R.layout.startgame, container,
                false);


        final TextView scoreTview = (TextView) juegoView.findViewById(R.id.Score);
        final TextView lifeTview = (TextView) juegoView.findViewById(R.id.Life);
//		final ImageView vida3 = (ImageView) juegoView.findViewById(R.id.corazon3);
//		final ImageView vida2 = (ImageView) juegoView.findViewById(R.id.corazon2);
//		final ImageView vida1 = (ImageView) juegoView.findViewById(R.id.corazon1);
        final GridView gw = (GridView) juegoView.findViewById(R.id.gridview);
        step = new ChangeImage();
        step2 = new ChangeImage();
        step3 = new ChangeImage();
        Update = new Handler();
        Update2 = new Handler();
        ima = new ImageAdapter(getActivity());
        gw.setAdapter(ima);

        gw.setOnItemClickListener(new OnItemClickListener() {


            public void onItemClick(AdapterView<?> parent, final View v, int position, long id) {
                if (bombipos == position) {

                    Update.post(new Runnable() {

                        @Override
                        public void run() {

                            if (posbombi == true) {
                                puntuacion = puntuacion + 1;
                                scoreTview.setText("Puntos: " + puntuacion);
                                scoreTview.refreshDrawableState();
                                if (puntuacion == 10) {
                                    setProbability(0.50);
                                    pruebahilo = new JuegoProcess(step2);
                                    pruebahilo.start();
                                    //jp.setTimeToWait(400);

                                    //aqui se debe mostrar varios muÒecos a la vez
                                } else if (puntuacion == 20) {
                                    pruebahilo2 = new JuegoProcess(step3);
                                    pruebahilo2.start();
                                    setProbability(0.48);
                                    //jp.setTimeToWait(300);
                                }
                            } else {
                                switch (vidas) {
                                    case 3:
                                        juegoView.findViewById(R.id.corazon3).setVisibility(View.INVISIBLE);
                                        break;
                                    case 2:
                                        juegoView.findViewById(R.id.corazon2).setVisibility(View.INVISIBLE);
                                        break;
                                    case 1:
                                        juegoView.findViewById(R.id.corazon1).setVisibility(View.INVISIBLE);
                                        break;

                                }
                                vidas = vidas - 1;
                                if (vidas == 0) {
                                    if (jp != null && jp.isAlive())
                                        jp.stopThread();
                                    if (pruebahilo != null && pruebahilo.isAlive())
                                        pruebahilo.stopThread();
                                    if (pruebahilo2 != null && pruebahilo2.isAlive())
                                        pruebahilo2.stopThread();
                                    gameDAO.Agregar(puntuacion);
                                    //aqui se deberia guardar la ultima puntacion y a√íadir a la lista de los 10 ptjes mas altos
                                    //									Intent gameOverIntent = new Intent(Slt.this, GameOver.class);
                                    //									startActivity(gameOverIntent);
                                    transaction = getActivity().getSupportFragmentManager()
                                            .beginTransaction();
                                    transaction.replace(R.id.fragmentPrincipal,
                                            ((MainActivity) getActivity()).gameoverFragment,
                                            MainActivity.GAMEOVER);
                                    transaction.addToBackStack(MainActivity.GAMEOVER);
                                    transaction.commit();


                                    //finish();

                                }
                            }

                        }
                    });
                }
            }
        });

        jp = new JuegoProcess(step);
        jp.start();
        return juegoView;

    }

//	public Activity getActivity() {
//
//		return this.getActivity();
//	}

    public void setProbability(double prob) {
        this.prob = prob;
    }

    private class ChangeImage extends Handler {

        HuecoModel hueco = new HuecoModel();
        private int posanterior = -1;

        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();

            bombipos = bundle.getInt("newPosition");
            if (Math.random() < prob) {
                ima.setItem(bombipos, bombi.getBombi());
                posbombi = true;
            } else {
                ima.setItem(bombipos, bombi.getEnchufe());

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
