package lesson.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lesson.model.Cat;
import lesson.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/api")
@PropertySource("classpath:application.properties")
public class HelloController {

    @Value("${conductor.repository.command}")
    public String command;

    @Value("${conductor.dns.versions}")
    public String dns;

    private Map<String, String> mapVersions;

    @RequestMapping(value = "/command", method = RequestMethod.GET)
    @ResponseBody
    public String getCommand() {
        return String.format(command, "Hi1", "Hi2", "H3", "H4");
    }

    @RequestMapping(value = "/dns", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getDns() {
        Gson gson = new Gson();
        try {
            mapVersions = gson.fromJson(dns, Map.class);
        } catch (JsonSyntaxException e) {
            throw e;
        }
        return mapVersions;
    }

    @RequestMapping(value = "/hello",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getUser() {
        return new User("Alex", 29);
    }

    @RequestMapping(value = "/cats",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Cat getCat() {
        return new Cat("Boris", 2);
    }

    @GetMapping("/jsp")
    public String getJSPPage() {
        return "main";
    }
}
