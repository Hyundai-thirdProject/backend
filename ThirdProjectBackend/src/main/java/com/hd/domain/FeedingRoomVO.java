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
public class FeedingRoomVO {
	
	private int fno;
	private String department_store;
	private int floor;
	private int room_count;
	private String floorPlan;
	private String image;
	private Double latitude;
	private Double longitude;



}
