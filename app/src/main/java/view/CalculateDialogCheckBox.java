package view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.bombiahorro.R;

import listener.CalculateOnCheckedChangedListener;
import model.CalculateParcelable;

/**
 * Created by mac on 4/5/15.
 */
public class CalculateDialogCheckBox extends DialogFragment {

    private View view;
    private View fatherView;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder;
        CalculateParcelable calculateParcelable;

        calculateParcelable = getArguments().getParcelable(CalculateOnCheckedChangedListener.idBundle);
        fatherView = calculateParcelable.getView();
        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(((TextView) fatherView.findViewById(R.id.calculate_item_name)).getText());
        builder.setIcon(R.drawable.menu_icon_calculate);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.calculate_popup, null);
        builder.setView(view)
                .setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        calculate(((NumberPicker) view.findViewById(R.id.popup_count_numberpicker)).getValue(), ((NumberPicker) view.findViewById(R.id.popup_hours_numberpicker)).getValue());
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ((CalculateCheckbox) fatherView.findViewById(R.id.calculate_item_checkBox)).setChecked(false);
                    }
                });
        return builder.create();
    }

    private void calculate(int count, int hours) {
        ((TextView) fatherView.findViewById(R.id.calculate_item_watts)).setText(String.valueOf(((CalculateCheckbox) fatherView.findViewById(R.id.calculate_item_checkBox)).getConsumption() * count * hours));
    }
}
