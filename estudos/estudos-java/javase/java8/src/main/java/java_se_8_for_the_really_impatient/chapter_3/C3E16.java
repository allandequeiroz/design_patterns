package java_se_8_for_the_really_impatient.chapter_3;

import common.Exercise;
import org.junit.Test;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C3E16 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        Runnable first = () -> System.out.println("First");
        Runnable second = () -> System.out.println("Second");

        doInOrder(first,second);
    }

    public static void doInOrder(Runnable first, Runnable second) {
        first.run();
        second.run();
    }


}


