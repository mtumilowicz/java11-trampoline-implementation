import org.junit.Test;
import trampoline.Trampoline2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by mtumilowicz on 2018-11-25.
 */
public class FactTest {

    @Test
    public void xxx() {
        Fact fact = new Fact();

        Long apply = fact.apply(1_000_000);
    }
    
    @Test
    public void xxxxxxxx() {
        Long aLong = naiveFactorial(1_000_000, 1);
    }

    @Test
    public void xxx2() {
        Long apply = Fact2.fact(1_000_000, 1);

        assertThat(apply, is(1307674368000L));
    }

    @Test
    public void xxx3() {
        Integer result = xxxxxxxxxx(1_000_000, 1).result();
    }
    
    @Test
    public void xxxxx() {
        Long fact = Fact3.fact(1_000_000, 1).result();
    }

    public Trampoline2<Integer> xxxxxxxxxx(int n, int acc) {
        return n == 1 ? Trampoline2.done(acc) : Trampoline2.more(() -> xxxxxxxxxx(n - 1, n * acc));
    }

    public Long naiveFactorial(int n, long acc) {
        return n == 1 ? acc : naiveFactorial(n-1, n*acc);
    }
}