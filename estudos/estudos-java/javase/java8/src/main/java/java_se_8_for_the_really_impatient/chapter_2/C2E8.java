package java_se_8_for_the_really_impatient.chapter_2;

import common.Exercise;
import common.Spliters;
import org.junit.Test;

import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C2E8 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        Stream<String> first = readFileAsList("words.txt",Spliters.WORDS_SPLITTER.getValue()).stream();
        Stream<String> second = readFileAsList("names.txt",Spliters.WORDS_SPLITTER.getValue()).stream();
        zip(first,second).forEach(System.out::println);
    }

    public <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Stream.Builder<T> builder = Stream.builder();
        Iterator<T> secondIterator = second.iterator();
        first.forEach(e -> {
            if(secondIterator.hasNext()){
                builder.accept(e);
                builder.accept(secondIterator.next());
            }else{
                first.close();
                second.close();
            }
        });
        return builder.build();
    }
}
