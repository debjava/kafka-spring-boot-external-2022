package com.ddlab.rnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ddlab.rnd.service.ProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class SampleController {
	
	@Autowired
	private ProducerService producer;

	@PostMapping(value = "/publish")
	public ResponseEntity<String> sendInfo(@RequestParam("msg") String msg) {
		producer.sendMessage(msg);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
}
