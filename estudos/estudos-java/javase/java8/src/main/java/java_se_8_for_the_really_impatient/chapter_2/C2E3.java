package java_se_8_for_the_really_impatient.chapter_2;

import common.Exercise;
import common.Spliters;
import org.junit.Test;

import java.util.List;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C2E3 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        List<String> words = readFileAsList("words.txt",Spliters.WORD_SPLITTER.getValue());

        long serialBegin = System.currentTimeMillis();
        words.stream().filter(w -> w.length()>5).count();
        long serialEnd =  System.currentTimeMillis();
        long serialResult = (serialBegin-serialEnd)/1000;
        System.out.println(serialResult);

        long parallellBegin = System.currentTimeMillis();
        words.parallelStream().filter(w -> w.length()>5).count();
        long parallellEnd = System.currentTimeMillis();
        long parallellResult = (parallellBegin-parallellEnd)/1000;
        System.out.println(parallellResult);
    }
}
