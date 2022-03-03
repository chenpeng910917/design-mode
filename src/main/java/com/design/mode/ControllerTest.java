package com.design.mode;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpeng
 */
@RestController
public class ControllerTest {

    @RequestMapping("/design/test")
    public String test(String name) {
        System.out.println(name);
        return name;
    }
}
