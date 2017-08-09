package com.studentslogin.model;

import java.util.List;

import com.coacheslogin.model.CoachesVO;

public class StudentsService {

	private StudentsDAO_interface dao;
	
	public StudentsService(){
		dao = new StudentsJNDIDAO();
	}
	
	public StudentsVO addStudents(String stu_acc, int stu_no, String stu_psw, int stu_acc_sta, 
			String stu_name, int stu_sex, String stu_id, String stu_mail, String stu_into, double stu_sto){
		
		StudentsVO studentsVO = new StudentsVO();
		
		studentsVO.setStu_acc(stu_acc);
		studentsVO.setStu_no(stu_no);
		studentsVO.setStu_psw(stu_psw);
		studentsVO.setStu_acc_sta(stu_acc_sta);
		studentsVO.setStu_name(stu_name);
		studentsVO.setStu_sex(stu_sex);
		studentsVO.setStu_id(stu_id);
		studentsVO.setStu_mail(stu_mail);
		studentsVO.setStu_into(stu_into);
//		byte[] pic = getPictureByteArray();
//		studentsVO.setStu_pic(stu_pic);
		studentsVO.setStu_sto(stu_sto);
		dao.insert(studentsVO);
		
		return studentsVO;
	}
	
	public StudentsVO updateStudents(String stu_acc, int stu_no, String stu_psw, int stu_acc_sta, 
			String stu_name, int stu_sex, String stu_id, String stu_mail, String stu_into, double stu_sto){
		
		StudentsVO studentsVO = new StudentsVO();
		
		studentsVO.setStu_acc(stu_acc);
		studentsVO.setStu_no(stu_no);
		studentsVO.setStu_psw(stu_psw);
		studentsVO.setStu_acc_sta(stu_acc_sta);
		studentsVO.setStu_name(stu_name);
		studentsVO.setStu_sex(stu_sex);
		studentsVO.setStu_id(stu_id);
		studentsVO.setStu_mail(stu_mail);
		studentsVO.setStu_into(stu_into);
//		byte[] pic = getPictureByteArray();
//		studentsVO.setStu_pic(stu_pic);
		studentsVO.setStu_sto(stu_sto);
		dao.update(studentsVO);
		
		return studentsVO;
	}
	
	public void deleteStudents(String Stu_no){
		dao.delete(Stu_no);
	}
	
	public StudentsVO findByPK(String stu_acc){
		return dao.findByPK(stu_acc);
	}
	
	public List<StudentsVO> getAll(){
		return dao.getAll();
	}

	public StudentsVO findStudentsByUser(String username, String password) {
		// TODO Auto-generated method stub
		return dao.findStudentsByUser(username , password);
	}

	public CoachesVO findCoachesByUser(String username, String password) {
		// TODO Auto-generated method stub
		return dao.findCoachesByUser(username , password);
	}



//	private byte[] getPictureByteArray() {
//		return null;
//	}


	
	
}
