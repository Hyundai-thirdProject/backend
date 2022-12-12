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
public class FeedingReservationVO {

	private String start_time;
	private String department_store;
	
	private int floor;
	private int room_count;
	private int use_count;	

}
