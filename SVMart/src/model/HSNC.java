package model;

public class HSNC {

	private int hsnId;
	private String hsncode;
	private double gst;

	public HSNC(int hsnId, String hsncode, double gst) {
		super();
		this.hsnId = hsnId;
		this.hsncode = hsncode;
		this.gst = gst;
	}

	public int getHsnId() {
		return hsnId;
	}

	public void setHsnId(int hsnId) {
		this.hsnId = hsnId;
	}

	public String getHsncode() {
		return hsncode;
	}

	public void setHsncode(String hsncode) {
		this.hsncode = hsncode;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

}
