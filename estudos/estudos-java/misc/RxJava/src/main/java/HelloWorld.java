import org.junit.Test;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by @author <a href="mailto:allandequeiroz@gmail.com">Allan de Queiroz</a>
 */
public class HelloWorld implements RxJava{

    @Test
    public void perform() throws Exception {
        hello("Ben","George");
    }

    public void hello(String... names){
        Observable.from(names).subscribe(new Action1<String>() {
            public void call(String s) {
                System.out.println("Hello " + s + "!");
            }
        });
    }
}
