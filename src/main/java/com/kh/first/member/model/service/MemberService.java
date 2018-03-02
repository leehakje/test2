package com.kh.first.member.model.service;

import java.util.ArrayList;

import com.kh.first.member.model.vo.Member;

public interface MemberService {
	Member loginCheck(Member member);
	int insertMember(Member member);
	int updateMemeber(Member member);
	int deleteMember(String userId);
	ArrayList<Member> memberAll();
}
