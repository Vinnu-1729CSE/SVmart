package model;

public class CartItem {
	private int id;
	private String name;
	private double price;
	private String image;
	private int quantity;
	private double gst;// Quantity of this item in the cart
	private double shipping;

	// Constructor
	public CartItem(int id, String name, double price, String image, double gst, double shipping) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.quantity = 1;
		this.gst = gst;
		this.shipping = shipping;// Initialize quantity to 1 when adding a new item to cart
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public double getShipping() {
		return shipping;
	}

	public void setShipping(double shipping) {
		this.shipping = shipping;
	}

	// Getter and setter methods for quantity
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// Other getter methods for item properties
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

}