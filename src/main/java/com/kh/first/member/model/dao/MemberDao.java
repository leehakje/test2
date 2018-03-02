package com.kh.first.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.first.member.model.vo.Member;

@Repository("memberDao")       //dao 클래스에 작성하는 annotation
public class MemberDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public Member loginCheck(Member member) {
		member = mybatis.selectOne("memberMapper.loginMember", member);
		return member;
	}

	public int insertMember(Member member) {
		
		return mybatis.insert("memberMapper.insertMember", member);
	}
}
