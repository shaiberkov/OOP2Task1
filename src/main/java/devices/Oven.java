package devices;

import traits.KitchenDevice;
import traits.TemperatureControl;

public class Oven extends ElectronicDevice implements KitchenDevice, TemperatureControl {
    @Override
    public String getName() {
        return "Oven";
    }

    public void operateOven() {
        System.out.println(getName());
        switchOn();
        controlTemperature();
    }
}