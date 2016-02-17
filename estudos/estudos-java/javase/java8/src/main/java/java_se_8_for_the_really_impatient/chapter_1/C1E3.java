package java_se_8_for_the_really_impatient.chapter_1;

import common.Exercise;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C1E3 implements Exercise{

    @Test
    @Override
    public void perform() throws Exception {
        String path = new File("src/main/java/common").getAbsolutePath();
        System.out.println(listFileNames(path));
    }

    private List<String> listFileNames(String root){
        return Stream.of(new File(root)
                .listFiles())
                .map(File::getName)
                .filter(f -> f.endsWith(".java"))
                .collect(Collectors.toList());
    }
}
