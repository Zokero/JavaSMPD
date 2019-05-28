package sample;

import javafx.application.Application;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

import java.net.URL;
import java.util.UUID;
import java.util.Vector;

public class Client {

    public static void main(String[] args) {
        try {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://localhost:8080/"));
            config.setEnabledForExtensions(true);

            XmlRpcClient client = new XmlRpcClient();
            client.setTransportFactory(
                    new XmlRpcCommonsTransportFactory(client));
            client.setConfig(config);
            String userID = UUID.randomUUID().toString().substring(0, 8);
            Vector<Object> params = new Vector<>();
            params.add(userID);
            System.out.println("Client " + userID);
            client.execute("Chat.addUser", params);
            params.clear();
            client.execute("Chat.readMessage", params);
            client.execute("Chat.sendMessage", params);
            Application.launch(ChatView.class, args);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
