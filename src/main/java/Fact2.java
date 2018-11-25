/**
 * Created by mtumilowicz on 2018-11-25.
 */
public class Fact2 {
    public static Long fact(int n, long acc) {
        if (n==1) return acc;
        return fact(n-1, acc*n);
    }
}
