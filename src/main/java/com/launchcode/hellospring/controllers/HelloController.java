package com.launchcode.hellospring.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
//@RequestMapping("hello")
public class HelloController {

    // handles request at /hello
//    @GetMapping("")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring";
    }

    // handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "createMessage")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        String greetName = name == null || name.isEmpty() ? "World!" : name + "!";
        String greeting = language.equals("en") ? "Hello, " :
                language.equals("fr") ? "Bonjour, " :
                        language.equals("it") ? "Buongiorno, " :
                                language.equals("es") ? "Hola, " :
                                        language.equals("de") ? "Hallo, " :
                                                "Mabuhay, ";
        return greeting + greetName;
    }

    // handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = 'createMessage'>" +
                        "<label for='name-input'>Name: </label>" +
                        "<input id='name-input' type = 'text' name = 'name' />" +
                        "<label for='lang-select'>Language: </label>" +
                        "<select id='lang-select' name='language'>" +
                        "<option value='en'>English</option>" +
                        "<option value='fr'>French</option>" +
                        "<option value='it'>Italian</option>" +
                        "<option value='es'>Spanish</option>" +
                        "<option value='de'>German</option>" +
                        "<option value='tg'>Tagalog</option>" +
                        "</select>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "   </form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

}
