package regularclass;

import com.sun.istack.internal.NotNull;
import kotlin.jvm.internal.Intrinsics;

public final class MyKotlinRegularClass {
    @NotNull
    private final String aString;
    @NotNull
    private final String aNullableString;
    private final int aNumber;

    @NotNull
    public final String getAString() {
        return this.aString;
    }

    @NotNull
    public final String getANullableString() {
        return this.aNullableString;
    }

    public final int getANumber() {
        return this.aNumber;
    }

    public MyKotlinRegularClass(@NotNull String aString, @NotNull String aNullableString, int aNumber) {
        Intrinsics.checkParameterIsNotNull(aString, "aString");
        Intrinsics.checkParameterIsNotNull(aNullableString, "aNullableString");
        super();
        this.aString = aString;
        this.aNullableString = aNullableString;
        this.aNumber = aNumber;
    }
}

/*
Notes:
- class is final since it the kotlin isn't open
- annotations added for not null parameters - but this isn't enoough so there's a field check in the constructor to throw the exception
- super() call to Object class? not really sure why
- getters but not setters - immutable because all our fields are the val!
 */
