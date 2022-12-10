package com.hd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hd.domain.FeedingReservationVO;
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

	@Override
	public List<FeedingReservationVO> feedingreservationselect(FeedingReservationVO feedingreservationVO) {
		List<FeedingReservationVO> lst = null;
		
		try {
			log.info("ReservationServiceImpl.feedingreservationselect()");
			lst = mapper.feedingreservation(feedingreservationVO);
			
		} catch (Exception e) {
			log.info(e.toString());
			throw e;
		}
		return lst;
	}

	@Override
	public ReservationVO searchMyReservation(String userId) {
		try {
			log.info("ReservationServiceImpl.searchMyReservation()");
			ReservationVO vo = mapper.searchMyReservation(userId);
			return vo;
			
		} catch (Exception e) {
			log.info(e.toString());
			throw e;
		}
	}

}
