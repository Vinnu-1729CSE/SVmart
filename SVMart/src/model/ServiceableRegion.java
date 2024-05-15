package model;

public class ServiceableRegion {
	private int srrgId;
	private String srrgName;
	private int srrgPinFrom;
	private int srrgPinTo;

	public ServiceableRegion(int srrgId, String srrgName, int srrgPinFrom, int srrgPinTo) {
		this.srrgId = srrgId;
		this.srrgName = srrgName;
		this.srrgPinFrom = srrgPinFrom;
		this.srrgPinTo = srrgPinTo;
	}

	public int getSrrgId() {
		return srrgId;
	}

	public void setSrrgId(int srrgId) {
		this.srrgId = srrgId;
	}

	public String getSrrgName() {
		return srrgName;
	}

	public void setSrrgName(String srrgName) {
		this.srrgName = srrgName;
	}

	public int getSrrgPinFrom() {
		return srrgPinFrom;
	}

	public void setSrrgPinFrom(int srrgPinFrom) {
		this.srrgPinFrom = srrgPinFrom;
	}

	public int getSrrgPinTo() {
		return srrgPinTo;
	}

	public void setSrrgPinTo(int srrgPinTo) {
		this.srrgPinTo = srrgPinTo;
	}

	@Override
	public String toString() {
		return "ServiceableRegion [srrgId=" + srrgId + ", srrgName=" + srrgName + ", srrgPinFrom=" + srrgPinFrom
				+ ", srrgPinTo=" + srrgPinTo + "]";
	}

	public int getloc() {
		// TODO Auto-generated method stub
		return 0;
	}
}
