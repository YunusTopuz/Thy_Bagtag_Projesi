package bagtag;

import java.util.ArrayList;
import java.util.List;

public class StreamElement {
	private String  ElementNo ;
	private String Data;
	
	public StreamElement() {

}

	

	public StreamElement(String elementNo, String data) {
		super();
		ElementNo = elementNo;
		Data = data;
	}



	public String getElementNo() {
		return ElementNo;
	}



	public void setElementNo(String elementNo) {
		ElementNo = elementNo;
	}



	public String getData() {
		return Data;
	}



	public void setData(String data) {
		Data = data;
	}



	public static StreamElement parse(String element) {
		StreamElement ste=new StreamElement();
		ste.setElementNo(element.substring(0, 2));
		ste.setData(element.substring(2));
		
		return ste;
	}



	@Override
	public String toString() {
		return "\nStreamElement [ElementNo=" + ElementNo + ", Data=" + Data + "]";
	}
	
	
}
