package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bombiahorro.R;

import activities.MainActivity;

public class Game extends Fragment {

    private FragmentTransaction transaction;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View gameView = inflater.inflate(R.layout.main, container, false);

        Button StartGameButton = (Button) gameView.findViewById(R.id.StartGame);

        StartGameButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.fragmentPrincipal,
                        ((MainActivity) getActivity()).juegoFragment,
                        MainActivity.JUEGO);
                transaction.addToBackStack(MainActivity.JUEGO);
                transaction.commit();

            }
        });


        Button PuntajeButton = (Button) gameView.findViewById(R.id.Puntajes);
        PuntajeButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // Intent HelpIntent = new Intent(Menu.this, Ayuda.class);
                // startActivity(HelpIntent);

                transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.fragmentPrincipal,
                        ((MainActivity) getActivity()).puntajeFragment,
                        MainActivity.PUNTAJES);
                transaction.addToBackStack(MainActivity.PUNTAJES);
                transaction.commit();


            }
        });


        Button HelpButton = (Button) gameView.findViewById(R.id.Help);
        HelpButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // Intent HelpIntent = new Intent(Menu.this, Ayuda.class);
                // startActivity(HelpIntent);

                transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.fragmentPrincipal,
                        ((MainActivity) getActivity()).ayudaFragment,
                        MainActivity.AYUDA);
                transaction.addToBackStack(MainActivity.AYUDA);
                transaction.commit();


            }
        });


        Button CreditsButton = (Button) gameView.findViewById(R.id.Credits);
        CreditsButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // Intent CreditsIntent = new Intent(Menu.this, Creditos.class);
                // startActivity(CreditsIntent);

                transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.fragmentPrincipal,
                        ((MainActivity) getActivity()).creditoFragment,
                        MainActivity.CREDITS);
                transaction.addToBackStack(MainActivity.CREDITS);
                transaction.commit();


            }
        });

        // aqui anadir el nuevo boton para los mejores puntajes
        return gameView;
    }
}
