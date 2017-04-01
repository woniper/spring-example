package net.woniper.spring.utils;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by woniper on 2017. 4. 1..
 */
public class AssertTest {

    private DemoClass demoClass;

    @Before
    public void setUp() throws Exception {
        demoClass = new DemoClass();
    }

    @Test
    public void assertIsNull() throws Exception {
        demoClass.setList(null);
        Assert.isNull(demoClass.getList(), "the list can't be null");
    }

    @Test
    public void assertIsTrue() throws Exception {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("test", new Object());
        list.add(map);
        demoClass.setList(list);

        Assert.isTrue(list.size() == 1, "list size is 1");
    }
}
