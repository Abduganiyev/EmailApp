package DataBase;

import java.util.Scanner;

public class UserInfo {
    static Scanner scanner;
    public static User newUser(){
        scanner=new Scanner(System.in);
        User user=new User();

        System.out.println("Firstame: ");
        String firstname=scanner.next();

        System.out.println("Lastame: ");
        String lastname=scanner.next();

        System.out.println("Password: ");
        String password=scanner.next();

        while (true){
            System.out.println("Retype Password: ");
            String retype_password=scanner.next();
            if (password.equals(retype_password))
                break;
        }
        while (true) {
            System.out.println("Email Address {alex@gmail.com}: ");
            String email = scanner.next();
            boolean validateEmail = user.validateEmail(email);
            if (validateEmail) {
                user.setEmail(email);
                break;
            } else {
                System.out.println("Email not valid!");
            }

        }
        if (!firstname.isEmpty() && !lastname.isEmpty() && !password.isEmpty()) {
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setPassword(password);
        }
        return user;
    }
}
