package listener;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bombiahorro.R;

import dao.HistoryDAO;
import view.CalculateCheckbox;
import view.CalculateDialog;


/**
 * Created by mac on 9/3/15.
 */
public class CalculateOnClickListener implements View.OnClickListener {

    public static String FLOAT_KEY = "floatKey";
    private FragmentManager fragmentManager;

    public CalculateOnClickListener(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void onClick(View v) {
        CalculateDialog calculateDialog = new CalculateDialog();
        HistoryDAO historyDAO = new HistoryDAO(v.getContext());
        Bundle bundle = new Bundle();
        float resultado = 0;
        LinearLayout l = (LinearLayout) v.getParent();
        ListView listView = (ListView) l.findViewById(android.R.id.list);
        if (listView != null)
            for (int i = 0; i < listView.getAdapter().getCount(); ++i) {
                ViewGroup row = (ViewGroup) listView.getChildAt(i);
                if (row != null)
                    resultado += Float.valueOf(((TextView) row.findViewById(R.id.calculate_item_watts)).getText().toString());
            }
        bundle.putFloat(FLOAT_KEY, resultado);
        calculateDialog.setArguments(bundle);
        calculateDialog.show(fragmentManager, "");
        if (resultado > 0) {
            historyDAO.insertHistoryRecord(resultado);
            cleanView(listView);
        }
    }

    private void cleanView(ListView listView) {
        if (listView != null)
            for (int i = 0; i < listView.getAdapter().getCount(); ++i) {
                ViewGroup row = (ViewGroup) listView.getChildAt(i);
                if (row != null) {
                    ((TextView) row.findViewById(R.id.calculate_item_watts)).setText("0.0");
                    ((CalculateCheckbox) row.findViewById(R.id.calculate_item_checkBox)).setChecked(false);
                }
            }
    }
}
