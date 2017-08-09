package com.coacheslogin.model;

import java.util.List;

import com.studentslogin.model.StudentsVO;

public class CoachesService {

	private CoachesDAO_interface dao;
	
	public CoachesService(){
		dao = new CoachesJDBCDAO();
	}
	
	public CoachesVO addCoaches(String coa_acc, int coa_no, String coa_psw, int coa_sta, 
			String coa_name, int coa_sex, String coa_id, String coa_mail, String coa_into, double coa_pft){
		
		CoachesVO coachesVO = new CoachesVO();
		
		coachesVO.setCoa_acc(coa_acc);
		coachesVO.setCoa_no(coa_no);
		coachesVO.setCoa_psw(coa_psw);
		coachesVO.setCoa_sta(coa_sta);
		coachesVO.setCoa_name(coa_name);
		coachesVO.setCoa_sex(coa_sex);
		coachesVO.setCoa_id(coa_id);
		coachesVO.setCoa_mail(coa_mail);
		coachesVO.setCoa_into(coa_into);
		byte[] pic = getPictureByteArray();
		coachesVO.setCoa_pic(pic);
		coachesVO.setCoa_pft(coa_pft);
		dao.insert(coachesVO);
		
		return coachesVO;
	}
	
	public CoachesVO updateCoaches(String coa_acc, int coa_no, String coa_psw, int coa_sta, 
			String coa_name, int coa_sex, String coa_id, String coa_mail, String coa_into, double coa_pft){
		
		CoachesVO coachesVO = new CoachesVO();
		
		coachesVO.setCoa_acc(coa_acc);
		coachesVO.setCoa_no(coa_no);
		coachesVO.setCoa_psw(coa_psw);
		coachesVO.setCoa_sta(coa_sta);
		coachesVO.setCoa_name(coa_name);
		coachesVO.setCoa_sex(coa_sex);
		coachesVO.setCoa_id(coa_id);
		coachesVO.setCoa_mail(coa_mail);
		coachesVO.setCoa_into(coa_into);
		byte[] pic = getPictureByteArray();
		coachesVO.setCoa_pic(pic);
		coachesVO.setCoa_pft(coa_pft);
		dao.update(coachesVO);
		
		return coachesVO;
	}
	
	public void deleteCoaches(String Coa_no){
		dao.delete(Coa_no);
	}
	
	public CoachesVO findByPK(String coa_acc){
		return dao.findByPK(coa_acc);
	}
	
	public List<CoachesVO> getAll(){
		return dao.getAll();
	}

	private byte[] getPictureByteArray() {
		return null;
	}

	public StudentsVO findStudentsByUser(String username, String password) {
		// TODO Auto-generated method stub
		return dao.findStudentsByUser(username , password);
	}

	public CoachesVO findCoachesByUser(String username, String password) {
		// TODO Auto-generated method stub
		return dao.findCoachesByUser(username , password);
	}
	
	
}
