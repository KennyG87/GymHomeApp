package com.members.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class TestMembersJDBCDAO {

	public static void main(String[] args) throws IOException {
		MembersJDBCDAO dao = new MembersJDBCDAO();

		// ?–°å¢?
//		MembersVO membersVO1 = new MembersVO();
//		membersVO1.setMem_acc("XXX");
//		membersVO1.setMem_rank("2");
//		membersVO1.setMem_nickname("BOBI");
//		dao.insert(membersVO1);
//		System.out.println("487");
//	}

		


//		// ä¿®æ”¹
		MembersVO membersVO2 = new MembersVO();
		membersVO2.setMem_acc("XXX");
		membersVO2.setMem_no(2);
		membersVO2.setMem_rank("6");
		membersVO2.setMem_nickname("BOBO");
		dao.update(membersVO2);
		System.out.println("888");
	}
//
//		// ?ˆª?™¤
//		dao.delete(1);
//
//		// ?Ÿ¥è©?
//		MembersVO membersVO3 = dao.findByPK("mem01");
//		System.out.println(membersVO3.getMem_acc() + ",");
//		System.out.println(membersVO3.getMem_no() + ",");
//		System.out.println(membersVO3.getMem_rank() + ",");
//		System.out.println(membersVO3.getMem_nickname() + ",");
//		System.out.println("---------------------");
//		
//
//		// ?Ÿ¥è©?
//		List<MembersVO> list = dao.getAll();
//		for (MembersVO aMembers : list){
//			System.out.println(aMembers.getMem_acc() + ",");
//			System.out.println(aMembers.getMem_no() + ",");
//			System.out.println(aMembers.getMem_rank() + ",");
//			System.out.println(aMembers.getMem_nickname() + ",");
//			System.out.println();
//		}
//		
}


