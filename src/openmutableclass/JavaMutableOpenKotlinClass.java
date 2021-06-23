package openmutableclass;

import com.sun.istack.internal.NotNull;
import kotlin.jvm.internal.Intrinsics;

public class MutableOpenKotlinClass {
    @NotNull
    private final String aString;
    @NotNull
    private String aMutableNullableString;
    private int aMutableNumber;

    @NotNull
    public final String getAString() {
        return this.aString;
    }

    @NotNull
    public final String getAMutableNullableString() {
        return this.aMutableNullableString;
    }

    public final void setAMutableNullableString(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.aMutableNullableString = var1;
    }

    public final int getAMutableNumber() {
        return this.aMutableNumber;
    }

    public final void setAMutableNumber(int var1) {
        this.aMutableNumber = var1;
    }

    public MutableOpenKotlinClass(@NotNull String aString, @NotNull String aMutableNullableString, int aMutableNumber) {
        Intrinsics.checkParameterIsNotNull(aString, "aString");
        Intrinsics.checkParameterIsNotNull(aMutableNullableString, "aMutableNullableString");
        super();
        this.aString = aString;
        this.aMutableNullableString = aMutableNullableString;
        this.aMutableNumber = aMutableNumber;
    }
}

/*
Notes:
- no more final, it can be extended
- getters and this time also setters for var variables
*/
