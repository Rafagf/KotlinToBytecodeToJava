package sealedclass;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Sum extends MathExpr {
    @NotNull
    private final Expr e1;
    @NotNull
    private final Expr e2;

    @NotNull
    public final Expr getE1() {
        return this.e1;
    }

    @NotNull
    public final Expr getE2() {
        return this.e2;
    }

    public Sum(@NotNull Expr e1, @NotNull Expr e2) {
        Intrinsics.checkParameterIsNotNull(e1, "e1");
        Intrinsics.checkParameterIsNotNull(e2, "e2");
        super((DefaultConstructorMarker)null);
        this.e1 = e1;
        this.e2 = e2;
    }

    @NotNull
    public final Expr component1() {
        return this.e1;
    }

    @NotNull
    public final Expr component2() {
        return this.e2;
    }

    @NotNull
    public final Sum copy(@NotNull Expr e1, @NotNull Expr e2) {
        Intrinsics.checkParameterIsNotNull(e1, "e1");
        Intrinsics.checkParameterIsNotNull(e2, "e2");
        return new Sum(e1, e2);
    }

    // $FF: synthetic method
    public static Sum copy$default(Sum var0, Expr var1, Expr var2, int var3, Object var4) {
        if ((var3 & 1) != 0) {
            var1 = var0.e1;
        }

        if ((var3 & 2) != 0) {
            var2 = var0.e2;
        }

        return var0.copy(var1, var2);
    }

    @NotNull
    public String toString() {
        return "Sum(e1=" + this.e1 + ", e2=" + this.e2 + ")";
    }

    public int hashCode() {
        Expr var10000 = this.e1;
        int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
        Expr var10001 = this.e2;
        return var1 + (var10001 != null ? var10001.hashCode() : 0);
    }

    public boolean equals(@Nullable Object var1) {
        if (this != var1) {
            if (var1 instanceof Sum) {
                Sum var2 = (Sum)var1;
                if (Intrinsics.areEqual(this.e1, var2.e1) && Intrinsics.areEqual(this.e2, var2.e2)) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }
}
// Expr.java
package sealedclass;

import kotlin.Metadata;

public interface Expr {
}
// MathExpr.java
package sealedclass;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class MathExpr implements Expr {
    private MathExpr() {
    }

    // $FF: synthetic method
    public MathExpr(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

// Const.java
package sealedclass;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Const extends MathExpr {
    private final double number;

    public final double getNumber() {
        return this.number;
    }

    public Const(double number) {
        super((DefaultConstructorMarker)null);
        this.number = number;
    }

    public final double component1() {
        return this.number;
    }

    @NotNull
    public final Const copy(double number) {
        return new Const(number);
    }

    // $FF: synthetic method
    public static Const copy$default(Const var0, double var1, int var3, Object var4) {
        if ((var3 & 1) != 0) {
            var1 = var0.number;
        }

        return var0.copy(var1);
    }

    @NotNull
    public String toString() {
        return "Const(number=" + this.number + ")";
    }

    public int hashCode() {
        long var10000 = Double.doubleToLongBits(this.number);
        return (int)(var10000 ^ var10000 >>> 32);
    }

    public boolean equals(@Nullable Object var1) {
        if (this != var1) {
            if (var1 instanceof Const) {
                Const var2 = (Const)var1;
                if (Double.compare(this.number, var2.number) == 0) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }
}
// NotANumber.java
package sealedclass;

import kotlin.Metadata;

public final class NotANumber implements Expr {
    public static final NotANumber INSTANCE;

    private NotANumber() {
    }

    static {
        NotANumber var0 = new NotANumber();
        INSTANCE = var0;
    }
}

/*
Notes:
- One to one Expr interface - nothing unexpected
- MathExpr is abstract and has a private constructor (remember that sealed classes cannot be instantiated, they're abstract) and implements
Expr.
- Const and Sum are incredibly boring - they subclass (extends!) the abstract MathExpr, and of course it has all the data class magic
- Const and Sum are also final - because sealed classes branches can't be extended.
- Const and Sum have public constructors so they can be instantiated
- NotANumber (object in kotlin world) is a singleton
 */
