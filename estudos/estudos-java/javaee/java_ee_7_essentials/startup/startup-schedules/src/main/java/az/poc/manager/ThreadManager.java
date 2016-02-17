package az.poc.manager;

import az.poc.thread.Task;

import java.io.Serializable;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadManager implements Serializable{

    private final Logger log = Logger.getLogger(this.getClass().getName());

    public void begin(Object regra, long nextExecution){
        try {
            Task timerTask = Task.class.newInstance();
            Timer timer = new Timer("Nome da Thread");
            timer.schedule(timerTask, nextExecution);
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }

}
