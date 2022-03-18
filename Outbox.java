package Services;

import DataBase.*;

import java.util.Scanner;

import static DataBase.EmailAccounts.emails;

public class Outbox {
    static Scanner scanner;
    public static void outBox(User user){
        scanner=new Scanner(System.in);
        //shu user yuborgan emaillarni ko'rsatadi
        int countEmail=0;
        int indexEmail=0;
        for (Email email : emails) {
            if (email!=null)
                if (email.getSender().equals(user)) {
                    indexEmail = email.getMessageId();
                    System.out.println("--------------------------------------");
                    System.out.println(indexEmail);
                    System.out.println("To: " + email.getReceiver().getEmail());
                    System.out.println("Title: " + email.getTitle());
                    System.out.println("others.Message: " + email.getBody());
                    countEmail++;
                }
        }
        if (countEmail>0) {
            System.out.println("1.DELETE");
            System.out.println("0.Exite");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    DeleteEmail.deleteEmail();
                    break;
                case 0:
                    break;
            }
        }
    }
}
