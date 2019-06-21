package hello;

public class JavaHello {
  public static String JavaHelloString = "Hello from Java!";

  public static String getHelloStringFromKotlin() {
    return KotlinHelloKt.getKotlinHelloString();
  }

  public static String foobar() {
    return "foobar-java";
  }

  public static void main(String[] args) {
    System.out.println(getHelloStringFromKotlin());
    System.out.println(KotlinHelloKt.getHelloStringFromJava());
  }
}
