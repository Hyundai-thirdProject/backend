package com.hd.service;

import com.hd.domain.FeedingRoomVO;
import org.springframework.stereotype.Service;

public interface FeedingRoomService {

    public FeedingRoomVO selectPosition(int fno);
}
