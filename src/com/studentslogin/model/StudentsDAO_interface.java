package com.studentslogin.model;

import java.util.List;

public interface StudentsDAO_interface {
	public void insert(StudentsVO studentsVO);
	public void update(StudentsVO studentsVO);
	public void delete(String stu_acc);
	public StudentsVO findByPK(String stu_acc);
	public List<StudentsVO> getAll();
	
//	萬用複合查詢(傳入參數型態Map)(回傳 List)
//	public List<StudentsVO> getAll(Map<String, String[]> map);
}