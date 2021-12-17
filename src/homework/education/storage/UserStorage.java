package homework.education.storage;

import homework.education.exception.UserNotFoundException;
import homework.education.model.Lesson;
import homework.education.model.User;

public class UserStorage {

    private User[] users = new User[10];
    private int size = 0;

    public void add(User user) {
        if (users.length == size) {
            extend();
        }
        users[size++] = user;
    }

    private void extend() {
        User[] temp = new User[users.length + 10];
        System.arraycopy(users, 0, temp, 0, users.length);
        users = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(users[i]);
        }
    }

    public User getByEmail (String email) throws UserNotFoundException {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i];
            }
        }
        throw new UserNotFoundException("User doesn't exist. Email: " + email);
    }
}
