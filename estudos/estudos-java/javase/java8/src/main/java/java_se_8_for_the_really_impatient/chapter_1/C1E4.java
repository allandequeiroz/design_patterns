package java_se_8_for_the_really_impatient.chapter_1;

import common.Exercise;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C1E4 implements Exercise{

    @Test
    @Override
    public void perform() throws Exception {
        File[] files = listFilesRecursively(new File("src/main/java").getAbsolutePath());
        Arrays.stream(sort(files)).forEach(System.out::println);
    }

    private File[] sort(File[] files){
        Arrays.sort(files,(f1,f2) -> {
            if(f1.isDirectory()&&!f2.isDirectory()) return -1;
            if(!f1.isDirectory()&&f2.isDirectory()) return 1;
            else return f1.getAbsolutePath().compareTo(f2.getAbsolutePath());
        });
        return files;
    }
}
