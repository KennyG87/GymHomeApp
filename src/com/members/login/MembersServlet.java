package com.members.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@SuppressWarnings("serial")
@WebServlet("/MembersServlet")
public class MembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String CONTENT_TYPE = "text/html; charset=UTF-8";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MembersJDBCDAO membersDao = new MembersJDBCDAO();
		List<MembersVO> membersList = membersDao.getAll();
		writeText(response, new Gson().toJson(membersList));
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
		MembersJDBCDAO membersDao = new MembersJDBCDAO();
		String action = jsonObject.get("action").getAsString();
		
		MembersService mbs = new MembersService();
		List<MembersVO> mbrs = mbs.getAll();
		for(MembersVO aMember:mbrs){
			if(aMember.getMem_acc().equals(email)&&aMember.getMem_no().equals(password)){
				b
			}
			
		}
		
		System.out.println("action: " + action);

		if (action.equals("getAll")) {
			List<MembersVO> membersList = membersDao.getAll();
			writeText(response, gson.toJson(membersList));
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
