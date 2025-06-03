package devices;

import traits.Audio;
import traits.Display;
import traits.HomeDevice;

public class Speaker extends ElectronicDevice implements HomeDevice, Audio, Display {
    @Override
    public String getName() {
        return "Speaker";
    }

    public void operateSpeaker() {
        System.out.println(getName());
        switchOn();
        controlVolume();
    }
}