import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by mtumilowicz on 2018-11-25.
 */
public class FactorialTest {
    
    private final Factorial factorial = new Factorial();

    @Test
    public void _3() {
        assertThat(factorial.applyAsLong(3), is(6L));
    }

    @Test
    public void _4() {
        assertThat(factorial.applyAsLong(4), is(24L));
    }

    @Test
    public void _5() {
        assertThat(factorial.applyAsLong(5), is(120L));
    }

    @Test
    public void _6() {
        assertThat(factorial.applyAsLong(6), is(720L));
    }

    @Test
    public void _7() {
        assertThat(factorial.applyAsLong(7), is(5040L));
    }

    @Test
    public void _20() {
        assertThat(factorial.applyAsLong(20), is(2432902008176640000L));
    }

    @Test
    public void _1_000_000() {
        factorial.applyAsLong(1_000_000);
    }
}