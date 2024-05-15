package model;

public class ProductCatagory {
	private int pcatid;
	private String pcatname;

	public ProductCatagory(int pcatid, String pcatname) {
		// TODO Auto-generated constructor stub
		this.pcatid = pcatid;
		this.pcatname = pcatname;
	}

	public int getPcatid() {
		return pcatid;
	}

	public void setPcatid(int pcatid) {
		this.pcatid = pcatid;
	}

	public String getPcatname() {
		return pcatname;
	}

	public void setPcatname(String pcatname) {
		this.pcatname = pcatname;
	}

	@Override
	public String toString() {
		return "ProductCatagory [pcatid=" + pcatid + ", pcatname=" + pcatname + "]";
	}

}