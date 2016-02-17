package java_se_8_for_the_really_impatient.chapter_2;

import common.Exercise;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C2E5 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        congruential(25214903917L,11L,(long)Math.pow(2,48),System.nanoTime())
                .limit(10)
                .forEach(System.out::println);
    }

    private Stream<Long> congruential(long a, long c, long m, long seed){
        return Stream.iterate(seed,r -> (a * r + c) % m);
    }
}
