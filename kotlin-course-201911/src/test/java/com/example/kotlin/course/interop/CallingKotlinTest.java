package com.example.kotlin.course.interop;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CallingKotlinTest {

  private Logger log = LoggerFactory.getLogger(getClass());

  @Test
  void test1() {
    KotlinTarget k = new KotlinTarget();
    log.debug("{}", k.field);

    // instance method of companion
    KotlinTarget.Companion.staticPrint();
    // static method (of companion)
    KotlinTarget.staticPrint();

    log.debug("{}", KotlinTarget.field);
    log.debug("{}", KotlinTarget.constField);

    KotlinTarget.Companion.optionalParamsFun("str", 32);
    // one arg function is not generated
    // KotlinTarget.Companion.optionalParamsFun("str");
    KotlinTarget.Companion.optionalParamsFunOverloads("str");
    KotlinTarget.Companion.optionalParamsFunOverloads("str", 32);

  }
}
