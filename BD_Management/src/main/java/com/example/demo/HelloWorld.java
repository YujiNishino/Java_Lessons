package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// ▼ ControllerをつけることでこのClassがユーザからのアクセスを受け取ることができる

@Controller
public class HelloWorld {

	// ▼ @GetMapping("/")とすると、httpメソッドがGETでURLが/のアクセスがあるとこのメソッドが呼ばれるようになる
	//		- ()の中のパスは、http://localhost:8080に続く内容を表す
	//		- 例えば@GetMapping("/users")だとhttp://localhost:8080/usersにマッピングされる

    @GetMapping("/")
    public String hello() {

    	// ▼ src/main/resources/templates/配下のhello.htmlをユーザに返す
    	//		- Stringを返しているだけなのになぜそんな動きをするかというと、
    	//		  このClassに@Controllerがついているから

        return "hello";
    }
}