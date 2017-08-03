package com.coacheslogin.model;

import java.util.List;

public interface CoachesDAO_interface {
	public void insert(CoachesVO coachesVO);
	public void update(CoachesVO coachesVO);
	public void delete(String coa_acc);
	public CoachesVO findByPK(String coa_acc);
	public List<CoachesVO> getAll();
	
//	萬用複合查詢(傳入參數型態Map)(回傳 List)
//	public List<CoachesVO> getAll(Map<String, String[]> map);
}