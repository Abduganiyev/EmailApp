package Services;

import DataBase.*;

import java.util.Scanner;

import static DataBase.UserAccounts.users;

public class SingIn {
    static Scanner scanner;
    public static User singIn(){
        //User ni UserAccount da bor/yo'q ligini tekshiradi
        //......
        scanner=new Scanner(System.in);
        User userIn = null;
        System.out.println("Email: ");
        String email=scanner.next();

        for (User user : users) {
            if (user!=null){
                if (user.getEmail().equals(email))
                    userIn=user;
            }
        }
        boolean succes=false;
        if (userIn!=null){
            System.out.println("password: ");
            String password=scanner.next();

            if (userIn
                    .getPassword()
                    .equals(password))
                succes=true;
        }

        if (succes)
            System.out.println("Welcome to Gamil!");
        return userIn;
    }
}
