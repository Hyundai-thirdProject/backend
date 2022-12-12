package com.hd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.domain.MemberVO;
import com.hd.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/member/*")
@AllArgsConstructor
public class MemberController {

	private MemberService member;
	
	@PostMapping("/join")
	public ResponseEntity<String> register(@RequestBody MemberVO vo) {
		log.info("MemberVO: " + vo);
		int insertSuccess = member.join(vo);
		System.out.println("id: " + vo.getMid() + ", pw: " + vo.getPassword());
		return insertSuccess == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
