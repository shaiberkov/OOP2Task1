
package org.example.QuestionOne;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final List<QueryHandler> handlers = List.of(
            new EntityQueryHandler(),
            new PropertyQueryHandler()
    );

    public static void main(String[] args) {
        while (true) {
            System.out.println("הזן שם של בעל חיים או צמח (למשל: 'קנרית', 'ורד'):");
            String objectName = scanner.nextLine().trim();

            Object obj = ObjectFactory.createObject(objectName);

            if (obj == null) {
                System.out.println("לא ניתן למצוא אובייקט עם השם: " + objectName);
                continue;
            }

            System.out.println("הזן שאלה לגבי האובייקט:");
            String query = scanner.nextLine();

            System.out.println(handleUserQuery(obj, query));
        }
    }


    public static String handleUserQuery(Object obj, String query) {
        for (QueryHandler handler : handlers) {
            if (handler.canHandle(query)) {
                return handler.handle(obj, query);
            }
        }
        return "לא ניתן להבין את השאלה.";
    }
}
