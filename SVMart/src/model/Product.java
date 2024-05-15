package model;

public class Product {
	private int pid;
	private String pname;
	private int hsnId;
	private int pcatid;
	private String image;
	private String brand;

	// Constructors
	public Product(int pid, String pname, int hsnId, int pcatid, String image, String brand) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.hsnId = hsnId;
		this.pcatid = pcatid;
		this.image = image;
		this.brand = brand;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getHsnId() {
		return hsnId;
	}

	public void setHsnId(int hsnId) {
		this.hsnId = hsnId;
	}

	public int getPcatid() {
		return pcatid;
	}

	public void setPcatid(int pcatid) {
		this.pcatid = pcatid;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}