package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;

public class SQLHelper {
    private static QueryRunner runner;

    @SneakyThrows
    public static String getCardPaymentStatus() {
        var runner = new QueryRunner();
        var status = "SELECT status FROM payment_entity;";

        try (
                var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");

        ) {
            return runner.query(conn, status, new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public static String getCreditPaymentStatus() {
        var runner = new QueryRunner();
        var status = "SELECT status FROM credit_request_entity;";

        try (
                var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");

        ) {
            return runner.query(conn, status, new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public static void cleanTables() {
        var runner = new QueryRunner();
        String cleanCredit = "DELETE FROM credit_request_entity;";
        String cleanOrder = "DELETE FROM order_entity;";
        String cleanPayment = "DELETE FROM payment_entity;";

        try (
                var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");

        ) {
            runner.update(conn, cleanCredit);
            runner.update(conn, cleanOrder);
            runner.update(conn, cleanPayment);
        }
    }

}
