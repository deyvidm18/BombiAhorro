package listener;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.bombiahorro.R;

import model.CalculateParcelable;
import view.CalculateDialogCheckBox;

/**
 * Created by mac on 7/27/15.
 */
public class CalculateOnCheckedChangedListener implements CompoundButton.OnCheckedChangeListener {

    public static final String idBundle = "BundleCalculate";
    private int position;
    private FragmentManager fragmentManager;
    private View view;
    private Bundle bundle;

    public CalculateOnCheckedChangedListener(int position, FragmentManager fragmentManager, View view) {
        this.position = position;
        this.fragmentManager = fragmentManager;
        this.view = view;
        bundle = new Bundle();
        bundle.putParcelable(idBundle, new CalculateParcelable(position, view));
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            CalculateDialogCheckBox df = new CalculateDialogCheckBox();
            df.setArguments(bundle);
            df.show(fragmentManager, "");

        } else {
            ((TextView) view.findViewById(R.id.calculate_item_watts)).setText("0.0");
        }
    }
}
