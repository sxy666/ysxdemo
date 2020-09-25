package cn.acrel.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.acrel.demo.ApiExample.httpGetExample;

@RestController
public class Controller {

    @GetMapping(value = "/Get", produces = "application/json", consumes = "application/json")
    public String get (String type){
        try {
            return httpGetExample(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
