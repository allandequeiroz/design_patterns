package java_se_8_for_the_really_impatient.chapter_2;

import common.Exercise;
import common.Spliters;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C2E10 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        Stream<Double> stream = Stream.of(5.0,10.0,15.0,20.0,25.0,30.0);
        Double result = reduce(stream);
        System.out.println(result);
    }

    private Double reduce(Stream<Double> stream){
        return stream.mapToDouble(d -> d).summaryStatistics().getAverage();
    }
}
