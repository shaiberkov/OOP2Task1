package traits;

public interface HomeDevice {
    default void HomeOn() {
        System.out.println("light home on");
    }
}