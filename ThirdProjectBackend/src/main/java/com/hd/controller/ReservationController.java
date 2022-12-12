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
		
//		// ���� ��¥ ���ϱ�
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Calendar c1 = Calendar.getInstance();
//		String strToday = sdf.format(c1.getTime());
//		log.info(".....................strToday��?" + strToday);
//		
//		// ���� ��¥ + ��Ʋ������ ������ �ð� ���ϱ� 
//		
//		String timeStamp = reservationVO.getStartTime().toString();
//		
//		log.info(".....................timeStamp��?" + timeStamp);
//		
//		String resultTime = strToday + " " + timeStamp;
//		
//		log.info(".....................resultTime��?" + resultTime);
//		
//		// string���� timestamp�� �ٲٱ�
//		java.sql.Timestamp t = java.sql.Timestamp.valueOf(resultTime);
//		log.info(".....................t��?" + t);
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
	
//	@GetMapping("/select")
//	public ResponseEntity<FeedingReservationVO> reservationSelect(@RequestParam String department_store,@RequestParam String start_time) throws JsonProcessingException{
//
//		log.info("FeedingReservationVO :"+ department_store + " , "+start_time); 
//		FeedingReservationVO feedingreservationVO = new FeedingReservationVO();
//		feedingreservationVO.setDepartment_store(department_store);
//		feedingreservationVO.setStart_time(start_time);
//		
//		FeedingReservationVO feedingreservation;
//		feedingreservation = reservation.feedingreservationselect(feedingreservationVO); 
//		System.out.println("starttime" + feedingreservationVO.getStart_time() + ",depart_store " + feedingreservationVO.getDepartment_store());
//
//		
//		return feedingreservation!=null ? new ResponseEntity<>(feedingreservation, HttpStatus.OK)
//				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@GetMapping("/select")
	public String reservationSelect(@RequestParam String department_store, @RequestParam String start_time) {
//		JSONObject jsonObject = new JSONObject();
		Gson gson = new Gson();
		
		log.info("FeedingReservationVO : "+ department_store + " , "+start_time); 
		FeedingReservationVO feedingreservationVO = new FeedingReservationVO();
		feedingreservationVO.setDepartment_store(department_store);
		feedingreservationVO.setStart_time(start_time);
		
		List<FeedingReservationVO> feedingreservation;
		feedingreservation = reservation.feedingreservationselect(feedingreservationVO); 
		
//		for (FeedingReservationVO feeding : feedingreservation ) {
//			jsonObject.put("start_time", feeding.getStart_time());
//			jsonObject.put("department_store", feeding.getDepartment_store());
//			jsonObject.put("floor", feeding.getFloor());
//			jsonObject.put("room_count", feeding.getRoom_count());
//			jsonObject.put("user_count", feeding.getUse_count());
//		}
//		
		return gson.toJson(feedingreservation, List.class);
	}

	@PostMapping("/search")
	public String search(@RequestBody String userId) {
		Gson gson = new Gson();
		System.out.println("userId는?? " + userId);
		
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
		
		System.out.println("userId는?? " + userId);
		
		
		
		int successful = reservation.cancelMyReservation(userId);
		
		return successful == 1 ? gson.toJson("success") : gson.toJson("failure");
	}
	
	@PostMapping("/check")
	public String check(@RequestBody String userId) {
		Gson gson = new Gson();
		
		System.out.println("userId는?? " + userId);
		
		
		
		int successful = reservation.checkMyReservation(userId);
		
		return successful == 1 ? gson.toJson("success") : gson.toJson("failure");
	}
}


