package activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bombiahorro.R;

import java.util.ArrayList;
import java.util.List;

import dao.GameDAO;

public class Puntajes extends Fragment {
    int[] aux_puntuaciones = new int[10];
    String[] datos = new String[10];
    List<String> datos2 = new ArrayList<String>();
    private GameDAO gameDAO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameDAO = new GameDAO(getActivity());

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View puntajeView = inflater.inflate(R.layout.puntajes, container,
                false);


        aux_puntuaciones = gameDAO.mejores10();

        for (int k = 0; k <= 9; k++) {
            datos[k] = ((Integer.toString(aux_puntuaciones[k])) + "  Puntos");
            datos2.add(Integer.toString(aux_puntuaciones[k]) + "  Puntos");

            System.out.println("arreglo de strings" + datos[k]);
            System.out.println("tamaÒo de list" + datos2.size());
        }
        ListView prueba = (ListView) puntajeView.findViewById(R.id.punt);
        //ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(getActivity(), R.id.prueba_final, datos);
        ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(getActivity(), R.layout.listprueba, datos);
        prueba.setAdapter(adaptador1);
        //prueba.
        return puntajeView;

    }

}
