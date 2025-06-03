package traits;

public interface KitchenDevice {
    default void kitchenOn() {
        System.out.println(" put Kitchen Device On");
    }
}