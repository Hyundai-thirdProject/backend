package com.hd.mapper;

import com.hd.domain.MemberVO;

public interface MemberMapper {

	public int insert(MemberVO member);
	public int select(MemberVO member);
}
