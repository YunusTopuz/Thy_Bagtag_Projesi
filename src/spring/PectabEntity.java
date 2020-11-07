package spring;

public class PectabEntity {

	private String pectab;
	private String stream;
	
	public String getPectab() {
		return pectab;
	}
	public void setPectab(String pectab) {
		this.pectab = pectab;
	}
	
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	
	public PectabEntity() {}
	
	public PectabEntity(String pectab, String stream) {
		super();
		this.pectab = pectab;
		this.stream = stream;
	}
	
	
}
