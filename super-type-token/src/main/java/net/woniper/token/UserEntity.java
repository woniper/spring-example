package net.woniper.token;

/**
 * Created by woniper on 2016. 11. 12..
 */
public class UserEntity {
    private String username;
    private int age;

    public UserEntity() {}

    public UserEntity(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
