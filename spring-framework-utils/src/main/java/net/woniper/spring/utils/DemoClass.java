package net.woniper.spring.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by woniper on 2017. 4. 1..
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class DemoClass {

    private List<Map<String, Object>> list = new ArrayList<>();

    @PostConstruct
    public void begin() {
        log.info("begin");
    }

}
