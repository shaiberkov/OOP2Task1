package devices;

import traits.HomeDevice;
import traits.Speed;

public class ElectricMotor extends FrequencyDevice implements HomeDevice, Speed {
    @Override
    public String getName() {
        return "Electric Motor";
    }

    public void operateMotor() {
        System.out.println(getName());
        switchOn();
        controlSpeed();
    }
}