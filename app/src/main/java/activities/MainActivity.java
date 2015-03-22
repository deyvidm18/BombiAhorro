package activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bombiahorro.R;

import fragment.Calculate;
import fragment.History;
import fragment.ScreenLoader;
import fragment.Tips;

public class MainActivity extends FragmentActivity {

    private static final String CALCULATE = "Calculate";
    private static final String TIPS = "Tips";
    private static final String HISTORY = "History";
    private static final String SCREEN_LOADER = "ScreenLoader";
    private FragmentTransaction transaction;
    private ScreenLoader screenLoaderFragment;
    private Calculate calculateFragment;
    private Tips tipsFragment;
    private History historyFragment;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_calculate: {
                if (getSupportFragmentManager().findFragmentByTag(CALCULATE) == null
                        || !getSupportFragmentManager().findFragmentByTag(CALCULATE).isVisible()) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal, calculateFragment, CALCULATE);
                    transaction.addToBackStack(CALCULATE);
                    transaction.commit();
                }
                break;
            }
            case R.id.menu_tips: {
                if (getSupportFragmentManager().findFragmentByTag(TIPS) == null
                        || !getSupportFragmentManager().findFragmentByTag(TIPS).isVisible()) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal, tipsFragment, TIPS);
                    transaction.addToBackStack(TIPS);
                    transaction.commit();
                }
                break;
            }
            case R.id.menu_history: {
                if (getSupportFragmentManager().findFragmentByTag(HISTORY) == null
                        || !getSupportFragmentManager().findFragmentByTag(HISTORY).isVisible()) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal, historyFragment, HISTORY);
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
        setContentView(R.layout.main_activity);
        transaction = getSupportFragmentManager().beginTransaction();
        screenLoaderFragment = new ScreenLoader();
        transaction.add(R.id.fragmentPrincipal, screenLoaderFragment, SCREEN_LOADER).commit();
        Thread screenTimer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    calculateFragment = new Calculate();
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal, calculateFragment, CALCULATE);
                    transaction.addToBackStack(CALCULATE);
                    transaction.commit();
                } catch (InterruptedException e) {
                    // TODO Manejo de Excepciones
                }
            }
        };
        screenTimer.start();
        tipsFragment = new Tips();
        historyFragment = new History();

    }

}
