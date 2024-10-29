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
			boolean exit = false;

			while (!exit) {
				System.out.println("View menu (press 1)");
				System.out.println("Contact information (press 2)");
				System.out.println("Read reviews (press 3)");
				int input = in.nextInt();

				if (input == 1) {
					System.out.println("Coffees (press 1)");
					System.out.println("Baked goods (press 2)");
					int inputMenu = in.nextInt();

					if (inputMenu == 1) {
						Menu menu = new Menu();
						menu.Coffees();
						System.out.println("Go back by pressing 5");
						int inputEsc = in.nextInt();

						if (inputEsc == 5) {
							continue;
						}
					}
					else if (inputMenu == 2) {
						Menu menu = new Menu();
						menu.BakedGoods();
						System.out.println("Go back by pressing 5");
						int inputEsc = in.nextInt();

						if (inputEsc == 5) {
							continue;
						}
					}
				}
				else if (input == 2) {
					ContactUs contact = new ContactUs();
					System.out.println(contact.getContactInfo());
					System.out.println("Go back by pressing 5");
					int inputEsc = in.nextInt();

					if (inputEsc == 5) {
						continue;
					}
				}
				else if (input == 3) {
					Review review = new Review();
					review.Reviews();
					System.out.println("Go back by pressing 5");
					int inputEsc = in.nextInt();
					if (inputEsc == 5) {
						continue;
					}
				}
				else {
					System.out.println("Invalid input. Please try again.");
				}
			}
		} else {
			System.out.println("Invalid username or password.");
		}
		in.close();
	}
}