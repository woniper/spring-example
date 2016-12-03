package net.woniper.notification.sender;

/**
 * Created by woniper on 2016. 11. 26..
 */
public interface Notification {
    void send(String title, String contents);
}
