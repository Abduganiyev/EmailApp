package Services;

import DataBase.*;

import java.util.Scanner;

import static DataBase.EmailAccounts.emails;

public class DeleteEmail {
    static Scanner scanner;
    public static void deleteEmail(){
        //emailni ochiradi
        scanner=new Scanner(System.in);
        System.out.println("Choice index message:");
        int index = scanner.nextInt();
        emails[index]=null;
    }
}
