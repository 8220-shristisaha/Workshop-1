import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


interface User {
    void sender();
    void receiver();
}

class Message implements User{
    private String name;
    private String SenderSendingName;
    private String message;
    Scanner scanner= new Scanner(System.in);

    HashMap<String,HashMap<String,String>> senderHashMap = new HashMap<>();
    HashMap<String, String> receiverHashMap = new HashMap<>();

    @Override
    public void sender() {

        System.out.println("Enter you Name : ");
        name = scanner.nextLine();
        System.out.println("Whom you want to send message : ");
        SenderSendingName = scanner.nextLine();
        System.out.println("Write your message : ");
        message = scanner.nextLine();
        receiverHashMap.put(SenderSendingName, message);
        senderHashMap.put(name, receiverHashMap);

        receiver();

    }

    @Override
    public void receiver() {
        System.out.println("Message recieved at reciever end : ");
        for(Map.Entry<String,String>map: receiverHashMap.entrySet()){
            System.out.print("[ "+map.getKey() +" ] : "+map.getValue());
        }
    }
}
class Chat implements User{
    private String name;
    private String SenderSendingName;
    private String message;
    Scanner scanner= new Scanner(System.in);

    HashMap<String,HashMap<String,String>> senderHashMap = new HashMap<>();
    HashMap<String, String> receiverHashMap = new HashMap<>();
    @Override
    public void sender() {
        String ch="y";
        do{
            System.out.println("Enter you Name : ");
            name=scanner.nextLine();
            System.out.println("Whom you want to send message : ");
            SenderSendingName = scanner.nextLine();
            System.out.println("Write your message : ");
            message = scanner.nextLine();
            receiverHashMap.put(SenderSendingName, message);
            senderHashMap.put(name, receiverHashMap);
            System.out.println("\n\nDo you wish to send more messages to anyone you wish to (Y/N) ? ");
            ch=scanner.nextLine();
            ch=ch.toLowerCase();
        }while(ch.equals("y"));
        receiver();

    }

    @Override
    public void receiver() {
        System.out.println("Message recieved at reciever end : ");
        for(Map.Entry<String,HashMap<String,String>> s : senderHashMap.entrySet()){
            System.out.println("Messages send from [ "+s.getKey()+" ] : ");
            for(Map.Entry<String,String>map: s.getValue().entrySet()){
                System.out.print("[ "+map.getKey() +" ] : "+map.getValue());
                System.out.println();
            }
        }

    }
}

public class SimpleMessageSystem {
    public static void main(String[] args) {
        System.out.println(" :::::::::::::::::::::::::::\nWelcome to Chatting and Messaging in Intellij\n\n ");
        Scanner scanner = new Scanner(System.in);
        String choice="y";
        Message msg = new Message();
        Chat chat = new Chat();
        do{
            System.out.println("Enter you choice \n\t1.Messaging \n\t2.Chatting\n\n");
            String ch=scanner.nextLine();
            switch(ch){
                case "1" -> msg.sender();
                case "2" -> chat.sender();
                default -> System.out.println("Invald choice");
            }
            System.out.println("\n\nDo you wish to continue to send message or chat (Y/N)?");
            choice=scanner.nextLine();
            choice=choice.toLowerCase();
        }while(choice.equals("y"));


        System.out.println("                Thank You ");
    }

}
