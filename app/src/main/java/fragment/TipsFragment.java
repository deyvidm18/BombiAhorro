package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bombiahorro.R;

public class TipsFragment extends Fragment {
    public static final String ID_LAYOUT = "layoutTips";
    public static final String ID_POSITION = "positionTips";
    private static final int COUNT = 8;
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    public static Fragment getInstance() {
        return new TipsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tipsView = inflater.inflate(R.layout.activity_tips, container,
                false);
        System.out.println("OncreateVIEW1");
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());
        mViewPager = (ViewPager) tipsView.findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        return tipsView;
    }

    public static class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        private Bundle bundle;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            System.out.println("constructor");
        }


        @Override
        public Fragment getItem(int position) {
            System.out.println("get item");
            return MyTipsChildFragment.newInstance(R.layout.tips_view, position);
        }

        @Override
        public int getCount() {
            return COUNT;
        }
    }


    public static class MyTipsChildFragment extends Fragment {

        int myLayout;
        int myPosition;

        static Fragment newInstance(int layout, int position) {
            MyTipsChildFragment f = new MyTipsChildFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ID_LAYOUT, layout);
            bundle.putInt(ID_POSITION, position);
            f.setArguments(bundle);
            return f;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            myLayout = getArguments() != null ? getArguments().getInt(ID_LAYOUT) : 1;
            myPosition = getArguments() != null ? getArguments().getInt(ID_POSITION) : 1;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(myLayout, container, false);
            switch (myPosition) {
                case 0:
                    rootView.setBackground(this.getResources().getDrawable(
                            R.drawable.tips_background0));
                    rootView.findViewById(R.id.flechaizq).setVisibility(
                            View.INVISIBLE);
                    break;
                case 1:
                    rootView.setBackground(this.getResources().getDrawable(
                            R.drawable.tips_background1));
                    break;
                case 2:
                    rootView.setBackground(this.getResources().getDrawable(
                            R.drawable.tips_background2));
                    break;
                case 3:
                    rootView.setBackground(this.getResources().getDrawable(
                            R.drawable.tips_background3));
                    break;
                case 4:
                    rootView.setBackground(this.getResources().getDrawable(
                            R.drawable.tips_background4));
                    break;
                case 5:
                    rootView.setBackground(this.getResources().getDrawable(
                            R.drawable.tips_background5));
                    break;
                case 6:
                    rootView.setBackground(this.getResources().getDrawable(
                            R.drawable.tips_background6));
                    break;
                case 7:
                    rootView.setBackground(this.getResources().getDrawable(
                            R.drawable.tips_background7));
                    rootView.findViewById(R.id.flechader).setVisibility(
                            View.INVISIBLE);
                    break;
            }
            return rootView;
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
                view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE)
                        / (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}
