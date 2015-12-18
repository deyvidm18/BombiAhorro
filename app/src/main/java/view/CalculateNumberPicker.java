package view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.NumberPicker;

/**
 * Created by Deyvid Martinez on 7/26/15.
 */
public class CalculateNumberPicker extends NumberPicker {
    public CalculateNumberPicker(Context context) {
        super(context);
    }

    public CalculateNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        processAttributeSet(attrs);
    }

    private void processAttributeSet(AttributeSet attrs) {
        this.setMinValue(attrs.getAttributeIntValue(null, "min", 0));
        this.setMaxValue(attrs.getAttributeIntValue(null, "max", 0));
    }
}
