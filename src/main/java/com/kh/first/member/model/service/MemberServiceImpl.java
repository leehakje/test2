package com.kh.first.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.first.member.model.dao.MemberDao;
import com.kh.first.member.model.vo.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	//private MemberDao memberDao = new MemberDao();
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member loginCheck(Member member) {
		return memberDao.loginCheck(member);
	}

	@Override
	public int insertMember(Member member) {
		return memberDao.insertMember(member);
	}

	@Override
	public int updateMemeber(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Member> memberAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
