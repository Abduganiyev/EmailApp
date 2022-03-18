package Services;

import DataBase.*;

import java.util.Scanner;

import static DataBase.EmailAccounts.emails;

public class Inbox {
    static Scanner scanner;
    public static void inBox(User user){
        scanner=new Scanner(System.in);
        //shu userga kelgan emaillarni ko'rsatadi
        int emailCount=0;
        int indexEmail;
        for (Email email : emails) {
            if (email!=null){
                if (email.getReceiver().equals(user)
                        && !email.isStatuts()) {
                    indexEmail=email.getMessageId();
                    System.out.println("--------------------------------------");
                    System.out.println(indexEmail);
                    System.out.println("Sender: "+email.getSender().getEmail());
                    System.out.println("Title: "+email.getTitle());
                    System.out.println("Message: "+email.getBody());
                    System.out.println();
                    emailCount++;
                }
            }
        }
        if (emailCount>0) {
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
