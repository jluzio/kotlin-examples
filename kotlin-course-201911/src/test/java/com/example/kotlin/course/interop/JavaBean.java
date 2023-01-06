package com.example.kotlin.course.interop;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaBean {

  private String value;
  private String nullableValue;
  private String nonNullableValue;
  private String onlySetterValue;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getNullableValue() {
    return nullableValue;
  }

  public void setNullableValue(@Nullable String nullableValue) {
    this.nullableValue = nullableValue;
  }

  public String getNonNullableValue() {
    return nonNullableValue;
  }

  public void setNonNullableValue(@NotNull String nonNullableValue) {
    this.nonNullableValue = nonNullableValue;
  }

  public void setOnlySetterValue(String onlySetterValue) {
    this.onlySetterValue = onlySetterValue;
  }
}
