package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import dao.ProductDAOImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -173319121081412032L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ProductDAO loginObj;
		try {
			loginObj = new ProductDAOImpl();
			boolean login = loginObj.logIn(username, password);
			if (login) {
				HttpSession sn = request.getSession();
				sn.setAttribute("username", username);
				// response.sendRedirect("onlinestore.jsp");
				// sn.setAttribute(password, arg1);
				response.setContentType("plain/text");
				PrintWriter out = response.getWriter();
				out.print("Success");
			} else {
				response.setContentType("plain/text");
				PrintWriter out = response.getWriter();
				out.print("Error");
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
