package com.example.kotlin.course.challenges.section5.javacode;

public class MountainBike extends Bicycle {

  private int seatHeight;

  public MountainBike(int seatHeight,
      int cadence,
      int speed,
      int gear) {
    super(cadence, speed, gear);
    this.seatHeight = seatHeight;
  }

  public int getSeatHeight() {
    return seatHeight;
  }

  public void setSeatHeight(int seatHeight) {
    this.seatHeight = seatHeight;
  }
}
