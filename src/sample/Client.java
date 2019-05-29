package sample;

import javafx.application.Application;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import sample.view.ChatView;
import sample.view.Controller;
import sample.view.Message;

import java.net.URL;
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
            new Thread(() -> {
                Vector<Object> params = new Vector<>();
                while (true) {
                    try {
                        Thread.sleep(1000);
                        if (!Controller.messageStack.isEmpty()) {
                            Message msg = Controller.messageStack.pop();
                            params.add(msg.toString());
                            client.execute("Chat.writeToFile", params);
                            params.clear();
                        }
                    } catch (InterruptedException | XmlRpcException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(()-> {
                Vector<Object> params = new Vector<>();
                params.add(Controller.userID);
                String string;
                while(true){
                    try{
                        Thread.sleep(1000);
                        string = (String) client.execute("Chat.readFromMap", params);
                        if(!string.isEmpty()){
                            System.out.println("test");
                            System.out.println(string);
                        }

                    }catch (InterruptedException | XmlRpcException e){
                        e.printStackTrace();
                    }
                }
            }).start();

            Application.launch(ChatView.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
