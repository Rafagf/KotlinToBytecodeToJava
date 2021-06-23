package dataclass;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
        mv = {1, 1, 15},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"},
        d2 = {"Ldataclass/MyKotlinRegularClass;", "", "aString1", "", "aString2", "(Ljava/lang/String;Ljava/lang/String;)V", "getAString1", "()Ljava/lang/String;", "getAString2", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "KotlinBytecodeJava"}
)
public final class MyKotlinRegularClass {
    @NotNull
    private final String aString1;
    @NotNull
    private final String aString2;

    @NotNull
    public final String getAString1() {
        return this.aString1;
    }

    @NotNull
    public final String getAString2() {
        return this.aString2;
    }

    public MyKotlinRegularClass(@NotNull String aString1, @NotNull String aString2) {
        Intrinsics.checkParameterIsNotNull(aString1, "aString1");
        Intrinsics.checkParameterIsNotNull(aString2, "aString2");
        super();
        this.aString1 = aString1;
        this.aString2 = aString2;
    }

    @NotNull
    public final String component1() {
        return this.aString1;
    }

    @NotNull
    public final String component2() {
        return this.aString2;
    }

    @NotNull
    public final MyKotlinRegularClass copy(@NotNull String aString1, @NotNull String aString2) {
        Intrinsics.checkParameterIsNotNull(aString1, "aString1");
        Intrinsics.checkParameterIsNotNull(aString2, "aString2");
        return new MyKotlinRegularClass(aString1, aString2);
    }

    // $FF: synthetic method
    public static MyKotlinRegularClass copy$default(MyKotlinRegularClass var0, String var1, String var2, int var3, Object var4) {
        if ((var3 & 1) != 0) {
            var1 = var0.aString1;
        }

        if ((var3 & 2) != 0) {
            var2 = var0.aString2;
        }

        return var0.copy(var1, var2);
    }

    @NotNull
    public String toString() {
        return "MyKotlinRegularClass(aString1=" + this.aString1 + ", aString2=" + this.aString2 + ")";
    }

    public int hashCode() {
        String var10000 = this.aString1;
        int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
        String var10001 = this.aString2;
        return var1 + (var10001 != null ? var10001.hashCode() : 0);
    }

    public boolean equals(@Nullable Object var1) {
        if (this != var1) {
            if (var1 instanceof MyKotlinRegularClass) {
                MyKotlinRegularClass var2 = (MyKotlinRegularClass)var1;
                if (Intrinsics.areEqual(this.aString1, var2.aString1) && Intrinsics.areEqual(this.aString2, var2.aString2)) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }
}


/*
Notes:
- crazy verbose
- hashCode, equals and toString implementation
- 2 getters per field which seems to be the same (component1() etc). This looks useless but it's used for destructuring
destructuring declaration

For example, use the date class from the previous example and add the following code:

Kotlin

classDestructuringDeclaration{
    funtest() {
        val (one, two) = Test("hello", "world")
    }
}

Decompiled java

publicfinalclassDestructuringDeclaration{
   publicfinalvoidtest(){
      Test var3 = new Test("hello", "world");
      String var1 = var3.component1();
      String two = var3.component2();
   }
}
https://sudonull.com/post/10420-Kotlin-under-the-hood-look-decompiled-bytecode

- getters and this time also setters for var variables
- synthetic method definition:  I like that very short definition of "synthetic": a Java construct introduced by the compiler to do extra things.
Example: In Java world a synthetic method getter will be created for private fields of a nested class, so the enclosing class can access to it.
Here the same is happening to give us the ability to only override some parameters. var 3 is a mask to tell which parameters are provided (if I undrstood right) and the last object seems useless.
*/
