package com.hd.service;

import com.hd.domain.MemberVO;

public interface MemberService {
	
	public int join(MemberVO member);
	public int login(MemberVO member);

}
