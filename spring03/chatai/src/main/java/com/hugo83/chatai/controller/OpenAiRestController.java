package com.hugo83.chatai.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/ai")
public class OpenAiRestController {
	
	@GetMapping("/translate")
	public ResponseEntity<String> data(@RequestParam(name = "query",defaultValue = "Hello") String query){
        RestTemplate restTemplate=new RestTemplate();
        Map<String,String> message=new HashMap<>();
        message.put("role","user");
        message.put("content",query);
        Map<String,Object> request=new HashMap<>();
        request.put("messages", List.of(message));
        request.put("model","gpt-3.5-turbo");
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization","Bearer yourKey");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map> httpEntity=new HttpEntity<>(request,headers);

		try {
			ResponseEntity<String> exchange = restTemplate.exchange(
                "https://api.openai.com/v1/chat/completions",
                HttpMethod.POST,
                httpEntity, String.class
        	);
        	return exchange;
		} catch (Exception e) {
			return null;
		}
        
    }
	
}
