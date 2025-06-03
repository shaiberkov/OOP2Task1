package devices;

import traits.KitchenDevice;
import traits.TemperatureControl;

public class Frige extends ElectronicDevice implements KitchenDevice, TemperatureControl {

    public String getName() {
        return "Fridge";
    }

    public void operateFridge() {
        System.out.println(getName());
        switchOn();
        controlTemperature();
    }
}