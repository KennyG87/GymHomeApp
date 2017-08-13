package com.members.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TestMembersJNDIDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	doPost(request, response);
	}	



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MembersJNDIDAO dao = new MembersJNDIDAO();

//		 //?���?
		MembersVO membersVO1 = new MembersVO();
		membersVO1.setMem_acc("XXX");
		membersVO1.setMem_rank("56");
		membersVO1.setMem_nickname("BOBI");
		dao.insert(membersVO1);
		System.out.println("487");
	}
		

//		// 修改
//		MembersVO membersVO2 = new MembersVO();
//		membersVO2.setMem_acc("XXX");
//		membersVO2.setMem_no(2);
//		membersVO2.setMem_rank("6");
//		membersVO2.setMem_nickname("BOBO");
//		dao.update(membersVO2);
//		System.out.println("888");
//	}
//
//		// ?��?��
//		dao.delete(1);
//
//		// ?���?
//		MembersVO membersVO3 = dao.findByPK("mem01");
//		System.out.println(membersVO3.getMem_acc() + ",");
//		System.out.println(membersVO3.getMem_no() + ",");
//		System.out.println(membersVO3.getMem_rank() + ",");
//		System.out.println(membersVO3.getMem_nickname() + ",");
//		System.out.println("---------------------");
//		

//		// ?���?
//		List<MembersVO> list = dao.getAll();
//		for (MembersVO aMembers : list){
//			System.out.println(aMembers.getMem_acc() + ",");
//			System.out.println(aMembers.getMem_no() + ",");
//			System.out.println(aMembers.getMem_rank() + ",");
//			System.out.println(aMembers.getMem_nickname() + ",");
//			System.out.println();
//		}
}

	


