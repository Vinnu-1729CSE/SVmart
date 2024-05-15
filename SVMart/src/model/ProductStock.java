package model;

public class ProductStock {

	private int prod_id;
	private String prod_batchno;
	private double prod_price;
	private int prod_stock; // qty available
	private double prod_mrp;

	public ProductStock(int prod_id, String prod_batchno, double prod_price, int prod_stock, double prod_mrp) {
		super();
		this.prod_id = prod_id;
		this.prod_batchno = prod_batchno;
		this.prod_price = prod_price;
		this.prod_stock = prod_stock;
		this.prod_mrp = prod_mrp;
	}

	public ProductStock(int int1, int int2) {
		// TODO Auto-generated constructor stub
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_batchno() {
		return prod_batchno;
	}

	public void setProd_batchno(String prod_batchno) {
		this.prod_batchno = prod_batchno;
	}

	public double getProd_price() {
		return prod_price;
	}

	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}

	public int getProd_stock() {
		return prod_stock;
	}

	public void setProd_stock(int prod_stock) {
		this.prod_stock = prod_stock;
	}

	public double getProd_mrp() {
		return prod_mrp;
	}

	public void setProd_mrp(double prod_mrp) {
		this.prod_mrp = prod_mrp;
	}

}
