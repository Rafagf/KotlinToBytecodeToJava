package collections;

//infix, operator, typealias and lateinit

// Point.java
package collections;

import kotlin.Metadata;

public final class Point {
    private final int x;
    private final int y;

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
// Foo.java
package collections;

        import kotlin.Metadata;
        import kotlin.jvm.internal.Intrinsics;
        import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 1, 15},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"},
        d2 = {"Lcollections/Foo;", "", "a", "", "(I)V", "getA", "()I", "b", "", "getB", "()Ljava/lang/String;", "setB", "(Ljava/lang/String;)V", "KotlinBytecodeJava"}
)
public final class Foo {
    @NotNull
    public String b;
    private final int a;

    @NotNull
    public final String getB() {
        String var10000 = this.b;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("b");
        }

        return var10000;
    }

    public final void setB(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.b = var1;
    }

    public final int getA() {
        return this.a;
    }

    public Foo(int a) {
        this.a = a;
    }
}
// KotlinRandomKt.java
package collections;

        import kotlin.Metadata;
        import kotlin.jvm.internal.Intrinsics;
        import org.jetbrains.annotations.NotNull;

public final class KotlinRandomKt {
    private static final int four = increment(3, 1);
    @NotNull
    private static final Point point = new Point(10, 20);

    public static final int increment(int $this$increment, int x) {
        return x + 1;
    }

    public static final int getFour() {
        return four;
    }

    @NotNull
    public static final Point unaryMinus(@NotNull Point $this$unaryMinus) {
        Intrinsics.checkParameterIsNotNull($this$unaryMinus, "$this$unaryMinus");
        return new Point(-$this$unaryMinus.getX(), -$this$unaryMinus.getY());
    }

    @NotNull
    public static final Point getPoint() {
        return point;
    }

    public static final void main() {
        Point var0 = unaryMinus(point);
        boolean var1 = false;
        System.out.println(var0);
    }

    // $FF: synthetic method
    public static void main(String[] var0) {
        main();
    }
}


/*
Notes:
- Infix or operator: Pretty much as any other extension function. A function that takes 2 parameters
(this and the ones provided by parameters). When using the infix notation (3 increment 1)
it just uses that function
- typealias: they don't exist in bytecode or Java!
So no, you can't use typealiases from Java, you'll just see the actual types of any parameter or variable that has a typealias'd type in Kotlin.
The Kotlin compiler erases the type aliases at compile time and uses the underlying types at runtime
- lateinit: no magic, very simple: the property getter does a check against null and throws an exception
 String var10000 = this.b;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("b");
      }
 */
