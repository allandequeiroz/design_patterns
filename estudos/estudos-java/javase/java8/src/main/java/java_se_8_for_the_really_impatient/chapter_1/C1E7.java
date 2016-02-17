package java_se_8_for_the_really_impatient.chapter_1;

import common.Exercise;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C1E7 implements Exercise{

    @Test
    @Override
    public void perform() throws Exception {
        new Thread(andThen(
                () -> System.out.println("Before"),
                () -> System.out.println("After")
        )).start();
    }

    private Runnable andThen(Runnable before, Runnable after){
        return () -> {
            before.run();
            after.run();
        };
    }
}
