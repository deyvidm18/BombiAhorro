package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bombiahorro.R;

public class CalculateFragment extends Fragment {
    private static final String CALCULATE_LIST = "CalculateListFragment";
    private CalculateListFragment calculateListFragment;
    private FragmentTransaction transaction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.calculate_fragment, container, false);
        calculateListFragment = new CalculateListFragment();
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout_contenedor_list, calculateListFragment, CALCULATE_LIST);
        transaction.addToBackStack(CALCULATE_LIST);
        transaction.commit();
        return rootView;
    }
}



