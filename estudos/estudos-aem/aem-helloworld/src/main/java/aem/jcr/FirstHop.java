package aem.jcr;

import aem.Exercise;
import org.apache.jackrabbit.core.TransientRepository;
import org.junit.Test;

import javax.jcr.Repository;
import javax.jcr.Session;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class FirstHop implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        Repository repository = getPostgreRepository();
        Session session = getPostgreSession(repository);
        try{
            String user = session.getUserID();
            String name = repository.getDescriptor(Repository.REP_NAME_DESC);
            System.out.println("Logged in as " + user + " to a " + name + " repository.");
        }finally {
            session.logout();
        }
    }
}
