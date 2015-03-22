package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bombiahorro.R;


public class CalculateDetail extends Fragment {

    public static final String ARG_SELECIONADO = "item_id";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.calculate_fragment, container, false);
    }

}
