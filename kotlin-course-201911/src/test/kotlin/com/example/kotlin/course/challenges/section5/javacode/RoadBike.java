package com.example.kotlin.course.challenges.section5.javacode;

public class RoadBike extends Bicycle {

  // In millimetres
  private int tireWidth;

  public RoadBike(int cadence,
      int speed,
      int gear,
      int tireWidth) {
    super(cadence, speed, gear);
    this.tireWidth = tireWidth;
  }

  public int getTireWidth() {
    return tireWidth;
  }

}
