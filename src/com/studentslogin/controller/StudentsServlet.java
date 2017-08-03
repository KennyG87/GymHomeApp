package com.studentslogin.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.members.login.MembersJDBCDAO;
import com.members.login.MembersService;
import com.members.login.MembersVO;
import com.studentslogin.model.*;

@SuppressWarnings("serial")
@WebServlet("/StudentsServlet")
public class StudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String CONTENT_TYPE = "text/html; charset=UTF-8";

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		StudentsJDBCDAO studentsDao = new StudentsJDBCDAO();
		List<StudentsVO> studentsList = studentsDao.getAll();
		writeText(res, new Gson().toJson(studentsList));
//		doPost(req, res);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		BufferedReader br = request.getReader();
		StringBuilder jsonIn = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			jsonIn.append(line);
		}
		JsonObject jsonObject = gson.fromJson(jsonIn.toString(),
				JsonObject.class);
		StudentsJDBCDAO studentsDao = new StudentsJDBCDAO();
		String action = jsonObject.get("action").getAsString();
		
//		StudentsService stus = new StudentsService();
//		List<StudentsVO> stus = stus.getAll();
//		for(StudentsVO aStudent:stus){
//			if(aStudent.getMem_acc().equals(email)&&aMember.getMem_no().equals(password)){
//				b
//			}
//			
//		}
		
		System.out.println("action: " + action);

		if (action.equals("getAll")) {
			List<StudentsVO> studentsList = studentsDao.getAll();
			writeText(response, gson.toJson(studentsList));
		}
	}

	private void writeText(HttpServletResponse response, String outText)
			throws IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		System.out.println("outText: " + outText);
		out.print(outText);
	}

//	private byte[] getPictureByteArray() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
