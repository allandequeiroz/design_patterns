package java_se_8_for_the_really_impatient.chapter_2;

import common.Exercise;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C2E11 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        Stream<Double> odd = Stream.of(5.0,10.0,15.0,20.0,25.0,30.0);
        Stream<Double> even = Stream.of(4.0,8.0,12.0,16.0,20.0,24.0);
        ArrayList<Double> result = reduce(odd,even);
        System.out.println(result);
    }

    private <T> ArrayList<T> reduce(Stream<T> odd, Stream<T> even){
        //FIX : I DONT KNOW
        return null;
    }
}
