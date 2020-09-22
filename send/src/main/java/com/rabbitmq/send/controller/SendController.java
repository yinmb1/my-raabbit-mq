package com.rabbitmq.send.controller;

import com.rabbitmq.send.service.TestSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：yinmb@ruyi.ai
 * @date ：Created in 2020/9/21 9:22 下午
 */
@RestController
public class SendController {
	@Autowired
	private TestSend testSend;

	@GetMapping("/send")
	public void send(){
		testSend.testSend();

	}
}
