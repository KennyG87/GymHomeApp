package com.members.login;

import java.util.List;

public interface MembersDAO_interface {
	public void insert(MembersVO gymsVO);
	public void update(MembersVO gymsVO);
	public void delete(String mem_acc);
	public MembersVO findByPK(String mem_acc);
	public List<MembersVO> getAll();
	
//	?¬?”¨è¤‡å?ˆæŸ¥è©?(?‚³?…¥??ƒæ•¸??‹æ?‹Map)(??å‚³ List)
//	public List<MembersVO> getAll(Map<String, String[]> map);
}