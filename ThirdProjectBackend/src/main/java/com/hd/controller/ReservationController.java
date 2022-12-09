package com.hd.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hd.domain.ReservationVO;
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
//	@JsonFormat
	public ResponseEntity<String> register(@RequestBody ReservationVO reservationVO) {
		log.info("ReservationVO: " + reservationVO);
		
//		// 오늘 날짜 구하기
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Calendar c1 = Calendar.getInstance();
//		String strToday = sdf.format(c1.getTime());
//		log.info(".....................strToday는?" + strToday);
//		
//		// 오늘 날짜 + 코틀린에서 선택한 시간 더하기 
//		
//		String timeStamp = reservationVO.getStartTime().toString();
//		
//		log.info(".....................timeStamp는?" + timeStamp);
//		
//		String resultTime = strToday + " " + timeStamp;
//		
//		log.info(".....................resultTime는?" + resultTime);
//		
//		// string에서 timestamp로 바꾸기
//		java.sql.Timestamp t = java.sql.Timestamp.valueOf(resultTime);
//		log.info(".....................t는?" + t);
//		
//		reservationVO.setStartTime(t);
//
//		
//		log.info("....................." + timeStamp);
//		
////		String finalTime = strToday + " " + strTime;
		
		// startTime 
		
		int insertSuccess = reservation.reservationinsert(reservationVO);
		System.out.println("id: " + reservationVO.getMid() + ", rno: " +reservationVO.getRno());
		return insertSuccess == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
