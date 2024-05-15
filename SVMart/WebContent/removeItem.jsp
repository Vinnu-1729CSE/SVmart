<%@ page import="model.Cart" %>
<%@ page import="java.util.*" %>
<%@ page import="model.CartItem" %>

<%@ page contentType="text/plain;charset=UTF-8" language="java" %>
<%
    String itemId = request.getParameter("itemId");
    HttpSession session1 = request.getSession();
    Cart cart = (Cart) session1.getAttribute("cart");

    if (cart != null) {
        List<CartItem> items = cart.getItems();
        items.removeIf(item -> String.valueOf(item.getId()).equals(itemId));
    }

    // Respond to the client (you can send back a success message or any relevant response)
    response.getWriter().write("Item removed successfully");
%>

