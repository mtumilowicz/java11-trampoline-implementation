import trampoline.Trampoline;

import java.util.function.Function;

/**
 * Created by mtumilowicz on 2018-11-25.
 */
public class Fact implements Function<Integer, Long> {
    @Override
    public Long apply(Integer integer) {
        return fact(integer, 1).invoke();
    }
    
    private Trampoline<Long> fact(int n, long acc) {
        if (n==1) return Trampoline.done(acc);
        return () -> fact(n-1, acc*n);
    }
}
