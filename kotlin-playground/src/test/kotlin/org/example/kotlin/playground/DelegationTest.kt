package org.example.kotlin.playground

import org.junit.Test

class DelegationTest {
    interface SoundBehavior {                                                          // 1
        fun makeSound()
    }

    class ScreamBehavior(val n: String) : SoundBehavior {                                // 2
        override fun makeSound() = println("${n.toUpperCase()} !!!")
    }

    class RockAndRollBehavior(val n: String) : SoundBehavior {                           // 2
        override fun makeSound() = println("I'm The King of Rock 'N' Roll: $n")
    }

    interface JumpBehavior {
        fun jump()
    }

    class AirGuitarJumpBehavior: JumpBehavior {
        override fun jump() {
            println("Does a mean air guitar!!!")
        }
    }

    // Tom Araya is the "singer" of Slayer
    class TomAraya(n: String) : SoundBehavior by ScreamBehavior(n), JumpBehavior by AirGuitarJumpBehavior()

    // You should know ;)
    class ElvisPresley(n: String) : SoundBehavior by RockAndRollBehavior(n)              // 3

    @Test
    fun delegation_test() {
        val tomAraya = TomAraya("Trash Metal")
        tomAraya.makeSound()                                                            // 4
        tomAraya.jump()
        val elvisPresley = ElvisPresley("Dancin' to the Jailhouse Rock.")
        elvisPresley.makeSound()
    }
}