package Services;

import DataBase.*;

import static DataBase.EmailAccounts.emails;

public class Unread {
    public static void unread(User user){
        //shu userga kelgan emlarni ko'rssatadi
        int emailCount=0;
        int indexEmail=0;
        for (Email email : emails) {
            if (email!=null){
                if (email.getReceiver().equals(user)
                        && email.isStatuts()) {
                    indexEmail=email.getMessageId();
                    System.out.println("--------------------------------------");
                    System.out.println(indexEmail);
                    System.out.println("Sender: "+email.getSender().getEmail());
                    System.out.println("Title: "+email.getTitle());
                    System.out.println("Message: "+email.getBody());
                    System.out.println();
                    email.setStatuts(false);
                    emailCount++;
                }
            }
        }
    }
}
