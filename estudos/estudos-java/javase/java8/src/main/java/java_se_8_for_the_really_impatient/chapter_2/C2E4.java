package java_se_8_for_the_really_impatient.chapter_2;

import common.Exercise;
import common.Spliters;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C2E4 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        int[] values = {1,4,9,16};
        Stream<int[]> streamOf = Stream.of(values);
        IntStream intStream = IntStream.of(values);
        IntStream intStream_ = Arrays.stream(values);
    }
}
