package java_se_8_for_the_really_impatient.chapter_3;

import common.Exercise;
import org.junit.Test;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C3E1 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        int[] a = randomNumbers();
        a[0] = 10;

        Logger.getGlobal().setLevel(Level.OFF);
        goThroughTheArray(a);

        Logger.getGlobal().setLevel(Level.ALL);
        goThroughTheArray(a);
    }

    private void goThroughTheArray(int[] a) {
        for(int i = 0 ; i < a.length ; i++){
            final int cursor = i;
            logIf(Level.INFO,() -> a[cursor]==10,() -> "a["+cursor+"]="+a[cursor]);
        }
    }

    private void logIf(Level level, Supplier<Boolean> condition, Supplier<String> message){
        if(Logger.getGlobal().isLoggable(level)&&condition.get()){
            Logger.getGlobal().log(level,message.get());
        }
    }
}
