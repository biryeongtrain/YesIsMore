package net.biryeongtrain.yes_is_more.util.function;

import java.util.Objects;

@FunctionalInterface
public interface QuadConsumer<T, U, V, W> {
    void accept(T t, U u, V v, W w);
    default QuadConsumer<T, U, V, W> andThen(QuadConsumer<? super T, ? super U, ? super V, ? super W> after) {
        Objects.requireNonNull(after);
        return (t, u, v, w) -> {
            this.accept(t, u, v, w);
            after.accept(t, u, v, w);
        };
    }
}
