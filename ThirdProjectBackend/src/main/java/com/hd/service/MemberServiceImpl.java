package com.hd.service;

import org.springframework.stereotype.Service;

import com.hd.domain.MemberVO;
import com.hd.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	private MemberMapper mapper;
	
	public int join(MemberVO member) {
		int successful = 0;
		
		try {
			log.info("MemberServiceImpl.register()");
			mapper.insert(member);
			successful = 1;
		} catch (Exception e) {
			log.info(e.toString());
			throw e;
		}
		return successful;
	}

	@Override
	public int login(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}
}
