package aem;

import javax.jcr.SimpleCredentials;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public interface Exercise {

    public void perform() throws Exception;

    default SimpleCredentials defaultCredentials() {
        return new SimpleCredentials("allan","queiro".toCharArray());
    }

    default String absolutePathToFile(String file){
        return new File("src/main/resources/"+file).getAbsolutePath();
    }
}
