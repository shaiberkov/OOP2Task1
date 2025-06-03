package org.example.QuestionOne;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PropertyQueryHandler implements QueryHandler {
    @Override
    public boolean canHandle(String query) {
        return getEnglishPropertyFromQuery(query) != null;
    }

    @Override
    public String handle(Object obj, String query) {
        String property = getEnglishPropertyFromQuery(query);
        if (property != null) {
            boolean hasProperty = hasProperty(obj, property);
            return hasProperty ? "כן" : "לא";
        }
        return "לא ניתן להבין את השאלה.";
    }
    private static boolean dfs(Class<?> clazz, String propertyName, Set<Class<?>> visited) {
        if (visited.contains(clazz)) {
            return false;
        }
        visited.add(clazz);

        for (Field field : clazz.getDeclaredFields()) {
            if (field.getName().equals(propertyName)) {
                return true;
            }
        }

        Class<?> superClass = clazz.getSuperclass();
        return superClass != null && dfs(superClass, propertyName, visited);
    }

    private  Map<String, String> hebrewToEnglishMapOfProperties = Map.ofEntries(
            Map.entry("לצמוח", "canGrow"),
            Map.entry("חי", "isLiving"),
            Map.entry("לזוז", "canMove"),
            Map.entry("עור", "hasSkin"),
            Map.entry("קשקשים", "hasScales"),
            Map.entry("לשחות", "canSwim"),
            Map.entry("זימים", "hasGills"),
            Map.entry("נוצות", "hasFeathers"),
            Map.entry("לעוף", "canFly"),
            Map.entry("כנפיים", "hasWings"),
            Map.entry("עלים", "hasLeaves"),
            Map.entry("שורשים", "hasRoots"),
            Map.entry("קליפה", "hasBark"),
            Map.entry("ענפים", "hasBranches"),
            Map.entry("אדום", "isRed"),
            Map.entry("צהוב", "isYellow"),
            Map.entry("לשיר", "canSing"),
            Map.entry("ירוק", "isGreen"),
            Map.entry("גדול", "isBig")
    );
    public  String getEnglishPropertyFromQuery(String query) {
        for (String hebrewProperty : hebrewToEnglishMapOfProperties.keySet()) {
            if (query.contains(hebrewProperty)) {
                return hebrewToEnglishMapOfProperties.get(hebrewProperty);
            }
        }
        return null;
    }

    public static boolean hasProperty(Object obj, String propertyName) {
        return dfs(obj.getClass(), propertyName, new HashSet<>());
    }

}
