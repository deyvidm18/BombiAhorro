package activities;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bombiahorro.R;

import fragment.CalculateFragment;
import fragment.GameFragment;
import fragment.HistoryFragment;
import fragment.TipsFragment;

public class MainActivity extends FragmentActivity {

    public static final String CALCULATE = "CalculateFragment";
    public static final String AYUDA = "Help";
    public static final String CREDITS = "Credits";
    public static final String TIPS = "TipsFragment";
    public static final String HISTORY = "HistoryFragment";
    public static final String GAME = "GameFragment";
    public static final String JUEGO = "Juego";
    public static final String GAMEOVER = "Gameover";
    public static final String PUNTAJES = "Puntaje";
    public CalculateFragment calculateFragment;
    public TipsFragment tipsFragment;
    public HistoryFragment historyFragment;
    public GameFragment gameFragment;
    public Ayuda ayudaFragment;
    public Creditos creditoFragment;
    public Slt juegoFragment;
    public GameOver gameoverFragment;
    public Puntajes puntajeFragment;
    public FragmentTransaction transaction;
    private boolean isFirstTime = true;

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
                    transaction.commit();
                }
                break;
            }
            case R.id.menu_tips: {
                if (getSupportFragmentManager().findFragmentByTag(TIPS) == null
                        || !getSupportFragmentManager().findFragmentByTag(TIPS)
                        .isVisible()) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal, TipsFragment.getInstance(), TIPS);
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
        calculateFragment = new CalculateFragment();
        tipsFragment = new TipsFragment();
        gameFragment = new GameFragment();
        historyFragment = new HistoryFragment();
        ayudaFragment = new Ayuda();
        creditoFragment = new Creditos();
        juegoFragment = new Slt();
        gameoverFragment = new GameOver();
        puntajeFragment = new Puntajes();
        setContentView(R.layout.main_activity);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentPrincipal, new CalculateFragment());
        transaction.commit();
        isFirstTime = false;

    }

}
