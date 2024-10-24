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
            System.out.println("Contact information (press 1)");

            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();  

            if (input == 1) {
                ContactUs contact = new ContactUs();
                System.out.println(contact.getContactInfo());
            } else {
                System.out.println("Invalid option. Please press 1 to see contact info.");
            }
        } else {
            System.out.println("Invalid username or password.");
        }
        in.close();
    }
}
