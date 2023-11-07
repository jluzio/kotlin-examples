package com.example.kotlin.playground.java;

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

}
