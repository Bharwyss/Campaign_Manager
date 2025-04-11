package campaignGUI.data;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class AuthManager // Class to hold data for accessing the application
{
    private static final Map<String, String> users = new HashMap<>();
    static {
        // DataBase
        // Passwords are on clear for purpose. I can put the encrypted password,
        // but it won't be able to be tested from exterior. I may create a vault later
        try {
            users.put("admin", hashPassword("123"));
            users.put("guest", hashPassword("guest"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isUserValid(String userName, String password)
    {
        if (!users.containsKey(userName)) // if there is no password, return false
        {
            return false;
        }
        try // Try to match the hash password and return the boolean value
        {
            String hashInput = hashPassword(password);
            return hashInput.equals(users.get(userName));
        }
        catch (Exception e)
        {
            return false;
        }
    }

    // Private method to encrypt passwords
    private static String hashPassword(String password) throws Exception
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Getting the instance of the algorithm
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8)); // Encrypting

        // Convert to hexString
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash)
        {
           hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
