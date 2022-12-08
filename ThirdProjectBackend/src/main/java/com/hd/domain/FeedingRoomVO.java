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
	private String departmentStore;
	private int floor;
	private int roomCount;
	private String floorPlan;
	private int latitude;
	private int longitude;


}
