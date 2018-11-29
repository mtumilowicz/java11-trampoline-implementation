package trampoline;

import java.util.function.Supplier;

/**
 * Created by mtumilowicz on 2018-11-25.
 */
public interface Trampoline2<T> extends Supplier<T> {

//    default Trampoline2<T> bounce() {
//        return this;
//    }
//
//    default T result() {
//        return get();
//    }
//
//    default boolean completed() {
//        return true;
//    }
//
//    public static <T> Trampoline2<T> done(final T result) {
//        return () -> result;
//    }
//
//    @Override
//    T get();
//
//    public static <T> Trampoline2<T> more(final Trampoline2<Trampoline2<T>> trampoline) {
//        return new Trampoline2<>() {
//
//
//            @Override
//            public boolean completed() {
//                return false;
//            }
//
//            @Override
//            public Trampoline2<T> bounce() {
//                return trampoline.result();
//            }
//
//            @Override
//            public T get() {
//                return trampoline(this);
//            }
//
//            T trampoline(final Trampoline2<T> trampoline) {
//
//                return Stream.iterate(trampoline, Trampoline2::bounce)
//                        .filter(Trampoline2::completed)
//                        .findFirst()
//                        .get()
//                        .result();
//
//            }
//        };
//    }
}
