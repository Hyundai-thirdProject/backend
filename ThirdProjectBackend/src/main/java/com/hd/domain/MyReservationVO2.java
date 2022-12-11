package com.hd.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyReservationVO2 {

	private String mid;
	private String start_time;
	private String department_store;
	private int floor;
	
}
