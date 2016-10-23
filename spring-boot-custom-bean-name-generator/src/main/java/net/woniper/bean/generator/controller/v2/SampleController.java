package net.woniper.bean.generator.controller.v2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by woniper on 2016. 10. 22..
 */
@RestController
@RequestMapping("/v2")
public class SampleController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello~ v2");
    }
}
