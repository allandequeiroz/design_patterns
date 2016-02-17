package co.mutt.dob.validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@Documented
@Target({ElementType.ANNOTATION_TYPE,
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp = ".+@.+\\.[a-z]+", message = "{co.mutt.dob.email.invalido}")
@Size(min = 5, max = 100)
@NotNull
public @interface EMail {
}
