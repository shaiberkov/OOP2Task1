package org.example.QuestionOne;

import java.util.Map;

public class EntityQueryHandler implements QueryHandler {
    @Override
    public boolean canHandle(String query) {
        return extractTargetTypeFromQuery(query) != null;
    }

    @Override
    public String handle(Object obj, String query) {
        String type = extractTargetTypeFromQuery(query);
        if (type != null) {
            try {
                Class<?> targetClass = Class.forName("org.example." + type);
                boolean result = isInstanceOf(obj, targetClass);
                return result ? "כן" : "לא";
            } catch (ClassNotFoundException e) {
                return "לא ניתן למצוא את המחלקה " + type;
            }
        }
        return "לא ניתן להבין את השאלה.";
    }
    public boolean isInstanceOf(Object obj, Class<?> clazz) {
        return isInstanceOfRecursive(obj.getClass(), clazz);
    }

    private boolean isInstanceOfRecursive(Class<?> clazz, Class<?> targetClass) {
        if (clazz.equals(targetClass)) {
            return true;
        }
        Class<?> superClass = clazz.getSuperclass();
        return superClass != null && isInstanceOfRecursive(superClass, targetClass);
    }
    public String extractTargetTypeFromQuery(String query) {
        for (String hebrewKey : hebrewToEnglishMapOfEntities.keySet()) {
            if (query.contains(hebrewKey)) {
                return hebrewToEnglishMapOfEntities.get(hebrewKey);
            }
        }
        return null;
    }
    private Map<String, String> hebrewToEnglishMapOfEntities = Map.ofEntries(
            Map.entry("אורן", "Oak"),
            Map.entry("אלון", "Pine"),
            Map.entry("ורד", "Rose"),
            Map.entry("מרגנית", "Daisy"),
            Map.entry("קנרית", "Canary"),
            Map.entry("אדום החזה", "Robin"),
            Map.entry("סלמון", "Salmon"),
            Map.entry("דג השמש", "Sunfish"),
            Map.entry("בעל חיים", "Animal"),
            Map.entry("צמח", "Plant"),
            Map.entry("ציפור", "Bird"),
            Map.entry("עץ","Tree"),
            Map.entry("פרח", "Flower")

    );
}