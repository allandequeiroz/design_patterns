package java_se_8_for_the_really_impatient.chapter_3;

import common.Exercise;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C3E7 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        String[] values = {"A BC","abc","123","bbb","cc dd"};

        EnumSet<CompareOptions> comparators = EnumSet.of(CompareOptions.REVERSED,CompareOptions.CASE_INSENSITIVE);
        Arrays.sort(values,buildComparator(comparators));
        Stream.of(values).forEach(System.out::println);

        System.out.println();

        comparators = EnumSet.of(CompareOptions.IGNORE_SPACE);
        Arrays.sort(values,buildComparator(comparators));
        Stream.of(values).forEach(System.out::println);

    }

    private Comparator<String> buildComparator(EnumSet<CompareOptions> compareOptions){
        return (a,b) -> {
            if(compareOptions.contains(CompareOptions.CASE_INSENSITIVE)){
                a = a.toLowerCase();
                b = b.toLowerCase();
            }
            if(compareOptions.contains(CompareOptions.IGNORE_SPACE)){
                a = a.replaceAll(" ","");
                b = b.replaceAll(" ","");
            }
            if(compareOptions.contains(CompareOptions.REVERSED)){
                return b.compareTo(a);
            }else{
                return a.compareTo(b);
            }
        };
    }

    private enum CompareOptions {
        REVERSED,
        IGNORE_SPACE,
        CASE_INSENSITIVE
    }
}


