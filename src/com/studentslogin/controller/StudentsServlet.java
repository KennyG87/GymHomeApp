package com.studentslogin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coacheslogin.model.CoachesJNDIDAO;
import com.coacheslogin.model.CoachesService;
import com.coacheslogin.model.CoachesVO;
import com.coacheslogin.model.MemberCoach;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.studentslogin.model.StudentsJNDIDAO;
import com.studentslogin.model.StudentsService;
import com.studentslogin.model.StudentsVO;

@SuppressWarnings("serial")
@WebServlet("/StudentsServlet")
public class StudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String CONTENT_TYPE = "text/html; charset=UTF-8";
	private MemberCoach memberCoach;
	StudentsJNDIDAO studentsDao = new StudentsJNDIDAO();
	CoachesJNDIDAO coachesDao = new CoachesJNDIDAO();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<StudentsVO> studentsList = studentsDao.getAll();
		writeText(response, new Gson().toJson(studentsList));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		BufferedReader br = request.getReader();
		StringBuilder jsonIn = new StringBuilder();
		String line = "";
		System.out.println("1111111111");
		while ((line = br.readLine()) != null) {
			jsonIn.append(line);
		}
		JsonObject jsonObject = gson.fromJson(jsonIn.toString(),
				JsonObject.class);
		System.out.println("22222222222");
		StudentsService stus = new StudentsService();
		CoachesService coas = new CoachesService();
		String role = jsonObject.get("role").getAsString();
		String username = jsonObject.get("username").getAsString();
		String password = jsonObject.get("password").getAsString();
		
		StudentsVO student=null;
		CoachesVO coach = null;
		String string = "";
				
		if (role.equals("0")) {
			student = stus.findStudentsByUser(username, password);
//			string = gson.toJson(student);
			
		
		
		}	else {
			coach = coas.findCoachesByUser(username, password);
			}
			
		
		
		
		
		
		memberCoach = new MemberCoach(student,coach);
		string = gson.toJson(memberCoach);
			
		
//		}
		
//		response.setContentType(CONTENT_TYPE);
//		PrintWriter out = response.getWriter();
//		out.println(string);
		
		
		System.out.println("333333333333");

	}

	private void writeText(HttpServletResponse response, String outText)
			throws IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		System.out.println("outText: " + outText);
		out.print(outText);
	}
}
