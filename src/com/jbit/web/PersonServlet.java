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
import com.jbit.dao.UserDao;
import com.jbit.entity.Person;
import com.jbit.entity.sqlquery;
import java.sql.ResultSet;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                String sql = request.getParameter("sql");
                sqlquery exec= new sqlquery();
                ResultSet resultset=exec.execute(sql);
		UserBiz userBiz = new UserBizImpl(resultset);

		List<Person>persons = userBiz.getUsers(sql,resultset);
		String cityIdStr = request.getParameter("cityId");
		String trainIdStr = request.getParameter("trainId");
		if(cityIdStr!=null&&cityIdStr!="") {
			int cityId = Integer.parseInt(cityIdStr);
			persons = userBiz.getPersonsByCityId(cityId,resultset);
		}else if(trainIdStr!=null&&trainIdStr!="") {
			int trainId = Integer.parseInt(trainIdStr);
			persons = userBiz.getPersonsByTrainId(trainId,resultset);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("persons", persons);
		
		
		response.sendRedirect("persons.jsp");
	}

}
