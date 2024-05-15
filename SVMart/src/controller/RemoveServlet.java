package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.CartItem;

/**
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String itemId = request.getParameter("pid");
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			// If cart doesn't exist in session, create a new one
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		List<CartItem> items = cart.getItems();

		// Iterate through the items in the cart
		Iterator<CartItem> iterator = items.iterator();
		while (iterator.hasNext()) {
			CartItem cartItem = iterator.next();
			String dbid = String.valueOf(cartItem.getId());

			if (dbid.equals(itemId)) {
				// If item ID matches, remove the item from the cart
				iterator.remove(); // Remove the current item from the list
				break; // Exit the loop since item is found and removed
			}
		}

		// Update the session attribute with the modified cart
		session.setAttribute("cart", cart);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
