package java_se_8_for_the_really_impatient.chapter_1;

import common.Exercise;
import common.Spliters;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C1E1 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        CopyOnWriteArraySet<Long> threads = new CopyOnWriteArraySet<>();
        threads.add(Thread.currentThread().getId());
        System.out.println("In the begining : " + threads.toString());

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                threads.add(Thread.currentThread().getId());
                return o1.compareTo(o2);
            }
        };

        String[] words = readFileAsArray("words.txt", Spliters.WORD_SPLITTER.getValue());
        Arrays.sort(words,comparator);
        System.out.println("After Arrays.sort : " + threads.toString());

        words = readFileAsArray("words.txt", Spliters.WORD_SPLITTER.getValue());
        Arrays.parallelSort(words,comparator);
        System.out.println("After Arrays.parallelSort : " + threads.toString());
    }
}
