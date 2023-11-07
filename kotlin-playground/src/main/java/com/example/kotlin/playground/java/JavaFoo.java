package com.example.kotlin.playground.java;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaFoo {

  public String run() {
    log.info("JavaFoo.run");
    return "java-foo";
  }

}
