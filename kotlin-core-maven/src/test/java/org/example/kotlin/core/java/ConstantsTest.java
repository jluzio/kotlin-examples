package org.example.kotlin.core.java;

import org.example.kotlin.core.java.model.SomeAnnotation;
import org.example.kotlin.core.kotlin.model.Constants;
import org.example.kotlin.core.kotlin.model.ConstantsKt;
import org.junit.Test;

public class ConstantsTest {

    @SomeAnnotation(text = ConstantsKt.CONST_VAL)
    public static class SomeAnnotatedClass {
    }
    @SomeAnnotation(text = Constants.CONST_VAL)
    public static class SomeAnnotatedClass2 {
    }

    @Test
    public void compileTimeConstants() {
        System.out.printf("annotation: %s%n", SomeAnnotatedClass.class.getAnnotation(SomeAnnotation.class).text());
        System.out.printf("annotation2: %s%n", SomeAnnotatedClass2.class.getAnnotation(SomeAnnotation.class).text());
    }

}
