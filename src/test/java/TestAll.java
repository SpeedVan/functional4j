import org.junit.jupiter.api.Test;
import org.supsys.common.collection.FHashMap;
import org.supsys.common.collection.FMap;
import org.supsys.common.functional.function.FunctionNP;


import static org.supsys.common.functional.closure.ClosureWrapper.funcWrapper;
import static org.supsys.common.functional.langfunction.HaskellFunc.foldl;

public class TestAll {

    public <R> R timeWrapper(FunctionNP<R> f){
        return funcWrapper(()->System.currentTimeMillis(), (v,sTime)->System.out.println(System.currentTimeMillis()-sTime), f);
    }


    @Test
    public void test(){
        FMap<String, String> fmap = new FHashMap<>();
        String result = timeWrapper(()->fmap._put("key1","abc")._put("key2","bcd")
                .pm(set->foldl((r,i)->r+","+i,"",set.stream())));
        System.out.println(result);
    }

}
