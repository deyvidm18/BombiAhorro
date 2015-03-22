package logic;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class JuegoProcess extends Thread {

    public final static int LOWERBOUND = 0;
    public final static int UPPERBOUND = 8;

    private int upperBound;
    private int timeWait;
    private Handler handler;
    private GameState gstate;
    ;

    public JuegoProcess(Handler handler) {
        super();
        this.upperBound = UPPERBOUND;
        gstate = GameState.RUNNING;
        this.handler = handler;
        this.timeWait = 1000;
    }

    @Override
    public void run() {

        while (gstate == GameState.RUNNING) {
            // random de la posicion nueva q se setea
            int newPosition;

            newPosition = (int) (Math.random() * (upperBound + 1));

            nextStep(newPosition);

            try {
                sleep(timeWait);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void nextStep(int newPosition) {
        Message msg = handler.obtainMessage();
        Bundle b = new Bundle();
        b.putInt("newPosition", newPosition);
        msg.setData(b);
        handler.sendMessage(msg);
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public String getGameState() {
        return gstate.name();
    }

    public void setState(String state) {
        if (state.equals(GameState.RUNNING.name()))
            this.gstate = GameState.RUNNING;
        else
            this.gstate = GameState.STOPPED;

    }

    public synchronized void stopThread() {
        this.gstate = GameState.STOPPED;

    }

    public void setTimeToWait(int timeWait) {
        this.timeWait = timeWait;

    }

    public enum GameState {
        RUNNING, STOPPED
    }

}