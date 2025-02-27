package campaignGUI.data;

import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.HashMap;
import java.util.Map;

public class AuthManager
{
    private static final Map<String, String> users = new HashMap<>();

    static {
        // DataBase
        users.put("admin", "123");
        users.put("guest", "guest");
        users.put("","");
    }

    public static boolean isUserValid(String userName, String password)
    {
        return users.containsKey(userName) && users.get(userName).equals(password);
    }
}
