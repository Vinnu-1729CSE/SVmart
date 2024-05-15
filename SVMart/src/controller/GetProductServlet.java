package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dao.ProductDAOImpl;

@WebServlet("/GetProductServlet")

public class GetProductServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		ProductDAO getProds;
		try {
			getProds = new ProductDAOImpl();
			req.setAttribute("productList", getProds.getProductList());
			req.setAttribute("len", getProds.getProductList().size());

		} catch (Exception e) {
		}
		// List<Product> parr = ;

		try {
			req.getRequestDispatcher("onlinestore.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

	}
}