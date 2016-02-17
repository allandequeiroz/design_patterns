package java_se_8_for_the_really_impatient.chapter_2;

import common.Exercise;
import common.Spliters;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C2E2 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        readFileAsList("words.txt",Spliters.WORD_SPLITTER.getValue())
                .stream()
                .filter(w -> w.length()>5)
                .limit(5)
                .forEach(System.out::println);
    }
}
