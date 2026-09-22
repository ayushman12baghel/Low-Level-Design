package managers;
import models.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserManager {
    private Map<Integer, User> users = new HashMap<>();
    
    public void addUser(User user) { users.put(user.getId(), user); }
    public User getUser(int id) { return users.get(id); }
    public void removeUser(int id) { users.remove(id); }
    public List<User> getAllUsers() { return new ArrayList<>(users.values()); }
    
    public User findUserByEmail(String email) {
        Optional<User> userOpt = users.values().stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst();
        return userOpt.orElse(null);
    }
}
