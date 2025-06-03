package traits;

public interface LivingRoomDevice {
    default void LivingRoomOn() {
        System.out.println("Living Room On ---->");
    }
}