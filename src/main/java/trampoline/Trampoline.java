package trampoline;

import java.util.stream.Stream;

/**
 * Created by mtumilowicz on 2018-11-25.
 */
@FunctionalInterface
public interface Trampoline<T> {

    default boolean isComplete() {
        return false;
    }

    default T result() {
        // result is not available yet
        throw new UnsupportedOperationException();
    }

    Trampoline<T> bounce();

    default T invoke() {
        return Stream.iterate(this, Trampoline::bounce)
                .filter(Trampoline::isComplete)
                .findFirst()
                .orElseThrow()
                .result();
    }

    static <T> Trampoline<T> done(T result) {
        return new TerminalCall<>(result);
    }

    static <T> Trampoline<T> more(Trampoline<T> intermediary) {
        return new IntermediaryCall<>(intermediary);
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
        public Trampoline<T> bounce() {
            // bouncing is over
            throw new UnsupportedOperationException();
        }
    }

    class IntermediaryCall<T> implements Trampoline<T> {

        private final Trampoline<T> previous;

        public IntermediaryCall(Trampoline<T> previous) {
            this.previous = previous;
        }

        @Override
        public boolean isComplete() {
            return false;
        }

        @Override
        public T result() {
            // result is not available yet
            throw new UnsupportedOperationException();
        }

        @Override
        public Trampoline<T> bounce() {
            return previous.bounce();
        }
    }
}
