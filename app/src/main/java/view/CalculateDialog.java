package view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import listener.CalculateOnClickListener;

public class CalculateDialog extends DialogFragment {

    private float consumo;

    public CalculateDialog() {

    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), AlertDialog.THEME_HOLO_DARK);
        consumo = getArguments().getFloat(CalculateOnClickListener.FLOAT_KEY);
        builder.setMessage(consumo > 0 ? "El Consumo Calculado fue: " + consumo + " Watts" : "Debe seleccionar los electrodomesticos para calcular su consumo")
                .setTitle("Consumo")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }

}
