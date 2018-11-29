# java11-trampoline-implementation

_Reference_: https://github.com/aol/cyclops/blob/master/cyclops/src/main/java/cyclops/control/Trampoline.java

# preface
Java implementation of trampoline concept. Please refer my other
project about trampolines: https://github.com/mtumilowicz/groovy-trampoline-tail-recursion
(contains all basics definitions).

# preface
We want to have mechanism that will convert recurrent 
calls to the stream of consecutive function 
invocations until some function could return value.
```
Stream.iterate(this, nextInvocation)
                .filter(checkIfComplete)
                .findFirst()
                .orElseThrow()
                .result();
```
# project description
## theory
We provide interface `Trampoline` with methods:
* for check if process is complete
    ```
    default boolean isComplete() {
              return false;
          }
    ```
* substitute of recurrent call
    ```
    Trampoline<T> bounce();
    ```
* function to return result of computation if complete
    ```
    default T result() {
              throw new UnsupportedOperationException();
          }
    ```
    **default behaviour**: throwing `UnsupportedOperationException`,
    because the result is not available yet
* pipeline
    ```
    default T invoke() {
        return Stream.iterate(this, Trampoline::bounce)
                .filter(Trampoline::isComplete)
                .findFirst()
                .orElseThrow()
                .result();
    }
    ```
* static method to provide terminal call
    ```
    static <T> Trampoline<T> completed(T result) {
            return new Completed<>(result);
        }
    ```
* terminal call
    ```
    class Completed<T> implements Trampoline<T> {
    
            private final T result;
    
            Completed(T result) {
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
    ```
## example
We will show how to use trampoline `Factorial`:
```
public class Factorial implements IntToLongFunction {

    @Override
    public long applyAsLong(int value) {
        return factorial(value, 1).invoke();
    }
    
    private Trampoline<Long> factorial(int n, long acc) {
        return n == 1 ? Trampoline.completed(acc) : () -> factorial(n - 1, acc * n);
    }
}
```
so to get `factorial(n)` simply call:
```
assertThat(new Factorial().applyAsLong(20), is(2432902008176640000L));
```