package jdbc_project;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter 1: Login");
			System.out.println("Enter 2: Register");
			System.out.println("Enter 0: out of app");
			int index = scanner.nextInt();
			scanner.nextLine();
			switch(index) {
				case 1: {
					System.out.println("Enter your username:");
					String username = scanner.nextLine();
					System.out.println("Enter your password:");
					String password = scanner.nextLine();
					UserLogin user = new UserLogin();
					user.login(username, password);
					if(user.isResult()) {
						System.out.println("App is running");
						while(true) {
							if(index == 3) {
								break;
							}
							System.out.println("Enter 3: to logout");
							System.out.println("Enter 4: to change password");
							index = scanner.nextInt();
							scanner.nextLine();
							switch(index) {
								case 3:{
									break;
								}
								case 4:{
									System.out.println("You are changing password has username is: "+ username);
									System.out.println("Enter your new password: ");
									String newpassword = scanner.nextLine();
									ChangePassword CP = new ChangePassword();
									CP.passwordChange(username, newpassword);
									break;
								}
							}
						}
					}
					break;
				}
				case 2:{
					System.out.println("Enter your username:");
					String username = scanner.nextLine();
					System.out.println("Enter your password:");
					String password = scanner.nextLine();
					UserRegister user = new UserRegister();
					user.Register(username, password);
					break;
				}
				case 0:{
					System.out.println("Thank you");
					return;
				}
			}
		}
	}
}
