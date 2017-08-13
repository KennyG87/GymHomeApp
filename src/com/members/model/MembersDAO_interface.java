package com.members.model;

import java.util.List;

public interface MembersDAO_interface {
	public void insert(MembersVO gymsVO);
	public void update(MembersVO gymsVO);
	public void delete(String mem_acc);
	public MembersVO findByPK(String mem_acc);
	public List<MembersVO> getAll();
	
	
//	?��?��複�?�查�?(?��?��??�數??��?�Map)(??�傳 List)
//	public List<MembersVO> getAll(Map<String, String[]> map);
}