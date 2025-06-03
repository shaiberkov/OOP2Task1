package org.example.QuestionOne;

public class ObjectFactory {
    public static Object createObject(String objectName) {
        switch (objectName.toLowerCase()) {
            case "אורן":
                return new Oak();
            case "אלון":
                return new Pine();
            case "ורד":
                return new Rose();
            case "מרגנית":
                return new Daisy();
            case "קנרית":
                return new Canary();
            case "אדום החזה":
                return new Robin();
            case "סלמון":
                return new Salmon();
            case "דג השמש":
                return new Sunfish();
            default:
                return null;
        }
    }
}
