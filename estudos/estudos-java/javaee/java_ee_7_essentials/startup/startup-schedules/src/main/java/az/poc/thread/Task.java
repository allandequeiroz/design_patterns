package az.poc.thread;

import az.poc.Service;
import az.poc.ServiceLocator;

import javax.naming.NamingException;
import java.io.Serializable;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Task extends TimerTask implements Serializable{

    protected Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public void run() {
        try {
            service().begin();
        }
        catch (NamingException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }

    protected Service service() throws NamingException {
        return ServiceLocator.getInstance().lookup("startup.bean.local");
    }
}


