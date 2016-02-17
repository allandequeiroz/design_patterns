package java_se_8_for_the_really_impatient.chapter_2;

import common.Exercise;
import common.Spliters;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C2E7 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        Stream<String> stream = readFileAsList("words.txt",Spliters.WORDS_SPLITTER.getValue()).stream();
        System.out.println( isFinite(stream) );
    }

    public <T> boolean isFinite(Stream<T> stream){
        //TODO: HOW?
        return false;
    }
}
