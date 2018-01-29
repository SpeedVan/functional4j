package org.supsys.common.functional.closure;

import org.supsys.common.functional.function.Function2NR;
import org.supsys.common.functional.function.FunctionNP;
import org.supsys.common.functional.function.FunctionNPNR;
import org.supsys.common.functional.function.FunctionNR;

public class ClosureWrapper {

    public static <T> T funcWrapper(FunctionNPNR before, FunctionNR<T> after, FunctionNP<T> supplier){
        before.apply();
        T result = supplier.apply();
        after.apply(result);
        return result;
    }

    public static <T,T1> T funcWrapper(FunctionNP<T1> before, Function2NR<T,T1> after, FunctionNP<T> supplier){
        T1 _1 = before.apply();
        T result = supplier.apply();
        after.apply(result, _1);
        return result;
    }

    public static <T> T funcWrapper(FunctionNPNR before, FunctionNP<T> supplier){
        before.apply();
        return supplier.apply();
    }

    public static <T> T funcWrapper(FunctionNR<T> after, FunctionNP<T> supplier){
        T result = supplier.apply();
        after.apply(result);
        return result;
    }

    public static <T> T staticBlock(FunctionNP<T> supplier){
        return supplier.apply();
    }


}
