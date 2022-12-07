package com.hd.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hd.domain.MemberVO;

import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log
public class MemberMapperTests {
	
	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void testInsert() {
		MemberVO vo = new MemberVO();
		vo.setMid("juyeon");
		vo.setPassword("1234");
		vo.setPhone("010-1111-1111");
		
		mapper.insert(vo);
	}
}
