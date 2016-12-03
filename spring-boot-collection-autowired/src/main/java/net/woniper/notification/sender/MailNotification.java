package net.woniper.notification.sender;

import org.springframework.stereotype.Component;

/**
 * Created by woniper on 2016. 11. 26..
 */
@Component
public class MailNotification implements Notification {

    @Override
    public void send(String title, String contents) {
        System.out.println(String.format("MAIL title : %s, contents : %s", title, contents));
    }
}
