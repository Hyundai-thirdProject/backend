package com.hd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.domain.MemberVO;
import com.hd.domain.ReservationVO;
import com.hd.service.MemberService;
import com.hd.service.ReservationService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/reservation/*")
@AllArgsConstructor
public class ReservationController {
	
	private ReservationService reservation;
	

	@PostMapping("/insert")
	public ResponseEntity<String> register(@RequestBody ReservationVO vo) {
		log.info("ReservationVO: " + vo);
		int insertSuccess = reservation.reservationinsert(vo);
		System.out.println("id: " + vo.getMid() + ", rno: " + vo.getRno());
		return insertSuccess == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
