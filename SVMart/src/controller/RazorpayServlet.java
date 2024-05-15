package controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

// RazorpayServlet.java
@WebServlet("/razorpay")
public class RazorpayServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String razorpayKeyID = "rzp_test_qz0DkggQja3OTl";
		String razorpayKeySecret = "Gfc25meS9OgGzjIJX44qb850";

		try {
			BufferedReader reader = request.getReader();
			StringBuilder jsonInput = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				jsonInput.append(line);
			}

			JSONObject paymentData = new JSONObject(jsonInput.toString());

			RazorpayClient razorpayClient = new RazorpayClient(razorpayKeyID, razorpayKeySecret);
			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", paymentData.getDouble("amount")); // Amount in paise
			orderRequest.put("currency", "INR");

			orderRequest.put("receipt", "order_receipt_" + "order_rcptid_16791");
			Order order = razorpayClient.Orders.create(orderRequest);

			response.setContentType("application/json");
			response.getWriter().print(order);
		} catch (RazorpayException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
