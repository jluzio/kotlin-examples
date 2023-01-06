package com.example.kotlin.course.generics

fun main() {
  defaultTypeHandling()
  contravarianceTypeHandling()
}

interface DefaultFlowerCare<T : Flower> {

  fun prune(flower: T)
}

// handles T and upper
interface ContravarianceFlowerCare<in T : Flower> {

  fun prune(flower: T)
  // can't be used to output values, since we wont return of type T (ie only as "in")
//    fun getFlower(i: Int): T // error

}

fun defaultTypeHandling() {
  class Garden<T : Flower>(val flowerCare: DefaultFlowerCare<T>) {

    val flowers = mutableListOf<T>()
    fun pruneFlower(i: Int) = flowerCare.prune(flowers[i])
  }

  val roseFlowerCare = object : DefaultFlowerCare<Rose> {
    override fun prune(flower: Rose) {
      println("Pruning a flower: ${flower.name}")
    }
  }
  val daisyFlowerCare = object : DefaultFlowerCare<Daisy> {
    override fun prune(flower: Daisy) {
      println("Pruning a flower: ${flower.name}")
    }
  }

  val roseGarden = Garden<Rose>(roseFlowerCare).apply {
    flowers.add(Rose("rose 1"))
    flowers.add(Rose("rose 2"))
  }
  val daisyGarden = Garden<Daisy>(daisyFlowerCare).apply {
    flowers.add(Daisy("daisy 1"))
    flowers.add(Daisy("daisy 2"))
    flowers.add(Daisy("daisy 3"))
  }

  roseGarden.pruneFlower(0)
  daisyGarden.pruneFlower(0)
  // can't reuse flowerCare
}

fun contravarianceTypeHandling() {
  class Garden<T : Flower>(val flowerCare: ContravarianceFlowerCare<T>) {

    val flowers = mutableListOf<T>()
    fun pruneFlower(i: Int) = flowerCare.prune(flowers[i])
  }

  val flowerCare = object : ContravarianceFlowerCare<Flower> {
    override fun prune(flower: Flower) {
      println("Pruning a flower: ${flower.name}")
    }
  }

  val roseGarden = Garden<Rose>(flowerCare).apply {
    flowers.add(Rose("rose 1"))
    flowers.add(Rose("rose 2"))
  }
  val daisyGarden = Garden<Daisy>(flowerCare).apply {
    flowers.add(Daisy("daisy 1"))
    flowers.add(Daisy("daisy 2"))
    flowers.add(Daisy("daisy 3"))
  }

  roseGarden.pruneFlower(0)
  daisyGarden.pruneFlower(0)
}