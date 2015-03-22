package logic;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.bombiahorro.R;

public class ImageAdapter extends BaseAdapter implements View.OnClickListener {

    private Context mContext;
    // references to our images
    private Integer[] mThumbIds = {R.drawable.hoyo, R.drawable.hoyo, R.drawable.hoyo, R.drawable.hoyo,
            R.drawable.hoyo, R.drawable.hoyo, R.drawable.hoyo, R.drawable.hoyo, R.drawable.hoyo

    };

    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public boolean areAllItemsEnabled() {

        return super.areAllItemsEnabled();
    }

    @Override
    public boolean isEnabled(int position) {

        return super.isEnabled(position);
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Integer getItem(int position) {

        Integer item = 0;

        for (int i = 0; i < getCount(); i++) {
            if (mThumbIds[i].equals(item)) {
                item = mThumbIds[i];
            }
        }

        return item;
    }

    public void setItem(Integer index, Integer item) {
        mThumbIds[index] = item;
        System.err.println(item);
    }

    public long getItemId(int position) {

        long item = 0;

        for (int i = 0; i < getCount(); i++) {
            if (mThumbIds[i].equals(position)) {
                item = mThumbIds[i];
            }
        }
        return item;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) { // if it's not recycled, initialize some
            // attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);

        return imageView;
    }

    public Integer[] getmThumbIds() {

        return mThumbIds;
    }

    @Override
    public void onClick(View v) {

        this.notifyDataSetChanged();

    }

}
