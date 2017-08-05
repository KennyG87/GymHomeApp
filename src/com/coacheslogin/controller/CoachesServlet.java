package com.coacheslogin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coacheslogin.model.CoachesJDBCDAO;
import com.coacheslogin.model.CoachesJNDIDAO;
import com.coacheslogin.model.CoachesService;
import com.coacheslogin.model.CoachesVO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@SuppressWarnings("serial")
@WebServlet("/CoachesServlet")
public class CoachesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String CONTENT_TYPE = "text/html; charset=UTF-8";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		CoachesJDBCDAO coachesDao = new CoachesJDBCDAO();
		CoachesJNDIDAO coachesDao = new CoachesJNDIDAO();
		List<CoachesVO> coachesList = coachesDao.getAll();
		writeText(response, new Gson().toJson(coachesList));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		BufferedReader br = request.getReader();
		StringBuilder jsonIn = new StringBuilder();
		String line = "";
		while ((line = br.readLine()) != null) {
			jsonIn.append(line);
		}
		JsonObject jsonObject = gson.fromJson(jsonIn.toString(),
				JsonObject.class);
		CoachesJNDIDAO coachesDao = new CoachesJNDIDAO();
		String action = jsonObject.get("action").getAsString();
		
		CoachesService coas = new CoachesService();
		List<CoachesVO> c = coas.getAll();
		
		
		System.out.println("action: " + action);

		if (action.equals("getAll")) {
			List<CoachesVO> coachesList = coachesDao.getAll();
			writeText(response, gson.toJson(coachesList));
		}
	}

	private void writeText(HttpServletResponse response, String outText)
			throws IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		System.out.println("outText: " + outText);
		out.print(outText);
	}
}
