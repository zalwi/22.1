package pl.zalwi.data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> userList;

    public UserRepository(){
        userList = new ArrayList<User>();
        userList.add(new User("Kamil", "Zalwert", 31));
        userList.add(new User("Jan", "Kowalski", 21));
        userList.add(new User("Piotr", "Pierwszy", 11));
    }

    public List<User> getAll(){
        return userList;
    }

    public void addUser(User user){
        userList.add(user);
    }
}
