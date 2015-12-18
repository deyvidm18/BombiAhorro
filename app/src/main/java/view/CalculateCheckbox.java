package view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

/**
 * Created by mac on 7/26/15.
 */
public class CalculateCheckbox extends CheckBox {
    private float consumption;

    public CalculateCheckbox(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public float getConsumption() {
        return consumption;
    }

    public void setConsumption(float consumption) {
        this.consumption = consumption;
    }
}
