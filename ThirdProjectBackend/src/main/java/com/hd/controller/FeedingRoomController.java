package com.hd.controller;

import com.google.gson.Gson;
import com.hd.domain.FeedingRoomVO;
import com.hd.service.FeedingRoomService;
import lombok.extern.java.Log;
import org.json.simple.JSONObject;
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
    public String getPosition(@RequestBody int fno) {
        Gson gson = new Gson();
        System.out.println("gson으로 바로 넘겨보자! " + fno);
        System.out.println("gson으로 바로 넘겨보자! " + gson.toJson(service.selectPosition(fno)));
        return gson.toJson(service.selectPosition(fno));
    }


    @PostMapping("/position2")
    public FeedingRoomVO getPosition2(@RequestBody int fno){
        log.info("controller로 값이 잘 넘어왔는지?"+fno);
//        FeedingRoomVO vo = new FeedingRoomVO();
//        service.selectPosition(fno);
        return service.selectPosition(fno);
    }

    @PostMapping("/position3")
    public String getPosition3(@RequestBody int fno) {
        log.info("controller로 값이 잘 넘어왔는지?"+fno);
        JSONObject jsonObject = new JSONObject();
        FeedingRoomVO vo = service.selectPosition(fno);
        jsonObject.put("fno",fno);
        jsonObject.put("department_store",vo.getDepartment_store());
        jsonObject.put("floor",vo.getFloor());
        jsonObject.put("room_count",vo.getRoom_count());
        jsonObject.put("image",vo.getImage());
        jsonObject.put("latitude", vo.getLatitude());
        jsonObject.put("longitude",vo.getLongitude());
        log.info(jsonObject+"");
        log.info(vo+"");
        return jsonObject.toJSONString();
    }
}
