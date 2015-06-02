package activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bombiahorro.R;


public class GameOver extends Fragment {
    public Slt restartFragment;
    /**
     * Called when the activity is first created.
     */

    private FragmentTransaction transaction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //setContentView(R.layout.gameover);
        View gameoverView = inflater.inflate(R.layout.gameover, container,
                false);


        Button RestartGameButton = (Button) gameoverView.findViewById(R.id.restart);
        RestartGameButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
//                        Intent RestartGameIntent = new Intent(GameOver.this,Menu.class);
//                        startActivity(RestartGameIntent);
                restartFragment = new Slt();
                transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.fragmentPrincipal, new Slt(),
                        MainActivity.JUEGO);
                transaction.addToBackStack(MainActivity.JUEGO);
                transaction.commit();

            }
        });

        Button QuitButton = (Button) gameoverView.findViewById(R.id.quit);
        QuitButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
//                        int pid = android.os.Process.myPid();
//                        android.os.Process.killProcess(pid);
                //mg.getActivity().moveTaskToBack(true);
                //      android.os.Process.sendSignal(pid, 3);


                transaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.fragmentPrincipal,
                        ((MainActivity) getActivity()).gameFragment,
                        MainActivity.GAME);
                transaction.addToBackStack(MainActivity.GAME);
                transaction.commit();


            }
        });

        return gameoverView;

    }

}
