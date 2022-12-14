package com.hd.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hd.domain.FeedingReservationVO;
import com.hd.domain.ReservationVO;
import com.hd.service.ReservationService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
/**
 * ReservationController
 * @author  *
 * <pre>
수정자                      	수정내용
-------------   --------------------------------------------------
김민선			/insert
장주연             		/search, /modify
신미림                          /select, /check
 **/
@Log
@RestController
@RequestMapping("/reservation/*")
@AllArgsConstructor
public class ReservationController {
	
	private ReservationService reservation;
	
	

	@PostMapping("/insert")

	public ResponseEntity<String> register(@RequestBody ReservationVO reservationVO) {
		log.info("ReservationVO: " + reservationVO);
	
		
		int insertSuccess = reservation.reservationinsert(reservationVO);
		System.out.println("id: " + reservationVO.getMid() + ", rno: " +reservationVO.getRno());
		return insertSuccess == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/select")
	public String reservationSelect(@RequestParam String department_store, @RequestParam String start_time) {
		Gson gson = new Gson();
		
		log.info("FeedingReservationVO : "+ department_store + " , "+start_time); 
		FeedingReservationVO feedingreservationVO = new FeedingReservationVO();
		feedingreservationVO.setDepartment_store(department_store);
		feedingreservationVO.setStart_time(start_time);
		
		List<FeedingReservationVO> feedingreservation;
		feedingreservation = reservation.feedingreservationselect(feedingreservationVO); 
	
		return gson.toJson(feedingreservation, List.class);
	}

	@PostMapping("/search")
	public String search(@RequestBody String userId) {
		Gson gson = new Gson();
		
		return gson.toJson(reservation.searchMyReservation(userId));
	}
	
	@PostMapping("/modify")
	public String modify(@RequestBody ReservationVO vo) {
		Gson gson = new Gson();
		
		int successful = reservation.modifyMyReservation(vo);
		
		return successful == 1 ? gson.toJson("success") : gson.toJson("failure");
	}

	@PostMapping("/cancel")
	public String cancel(@RequestBody String userId) {
		Gson gson = new Gson();
		

		
		
		
		int successful = reservation.cancelMyReservation(userId);
		
		return successful == 1 ? gson.toJson("success") : gson.toJson("failure");
	}
	
	@PostMapping("/check")
	public String check(@RequestBody String userId) {
		Gson gson = new Gson();
		

		
		
		
		int successful = reservation.checkMyReservation(userId);
		
		return successful == 1 ? gson.toJson("success") : gson.toJson("failure");
	}
}


