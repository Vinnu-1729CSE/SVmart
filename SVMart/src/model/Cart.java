package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> items;

	public Cart() {
		items = new ArrayList<>();
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void addItem(CartItem item) {
		items.add(item);
	}

	public void removeItem(int productId) {
		items.removeIf(item -> item.getId() == productId);
	}

	// Method to calculate total order value
	public double calculateTotalOrderValue() {
		double total = 0;
		for (CartItem item : items) {
			total += item.getPrice() * item.getQuantity();
		}
		return total;
	}

	// Method to calculate total shipping charges
	// public double calculateTotalShippingCharges() {
	// double totalShippingCharges = 0;
	// for (CartItem item : items) {
	// totalShippingCharges += item.getShippingCharges();
	// }
	// return totalShippingCharges;
	// }
}
