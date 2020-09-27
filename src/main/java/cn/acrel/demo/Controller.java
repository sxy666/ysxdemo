package cn.acrel.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.acrel.demo.ApiExample.httpGetExample;
import static cn.acrel.demo.ApiExample.httpPostExample;

@RestController
public class Controller {

    @GetMapping(value = "/Get", produces = "application/json", consumes = "application/json")
    public String get (){
        try {
            return httpGetExample("product");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @PostMapping(value = "/Post", produces = "application/json", consumes = "application/json")
    public String post(){
        try {
            return httpPostExample();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
