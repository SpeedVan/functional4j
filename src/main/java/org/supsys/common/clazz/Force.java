package org.supsys.common.clazz;

import sun.reflect.CallerSensitive;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Force {

    public static FieldX getFieldX(Object o, String field){
        return new FieldX(findField(o.getClass(),field), o);
    }

    public static Field findField(Class clazz, String field){
        if(clazz == Object.class) throw new RuntimeException("该class及其super class不存在这样的field");
        try {
            return clazz.getDeclaredField(field);
        } catch (NoSuchFieldException e) {
            return findField(clazz.getSuperclass(), field);
        }
    }

    public static MethodX getMethodX(Object o, String method, Class<?>... parameterTypes){
        try {
            return new MethodX(o.getClass().getDeclaredMethod(method, parameterTypes), o);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static class FieldX {
        public final Field field;
        public final Object object;
        public FieldX(Field field, Object object){
            this.field = field;
            this.object = object;
        }

        public <T> T getValue(){
            boolean currValue = field.isAccessible();
            field.setAccessible(true);
            try {
                Object result = field.get(object);
                return (T)result;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getMessage());
            } finally {
                field.setAccessible(currValue);
            }
        }

        //v-----------Delegate Methods----------v
        public Class<?> getDeclaringClass() {
            return field.getDeclaringClass();
        }

        public String getName() {
            return field.getName();
        }

        public int getModifiers() {
            return field.getModifiers();
        }

        public boolean isEnumConstant() {
            return field.isEnumConstant();
        }

        public boolean isSynthetic() {
            return field.isSynthetic();
        }

        public Class<?> getType() {
            return field.getType();
        }

        public Type getGenericType() {
            return field.getGenericType();
        }

        public String toGenericString() {
            return field.toGenericString();
        }

        @CallerSensitive
        public Object get(Object obj) throws IllegalArgumentException, IllegalAccessException {
            return field.get(obj);
        }

        @CallerSensitive
        public boolean getBoolean(Object obj) throws IllegalArgumentException, IllegalAccessException {
            return field.getBoolean(obj);
        }

        @CallerSensitive
        public byte getByte(Object obj) throws IllegalArgumentException, IllegalAccessException {
            return field.getByte(obj);
        }

        @CallerSensitive
        public char getChar(Object obj) throws IllegalArgumentException, IllegalAccessException {
            return field.getChar(obj);
        }

        @CallerSensitive
        public short getShort(Object obj) throws IllegalArgumentException, IllegalAccessException {
            return field.getShort(obj);
        }

        @CallerSensitive
        public int getInt(Object obj) throws IllegalArgumentException, IllegalAccessException {
            return field.getInt(obj);
        }

        @CallerSensitive
        public long getLong(Object obj) throws IllegalArgumentException, IllegalAccessException {
            return field.getLong(obj);
        }

        @CallerSensitive
        public float getFloat(Object obj) throws IllegalArgumentException, IllegalAccessException {
            return field.getFloat(obj);
        }

        @CallerSensitive
        public double getDouble(Object obj) throws IllegalArgumentException, IllegalAccessException {
            return field.getDouble(obj);
        }

        @CallerSensitive
        public void set(Object obj, Object value) throws IllegalArgumentException, IllegalAccessException {
            field.set(obj, value);
        }

        @CallerSensitive
        public void setBoolean(Object obj, boolean z) throws IllegalArgumentException, IllegalAccessException {
            field.setBoolean(obj, z);
        }

        @CallerSensitive
        public void setByte(Object obj, byte b) throws IllegalArgumentException, IllegalAccessException {
            field.setByte(obj, b);
        }

        @CallerSensitive
        public void setChar(Object obj, char c) throws IllegalArgumentException, IllegalAccessException {
            field.setChar(obj, c);
        }

        @CallerSensitive
        public void setShort(Object obj, short s) throws IllegalArgumentException, IllegalAccessException {
            field.setShort(obj, s);
        }

        @CallerSensitive
        public void setInt(Object obj, int i) throws IllegalArgumentException, IllegalAccessException {
            field.setInt(obj, i);
        }

        @CallerSensitive
        public void setLong(Object obj, long l) throws IllegalArgumentException, IllegalAccessException {
            field.setLong(obj, l);
        }

        @CallerSensitive
        public void setFloat(Object obj, float f) throws IllegalArgumentException, IllegalAccessException {
            field.setFloat(obj, f);
        }

        @CallerSensitive
        public void setDouble(Object obj, double d) throws IllegalArgumentException, IllegalAccessException {
            field.setDouble(obj, d);
        }

        public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
            return field.getAnnotation(annotationClass);
        }

        public <T extends Annotation> T[] getAnnotationsByType(Class<T> annotationClass) {
            return field.getAnnotationsByType(annotationClass);
        }

        public Annotation[] getDeclaredAnnotations() {
            return field.getDeclaredAnnotations();
        }

        public AnnotatedType getAnnotatedType() {
            return field.getAnnotatedType();
        }

        public static void setAccessible(AccessibleObject[] array, boolean flag) throws SecurityException {
            AccessibleObject.setAccessible(array, flag);
        }

        public void setAccessible(boolean flag) throws SecurityException {
            field.setAccessible(flag);
        }

        public boolean isAccessible() {
            return field.isAccessible();
        }

        public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
            return field.isAnnotationPresent(annotationClass);
        }

        public Annotation[] getAnnotations() {
            return field.getAnnotations();
        }

        public <T extends Annotation> T getDeclaredAnnotation(Class<T> annotationClass) {
            return field.getDeclaredAnnotation(annotationClass);
        }

        public <T extends Annotation> T[] getDeclaredAnnotationsByType(Class<T> annotationClass) {
            return field.getDeclaredAnnotationsByType(annotationClass);
        }
    }

    public static class MethodX {
        public final Method method;
        public final Object object;
        public MethodX(Method method, Object object){
            this.method = method;
            this.object = object;
        }

        public <T> T invokeMethod(Object... parameters){
            boolean currValue = method.isAccessible();
            method.setAccessible(true);
            try {
                Object result = method.invoke(object, parameters);
                return (T)result;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getMessage());
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getMessage());
            } finally {
                method.setAccessible(currValue);
            }
        }

        //v-----------Delegate Methods----------v
        public Class<?> getDeclaringClass() {
            return method.getDeclaringClass();
        }

        public String getName() {
            return method.getName();
        }

        public int getModifiers() {
            return method.getModifiers();
        }

        public TypeVariable<Method>[] getTypeParameters() {
            return method.getTypeParameters();
        }

        public Class<?> getReturnType() {
            return method.getReturnType();
        }

        public Type getGenericReturnType() {
            return method.getGenericReturnType();
        }

        public Class<?>[] getParameterTypes() {
            return method.getParameterTypes();
        }

        public int getParameterCount() {
            return method.getParameterCount();
        }

        public Type[] getGenericParameterTypes() {
            return method.getGenericParameterTypes();
        }

        public Class<?>[] getExceptionTypes() {
            return method.getExceptionTypes();
        }

        public Type[] getGenericExceptionTypes() {
            return method.getGenericExceptionTypes();
        }

        public String toGenericString() {
            return method.toGenericString();
        }

        @CallerSensitive
        public Object invoke(Object obj, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            return method.invoke(obj, args);
        }

        public boolean isBridge() {
            return method.isBridge();
        }

        public boolean isVarArgs() {
            return method.isVarArgs();
        }

        public boolean isSynthetic() {
            return method.isSynthetic();
        }

        public boolean isDefault() {
            return method.isDefault();
        }

        public Object getDefaultValue() {
            return method.getDefaultValue();
        }

        public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
            return method.getAnnotation(annotationClass);
        }

        public Annotation[] getDeclaredAnnotations() {
            return method.getDeclaredAnnotations();
        }

        public Annotation[][] getParameterAnnotations() {
            return method.getParameterAnnotations();
        }

        public AnnotatedType getAnnotatedReturnType() {
            return method.getAnnotatedReturnType();
        }

        public Parameter[] getParameters() {
            return method.getParameters();
        }

        public <T extends Annotation> T[] getAnnotationsByType(Class<T> annotationClass) {
            return method.getAnnotationsByType(annotationClass);
        }

        public AnnotatedType getAnnotatedReceiverType() {
            return method.getAnnotatedReceiverType();
        }

        public AnnotatedType[] getAnnotatedParameterTypes() {
            return method.getAnnotatedParameterTypes();
        }

        public AnnotatedType[] getAnnotatedExceptionTypes() {
            return method.getAnnotatedExceptionTypes();
        }

        public static void setAccessible(AccessibleObject[] array, boolean flag) throws SecurityException {
            AccessibleObject.setAccessible(array, flag);
        }

        public void setAccessible(boolean flag) throws SecurityException {
            method.setAccessible(flag);
        }

        public boolean isAccessible() {
            return method.isAccessible();
        }

        public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
            return method.isAnnotationPresent(annotationClass);
        }

        public Annotation[] getAnnotations() {
            return method.getAnnotations();
        }

        public <T extends Annotation> T getDeclaredAnnotation(Class<T> annotationClass) {
            return method.getDeclaredAnnotation(annotationClass);
        }

        public <T extends Annotation> T[] getDeclaredAnnotationsByType(Class<T> annotationClass) {
            return method.getDeclaredAnnotationsByType(annotationClass);
        }
    }
}
