package aem;

import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.jackrabbit.core.TransientRepository;

import javax.jcr.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public interface Exercise {

    public void perform() throws Exception;

    default SimpleCredentials defaultCredentials() {
        return new SimpleCredentials("allan","queiroz".toCharArray());
    }

    default String absolutePathToFile(String file){
        return new File("src/main/resources/"+file).getAbsolutePath();
    }

    default Repository getDerbyRepository() throws RepositoryException {
        return new TransientRepository();
    }

    default Repository getPostgreRepository() throws RepositoryException {
        return JcrUtils.getRepository();
    }

    default Session getDerbySession(Repository repository) throws RepositoryException {
        return repository.login(defaultCredentials());
    }

    default Session getPostgreSession(Repository repository) throws RepositoryException {
        return repository.login(new SimpleCredentials("admin","admin".toCharArray()));
    }
}
