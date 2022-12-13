package com.hd.controller;

import com.google.gson.Gson;
import com.hd.service.FeedingRoomService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * FeedingRoomController
 * @author �����
 *
 * <pre>
 *     ������            ��������
 * -------------   ------------------------
 *   �����              ���� ����
 * </pre>
 */

@RestController
@RequestMapping("/feedingroom")
@Log
public class FeedingRoomController {


    @Autowired
    private FeedingRoomService service;

    @PostMapping("/position")
    public String getPosition(@RequestBody int fno) {
        Gson gson = new Gson();

        return gson.toJson(service.selectPosition(fno));
    }

}