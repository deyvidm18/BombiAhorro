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
import model.Constants;

public class MainActivity extends FragmentActivity {
    private FragmentTransaction transaction;
    private ScreenLoader screenLoaderFragment;
    private Calculate calculateFragment;
    private Tips tipsFragment;
    private History historyFragment;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_calculate: {
                if (getSupportFragmentManager().findFragmentByTag(Constants.CALCULATE) == null
                        || !getSupportFragmentManager().findFragmentByTag(Constants.CALCULATE).isVisible()) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal, calculateFragment, Constants.CALCULATE);
                    transaction.addToBackStack(Constants.CALCULATE);
                    transaction.commit();
                }
                break;
            }
            case R.id.menu_tips: {
                if (getSupportFragmentManager().findFragmentByTag(Constants.TIPS) == null
                        || !getSupportFragmentManager().findFragmentByTag(Constants.TIPS).isVisible()) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal, tipsFragment, Constants.TIPS);
                    transaction.addToBackStack(Constants.TIPS);
                    transaction.commit();
                }
                break;
            }
            case R.id.menu_history: {
                if (getSupportFragmentManager().findFragmentByTag(Constants.HISTORY) == null
                        || !getSupportFragmentManager().findFragmentByTag(Constants.HISTORY).isVisible()) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal, historyFragment, Constants.HISTORY);
                    transaction.addToBackStack(Constants.HISTORY);
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
        transaction.add(R.id.fragmentPrincipal, screenLoaderFragment, Constants.SCREEN_LOADER).commit();
        Thread screenTimer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    calculateFragment = new Calculate();
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentPrincipal, calculateFragment, Constants.CALCULATE);
                    transaction.addToBackStack(Constants.CALCULATE);
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
