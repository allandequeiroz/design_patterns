package java_se_8_for_the_really_impatient.chapter_1;

import common.Exercise;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C1E8 implements Exercise{

    @Test
    @Override
    public void perform() throws Exception {
        String[] names = {"Peter","Paul","Mary"};

        List<Runnable> runners = new ArrayList<>();
        for(String name : names)
            runners.add(() -> System.out.println(name));
        System.out.println("Enhanced for results :");
        runners.forEach(r -> new Thread(r).start());

        runners = new ArrayList<>();
        for(int i = 0 ; i < names.length ; i++){
            final int cursor = i;
            runners.add(() -> System.out.println(names[cursor]));
        }
        System.out.println("Tradicional loop :");
        runners.forEach(r -> new Thread(r).start());
    }
}
