package listener;

import domain.ItemManager;
import domain.Verzameling;
import domain.VerzamelingManager;
import security.SecurityManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Server started");
        SecurityManager.getInstance().addUser("Tim", "test", "test", "eigenaar");
        SecurityManager.getInstance().addUser("Test","test2", "test","admin");
        VerzamelingManager.getInstance().addVerzameling("Verzameling1");
//        ItemManager.getInstance().addItem(null,"test","test",1);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Shutdown received");
    }
}

