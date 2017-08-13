package com.members.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coacheslogin.model.CoachesService;
import com.coacheslogin.model.CoachesVO;
import com.coacheslogin.model.MemberCoach;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.members.model.MembersJNDIDAO;
import com.members.model.MembersService;
import com.members.model.MembersVO;
import com.studentslogin.model.StudentsService;
import com.studentslogin.model.StudentsVO;

@SuppressWarnings("serial")
@WebServlet("/MembersServlet")
public class MembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String CONTENT_TYPE = "text/html; charset=UTF-8";
	MembersJNDIDAO membersDao = new MembersJNDIDAO();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<MembersVO> membersList = membersDao.getAll();
		writeText(response, new Gson().toJson(membersList));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		BufferedReader br = request.getReader();
		StringBuilder jsonIn = new StringBuilder();
		String line = "";
		System.out.println("AAAAAAAAAAAA");
		while ((line = br.readLine()) != null) {
			jsonIn.append(line);
		}
		JsonObject jsonObject = gson.fromJson(jsonIn.toString(),
				JsonObject.class);
		System.out.println("BBBBBBBBBBB");

		MembersService mems = new MembersService();
		String role = jsonObject.get("role").getAsString();
		
		String mem_acc = jsonObject.get("mem_acc").getAsString();



		MembersVO member=null;

		String string = "";
				
		if (role.equals("0")) {
			member = mems.insert(mem_acc);
			string = gson.toJson(member);
			
//		}	else {
//			coach = coas.findCoachesByUser(username, password);
//			}
//			memberCoach = new MemberCoach(student,coach);
//			string = gson.toJson(memberCoach);
			
		}
		
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println(string);
		

	}

	private void writeText(HttpServletResponse response, String outText)
			throws IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		System.out.println("outText: " + outText);
		out.print(outText);
	}
}
