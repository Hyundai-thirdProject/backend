package com.hd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hd.domain.FeedingReservationVO;
import com.hd.domain.MyReservationVO;
import com.hd.domain.MyReservationVO2;
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
	public MyReservationVO2 searchMyReservation(String userId) {
		try {
			log.info("ReservationServiceImpl.searchMyReservation()");
			String uid = userId.replace("\"", "");
			
			MyReservationVO vo = mapper.searchMyReservation(uid);
			MyReservationVO2 kotVo = new MyReservationVO2();
			
			kotVo.setMid(vo.getMid());
			kotVo.setStart_time(vo.getStart_time().toString().split(" ")[3].substring(0, 5));
			kotVo.setFloor(vo.getFloor());
			kotVo.setDepartment_store(vo.getDepartment_store());

			return kotVo;
			
		} catch (Exception e) {
			log.info(e.toString());
			throw e;
		}
	}

	@Override
	public int modifyMyReservation(ReservationVO vo) {
		int successful = 0;
		
		try {
			log.info("ReservationServiceImpl.modifyMyReservation()");
			mapper.modifyMyReservation(vo);
			successful = 1;
		} catch (Exception e) {
			log.info(e.toString());
			throw e;
		}
		return successful;
	}

	@Override
	public int cancelMyReservation(String userId) {
		
		int successful = 0;
		try {
			log.info("ReservationServiceImpl.calcelMyReservation()");
			String uid = userId.replace("\"", "");
			
			mapper.cancelMyReservation(uid);
			successful = 1;
		} catch (Exception e) {
			log.info(e.toString());
			throw e;
		}
		return successful;
	}

}
