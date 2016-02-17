package java_se_8_for_the_really_impatient.chapter_1;

import common.Exercise;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C1E9 implements Exercise{

    @Test
    @Override
    public void perform() throws Exception {
        Collection2<Integer> col = new ArrayList2<>();
        col.add(5);
        col.add(8);
        col.add(1);
        col.add(50);
        col.forEachIf(
                System.out::println,
                e -> e > 5
        );
    }
}

interface Collection2<T> extends Collection<T>{
    default void forEachIf(Consumer<T> action, Predicate<T> filter){
        forEach(e -> {
            if(filter.test(e)){
                action.accept(e);
            }
        });
    }
}

class ArrayList2<T> extends ArrayList<T> implements Collection2<T>{}