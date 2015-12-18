package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bombiahorro.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ValueFormatter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dao.HistoryDAO;
import listener.BarChartListener;
import model.HistoryModel;

public class HistoryFragment extends Fragment {

    public HistoryFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);
        BarChart barChart = (BarChart) rootView.findViewById(R.id.history_chart);
        barChart.setOnChartValueSelectedListener(new BarChartListener(barChart));
        setValuesChart(barChart);
        return rootView;
    }

    private void setValuesChart(BarChart barChart) {
        List<HistoryModel> listHistory;
        Legend legend;
        HistoryModel historyModel;
        BarData barData;
        BarDataSet barDataSet;
        BarEntry entryHistory;
        YAxis leftAxis;
        YAxis rightAxis;
        XAxis downAxis;
        MyValueFormatter myValueFormatter = new MyValueFormatter();
        ArrayList<BarEntry> valuesList = new ArrayList<BarEntry>();
        ArrayList<String> xVals = new ArrayList<String>();
        HistoryDAO historyDAO = new HistoryDAO(getActivity().getApplicationContext());
        listHistory = historyDAO.getAllHistoryModel();
        if (listHistory != null && listHistory.size() > 0) {

            for (int i = 0; i < listHistory.size(); ++i) {
                historyModel = listHistory.get(i);
                entryHistory = new BarEntry(historyModel.getResultConsumption(), i);
                xVals.add(historyModel.getCreated());
                valuesList.add(entryHistory);
            }
            barDataSet = new BarDataSet(valuesList, getResources().getString(R.string.consumption));
            barDataSet.setValueFormatter(myValueFormatter);
            barDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
            // barDataSet.setColors(new int[]{R.color.my_blue,R.color.my_orange,R.color.my_green,R.color.my_purple,R.color.my_yellow},getActivity().getApplicationContext());
            barData = new BarData(xVals, barDataSet);
            barChart.setData(barData);
            barChart.setDescription("");
            // Legend
            legend = barChart.getLegend();
            legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
            legend.setForm(Legend.LegendForm.SQUARE);
            legend.setFormSize(9f);
            legend.setTextSize(11f);
            legend.setXEntrySpace(4f);
            //AXIS
            leftAxis = barChart.getAxisLeft();
            leftAxis.setValueFormatter(myValueFormatter);
            leftAxis.setDrawAxisLine(false);
            leftAxis.setDrawGridLines(false);

            rightAxis = barChart.getAxisRight();
            rightAxis.setDrawLabels(false);
            rightAxis.setDrawAxisLine(false);
            rightAxis.setDrawGridLines(false);
        }
        barChart.setNoDataText(getResources().getString(R.string.noDataText));
        barChart.setDrawGridBackground(false);
        barChart.setDrawValueAboveBar(true);
        barChart.animateY(2000);
    }

    class MyValueFormatter implements ValueFormatter {

        private DecimalFormat mFormat;

        public MyValueFormatter() {
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
            mFormat = (DecimalFormat) nf;
        }

        @Override
        public String getFormattedValue(float value) {
            return mFormat.format(value) + " W";
        }
    }

}
