# Kotlin
https://kotlinlang.org/
https://kotlinlang.org/docs/home.html

## coroutines
https://kotlinlang.org/docs/coroutines-guide.html

## serialization
https://kotlinlang.org/docs/serialization.html

## kotlinx-html
https://github.com/Kotlin/kotlinx.html

## testing
https://kotlinlang.org/docs/jvm-test-using-junit.html

https://strikt.io

https://kotest.io
https://kotest.io/docs/assertions/matchers/

## Using Maven
https://kotlinlang.org/docs/reference/using-maven.html
- Examples
https://github.com/JetBrains/kotlin-examples
https://github.com/JetBrains/kotlin-examples/archive/master/maven.zip

## Eclipse Plugin
Marketplace or update site
https://dl.bintray.com/jetbrains/kotlin/eclipse-plugin/last/
- Last working@2020-03-25
https://dl.bintray.com/jetbrains/kotlin/eclipse-plugin/0.8.19/

-- To Read --
Courses:
https://codelabs.developers.google.com/kotlin-bootcamp/
https://codelabs.developers.google.com/android-kotlin-fundamentals/

Kotlin: requires Maven 3.x

Kotlin Koans (Learning Kotlin):
https://play.kotlinlang.org/koans/overview
https://www.jetbrains.com/help/education/learner-start-guide.html

## Lombok
https://projectlombok.org
https://projectlombok.org/setup/maven
https://projectlombok.org/setup/gradle
https://projectlombok.org/setup/eclipse
https://projectlombok.org/setup/intellij

## Kotlin REPL
Kotlin REPL stands for Read- Eval- Print- Loop
Tools -> Kotlin -> Kotlin REPL
NOTE: REPL includes all module classes

## Kotlin Compiler Plugins
https://kotlinlang.org/docs/reference/compiler-plugins.html

## Generics (covariance/contravariance)
https://kotlinlang.org/docs/reference/generics.html
--- Covariance ---
- Generic<Subtype> can be assigned to Generic<Supertype>
- keyword: out
- example: List<String> can be assigned to List<Object> (needs List define T as covariant)
- example Java:
List<String> sValues = null;
List<? extends Object> oValues = sValues;

--- Contravariance ---
- Generic<Supertype> can be assigned to Generic<Subtype>
- keyword: in
- example: Comparator<Object> can be assigned to Comparator<String> (needs Comparator define T as contravariant)
- example Java:
Comparator<Object> cObj = null;
Comparator<? super String> cStr = cObj;

-- Declarative Variance --
When using on class there are some restrictions:
-- Covariance --
- keyword: out
- when type is used on public methods, it can only be on out position (return)
-- Contravariance --
- keyword: in
- when type is used on public methods, it can only be on in position (parameters)


## Known issues
- Compile-time constants not correctly recognized by IntelliJ IDE (but compiles fine)
https://youtrack.jetbrains.com/issue/KT-34081
- Eclipse Kotlin Plugin
 > 'Kotlin Analysis: lateinit property trace has not been initialized
 Interface defined in KT generates this error if used in Java class as a parameter on a method for ex
