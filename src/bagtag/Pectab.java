package bagtag;

import java.util.ArrayList;
import java.util.List;

public class Pectab {

	private String header;
	private String tableNo;
	private String tableVersion;
	private String contChar;
	private String fieldLength;
	private String colourChar;
	private String width;
	private String mirrorPoint;
	private String refChar;
	private String Separator;
	private List<PectabElement> pectabElementList = new ArrayList<PectabElement>();

	public Pectab() {

	}

	public Pectab(String header, String tableNo, String tableVersion, String contChar, String fieldLength,
			String colourChar, String width, String mirrorPoint, String refChar, String separator) {
		this.header = header;
		this.tableNo = tableNo;
		this.tableVersion = tableVersion;
		this.contChar = contChar;
		this.fieldLength = fieldLength;
		this.colourChar = colourChar;
		this.width = width;
		this.mirrorPoint = mirrorPoint;
		this.refChar = refChar;
		Separator = separator;
	}

	public List<PectabElement> getPectabElementList() {
		return pectabElementList;
	}

	public void setPectabElementList(List<PectabElement> pectabElementList) {
		this.pectabElementList = pectabElementList;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getTableNo() {
		return tableNo;
	}

	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}

	public String getTableVersion() {
		return tableVersion;
	}

	public void setTableVersion(String tableVersion) {
		this.tableVersion = tableVersion;
	}

	public String getContChar() {
		return contChar;
	}

	public void setContChar(String contChar) {
		this.contChar = contChar;
	}

	public String getFieldLength() {
		return fieldLength;
	}

	public void setFieldLength(String fieldLength) {
		this.fieldLength = fieldLength;
	}

	public String getColourChar() {
		return colourChar;
	}

	public void setColourChar(String colourChar) {
		this.colourChar = colourChar;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getMirrorPoint() {
		return mirrorPoint;
	}

	public void setMirrorPoint(String mirrorPoint) {
		this.mirrorPoint = mirrorPoint;
	}

	public String getRefChar() {
		return refChar;
	}

	public void setRefChar(String refChar) {
		this.refChar = refChar;
	}

	public String getSeparator() {
		return Separator;
	}

	public void setSeparator(String separator) {
		Separator = separator;
	}

	public static Pectab parse(String pectab) {

		Pectab pt = new Pectab();

		pt.setHeader(pectab.substring(0, 3));
		pt.setTableNo(pectab.substring(3, 5));
		pt.setTableVersion(pectab.substring(5, 7));
		pt.setContChar(pectab.substring(7, 8));
		pt.setFieldLength(pectab.substring(8, 9));
		pt.setColourChar(pectab.substring(9, 10));
		pt.setWidth(pectab.substring(10, 13));
		pt.setMirrorPoint(pectab.substring(13, 16));
		pt.setRefChar(pectab.substring(16, 17));
		pt.setSeparator(pectab.substring(17, 18));

		String tempPectab = pectab.substring(18);
		System.out.println(tempPectab);
		String pectabArray[] = tempPectab.split(pt.getSeparator());

		for (int i = 0; i < pectabArray.length; i++) {
			PectabElement pte = PectabElement.parse(pectabArray[i]);
			pt.getPectabElementList().add(pte);
		}

		return pt;

	}

	@Override
	public String toString() {
		return "Pectab [header=" + header + ", tableNo=" + tableNo + ", tableVersion=" + tableVersion + ", contChar="
				+ contChar + ", fieldLength=" + fieldLength + ", colourChar=" + colourChar + ", width=" + width
				+ ", mirrorPoint=" + mirrorPoint + ", refChar=" + refChar + ", Separator=" + Separator
				+ ", pectabElementList=" + pectabElementList + "]";
	}

}
