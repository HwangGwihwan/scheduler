package com.example.scheduler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.scheduler.dto.SampleForm;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {
	@GetMapping("/addSample")
	public String addSample() {
		return "addSample";
	}
	
	@PostMapping("/addSample")
	public String addSample(Model model,@Valid SampleForm sampleForm, Errors errors) {
		// @Valid 유효성 검증 -> 에러 발생시 Errors 객체에 에러정보 추가
		log.info(sampleForm.toString());
		// Error 발생하면 : 입력값 유효성 검사
		if (errors.hasErrors()) {
			for(FieldError e : errors.getFieldErrors()) {
				model.addAttribute(e.getField() + "ErrMsg", e.getDefaultMessage());
			}
			return "addSample";
		}
		return "redirect:/";
	}
}
