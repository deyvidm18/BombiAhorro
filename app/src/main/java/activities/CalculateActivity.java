package activities;

import android.app.ActionBar;
import android.os.Bundle;

import com.example.bombiahorro.R;

public class CalculateActivity extends MainActivity {

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		return super.onOptionsItemSelected(item);
//	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_calcular);
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(R.string.calculate);
        // Create the adapter that will return a fragment
//		mSectionsPagerAdapter = new SectionsPagerAdapter(
//				getSupportFragmentManager());
//
//		// Set up the ViewPager with the sections adapter.
//		mViewPager = (ViewPager) findViewById(R.id.pager);
//		mViewPager.setAdapter(mSectionsPagerAdapter);
//
//		// Cargar los valores de la Lista calcular
//		for (int i = 0; i < 5; ++i) {
//			ListaCalcular.setListaFragment(this, i);
//		}
    }

}
