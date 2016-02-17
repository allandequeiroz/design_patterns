package java_se_8_for_the_really_impatient.chapter_2;

import common.Exercise;
import common.Spliters;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C2E9 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        Stream<List<String>> stream1 = Stream.of(readFileAsList("words.txt",Spliters.WORDS_SPLITTER.getValue()));
        List<String> reduce1 = reduce1(stream1);
        System.out.println("reduce1 -> " + reduce1);

        Stream<List<String>> stream2 = Stream.of(readFileAsList("words.txt",Spliters.WORDS_SPLITTER.getValue()));
        List<String> reduce2 = reduce2(stream2);
        System.out.println("reduce2 -> " + reduce2);

        Stream<List<String>> stream3 = Stream.of(readFileAsList("words.txt",Spliters.WORDS_SPLITTER.getValue()));
        List<String> reduce3 = reduce3(stream3);
        System.out.println("reduce3 -> " + reduce3);
    }

    private <T> List<T> reduce1(Stream<List<T>> stream){
        return stream
                .reduce((list1,list2) -> {
                    list1.addAll(list2);
                    return list1;
                }).orElse(Collections.EMPTY_LIST);
    }

    private <T> List<T> reduce2(Stream<List<T>> stream){
        return stream
                .reduce(new ArrayList<>(),(list1,list2) -> {
                    list1.addAll(list2);
                    return list1;
                });
    }

    private <T> List<T> reduce3(Stream<List<T>> stream){
        return stream
                .reduce(new ArrayList<T>(),
                        (l1,l2) -> {
                            l1.addAll(l2);
                            return l1;
                        },
                        (l3,l4) -> {
                            l3.addAll(l4);
                            return l3;
                        });
    }
}
