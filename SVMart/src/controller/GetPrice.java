package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.ProductDAO;
import dao.ProductDAOImpl;

@WebServlet("/GetPrice")
public class GetPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Read the JSON data from the request
			BufferedReader reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String json = sb.toString();

			// Parse JSON string to retrieve items
			JSONArray itemsArray = new JSONArray(json);

			// Process items (calculate total cost, update database, etc.)
			JSONArray gstArray = new JSONArray();
			ProductDAO gstObj = new ProductDAOImpl();
			double gstval = 9.0;
			for (int i = 0; i < itemsArray.length(); i++) {
				JSONObject item = itemsArray.getJSONObject(i);
				int prod_id = item.getInt("itemId");

				// Get GST for the item
				double gst = gstObj.getGst(prod_id);
				System.out.println("gst" + gst);
				double prod_price = item.getDouble("price");
				System.out.println("Price: " + prod_price);
				gstval = prod_price - (prod_price * (gst / 100));
				System.out.println("gst in getprice srevlet: " + gstval);
				// Create a JSON object to hold the product ID and GST value
				JSONObject gstObj1 = new JSONObject();
				gstObj1.put("itemId", prod_id);
				gstObj1.put("gst", gstval);

				// Add the GST object to the array
				gstArray.put(gstObj1);
			}

			// Set response content type to JSON
			response.setContentType("application/json");
			// Write the GST array to the response
			response.getWriter().write(gstArray.toString());

		} catch (JSONException e) {
			// Handle JSON parsing errors
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("Invalid JSON data: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
}