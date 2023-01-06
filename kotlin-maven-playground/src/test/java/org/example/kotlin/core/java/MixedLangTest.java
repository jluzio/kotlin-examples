package org.example.kotlin.core.java;

import com.example.kotlin.maven.playground.java.model.FooBean;
import com.example.kotlin.maven.playground.model.BarBean;
import org.junit.jupiter.api.Test;

class MixedLangTest {

  @Test
  void test() throws ClassNotFoundException {
    FooBean foo = new FooBean();
    foo.setName("java222-foo");

    System.out.println(foo);

    System.out.println(Class.forName("com.example.kotlin.maven.playground.model.BarBean"));

    BarBean barBean = new BarBean();
    System.out.println(barBean.toString());
    System.out.println(barBean.getText1());
  }

}
