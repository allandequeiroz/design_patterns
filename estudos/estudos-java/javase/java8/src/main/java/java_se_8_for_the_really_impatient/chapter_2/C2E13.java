package java_se_8_for_the_really_impatient.chapter_2;

import common.Exercise;
import common.Spliters;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C2E13 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        Stream<String> words = readFileAsList("war-and-peace.txt", Spliters.WORDS_SPLITTER.getValue()).parallelStream();
        System.out.println(countSmallWords(words));
    }

    private Map<Integer,Long> countSmallWords(Stream<String> words){
        return words.filter(w -> w.length()<5).collect(Collectors.groupingBy(String::length,Collectors.counting()));
    }
}
