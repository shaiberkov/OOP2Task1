package traits;

public interface Audio {
    default void controlVolume() {
        System.out.println("Control Volume");
    }
}