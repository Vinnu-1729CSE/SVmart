package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Cart;
import model.CartItem;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 7354596430124874293L;

	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			doPost(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get product details from request parameters
		int productId = Integer.parseInt(request.getParameter("id"));
		String productName = request.getParameter("name");
		double productPrice = Double.parseDouble(request.getParameter("price"));
		String productImage = request.getParameter("image");

		// Get PIN code entered by the user
		int enteredPin = Integer.parseInt(request.getParameter("pinCode"));
		System.out.println("entered pin is: " + enteredPin);
		ProductDAO obj;
		try {
			obj = new ProductDAOImpl();
			// get categoryid
			int productCategoryId = Integer.parseInt(request.getParameter("prodCatId"));

			// Validate the PIN code against serviceable regions
			boolean isAvailableInRegion = obj.getServiceableRegions(enteredPin, productCategoryId);
			System.out.println("servicerefgionjs: + " + isAvailableInRegion);

			if (!isAvailableInRegion) {
				// If the product is not available in the region, show an error message
				response.setContentType("text/html");
				response.getWriter().write("This product is not deliverable to your region.......");
				return;
			}
			// Get or create session
			HttpSession session = request.getSession();

			// Get the cart from session, or create a new one if it doesn't exist
			Cart cart = (Cart) session.getAttribute("cart");

			if (cart == null) {
				cart = new Cart();
				session.setAttribute("cart", cart);
			}

			// Check if the product already exists in the cart
			List<CartItem> items = cart.getItems();
			boolean productFound = false;

			for (CartItem item : items) {
				if (item.getId() == productId) {

					// Product already exists in the cart, update the quantity

					item.setQuantity(item.getQuantity() + 1); // Increment quantity
					System.out.println("q set");
					System.out.println(item.getQuantity());
					productFound = true;
					break;
				}
			}

			if (!productFound) {
				// Product does not exist in the cart, add a new item
				System.out.println("prod id: " + productId);
				double gst = obj.getGst(productId);
				System.out.println("GST in addtocart: " + gst);
				double dshipping = 0.0;
				CartItem newItem = new CartItem(productId, productName, productPrice, productImage, gst, dshipping);
				cart.addItem(newItem);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("this is cart");
		// System.out.println();
		// Send success response

		response.setContentType("text/html");
		response.getWriter().write("Product added to cart successfully.....!");

	}

}
