package traits;

public interface Display {
    default void changeResolution() {
        System.out.println("Change color");
    }
}