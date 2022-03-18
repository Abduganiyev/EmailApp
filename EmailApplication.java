import java.util.Scanner;


public class EmailApplication {
    public static Scanner scanner;
    public static User[] users;
    public static Email[] emails;
    public static Integer index=0;
    public static Integer emailindex=13;
    public static User onlineUser;
    public static void main(String[] args) {

        users=new User[10000];
        emails=new Email[10000];
        users[index++]=new User("tohir","sobirov","tohir@mail.ru","123");
        users[index++]=new User("sobir","sobirov","sobir@mail.ru","123");
        users[index++]=new User("qobil","sobirov","qobil@mail.ru","123");
        emails[emailindex++]=new Email("Test1","Test_1",users[0],users[1],emailindex-1,false);
        emails[emailindex++]=new Email("Test2","Test_2",users[0],users[1],emailindex-1,true);
        emails[emailindex++]=new Email("Test3","Test_3",users[0],users[1],emailindex-1,true);

        while (true){
            showMainMenu();
            scanner =new Scanner(System.in);
            int choise=scanner.nextInt();
            switch (choise){
                case 1:
                    signIn();
                    break;
                case 2:
                    signOn();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void signIn() {
        scanner=new Scanner(System.in);

        System.out.println("Email: ");
        String email=scanner.next();

        for (User user : users) {
            if (user!=null){
                if (user.getEmail().equals(email))
                    onlineUser=user;
            }
        }
        boolean succes=false;
        if (onlineUser!=null){
            System.out.println("password: ");
            String password=scanner.next();

            if (onlineUser
                    .getPassword()
                    .equals(password))
                succes=true;
        }

        if (succes) {
            System.out.println("Welcome to Gamil!");
            showEmailMenu();
        }

    }

    private static void showEmailMenu() {
        scanner=new Scanner(System.in);

        System.out.println("1. Send Message");
        System.out.println("2. Unread");
        System.out.println("3. Inbox");
        System.out.println("4. Outbox");
        System.out.println("0. Sing out");

        int choice=scanner.nextInt();
        switch (choice) {
            case 1:
                sendMessage();
                break;

            case 2:
                unread();
                break;

            case 3:
                inbox();
                break;

            case 4:
                outbox();
                break;

            case 0:
                break;
        }
    }

    private static void outbox() {
        int indexEmail=0;
        for (Email email : emails) {
            if (email!=null)
                if (email.getSender().equals(onlineUser)) {
                    indexEmail = email.getMessageId();
                    System.out.println("--------------------------------------");
                    System.out.println(indexEmail);
                    System.out.println("To: " + email.getReceiver().getEmail());
                    System.out.println("Title: " + email.getTitle());
                    System.out.println("Message: " + email.getBody());
                }
        }
        if (indexEmail!=0) {
            System.out.println("1.DELETE");
            System.out.println("0.Exite");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    deleteMessage();
                    break;
                case 0:
                    break;
            }
        }
    }

    private static void inbox() {
        scanner=new Scanner(System.in);
        int indexEmail=0;
        for (Email email : emails) {
            if (email!=null){
                if (email.getReceiver().equals(onlineUser)
                        && !email.isStatuts()) {
                    indexEmail=email.getMessageId();
                    System.out.println("--------------------------------------");
                    System.out.println(indexEmail);
                    System.out.println("Sender: "+email.getSender().getEmail());
                    System.out.println("Title: "+email.getTitle());
                    System.out.println("Message: "+email.getBody());
                }
            }
        }
        if (indexEmail!=0) {
            System.out.println("1.DELETE");
            System.out.println("0.Exite");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    deleteMessage();
                    break;
                case 0:
                    break;
            }
        }
    }

    private static void deleteMessage() {
        scanner=new Scanner(System.in);
        System.out.println("Choice index message:");
        int index = scanner.nextInt();
        emails[index]=null;
        System.out.println("Succesfuly deleted!\n");
    }

    private static void unread() {
        int indexEmail=0;
        for (Email email : emails) {
            if (email!=null){
                indexEmail=email.getMessageId();
                if (email.getReceiver().equals(onlineUser) && email.isStatuts()) {
                    System.out.println("--------------------------------------");
                    System.out.println(indexEmail);
                    System.out.println("Sender: "+email.getSender().getEmail());
                    System.out.println("Title: "+email.getTitle());
                    System.out.println("Message: "+email.getBody());
                    System.out.println();
                    email.setStatuts(false);
                }
            }
        }
    }

    private static void sendMessage() {

        System.out.println("===========Email Adresses=============");
        for (User user : users) {
            if (user!=null){
                if (!user.equals(onlineUser)) {
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

        emails[emailindex++]=new Email(subject,message,onlineUser,receiver,emailindex-1,true);
        System.out.println("Succesfuly sent!\n");
    }

    private static void signOn() {
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
        users[index++] = user;
        System.out.println("Succesfuly registered!");
    }

    private static void showMainMenu() {
        System.out.println("Main menu");
        System.out.println("1. Sign In"); //loging
        System.out.println("2. Sign On"); //registring
        System.out.println("0. Exite");
    }


}
