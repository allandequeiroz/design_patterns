package az.poc;

import az.poc.schedule.JobsSchelule;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class ServiceBean implements ServiceLocal, ServiceRemote {

    protected Logger log = Logger.getLogger(this.getClass().getName());

    @Inject
    private JobsSchelule jobsSchelule;

    @Override
    public void begin() {
        log.log(Level.INFO, "Begin");

        long nextExecution = 1*60*1000;
        jobsSchelule.begin(nextExecution);
    }


}
