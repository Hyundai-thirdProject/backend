package com.hd.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ReservationVO {

	private int rno;
	private String mid;
	private int fno;
	private Date startTime;
	private Date endTime;
	private int status;
	
}
