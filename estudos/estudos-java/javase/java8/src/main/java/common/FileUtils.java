package common;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**  * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>  */
public class FileUtils {

    public String readFileContent(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)),StandardCharsets.UTF_8);
    }

    public List<String> readFileAsList(String file, String splitter) throws IOException {
        return Arrays.asList(readFileContent(buildPathToFile(file)).split(splitter)).stream().collect(Collectors.toList());
    }

    public String[] readFileAsArray(String file, String splitter) throws IOException {
        return readFileContent(buildPathToFile(file)).split(splitter);
    }

    public String buildPathToFile(String file){
        return new File("src/main/resources/"+file).getAbsolutePath();
    }

    public List<File> listFilesRecurively(String root) {
        List<File> list = new ArrayList<>();
        File[] array = new File(root).listFiles();
        Arrays.asList(array).forEach(file -> {
            if(file.isDirectory()){
                list.addAll(listFilesRecurively(file.getAbsolutePath()));
            }
            list.add(file);
        });
        return list;
    }
}
