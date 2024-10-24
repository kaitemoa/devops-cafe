package CafeProject.cafe.project;
import java.util.Scanner;

public class Login {
    public String username = "Spiderman";
    public String password = "123";

    public boolean login(String userInput, String passInput) {
        if (this.username.equals(userInput) && this.password.equals(passInput)) {
            return true; 
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String user = in.nextLine();
        System.out.print("Enter your password: ");
        String pass = in.nextLine();
        
        Login login = new Login();
        if (login.login(user, pass)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
        in.close();
    }
}
