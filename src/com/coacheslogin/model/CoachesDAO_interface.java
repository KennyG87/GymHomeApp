package com.coacheslogin.model;

import java.util.List;

import com.studentslogin.model.StudentsVO;

public interface CoachesDAO_interface {
	public void insert(CoachesVO coachesVO);
	public void update(CoachesVO coachesVO);
	public void delete(String coa_acc);
	public CoachesVO findByPK(String coa_acc);
	public List<CoachesVO> getAll();
	CoachesVO findCoachesByUser(String username, String password);
	StudentsVO findStudentsByUser(String username, String password);
	
//	萬用複合查詢(傳入參數型態Map)(回傳 List)
//	public List<CoachesVO> getAll(Map<String, String[]> map);
}