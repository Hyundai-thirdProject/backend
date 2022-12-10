package com.hd.service;

import java.util.List;

import com.hd.domain.FeedingReservationVO;
import com.hd.domain.ReservationVO;

public interface ReservationService {
	
	public int reservationinsert(ReservationVO reservation);

	public List<FeedingReservationVO> feedingreservationselect(FeedingReservationVO feedingreservationVO);

	public ReservationVO searchMyReservation(String userId);

}
