package com.studentslogin.model;

import java.util.List;

import com.coacheslogin.model.CoachesVO;

public interface StudentsDAO_interface {
	public abstract void insert(StudentsVO studentsVO);
	public abstract void update(StudentsVO studentsVO);
	public abstract void delete(String stu_acc);
	public abstract StudentsVO findByPK(String stu_acc);
	public abstract List<StudentsVO> getAll();
	public abstract StudentsVO findStudentsByUser(String username, String password);
	public abstract CoachesVO findCoachesByUser(String username, String password);
	
//	萬用複合查詢(傳入參數型態Map)(回傳 List)
//	public List<StudentsVO> getAll(Map<String, String[]> map);
}