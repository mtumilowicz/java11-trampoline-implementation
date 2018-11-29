import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by mtumilowicz on 2018-11-25.
 */
public class FactTest {

    @Test
    public void xxx() {
        Fact fact = new Fact();

        Long apply = fact.apply(5);
        
        assertThat(apply, is(120L));
    }

    @Test
    public void xxx2() {
//        Long apply = Fact2.fact(1_000_000, 1);
//
//        assertThat(apply, is(1307674368000L));
    }
}