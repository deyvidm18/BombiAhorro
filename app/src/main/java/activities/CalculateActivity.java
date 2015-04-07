package activities;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.PopupWindow;

import com.example.bombiahorro.R;

public class CalculateActivity extends MainActivity {

    private PopupWindow pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_calcular);
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(R.string.calculate);

    }


}
