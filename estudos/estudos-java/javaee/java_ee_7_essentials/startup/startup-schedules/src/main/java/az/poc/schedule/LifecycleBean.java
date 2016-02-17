package az.poc.schedule;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.Calendar;

/**
 * Created by allanqueiroz on 9/26/14.
 */
@Singleton
@Startup
public class LifecycleBean {

    @Inject
    private JobsSchelule jobsSchelule;

    @PostConstruct
    public void init() {
        jobsSchelule.begin(0L);
    }

}
