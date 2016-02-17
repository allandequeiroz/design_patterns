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
public class C2E6 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        List<String> worlds = readFileAsList("words.txt", Spliters.WORDS_SPLITTER.getValue());
        worlds.stream().flatMap(w -> characterStream(w)).forEach(System.out::println);

    }

    private Stream<Character> characterStream(String word){
        return IntStream.range(0,word.length()-1).mapToObj(word::charAt);
    }
}
