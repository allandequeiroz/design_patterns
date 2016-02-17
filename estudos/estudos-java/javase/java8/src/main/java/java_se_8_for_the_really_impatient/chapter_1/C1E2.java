package java_se_8_for_the_really_impatient.chapter_1;

import common.Exercise;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C1E2 implements Exercise{

    @Test
    @Override
    public void perform() throws Exception {
        String path = new File(".").getAbsolutePath();
        System.out.println(oldReadDirectory(path));
        System.out.println(newReadDirectory(path));
    }

    private List<String> newReadDirectory(String root){
        return Stream.of(new File(root)
                .listFiles())
                .filter(File::isDirectory)
                .map(File::getName)
                .collect(Collectors.toList());
    }

    private List<String> oldReadDirectory(String root){
        File[] files = new File(root).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return Files.isDirectory(pathname.toPath());
            }
        });
        List<String> directories = new ArrayList<>();
        for(File file : files){
            directories.add(file.getName());
        }
        return directories;
    }
}
