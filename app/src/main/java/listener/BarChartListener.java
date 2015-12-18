package listener;

import android.graphics.PointF;
import android.graphics.RectF;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

/**
 * Created by mac on 9/7/15.
 */
public class BarChartListener implements OnChartValueSelectedListener {
    private BarChart myChart;

    public BarChartListener(BarChart myChart) {
        this.myChart = myChart;
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        if (e == null)
            return;
        RectF bounds = myChart.getBarBounds((BarEntry) e);
        PointF position = myChart.getPosition(e, YAxis.AxisDependency.LEFT);
    }

    @Override
    public void onNothingSelected() {

    }
}
