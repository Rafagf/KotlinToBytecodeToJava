package object;

import com.sun.istack.internal.NotNull;
import kotlin.jvm.internal.Intrinsics;

//KotlinObject renamed to JavaKotlinObject as otherwise it'll complain about duplicates

public final class JavaKotlinObject {
    @NotNull
    private static String aString;
    public static final JavaKotlinObject INSTANCE;

    @NotNull
    public final String getAString() {
        return aString;
    }

    public final void setAString(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        aString = var1;
    }

    private JavaKotlinObject() {
    }

    static {
        JavaKotlinObject var0 = new JavaKotlinObject();
        INSTANCE = var0;
        aString = "foo";
    }
}

/*
Notes
- Singleton
- Eager implemention of it: will be created when the class loader loads the class (maybe it could have been lazy?)
 */
