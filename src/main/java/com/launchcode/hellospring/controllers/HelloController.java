package com.launchcode.hellospring.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // handles request at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring";
    }

    // handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello " + name + "!";
    }

    // handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                            "<form method = 'post' action = 'hello'>" +
                                "<input type = 'text' name = 'name' />" +
                                "<input type = 'submit' value = 'Greet Me!' />" +
                        "   </form>" +
                        "</body>" +
                "</html>";
        return html;
    }

}
