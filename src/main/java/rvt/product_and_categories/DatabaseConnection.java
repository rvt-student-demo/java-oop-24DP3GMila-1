package rvt.product_and_categories;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:sqlite:App.db";
    Scanner scanner = new Scanner(System.in);

    public DatabaseConnection() {
        this.scanner = scanner;
        new Category();
        new Product();
    }

    private Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL);
        try (PreparedStatement pstmt = conn.prepareStatement("PRAGMA foreign_keys = ON")) {
            pstmt.execute();
        }
        return conn;
    }

    public void addCategory() {
        System.out.print("Enter category name: ");
        String name = scanner.nextLine();

        String sql = "INSERT INTO categories(name) VALUES(?)";

        try (Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Category added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding category: " + e.getMessage());
        }
    }

    public void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter category ID: ");
        int categoryId = scanner.nextInt();
        scanner.nextLine();

        String sql = "INSERT INTO products(name, price, category_id) VALUES(?, ?, ?)";

        try (Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, categoryId);
            pstmt.executeUpdate();
            System.out.println("Product added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    public void showCategories() {
        String sql = "SELECT * FROM categories";

        try (Connection conn = connect();
            Statement stmt = conn.createStatement();) {
             var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching categories: " + e.getMessage());
        }
    }

    public void showProducts() {
        String sql = "SELECT * FROM products";

        try (Connection conn = connect();
            Statement stmt = conn.createStatement();) {
             var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Price: " + rs.getDouble("price") + ", Category ID: " + rs.getInt("category_id"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching products: " + e.getMessage());
        }
    }

    public void FindProductsByCategory() {
        System.out.print("Enter category ID to find products: ");
        int categoryId = scanner.nextInt();
        scanner.nextLine();

        String sql = "SELECT * FROM products WHERE category_id = ?";

        try (Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, categoryId);
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Price: " + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching products by category: " + e.getMessage());
        }
    }

    public void Exit() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }

}

