package net.woniper.notification.sender;

import org.springframework.stereotype.Component;

/**
 * Created by woniper on 2016. 11. 26..
 */
@Component
public class SlackNotification implements Notification {

    @Override
    public void send(String title, String contents) {
        System.out.println(String.format("SLACK title : %s, contents : %s", title, contents));
    }
}
