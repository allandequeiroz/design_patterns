package java_se_8_for_the_really_impatient.chapter_3;

import common.Exercise;
import lombok.Data;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Optional;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class C3E9 implements Exercise {

    @Test
    @Override
    public void perform() throws Exception {
        Being b1 =  new Being.Builder().withFirstName("Barak").withLastName("Obama").build();
        Being b2 =  new Being.Builder().withFirstName("Barak").withLastName("Obama").build();
        int result1 = lexicographicComparator("firstName","lastName").compare(b1,b2);
        Assert.assertEquals(0,result1);

        Being b3 =  new Being.Builder().withFirstName("Barak").withLastName("Obama").build();
        Being b4 =  new Being.Builder().withFirstName("Obama").withLastName("Barak").build();
        int result2 = lexicographicComparator("firstName","lastName").compare(b3,b4);
        Assert.assertNotEquals(0,result2);
    }

    private Comparator<Object> lexicographicComparator(String... fields){
        return (o1, o2) -> {
            for (String field : fields){
                Optional<String> o1Optional = extractFieldValue(o1,field);
                Optional<String> o2Optional = extractFieldValue(o2,field);
                if(o1Optional.isPresent()&&o2Optional.isPresent()) {
                    String o1Value = o1Optional.get();
                    String o2Value = o2Optional.get();
                    if(!o1Value.equals(o2Value)) {
                        return o1Value.compareTo(o2Value);
                    }
                }else {
                    return -1;
                }
            }
            return 0;
        };
    }

    private Optional<String> extractFieldValue(Object target, String field){
        try {
            String methodName = "get"+String.valueOf(field.charAt(0)).toUpperCase()+field.substring(1);
            Object returnedValue = target.getClass().getDeclaredMethod(methodName).invoke(target);
            if(returnedValue!=null){
                return Optional.of(returnedValue.toString());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

class Being {
    @Getter private String firstName;
    @Getter private String lastName;

    private Being(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
    }

    public static final class Builder {
        private String firstName;
        private String lastName;

        public Builder() {
        }

        public Builder withFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder withLastName(String val) {
            lastName = val;
            return this;
        }

        public Being build() {
            return new Being(this);
        }
    }
}


