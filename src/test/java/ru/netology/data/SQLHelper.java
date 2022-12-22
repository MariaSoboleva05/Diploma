package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;

public class SQLHelper {

    @SneakyThrows
    public static String getCardPaymentStatusMySQL() {
        var runner = new QueryRunner();
        var status = "SELECT status FROM payment_entity ORDER BY id DESC LIMIT 1;";
        var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        return runner.query(conn, status, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCardPaymentStatusPostgresSQL() {
        var runner = new QueryRunner();
        var status = "SELECT status FROM payment_entity ORDER BY id DESC LIMIT 1;";
        var conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "pass");
        return runner.query(conn, status, new ScalarHandler<>());
    }


    @SneakyThrows
    public static String getCreditPaymentStatusMySQL() {
        var runner = new QueryRunner();
        var status = "SELECT status FROM credit_request_entity ORDER BY id DESC LIMIT 1;";
        var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        return runner.query(conn, status, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCreditPaymentStatusPostgresSQL() {
        var runner = new QueryRunner();
        var status = "SELECT status FROM credit_request_entity ORDER BY id DESC LIMIT 1;";
        var conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "pass");
        return runner.query(conn, status, new ScalarHandler<>());
    }


    @SneakyThrows
    public static void cleanTablesMySQL() {
        var runner = new QueryRunner();
        var cleanCredit = "DELETE FROM credit_request_entity;";
        var cleanOrder = "DELETE FROM order_entity;";
        var cleanPayment = "DELETE FROM payment_entity;";
        var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
        runner.update(conn, cleanCredit);
        runner.update(conn, cleanOrder);
        runner.update(conn, cleanPayment);
    }

    @SneakyThrows
    public static void cleanTablesPostgresSQL() {
        var runner = new QueryRunner();
        var cleanCredit = "DELETE FROM credit_request_entity;";
        var cleanOrder = "DELETE FROM order_entity;";
        var cleanPayment = "DELETE FROM payment_entity;";
        var conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "pass");
        runner.update(conn, cleanCredit);
        runner.update(conn, cleanOrder);
        runner.update(conn, cleanPayment);
    }
}


