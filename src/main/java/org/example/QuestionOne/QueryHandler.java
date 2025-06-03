package org.example.QuestionOne;

    public interface QueryHandler {
        boolean canHandle(String query);
        String handle(Object obj, String query);
    }

