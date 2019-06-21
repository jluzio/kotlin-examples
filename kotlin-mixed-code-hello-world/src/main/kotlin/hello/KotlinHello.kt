package hello

val KotlinHelloString : String = "Hello from Kotlin!"

fun getHelloStringFromJava() : String {
    return JavaHello.JavaHelloString!!;
}

fun foobar() : String {
    return "foobar-kotlin";
}

