package com.hd.mapper;

import java.util.List;

import com.hd.domain.FeedingReservationVO;
import com.hd.domain.MyReservationVO;
import com.hd.domain.ReservationVO;

public interface ReservationMapper {
	
	public int reservationinsert(ReservationVO reservation);

	public List<FeedingReservationVO> feedingreservation(FeedingReservationVO feedingreservationVO);
	
	public MyReservationVO searchMyReservation(String userId);
	
	public int modifyMyReservation(ReservationVO reservation);
}
