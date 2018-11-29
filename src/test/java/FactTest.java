import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by mtumilowicz on 2018-11-25.
 */
public class FactTest {

    @Test
    public void _3() {
        Fact fact = new Fact();

        Long apply = fact.apply(3);
        
        assertThat(apply, is(6L));
    }

    @Test
    public void _4() {
        Fact fact = new Fact();

        Long apply = fact.apply(4);

        assertThat(apply, is(24L));
    }

    @Test
    public void _5() {
        Fact fact = new Fact();

        Long apply = fact.apply(5);

        assertThat(apply, is(120L));
    }

    @Test
    public void _6() {
        Fact fact = new Fact();

        Long apply = fact.apply(6);

        assertThat(apply, is(720L));
    }

    @Test
    public void _7() {
        Fact fact = new Fact();

        Long apply = fact.apply(7);

        assertThat(apply, is(5040L));
    }

    @Test
    public void _20() {
        Fact fact = new Fact();

        Long apply = fact.apply(20);

        assertThat(apply, is(2432902008176640000L));
    }
}