package java_se_8_for_the_really_impatient.chapter_3;

import common.Exercise;
import org.junit.Test;

import java.util.function.BooleanSupplier;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C3E3 implements Exercise {

    @Override
    @Test(expected = AssertionError.class)
    public void perform() throws Exception {
        withAssertion(()->false);
    }

    private void withAssertion(BooleanSupplier condition){
        if(!condition.getAsBoolean()){
            throw new AssertionError();
        }
    }
}
