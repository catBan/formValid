package myanno;

/**
 * Created by catban on 16-12-11.
 */
public class ReflectTest {
    @Reflect()
    public static void hello1(final String name){
        System.out.println("I am "+name);
    }

    @Reflect(name = "jessie")
    public static void hello2(String name){
        System.out.println("I am "+name);
    }

    public static void main(String[] args) throws Exception {
        ReflecrProcessor reflecrProcessor = new ReflecrProcessor();
        reflecrProcessor.parseMethod(ReflectTest.class);
    }
}
