package activities;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bombiahorro.R;

public class TipsActivity extends MainActivity {

    private static final int COUNT = 8;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcular);
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(R.string.tips);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }

    public static class TipsFragment extends Fragment {

        private int layoutFragment;
        private int position;


//		public TipsFragment(int layoutFragment, int position) {
//			this.layoutFragment = layoutFragment;
//			this.position = position;
//		}

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(layoutFragment, container, false);
            switch (position) {
                case 0:
                    rootView.setBackground(this.getResources().getDrawable(R.drawable.background_tips0));
                    rootView.findViewById(R.id.flechaizq).setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    rootView.setBackground(this.getResources().getDrawable(R.drawable.background_tips1));
                    break;
                case 2:
                    rootView.setBackground(this.getResources().getDrawable(R.drawable.background_tips2));
                    break;
                case 3:
                    rootView.setBackground(this.getResources().getDrawable(R.drawable.background_tips3));
                    break;
                case 4:
                    rootView.setBackground(this.getResources().getDrawable(R.drawable.background_tips4));
                    break;
                case 5:
                    rootView.setBackground(this.getResources().getDrawable(R.drawable.background_tips5));
                    break;
                case 6:
                    rootView.setBackground(this.getResources().getDrawable(R.drawable.background_tips6));
                    break;
                case 7:
                    rootView.setBackground(this.getResources().getDrawable(R.drawable.background_tips7));
                    rootView.findViewById(R.id.flechader).setVisibility(View.INVISIBLE);
                    break;
            }
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //return new TipsFragment(R.layout.tips_view, position);
            return null;
        }

        @Override
        public int getCount() {
            return COUNT;
        }

    }

    private class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as
                // well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

}
