
package Dao;
import Entity.User;
public class UserDao {
    public boolean checkUser(User user) {
        if (user != null) {
            if ("Admin".equals(user.getUserName()) 
                    && "thien".equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
