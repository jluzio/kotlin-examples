package org.example.kotlin.core.java;

import com.example.kotlin.maven.playground.java.model.SomeAnnotation;
import com.example.kotlin.maven.playground.model.Constants;
import com.example.kotlin.maven.playground.model.ConstantsKt;
import org.junit.jupiter.api.Test;

public class ConstantsTest {

  @SomeAnnotation(text = ConstantsKt.CONST_VAL)
  public static class SomeAnnotatedClass {

  }

  @SomeAnnotation(text = Constants.CONST_VAL)
  public static class SomeAnnotatedClass2 {

  }

  @Test
  public void compileTimeConstants() {
    System.out.printf("annotation: %s%n",
        SomeAnnotatedClass.class.getAnnotation(SomeAnnotation.class).text());
    System.out.printf("annotation2: %s%n",
        SomeAnnotatedClass2.class.getAnnotation(SomeAnnotation.class).text());
  }

}
