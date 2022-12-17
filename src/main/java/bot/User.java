package bot;

import java.util.Vector;

public class User {
    private String login;
    private String password;
    private long   telegramChatID;

    public User() {
        
    }

    public User(String login, String password, long telegramChatID) {
        this.login = login;
        this.password = password;
        this.telegramChatID = telegramChatID;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public long getTelegramChatID() {
        return telegramChatID;
    }
    public void setTelegramChatID(long telegramChatID) {
        this.telegramChatID = telegramChatID;
    }

    public static User getUserByChatId(Long chatID, Vector<User> usersVec) {
        for (User user : usersVec) {
            if (user.telegramChatID == chatID) {
                return user;
            }
        }
        return null;
    }
}
