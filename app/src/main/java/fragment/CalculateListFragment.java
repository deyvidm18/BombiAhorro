package fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bombiahorro.R;

import java.util.List;

import dao.CalculateDAO;
import listener.CalculateOnCheckedChangedListener;
import listener.CalculateOnClickListener;
import model.CalculateModel;
import view.CalculateCheckbox;

public class CalculateListFragment extends ListFragment {

    private CalculateDAO calculateDAO;
    private List<CalculateModel> values;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculateDAO = new CalculateDAO(getActivity());
        values = calculateDAO.getAllCalculateModel();
        setListAdapter(new CalculateAdaptor(getActivity()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.calculate_list, container, false);
        rootView.findViewById(R.id.btn_calcular).setOnClickListener(new CalculateOnClickListener(getFragmentManager()));
        return rootView;
    }


    private class CalculateAdaptor extends ArrayAdapter<CalculateModel> {
        private Activity context;

        public CalculateAdaptor(Activity context) {
            super(context, R.layout.calculate_element_list, values);
            this.context = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.calculate_element_list, null);
            ((TextView) item.findViewById(R.id.calculate_item_name)).setText(values.get(position).getName());
            ((ImageView) item.findViewById(R.id.calculate_item_image)).setImageResource(getResources().getIdentifier(values.get(position).getDrawable(), "drawable", getActivity().getPackageName()));
            ((CalculateCheckbox) item.findViewById(R.id.calculate_item_checkBox)).setOnCheckedChangeListener(new CalculateOnCheckedChangedListener(position, getFragmentManager(), item));
            ((CalculateCheckbox) item.findViewById(R.id.calculate_item_checkBox)).setConsumption(values.get(position).getConsumption());
            return (item);
        }
    }
}
