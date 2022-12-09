package com.hd.service;

import com.hd.domain.FeedingRoomVO;
import com.hd.mapper.FeedingRoomMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedingRoomServiceImpl implements FeedingRoomService{

    @Autowired
    private FeedingRoomMapper mapper;

    @Override
    public FeedingRoomVO selectPosition(int fno) {
        return mapper.selectPosition(fno);
    }
}
