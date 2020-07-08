package com.jbit.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jbit.biz.UserBiz;
import com.jbit.biz.impl.UserBizImpl;
import com.jbit.entity.Train;
import com.jbit.entity.sqlquery;
import java.sql.ResultSet;

/**
 * Servlet implementation class TrainServlet
 */
@WebServlet("/TrainServlet")
public class TrainServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = request.getParameter("sql");
                sqlquery exec= new sqlquery();
                ResultSet resultset=exec.execute(sql);
		UserBiz userBiz = new UserBizImpl(resultset);
		List<Train>trains = userBiz.getTrains(sql,resultset);
		
		HttpSession session = request.getSession();
		session.setAttribute("trains", trains);
		response.sendRedirect("train.jsp");
	}

}
