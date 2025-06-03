package remote;

import devices.*;
import traits.*;

import java.util.List;

public class SmartRemote {

    public void operateAll(List<Object> devices) {
        System.out.println("🔹 הפעלת כל המכשירים:");
        int index = 1;

        for (Object device : devices) {
            String deviceName = device.getClass().getSimpleName();
            System.out.print(index++ + ". " + deviceName + " -> ");

            switch (device) {
                case Television tv       -> { tv.operateTelevision(); System.out.println("Television is now ON"); }
                case Radio r             -> { r.operateRadio(); System.out.println("Radio is playing"); }
                case Speaker s           -> { s.operateSpeaker(); System.out.println("Speaker is active"); }
                case ElectricMotor e     -> { e.operateMotor(); System.out.println("Electric Motor is running"); }
                case MechanicalMotor m   -> { m.operateMotor(); System.out.println("Mechanical Motor is spinning"); }
                case Frige f             -> { f.operateFridge(); System.out.println("Fridge is cooling"); }
                case Oven o              -> { o.operateOven(); System.out.println("Oven is heating"); }
                default -> System.out.println("❌ Unknown device: " + deviceName);
            }
        }
    }

    public void operateByCategory(List<Object> devices, String category) {
        System.out.println("🔹 הפעלה לפי קטגוריה: " + category.toUpperCase());
        int index = 1;

        for (Object device : devices) {
            String deviceName = device.getClass().getSimpleName();

            boolean matched = switch (category) {
                case "HomeDevice"       -> device instanceof HomeDevice;
                case "KitchenDevice"    -> device instanceof KitchenDevice;
                case "LivingRoomDevice" -> device instanceof LivingRoomDevice;
                case "audio"            -> device instanceof Audio;
                case "temperature"      -> device instanceof TemperatureControl;
                case "speed"            -> device instanceof Speed;
                default -> false;
            };

            if (!matched) continue;

            System.out.print(index++ + ". " + deviceName + " -> ");

            switch (device) {
                case HomeDevice h when category.equals("HomeDevice") -> {
                    h.HomeOn();
                    System.out.println("Home device is now ON");
                }
                case KitchenDevice k when category.equals("KitchenDevice") -> {
                    k.kitchenOn();
                    System.out.println("Kitchen device is now ON");
                }
                case LivingRoomDevice l when category.equals("LivingRoomDevice") -> {
                    l.LivingRoomOn();
                    System.out.println("Living room device is now ON");
                }
                case Audio a when category.equals("audio") -> {
                    a.controlVolume();
                    System.out.println("Volume adjusted");
                }
                case TemperatureControl t when category.equals("temperature") -> {
                    t.controlTemperature();
                    System.out.println("Temperature adjusted");
                }
                case Speed s when category.equals("speed") -> {
                    s.controlSpeed();
                    System.out.println("Speed adjusted");
                }
                default -> System.out.println("❌ No action for device: " + deviceName);
            }
        }
    }
}
