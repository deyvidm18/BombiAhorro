package view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DialogoCalcular extends DialogFragment {

    private float consumo = 0;

    public DialogoCalcular() {

    }

//	public DialogoCalcular(float consumo) {
//		this.consumo = consumo;
//	}

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("El Consumo Calculado fue: " + consumo + "Watts")
                .setTitle("Consumo")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }

}
