import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class SimpleAuthenticationSystem {
    private Map<String, User> userDatabase;
    private User loggedInUser;

    public SimpleAuthenticationSystem() {
        userDatabase = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        if (!userDatabase.containsKey(username)) {
            userDatabase.put(username, new User(username, password));
            System.out.println("Registration successful.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    public void loginUser(String username, String password) {
        if (userDatabase.containsKey(username)) {
            User user = userDatabase.get(username);
            if (user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println("Login successful.");
            } else {
                System.out.println("Incorrect password.");
            }
        } else {
            System.out.println("Username not found.");
        }
    }

    public void accessSecuredPage() {
        if (loggedInUser != null) {
            System.out.println("Welcome to the secured page, " + loggedInUser.getUsername() + "!");
        } else {
            System.out.println("You need to login first.");
        }
    }

    public static void main(String[] args) {
        SimpleAuthenticationSystem authSystem = new SimpleAuthenticationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register   2. Login   3. Access Secured Page   4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String regPassword = scanner.nextLine();
                    authSystem.registerUser(regUsername, regPassword);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    authSystem.loginUser(loginUsername, loginPassword);
                    break;
                case 3:
                    authSystem.accessSecuredPage();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

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

    public String getPassword() {
        return password;
    }
}
