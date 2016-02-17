package java_se_8_for_the_really_impatient.chapter_1;

import common.Exercise;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ThreadFactory;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C1E6 implements Exercise{



    @Test
    @Override
    public void perform() throws Exception {
        new Thread(uncheck(
                () -> {
                    System.out.println("Zzz");
                    Thread.sleep(1000);
                }
        )).start();
    }

    public Runnable uncheck(RunnableEx runner){
        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }


}

@FunctionalInterface
interface RunnableEx{
    void run() throws Exception;
}
