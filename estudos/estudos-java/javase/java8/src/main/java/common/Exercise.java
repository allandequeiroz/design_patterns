package common;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public interface Exercise {

    public void perform() throws Exception;

    default String readFileContent(String file) throws IOException {
        return new FileUtils().readFileContent(file);
    }

    default List<String> readFileAsList(String file, String splitter) throws IOException {
        return new FileUtils().readFileAsList(file,splitter);
    }

    default String[] readFileAsArray(String file, String splitter) throws IOException {
        return new FileUtils().readFileAsArray(file, splitter);
    }

    default File[] listFilesRecursively(String root){
        List<File> files = new FileUtils().listFilesRecurively(root);
        return files.toArray(new File[files.size()]);
    }
}
