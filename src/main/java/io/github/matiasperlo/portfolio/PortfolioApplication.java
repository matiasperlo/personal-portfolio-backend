package io.github.matiasperlo.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
                
                String url = "jdbc:mysql://localhost:3306/ap_portfolio";
                String username = "arg_programa_api";
                String password = "uZua6V1iEA.p3pjs";

                System.out.println("Connecting database...");

                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    System.out.println("Database connected!");
                } catch (SQLException e) {
                    throw new IllegalStateException("Cannot connect the database!", e);

                }
        }

}
