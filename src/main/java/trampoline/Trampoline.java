package trampoline;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by mtumilowicz on 2018-11-25.
 */
@FunctionalInterface
public interface Trampoline<T> extends Supplier<Trampoline<T>> {

    default boolean isComplete() {
        return false;
    }

    default T result() {
        // result is not available
        throw new UnsupportedOperationException();
    }

    default T invoke() {
        return Stream.iterate(this, Trampoline::get)
                .filter(Trampoline::isComplete)
                .findFirst()
                .orElseThrow()
                .result();
    }

    static <T> Trampoline<T> done(T result) {
        return new TerminalCall<>(result);
    }

    class TerminalCall<T> implements Trampoline<T> {

        private final T result;

        TerminalCall(T result) {
            this.result = result;
        }

        @Override
        public boolean isComplete() {
            return true;
        }

        @Override
        public T result() {
            return result;
        }

        @Override
        public Trampoline<T> get() {
            // bouncing is over
            throw new UnsupportedOperationException();
        }
    }
}
