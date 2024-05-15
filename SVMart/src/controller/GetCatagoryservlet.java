package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.Dataaccesspctg;
import model.ProductCatagory;

@WebServlet("/GetCatagoryServlet")
public class GetCatagoryservlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("this is productcatagory servlet");
		Dataaccesspctg dal = new Dataaccesspctg();
		ArrayList<ProductCatagory> pcat = dal.getPcatlist();
		Gson gson = new Gson();
		String jsondata = gson.toJson(pcat);
		System.out.println("this is json output" + jsondata);
		res.setContentType("application/json");
		PrintWriter pw = res.getWriter();
		pw.print(jsondata);
	}
}