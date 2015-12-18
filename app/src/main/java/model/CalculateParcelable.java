package model;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/**
 * Created by mac on 7/27/15.
 */
public class CalculateParcelable implements Parcelable {

    public static final Parcelable.Creator<CalculateParcelable> CREATOR
            = new Parcelable.Creator<CalculateParcelable>() {
        public CalculateParcelable createFromParcel(Parcel in) {
            return new CalculateParcelable(in);
        }

        public CalculateParcelable[] newArray(int size) {
            return new CalculateParcelable[size];
        }
    };
    private static final String ID_PARCELABLE_CALCULATE = "id_parcelable_calculate";
    private int position;
    private View view;

    public CalculateParcelable(int position, View view) {
        this.setPosition(position);
        this.setView(view);
    }


    private CalculateParcelable(Parcel in) {
        setPosition(in.readInt());
        setView((View) in.readValue(null));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getPosition());
        dest.writeValue(getView());
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
