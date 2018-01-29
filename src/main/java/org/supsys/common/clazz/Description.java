package org.supsys.common.clazz;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Description {

    public void getAllStaticMethodShortName2(Class clazz){

    }

    public static List<String> getAllPublicStaticMethodShortName(Class clazz){
        return Stream.of(clazz.getDeclaredMethods())
                .filter(m-> Modifier.isStatic(m.getModifiers()) && Modifier.isPublic(m.getModifiers()))
                .map(m->m.getName()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(getAllPublicStaticMethodShortName(TestClass.class));
    }

    public static class TestClass {
        public static void method1(){}

        private void method2(){}

        public void method3(){}

        private static void method4(){}
    }
}
