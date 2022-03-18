package Services;

import DataBase.*;

import java.util.Scanner;

import static DataBase.EmailAccounts.emails;
import static DataBase.UserAccounts.users;

public class SendMessage {
    static Scanner scanner;
    static Integer index=0;
    public static void sendMessage(User sender){
        //emailni EmailAccounts ga qo'shadi
        System.out.println("===========Email Adresses=============");
        for (User user : users) {
            if (user!=null){
                if (!user.getEmail().equals(sender.getEmail())){
                    System.out.println(user.getEmail());
                }
            }
        }

        System.out.println("======================================");
        scanner=new Scanner(System.in);
        System.out.println("To: ");
        String receiverEmailAddress=scanner.next();
        User receiver = null;
        for (User user : users) {
            if (user!=null){
                if (user.getEmail().equals(receiverEmailAddress))
                    receiver=user;
            }
        }

        System.out.println("Subject: ");
        scanner=new Scanner(System.in);
        String subject=scanner.nextLine();
        System.out.println("Message: ");
        String message=scanner.nextLine();

        emails[index++]=new Email(subject,message,sender,receiver,index-1,true);
        System.out.println("Succesfuly sent!\n");
    }
}
