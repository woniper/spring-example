package net.woniper.notification.sender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootNotificationSenderApplicationTests {

	@Autowired private List<Notification> notifications;

	@Autowired private Map<String, Notification> notificationMap;

	@Autowired private Set<Notification> notificationSet;

	@Test
	public void testNotificationList() {
		notifications.forEach(notification -> notification.send("list", "contents"));
	}

	@Test
	public void testNotificationMap() throws Exception {
		notificationMap.entrySet().forEach(notification -> notification.getValue().send("map", notification.getKey()));
	}

	@Test
	public void testNotificationSet() throws Exception {
		notificationSet.forEach(notification -> notification.send("set", "contends"));
	}

	@Test
	public void testNotificationMapName() throws Exception {
		notificationMap.keySet().forEach(System.out::println);
	}
}
