package com.hd.mapper;

import com.hd.domain.FeedingRoomVO;
import com.hd.domain.MemberVO;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log
public class FeedingRoomMapperTests {


    @Autowired
    private FeedingRoomMapper mapper;

    @Test
    public void selectPositionTest() {
        int fno=4;
        FeedingRoomVO vo = new FeedingRoomVO();

        log.info("gd");
        vo=mapper.selectPosition(fno);
        log.info(vo.getLatitude()+" "+vo.getLongitude());
    }
}
