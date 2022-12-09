package com.hd.controller;

import com.hd.domain.FeedingRoomVO;
import com.hd.service.FeedingRoomService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedingroom")
@Log
public class FeedingRoomController {


    @Autowired
    private FeedingRoomService service;

    @PostMapping("/position")
    public FeedingRoomVO getPosition(@RequestBody int fno){

        log.info("controller로 값이 잘 넘어왔는지?"+fno);
//        FeedingRoomVO vo = new FeedingRoomVO();
//        service.selectPosition(fno);
        return service.selectPosition(fno);
    }
}
