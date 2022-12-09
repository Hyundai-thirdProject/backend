package com.hd.mapper;

import org.junit.Test;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hd.domain.ReservationVO;

import lombok.extern.java.Log;

import java.util.Calendar;
import java.util.Date;

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

}
