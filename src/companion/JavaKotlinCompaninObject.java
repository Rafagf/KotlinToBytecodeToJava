package companion;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public final class MyClass {
    public static final MyClass.Factory Factory = new MyClass.Factory((DefaultConstructorMarker)null);

    public static final class Factory {
        @NotNull
        public final MyClass create() {
            return new MyClass();
        }

        private Factory() {
        }

        // $FF: synthetic method
        public Factory(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

/*
Notes:
- It basically delegates to a static class.
- MyClass and then inner nested class Factory
- Factory static field to call the factory create method, which will crete the MyClass instance.
 */
