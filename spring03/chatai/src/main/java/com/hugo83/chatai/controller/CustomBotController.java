package com.hugo83.chatai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hugo83.chatai.dto.ChatGPTRequest;
import com.hugo83.chatai.dto.ChatGptResponse;

@RestController
@RequestMapping("/bot")
public class CustomBotController {
	
	@Value("${spring.ai.openai.chat.options.model}")
	private String model;

	@Value("${spring.ai.openai.chat.base-url}")
	private String apiURL;

	@Autowired
	private RestTemplate template;

	@SuppressWarnings("null")
	@GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){
        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
        ChatGptResponse chatGptResponse = template.postForObject(apiURL, request, ChatGptResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }
}
