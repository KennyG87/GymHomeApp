package com.members.login;

import java.util.List;

public class MembersService {

	private MembersDAO_interface dao;
	
	public MembersService(){
		dao = new MembersJDBCDAO();
	}
	
	public MembersVO addMembers(int mem_no, String mem_acc,	String mem_rank, String mem_nickname, Integer mr_num){
		
		MembersVO membersVO = new MembersVO();
		
		membersVO.setMem_no(mem_no);
		membersVO.setMem_acc(mem_acc);
		membersVO.setMem_rank(mem_rank);
		membersVO.setMem_nickname(mem_nickname);
		membersVO.setMr_num(mr_num);
		dao.insert(membersVO);
		
		return membersVO;
	}
	
	public MembersVO updateMembers(int mem_no, String mem_acc,	String mem_rank, String mem_nickname, Integer mr_num){
		
		MembersVO membersVO = new MembersVO();
		
		membersVO.setMem_no(mem_no);
		membersVO.setMem_acc(mem_acc);
		membersVO.setMem_rank(mem_rank);
		membersVO.setMem_nickname(mem_nickname);
		membersVO.setMr_num(mr_num);
		dao.update(membersVO);
		
		return membersVO;
	}
	
	public void deleteMembers(String Mem_acc){
		dao.delete(Mem_acc);
	}
	
	public MembersVO getOneMembers(String mem_acc){
		return dao.findByPK(mem_acc);
	}
	
	public List<MembersVO> getAll(){
		return dao.getAll();
	}


	
	
}
