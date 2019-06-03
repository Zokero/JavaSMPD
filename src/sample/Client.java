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

                    getFromServer(Controller.userID);
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
            Thread.sleep(3000);
            params.add(string);
            recievedMessage = (String)client.execute("Chat.readFromMap", params);
            params.clear();
        } catch (XmlRpcException | InterruptedException e) {
            e.printStackTrace();
        }
        return recievedMessage;
    }

    public static void sendToServer(String string) {
        Vector<Object> params = new Vector<>();
        try {
            Thread.sleep(1000);
            params.add(string);
            client.execute("Chat.writeToFile", params);
            params.clear();
        } catch (XmlRpcException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
