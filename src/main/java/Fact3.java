import trampoline.Trampoline2;

/**
 * Created by mtumilowicz on 2018-11-29.
 */
public class Fact3 {
    public static Trampoline2<Long> fact(int n, long acc) {
        return n == 1 ? Trampoline2.done(acc) : Trampoline2.more(() -> fact(n - 1, acc * n));
    }
}
