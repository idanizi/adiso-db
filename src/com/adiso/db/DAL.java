package com.adiso.db;

import java.lang.*;
import java.sql.*;

/**
 * This is Data Access Layer
 * using JDBC to connect to Azure Cloud Data Base (SQL)
 */
public class DAL {

    //region Fields

    //  Database credentials
    private static final String USER = "adiso";
    private static final String PASS = "!QA2ws3ed";

    private Connection connection;
    //endregion

    private void init() {

        // Connect to database
        String hostName = "adiso-db.database.windows.net";
        String dbName = "adiso.questions.db";
        String user = USER;
        String password = PASS;
        String url = String.format(
                "jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;" +
                        "hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                hostName, dbName, user, password
        );

        this.connection = null;

        try {
            this.connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);
            System.out.println("=========================================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //region Singleton

    private static final DAL instance = new DAL();

    private DAL() {
        // singleton
        init();
    }

    public static DAL getInstance() {
        return instance;
    }

    //endregion

    //region Methods

    /**
     * example of usage
     */
    public void example() {
        System.out.println("Query data example:");
        System.out.println("=========================================");

        // Create and execute a SELECT SQL statement.
        String selectSql;
        selectSql = "SELECT TOP 10 * FROM [questions] AS q JOIN [choices] AS c\n" +
                "ON q.[ANSWER_ID] = c.[ID]";

        try (
                // resources for this try-with-resource (Java-8)
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectSql)
        ) {

            // Print results from select statement
            System.out.println("output:");
            while (resultSet.next()) {
                String str = "";

                // loop for all columns
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    str += resultSet.getString(i);

                    // if not last -> add space
                    if (i < resultSet.getMetaData().getColumnCount()) {
                        str += " ";
                    }
                }

                System.out.println(str);

            } // while

            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * adds new question to the data base
     *
     * @param text the question text
     * @return question ID
     */
    public int addQuestion(String text) {
        //todo
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * adds new choice to existing question in the data base
     *
     * @param questionId
     * @param text       the choice text
     * @return Choice ID
     * @apiNote do nothing case not found
     */
    public int addNewChoiceToQuestion(int questionId, String text) {
        //todo
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * set a question answer by given choice
     *
     * @param questionId
     * @param choiceId
     * @apiNote do nothing case not found
     */
    public void setQuestionAnswer(int questionId, int choiceId) {
        //todo
        throw new UnsupportedOperationException("not implemented yet");
    }
    //endregion

}
