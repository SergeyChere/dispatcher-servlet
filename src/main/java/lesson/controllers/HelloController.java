package lesson.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    cannot response with JSON!!!
    @GetMapping("/hello")
    public String getUser() {
        return "Hello";
    }

    private class User {
        private String name;
        private int age;

        public User (String name, int age) {
            this.name=name;
            this.age=age;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}
