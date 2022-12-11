package com.hd.service;

import java.util.List;

import com.hd.domain.FeedingReservationVO;
import com.hd.domain.MyReservationVO2;
import com.hd.domain.ReservationVO;

public interface ReservationService {
	
	public int reservationinsert(ReservationVO reservation);

	public List<FeedingReservationVO> feedingreservationselect(FeedingReservationVO feedingreservationVO);

	public MyReservationVO2 searchMyReservation(String userId);

}
