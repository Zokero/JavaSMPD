package sample;

import javafx.application.Application;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import sample.view.ChatView;
import sample.view.Controller;

import java.net.URL;
import java.util.Vector;

public class Client {
    public static XmlRpcClient client;
    public static String xxxx;

    public static void main(String[] args) {
        try {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://localhost:8080/"));
            config.setEnabledForExtensions(true);
            client = new XmlRpcClient();
            client.setTransportFactory(
                    new XmlRpcCommonsTransportFactory(client));
            client.setConfig(config);
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(3000);
                        getFromServer(Controller.userID);
                    } catch (InterruptedException | NullPointerException e) {
                        e.printStackTrace();
                    }

                }
            }).start();

            Application.launch(ChatView.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getFromServer(String string){
        Vector<Object> params = new Vector<>();
        String recievedMessage = "";
        try {
            params.add(string + "\n");
            recievedMessage = (String)client.execute("Chat.readFromMap", params);
            xxxx = recievedMessage;
//            Controller.printOnTextArea();
            System.out.println(recievedMessage);
            params.clear();
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return recievedMessage;
    }

    public static void sendToServer(String string) {
        Vector<Object> params = new Vector<>();
        try {
            params.add(string);
            client.execute("Chat.writeToFile", params);
            params.clear();
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
    }
}
