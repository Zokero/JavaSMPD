package sample;

import javafx.application.Application;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

import java.net.URL;

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

//            Object[] params = new Object[]{};
//            Integer result = (Integer) client.execute("ChatView.start", params);
            Application.launch(ChatView.class,args);
            //System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
