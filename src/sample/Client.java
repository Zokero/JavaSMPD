package sample;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import sample.view.Message;

import java.net.URL;
import java.util.Vector;

public class Client {
    public static XmlRpcClient client;
    public static String receivedString;

    public Client() {
        try {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://localhost:8080/"));
            config.setEnabledForExtensions(true);
            client = new XmlRpcClient();
            client.setTransportFactory(
                    new XmlRpcCommonsTransportFactory(client));
            client.setConfig(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFromServer(String uuid) {
        Vector<Object> params = new Vector<>();
        String receivedStringFromServer = "";
        try {
            params.add(uuid);
            receivedStringFromServer = (String) client.execute("Chat.readFromMap", params);
            params.clear();
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return receivedStringFromServer;
    }

    public void sendToServer(Message message) {
        Vector<Object> params = new Vector<>();
        try {
            params.addElement(message.getTimestamp());
            params.addElement(message.getMessageText());
            params.addElement(message.getUuid());
            client.execute("Chat.writeToFile", params);
            params.clear();
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
    }
}
