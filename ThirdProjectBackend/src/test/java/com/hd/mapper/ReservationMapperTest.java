package com.hd.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hd.domain.MyReservationVO;
import com.hd.domain.ReservationVO;

import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log

public class ReservationMapperTest {
	
	@Autowired
	private ReservationMapper mapper;
	
	@Test
	public void testInsert() {
			
		
		ReservationVO vo = new ReservationVO();
		vo.setMid("ms");
		vo.setFno(2);
		vo.setStartTime("09:30");
		vo.setEndTime("10:00");
		
		mapper.reservationinsert(vo);
	}
	
	@Test
	public void testSearchMyReservation() {
	
		MyReservationVO vo = mapper.searchMyReservation("jjy990409@naver.com");
		System.out.println("fno: " + vo.getFloor());
		System.out.println("start time: " + vo.getStart_time());
		
		Date time = vo.getStart_time();
		System.out.println(time.toString().split(" ")[3].substring(0, 5));
	}

}
