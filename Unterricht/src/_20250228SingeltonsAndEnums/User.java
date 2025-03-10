package _20250228SingeltonsAndEnums;

import java.util.List;

class User {
    private String username;
    private String password;
    List<Role> roles;

    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public static void main(String[] args) {
        User user = new User("John", "Doe", List.of(Role.ADMIN, Role.EMPLOYEE));
        User user1 = new User("Jan", "Doe", List.of(Role.ADMIN, Role.CEO));

    }

}
