package bagtag;

public class PectabElement {
	private String elementNo;
	private String type;
	private String fontNormal;
	private String elementMirrorFaced;
	private String orientDegree;
	private String locVertical;
	private String locHorizontal;
	private String height;
	private String width;
	private String commonData;
	private String colourChar;
	private String colorOred;

	public PectabElement(String elementNo, String type, String fontNormal, String elementMirrorFaced,
			String orientDegree, String locVertical, String locHorizontal, String height, String width,
			String commonData, String colourChar, String colorOred) {
		super();
		this.elementNo = elementNo;
		this.type = type;
		this.fontNormal = fontNormal;
		this.elementMirrorFaced = elementMirrorFaced;
		this.orientDegree = orientDegree;
		this.locVertical = locVertical;
		this.locHorizontal = locHorizontal;
		this.height = height;
		this.width = width;
		this.commonData = commonData;
		this.colourChar = colourChar;
		this.colorOred = colorOred;
	}

	public PectabElement() {

	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getElementNo() {
		return elementNo;
	}

	public void setElementNo(String elementNo) {
		this.elementNo = elementNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFontNormal() {
		return fontNormal;
	}

	public void setFontNormal(String fontNormal) {
		this.fontNormal = fontNormal;
	}

	public String getElementMirrorFaced() {
		return elementMirrorFaced;
	}

	public void setElementMirrorFaced(String elementMirrorFaced) {
		this.elementMirrorFaced = elementMirrorFaced;
	}

	public String getOrientDegree() {
		return orientDegree;
	}

	public void setOrientDegree(String orientDegree) {
		this.orientDegree = orientDegree;
	}

	public String getLocVertical() {
		return locVertical;
	}

	public void setLocVertical(String locVertical) {
		this.locVertical = locVertical;
	}

	public String getLocHorizontal() {
		return locHorizontal;
	}

	public void setLocHorizontal(String locHorizontal) {
		this.locHorizontal = locHorizontal;
	}

	public String getCommonData() {
		return commonData;
	}

	public void setCommonData(String commonData) {
		this.commonData = commonData;
	}

	public String getColourChar() {
		return colourChar;
	}

	public void setColourChar(String colourChar) {
		this.colourChar = colourChar;
	}

	public String getColorOred() {
		return colorOred;
	}

	public void setColorOred(String colorOred) {
		this.colorOred = colorOred;
	}

	public static PectabElement parse(String element) {
		PectabElement pe = new PectabElement();
		pe.setElementNo(element.substring(0, 2));
		pe.setType(element.substring(2, 3));
		pe.setFontNormal(element.substring(3, 4));
		pe.setElementMirrorFaced(element.substring(4, 5));
		pe.setOrientDegree(element.substring(5, 6));
		pe.setLocVertical(element.substring(6, 9));
		pe.setLocHorizontal(element.substring(9, 11));
		pe.setHeight(element.substring(11, 13));
		pe.setWidth(element.substring(13,15));
		if(element.length()>15) {
			pe.setCommonData(element.substring(16, 18));
		}
		
		// pe.setCommonData(element.substring(15,36));
//		pe.setColourChar(element.substring(36,38));
//		pe.setColorOred(element.substring(38,40));
		return pe;

	}

	@Override
	public String toString() {
		return "\nPectabElement [elementNo=" + elementNo + ", type=" + type + ", fontNormal=" + fontNormal
				+ ", elementMirrorFaced=" + elementMirrorFaced + ", orientDegree=" + orientDegree + ", locVertical="
				+ locVertical + ", locHorizontal=" + locHorizontal + ", height=" + height + ", width=" + width
				+ ", commonData=" + commonData + ", colourChar=" + colourChar + ", colorOred=" + colorOred + "]";
	}

}
