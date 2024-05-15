package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.DataAccessCatagoryWiseProduct;
import model.Product;

@WebServlet("/GetSelectedPCatagory")
public class GetSelectedPCatagory extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		DataAccessCatagoryWiseProduct dac = new DataAccessCatagoryWiseProduct();
		Integer selectedpcat = Integer.parseInt(req.getParameter("selectctg"));
		dac.rundta(selectedpcat);
		ArrayList<Product> selectedcatp = (ArrayList<Product>) dac.getProductList();
		Gson gson = new Gson();
		String jsondata = gson.toJson(selectedcatp);
		res.setContentType("application/json");
		PrintWriter pw = res.getWriter();
		pw.print(jsondata);
	}
}