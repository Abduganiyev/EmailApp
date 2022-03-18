package Services;

import DataBase.*;

import java.util.Scanner;

import static DataBase.UserAccounts.users;

public class SingOn {
    static Scanner scanner;
    public static Integer index=0;
    public static void singOn(User adduser){
        //userni UserAccounts ga qo'shadi
        users[index++] = adduser;
        System.out.println("Succesfuly registered!");
    }
}
