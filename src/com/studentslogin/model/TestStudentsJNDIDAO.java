package com.studentslogin.model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TestStudentsJNDIDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	doPost(request, response);
	}	



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentsJNDIDAO dao = new StudentsJNDIDAO();

		// 新增
//		StudentsVO studentsVO1 = new StudentsVO();
//		studentsVO1.setStu_acc("Stu88");
//		studentsVO1.setStu_psw("KD1");
//		studentsVO1.setStu_acc_sta(1);
//		studentsVO1.setStu_name("80學生");
//		studentsVO1.setStu_sex(1);
//		studentsVO1.setStu_id("A56789");
//		studentsVO1.setStu_mail("Stu80@gmail.com");
//		studentsVO1.setStu_into("包你籃球變很強");
//		byte[] pic = getPictureByteArray("C:\\Users\\cuser\\Desktop\\Amos.png");
//		studentsVO1.setStu_pic(pic);
//		studentsVO1.setStu_sto(55.66);
//		dao.insert(studentsVO1);
//		System.out.println("487");
//	}
	
//		修改
		StudentsVO studentsVO2 = new StudentsVO();
		studentsVO2.setStu_acc("Stu9");
		studentsVO2.setStu_no(1);
		studentsVO2.setStu_psw("KD2");
		studentsVO2.setStu_name("K123");
		studentsVO2.setStu_mail("Stu87@gmail.com");
		studentsVO2.setStu_into("包你籃球變很強666");
		studentsVO2.setStu_pic(null);
		studentsVO2.setStu_sto(77.88);
		dao.update(studentsVO2);
		System.out.println("689");
}



//		刪除
//		dao.delete(0001);

//		查詢
//		StudentsVO studentsVO3 = dao.findByPK("XXX");
//		System.out.println(studentsVO3.getStu_acc() + ",");
//		System.out.println(studentsVO3.getStu_no() + ",");
//		System.out.println(studentsVO3.getStu_psw() + ",");
//		System.out.println(studentsVO3.getStu_acc_sta() + ",");
//		System.out.println(studentsVO3.getStu_name() + ",");
//		System.out.println(studentsVO3.getStu_sex() + ",");
//		System.out.println(studentsVO3.getStu_id() + ",");
//		System.out.println(studentsVO3.getStu_mail() + ",");
//		System.out.println(studentsVO3.getStu_into() + ",");
//		System.out.println(studentsVO3.getStu_pic() + ",");
//		System.out.println(studentsVO3.getStu_sto() + ",");
//		System.out.println("---------------------");
//		

//		查詢
//		List<StudentsVO> list = dao.getAll();
//		for (StudentsVO aStudents : list){
//			System.out.println(aStudents.getStu_acc() + ",");
//			System.out.println(aStudents.getStu_no() + ",");
//			System.out.println(aStudents.getStu_psw() + ",");
//			System.out.println(aStudents.getStu_acc_sta() + ",");
//			System.out.println(aStudents.getStu_name() + ",");
//			System.out.println(aStudents.getStu_sex() + ",");
//			System.out.println(aStudents.getStu_id() + ",");
//			System.out.println(aStudents.getStu_mail() + ",");
//			System.out.println(aStudents.getStu_into() + ",");
//			System.out.println(aStudents.getStu_pic() + ",");
//			System.out.println(aStudents.getStu_sto() + ",");
//			System.out.println();
//		}}
	public static byte[] getPictureByteArray(String path) throws IOException {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[8192];
		int i;
		while ((i = fis.read(buffer)) != -1) {
			baos.write(buffer, 0, i);
		}
		baos.close();
		fis.close();

		return baos.toByteArray();
	}
	}

	


