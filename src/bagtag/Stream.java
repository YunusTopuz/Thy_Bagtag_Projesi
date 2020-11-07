package bagtag;

import java.util.ArrayList;
import java.util.List;

public class Stream {
	private String ElementNo;
	private String Data;
	private List<StreamElement> streamElementList = new ArrayList<StreamElement>();

	public Stream(String elementNo, String data) {

		this.ElementNo = elementNo;
		this.Data = data;

	}

	public Stream() {

	}

	public List<StreamElement> getStreamElementList() {
		return streamElementList;
	}

	public void setStreamElementList(List<StreamElement> streamElementList) {
		this.streamElementList = streamElementList;
	}

	public String getElementNo() {
		return ElementNo;
	}

	public void setElementNo(String elementNo) {
		this.ElementNo = elementNo;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		this.Data = data;
	}

	public static Stream parse(String stream) {
		Stream st = new Stream();
		String[] streamArray = stream.split("\\_");

		for (int i = 0; i < streamArray.length; i++) {

			StreamElement temp = StreamElement.parse(streamArray[i]);
			st.getStreamElementList().add(temp);
		}

		return st;

	}

	@Override
	public String toString() {
		return "Stream [ElementNo=" + ElementNo + ", Data=" + Data + ", streamElementList=" + streamElementList + "]";
	}

}
