package java_se_8_for_the_really_impatient.chapter_2;

import common.Exercise;
import common.Spliters;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C2E1 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        Long methodResult = parallellWorldCounter(readFileAsList("words.txt",Spliters.WORD_SPLITTER.getValue()));
        Long lambdaResult = readFileAsList("words.txt",Spliters.WORD_SPLITTER.getValue()).parallelStream().filter(w -> w.length()>5).count();
        Assert.assertEquals(methodResult,lambdaResult);
    }

    private Long parallellWorldCounter(List<String> words){
        int cores = Runtime.getRuntime().availableProcessors();
        int chunkSize = words.size() / cores;
        List<List<String>> chunks = new ArrayList<>();
        for(int i = 0 ; i < words.size() ; i += chunkSize){
            int toIndex = Math.min(i+chunkSize,words.size());
            chunks.add(words.subList(i,toIndex));

        }
        ExecutorService pool = Executors.newFixedThreadPool(cores);
        Set<Future<Long>> results = new HashSet<>();
        for (List<String> chunk : chunks){
            Callable<Long> callable = () -> {
                long counter = 0;
                for(String word : chunk){
                    if(word.length()>5){
                        counter++;
                    }
                }
                return counter;
            };
            Future<Long> future = pool.submit(callable);
            results.add(future);
        }
        long counter = 0;
        for (Future<Long> result : results){
            try {
                counter += result.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        pool.shutdown();
        return counter;
    }
}
