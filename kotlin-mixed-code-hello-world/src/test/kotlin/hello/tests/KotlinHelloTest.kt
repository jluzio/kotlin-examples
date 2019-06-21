package hello.tests

import org.junit.Test

class KotlinHelloTest {

    @Test
    fun test() {
        println(hello.foobar())
        println(hello.JavaHello.foobar())
    }
}