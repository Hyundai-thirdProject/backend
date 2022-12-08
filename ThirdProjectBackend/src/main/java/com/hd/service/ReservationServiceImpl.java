package com.hd.service;

import org.springframework.stereotype.Service;

import com.hd.domain.ReservationVO;
import com.hd.mapper.ReservationMapper;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

	private ReservationMapper mapper;
	
	public int reservationinsert(ReservationVO reservation) {
		int successful = 0;
		
		try {
			log.info("ReservationServiceImpl.register()");
			mapper.reservationinsert(reservation);
			successful = 1;
		} catch (Exception e) {
			log.info(e.toString());
			throw e;
		}
		return successful;
	}


}
