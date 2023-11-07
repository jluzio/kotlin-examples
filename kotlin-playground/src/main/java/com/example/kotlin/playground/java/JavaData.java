package com.example.kotlin.playground.java;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class JavaData {

  List<String> stringList;
  String[] stringArray;

  public boolean equalsToStringArray(String... values) {
    return Arrays.asList(stringArray).equals(Arrays.asList(values));
  }

}
