package com.hd.service;

import com.hd.domain.FeedingRoomVO;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log
public class FeedingRoomServiceTests {

        @Autowired
        private FeedingRoomService service;

        @Test
        public void selectPositionTest() {
            int fno=1;
            FeedingRoomVO vo = new FeedingRoomVO();
            vo=service.selectPosition(fno);
            log.info(vo.getLatitude()+" "+vo.getLongitude());
        }


}
