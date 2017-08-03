package com.coacheslogin.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TestCoachesJNDIDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	doPost(request, response);
	}	



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CoachesJNDIDAO dao = new CoachesJNDIDAO();

//		 //新增
//		CoachesVO coachesVO1 = new CoachesVO();
//		coachesVO1.setCoa_acc("CoachK8");
//		coachesVO1.setCoa_psw("KD1");
//		coachesVO1.setCoa_sta(2);
//		coachesVO1.setCoa_name("K教練");
//		coachesVO1.setCoa_sex(1);
//		coachesVO1.setCoa_id("A123456");
//		coachesVO1.setCoa_mail("CoachK@gmail.com");
//		coachesVO1.setCoa_into("包你籃球變很強");
//		byte[] pic = getPictureByteArray("C:\\Users\\cuser\\Desktop\\Amos.png");
//		coachesVO1.setCoa_pic(pic);
//		coachesVO1.setCoa_pft(55.66);
//		dao.insert(coachesVO1);
//		System.out.println("487");
//	}
		

		//修改
		CoachesVO coachesVO2 = new CoachesVO();
		coachesVO2.setCoa_acc("CoachK9");
		coachesVO2.setCoa_no(1);
		coachesVO2.setCoa_psw("KD2");
		coachesVO2.setCoa_name("K教練123");
		coachesVO2.setCoa_mail("CoachK87@gmail.com");
		coachesVO2.setCoa_into("包你籃球變很強666");
		coachesVO2.setCoa_pic(null);
		coachesVO2.setCoa_pft(77.88);
		dao.update(coachesVO2);
		System.out.println("689");
	}
//
//		// 刪除
//		dao.delete("gym01");


	// 查詢
//		CoachesVO coachesVO3 = dao.findByPK("XXX");
//		System.out.println(coachesVO3.getCoa_acc() + ",");
//		System.out.println(coachesVO3.getCoa_no() + ",");
//		System.out.println(coachesVO3.getCoa_psw() + ",");
//		System.out.println(coachesVO3.getCoa_sta() + ",");
//		System.out.println(coachesVO3.getCoa_name() + ",");
//		System.out.println(coachesVO3.getCoa_sex() + ",");
//		System.out.println(coachesVO3.getCoa_id() + ",");
//		System.out.println(coachesVO3.getCoa_mail() + ",");
//		System.out.println(coachesVO3.getCoa_into() + ",");
//		System.out.println(coachesVO3.getCoa_pic() + ",");
//		System.out.println(coachesVO3.getCoa_pft() + ",");
//		System.out.println("---------------------");
	

	// 查詢
//	List<CoachesVO> list = dao.getAll();
//	for (CoachesVO aCoaches : list){
//		System.out.println(aCoaches.getCoa_acc() + ",");
//		System.out.println(aCoaches.getCoa_no() + ",");
//		System.out.println(aCoaches.getCoa_psw() + ",");
//		System.out.println(aCoaches.getCoa_sta() + ",");
//		System.out.println(aCoaches.getCoa_name() + ",");
//		System.out.println(aCoaches.getCoa_sex() + ",");
//		System.out.println(aCoaches.getCoa_id() + ",");
//		System.out.println(aCoaches.getCoa_mail() + ",");
//		System.out.println(aCoaches.getCoa_into() + ",");
//		System.out.println(aCoaches.getCoa_pic() + ",");
//		System.out.println(aCoaches.getCoa_pft() + ",");
//		System.out.println();
//	}
	}

	


