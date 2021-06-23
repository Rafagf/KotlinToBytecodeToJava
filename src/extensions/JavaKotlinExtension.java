package extensions;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import kotlin.jvm.internal.Intrinsics;

public final class JavaKotlinExtension {
    public static final int toSquare(@NotNull Number $this$toSquare) {
        Intrinsics.checkParameterIsNotNull($this$toSquare, "$this$toSquare");
        return $this$toSquare.getAInt() * $this$toSquare.getAInt();
    }
}

/*
Notes
- syntactic sugar. Static method under a dummy class that takes the instance as parameter and executes the code
 */

public final class Number {
    private final int aInt;

    public final int getAInt() {
        return this.aInt;
    }

    public Number(int aInt) {
        this.aInt = aInt;
    }

    public final int component1() {
        return this.aInt;
    }

    @NotNull
    public final Number copy(int aInt) {
        return new Number(aInt);
    }

    // $FF: synthetic method
    public static Number copy$default(Number var0, int var1, int var2, Object var3) {
        if ((var2 & 1) != 0) {
            var1 = var0.aInt;
        }

        return var0.copy(var1);
    }

    @NotNull
    public String toString() {
        return "Number(aInt=" + this.aInt + ")";
    }

    public int hashCode() {
        return this.aInt;
    }

    public boolean equals(@Nullable Object var1) {
        if (this != var1) {
            if (var1 instanceof Number) {
                Number var2 = (Number)var1;
                if (this.aInt == var2.aInt) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }
}
