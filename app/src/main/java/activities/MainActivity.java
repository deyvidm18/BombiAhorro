package activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bombiahorro.R;

import fragment.Calculate;
import fragment.Game;
import fragment.History;
import fragment.ScreenLoader;
import fragment.Tips;

public class MainActivity extends FragmentActivity {

    public static final String CALCULATE = "Calculate";
    public static final String AYUDA = "Help";
    public static final String CREDITS = "Credits";
    public static final String TIPS = "Tips";
    public static final String HISTORY = "History";
    public static final String GAME = "Game";
    public static final String SCREEN_LOADER = "ScreenLoader";
    public static final String JUEGO = "Juego";
    public static final String GAMEOVER = "Gameover";
    public static final String PUNTAJES = "Puntaje";
    public Calculate calculateFragment;
    public Tips tipsFragment;
    public History historyFragment;
    public Game gameFragment;
    public Ayuda ayudaFragment;
    public Creditos creditoFragment;
    public Slt juegoFragment;
    public GameOver gameoverFragment;
    public Puntajes puntajeFragment;
    FragmentTransaction transaction;
    private ScreenLoader screenLoaderFragment;
    private ScreenLoaderActivity sla;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_calculate: {
                if (getSupportFragmentManager().findFragmentByTag(CALCULATE) == null
                        || !getSupportFragmentManager()
                        .findFragmentByTag(CALCULATE).isVisible()) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal, calculateFragment,
                            CALCULATE);
                    transaction.addToBackStack(CALCULATE);
                    transaction.commit();
                }
                break;
            }

            case R.id.menu_game: {
                if (getSupportFragmentManager().findFragmentByTag(GAME) == null
                        || !getSupportFragmentManager().findFragmentByTag(GAME)
                        .isVisible()) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal, gameFragment, GAME);
                    transaction.addToBackStack(GAME);
                    transaction.commit();
                }
                break;
            }
            case R.id.menu_tips: {
                if (getSupportFragmentManager().findFragmentByTag(TIPS) == null
                        || !getSupportFragmentManager().findFragmentByTag(TIPS)
                        .isVisible()) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal, tipsFragment, TIPS);
                    transaction.addToBackStack(TIPS);
                    transaction.commit();

                }
                break;
            }
            case R.id.menu_history: {
                if (getSupportFragmentManager().findFragmentByTag(HISTORY) == null
                        || !getSupportFragmentManager().findFragmentByTag(HISTORY)
                        .isVisible()) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal, historyFragment,
                            HISTORY);
                    transaction.addToBackStack(HISTORY);
                    transaction.commit();
                }
                break;
            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculateFragment = new Calculate();
        tipsFragment = new Tips();
        gameFragment = new Game();
        historyFragment = new History();
        ayudaFragment = new Ayuda();
        creditoFragment = new Creditos();
        juegoFragment = new Slt();
        gameoverFragment = new GameOver();
        puntajeFragment = new Puntajes();
        setContentView(R.layout.main_activity);
        transaction = getSupportFragmentManager().beginTransaction();
        screenLoaderFragment = new ScreenLoader();
        transaction.add(R.id.fragmentPrincipal, screenLoaderFragment,
                SCREEN_LOADER).commit();
        Thread screenTimer = new Thread() {
            public void run() {
                try {
                    sleep(3000);

                    transaction = getSupportFragmentManager()
                            .beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal,
                            calculateFragment, CALCULATE);
                    transaction.addToBackStack(CALCULATE);
                    transaction.commit();
                } catch (InterruptedException e) {
                    // TODO Manejo de Excepciones
                }
            }
        };
        screenTimer.start();
    }

}
