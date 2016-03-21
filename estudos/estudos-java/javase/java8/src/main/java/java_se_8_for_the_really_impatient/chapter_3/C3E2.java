package java_se_8_for_the_really_impatient.chapter_3;

import common.Exercise;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C3E2 implements Exercise {

    private ReentrantLock lock = new ReentrantLock();

    @Test
    @Override
    public void perform() throws Exception {
        new Random().ints().parallel().limit(5000).forEach(i -> {
            withLock(lock,()->"I'm thread. " + Thread.currentThread().getName());
        });
    }

    private void withLock(ReentrantLock lock, Supplier<String> message){
        try{
            lock.lock();
            System.out.println(message.get());
        }finally {
            lock.unlock();
        }
    }
}
