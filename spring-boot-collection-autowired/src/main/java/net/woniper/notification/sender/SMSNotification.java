package net.woniper.notification.sender;

import org.springframework.stereotype.Component;

/**
 * Created by woniper on 2016. 11. 30..
 */
@Component
public class SMSNotification implements Notification {
    @Override
    public void send(String title, String contents) {
        System.out.println(String.format("SMS title : %s, contents : %s", title, contents));
    }
}
