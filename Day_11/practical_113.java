package Day_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}

class LoginService {
    private List<User> users;

    public LoginService() {
        users = new ArrayList<>();
        
        users.add(new User("admin", "admin123"));
    }

    public boolean registerUser(String username, String password) {
        
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
        }
        users.add(new User(username, password));
        return true;
    }

    public boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user.checkPassword(password);
            }
        }
        return false;
    }
}

public class practical_113 {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Welcome to the OOP Login System ===");

        while (running) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter new username: ");
                    String regUser = scanner.nextLine().trim();
                    System.out.print("Enter new password: ");
                    String regPass = scanner.nextLine().trim();
                    
                    if (regUser.isEmpty() || regPass.isEmpty()) {
                        System.out.println("Username and Password cannot be empty!");
                    } else if (loginService.registerUser(regUser, regPass)) {
                        System.out.println("Registration successful! You can now log in.");
                    } else {
                        System.out.println("Registration failed! Username already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String loginUser = scanner.nextLine().trim();
                    System.out.print("Enter password: ");
                    String loginPass = scanner.nextLine().trim();
                    
                    if (loginService.loginUser(loginUser, loginPass)) {
                        System.out.println("Login Successful! Welcome, " + loginUser + ".");
                    } else {
                        System.out.println("Login Failed! Incorrect username or password.");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the Login System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please choose 1, 2, or 3.");
            }
        }
        scanner.close();
    }
}
