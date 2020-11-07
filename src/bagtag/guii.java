package bagtag;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.dnd.DragGestureEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class guii extends JPanel {

	private Stream st;
	private Pectab pt;
	final static int zoomfactor = 1;
	final static float elementZoomfactor = 1f;
	final static int fontSize = 1;

	public guii(Stream st, Pectab pt) {
		this();
		this.st = st;
		this.pt = pt;
	}

	public guii() {

		setBorder(new LineBorder(Color.RED));

		setPreferredSize(new Dimension(1500, 20000));

	}

	public Stream getSt() {
		return st;
	}

	public void setSt(Stream st) {
		this.st = st;
	}

	public Pectab getPt() {
		return pt;
	}

	public void setPt(Pectab pt) {
		this.pt = pt;
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.scale(4, 4);
		g2d.drawRect(0, 0, 92 * zoomfactor, 550 * zoomfactor);
		AffineTransform oldTransform = g2d.getTransform();

		float x;
		float y;
		int width;
		int height;

		for (PectabElement pectab : pt.getPectabElementList()) {

			for (StreamElement stream : st.getStreamElementList()) {

				if (!pectab.getType().equals("I")) {

					if (pectab.getElementNo().equals(stream.getElementNo())) {

						switch (pectab.getOrientDegree()) {
						case "5":
						case "6":
						case "E":
						case "F":
						case "M":
						case "N":

							if (pectab.getOrientDegree().equals("5") || pectab.getOrientDegree().equals("6")) {

								g2d.setFont(g.getFont().deriveFont(Font.BOLD, Integer.parseInt(pectab.getHeight())));

								FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
								int stringWidth = fontMetrics.stringWidth(stream.getData());
								int stringHeight = fontMetrics.getHeight();

								g2d.translate(Integer.parseInt(pectab.getLocHorizontal()),
										Integer.parseInt(pectab.getLocVertical()));

								g2d.rotate(Math.PI);
								g2d.drawString(stream.getData(), 0, 0);
								g2d.setTransform(oldTransform);

							} else if (pectab.getOrientDegree().equals("E") || pectab.getOrientDegree().equals("F")) {

								g2d.setFont(g.getFont().deriveFont(Font.BOLD, Integer.parseInt(pectab.getHeight())));

								FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
								int stringWidth = fontMetrics.stringWidth(stream.getData());
								int stringHeight = fontMetrics.getHeight();

								g2d.translate(Integer.parseInt(pectab.getLocHorizontal()) + stringWidth / 2,
										Integer.parseInt(pectab.getLocVertical()) - stringHeight / 4);

								g2d.rotate(Math.PI);
								g2d.drawString(stream.getData(), -stringWidth / 2, +stringHeight / 4);
								g2d.setTransform(oldTransform);

//

							} else {

								g2d.setFont(g.getFont().deriveFont(Font.BOLD, Integer.parseInt(pectab.getHeight())));

								FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
								int stringWidth = fontMetrics.stringWidth(stream.getData());
								int stringHeight = fontMetrics.getHeight();

								g2d.translate(Integer.parseInt(pectab.getLocHorizontal()) + stringWidth,
										Integer.parseInt(pectab.getLocVertical()));

								g2d.rotate(Math.PI);
								g2d.drawString(stream.getData(), -stringWidth, 0);
								g2d.setTransform(oldTransform);

							}

							break;
						default:

							if (pectab.getOrientDegree().equals("1") || pectab.getOrientDegree().equals("2")) {

								g2d.setFont(g.getFont().deriveFont(Font.BOLD, Integer.parseInt(pectab.getHeight())));

								FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
								int stringWidth = fontMetrics.stringWidth(stream.getData());
								int stringHeight = fontMetrics.getHeight();

								g2d.translate(Integer.parseInt(pectab.getLocHorizontal()),
										Integer.parseInt(pectab.getLocVertical()));

								g2d.rotate(0 / Math.PI);
								g2d.drawString(stream.getData(), 0, 0);
								g2d.setTransform(oldTransform);

							} else if (pectab.getOrientDegree().equals("A") || pectab.getOrientDegree().equals("B")) {

								g2d.setFont(g.getFont().deriveFont(Font.BOLD, Integer.parseInt(pectab.getHeight())));

								FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
								int stringWidth = fontMetrics.stringWidth(stream.getData());
								int stringHeight = fontMetrics.getHeight();

								g2d.translate(Integer.parseInt(pectab.getLocHorizontal()) + stringWidth / 2,
										Integer.parseInt(pectab.getLocVertical()) - stringHeight / 4);

								g2d.rotate(0 / Math.PI);
								g2d.drawString(stream.getData(), -stringWidth / 2, +stringHeight / 4);
								g2d.setTransform(oldTransform);

							} else {

								g2d.setFont(g.getFont().deriveFont(Font.BOLD, Integer.parseInt(pectab.getHeight())));

								FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
								int stringWidth = fontMetrics.stringWidth(stream.getData());
								int stringHeight = fontMetrics.getHeight();

								g2d.translate(Integer.parseInt(pectab.getLocHorizontal()) + stringWidth,
										Integer.parseInt(pectab.getLocVertical()));

								g2d.rotate(0 / Math.PI);
								g2d.drawString(stream.getData(), -stringWidth, 0);
								g2d.setTransform(oldTransform);

							}

							break;
						}

					}
				}

			}

			// barcode kısmı
			if ((!(pectab.getCommonData() == null || pectab.getCommonData() == ""))) {

				if (pectab.getType().equals("I")) {

					for (StreamElement stream2 : st.getStreamElementList()) {

						if (pectab.getCommonData().equals(stream2.getElementNo())) {

							System.out.println("---------");

							switch (pectab.getOrientDegree()) {
							case "5":
							case "6":
							case "E":
							case "F":
							case "M":
							case "N":

								if (pectab.getOrientDegree().equals("E") || pectab.getOrientDegree().equals("F")) {

									x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
									y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
									width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
									height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;
//									g2d.fillRect((int) x, (int) y, width * (int) elementZoomfactor,
//											height * (int) elementZoomfactor);
									// g2d.drawLine((int)x + (width / 2), (int) y + (height / 2), (int)x + (width /
									// 2), 4000);
									g2d.translate(x + (width / 2), y + (height / 6));
									g2d.rotate(Math.PI);
									// g2d.setColor(Color.white);
									g2d.fillRect(-width/2 , -height /6, width * (int) elementZoomfactor,
											height * (int) elementZoomfactor);
									g2d.setTransform(oldTransform);

								} else if (pectab.getOrientDegree().equals("5")
										|| pectab.getOrientDegree().equals("6")) {

									x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
									y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
									width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
									height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

									g2d.translate(x, y + height);
									g2d.rotate(Math.PI);
									// g2d.setColor(Color.white);
									g2d.fillRect(0, -height, width * (int) elementZoomfactor,
											height * (int) elementZoomfactor);
									g2d.setTransform(oldTransform);

								} else {

									x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
									y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
									width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
									height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

									g2d.translate(x + width, y + height);
									g2d.rotate(Math.PI);
									// g2d.setColor(Color.white);
									g2d.fillRect(-width, 0, width * (int) elementZoomfactor,
											height * (int) elementZoomfactor);
									g2d.setTransform(oldTransform);

								}

								break;

							case "3":
							case "4":
							case "C":
							case "D":
							case "K":
							case "L":

								if (pectab.getOrientDegree().equals("C") || pectab.getOrientDegree().equals("D")) {

									x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
									y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
									width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
									height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

									g2d.translate(x + (width / 2), y + (height / 2));
									g2d.rotate(Math.PI / 2);
									// g2d.setColor(Color.white);
									g2d.fillRect(-width / 2, -height / 2, width * (int) elementZoomfactor,
											height * (int) elementZoomfactor);
									g2d.setTransform(oldTransform);

								} else if (pectab.getOrientDegree().equals("3")
										|| pectab.getOrientDegree().equals("4")) {

									// 4. barcode du çiziyor yanliş olabilir.

									x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
									y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
									width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
									height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

//									g2d.fillRect((int)x, (int)y, width * (int) elementZoomfactor,
//											height * (int) elementZoomfactor);

									g2d.translate(x, y);
									g2d.rotate(Math.PI / 2);
									// g2d.setColor(Color.white);
									g2d.fillRect(0, 0, width * (int) elementZoomfactor,
											height * (int) elementZoomfactor);
									g2d.setTransform(oldTransform);

								} else {

									x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
									y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
									width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
									height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

									g2d.translate(x + width, y + height);
									g2d.rotate(Math.PI / 2);
									// g2d.setColor(Color.white);
									g2d.fillRect(-width, 0, width * (int) elementZoomfactor,
											height * (int) elementZoomfactor);
									g2d.setTransform(oldTransform);

								}

								break;
							case "7":
							case "8":
							case "G":
							case "H":
							case "O":
							case "P":

								if (pectab.getOrientDegree().equals("G") || pectab.getOrientDegree().equals("H")) {

									x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
									y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
									width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
									height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

									g2d.translate(x + (width / 2), y + (height / 2));
									g2d.rotate(Math.PI * 3 / 2);
									// g2d.setColor(Color.white);
									g2d.fillRect(-width / 2, -height / 2, width * (int) elementZoomfactor,
											height * (int) elementZoomfactor);
									g2d.setTransform(oldTransform);

								} else if (pectab.getOrientDegree().equals("7")
										|| pectab.getOrientDegree().equals("8")) {

									x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
									y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
									width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
									height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

									g2d.translate(x, y + height);
									g2d.rotate(Math.PI * 3 / 2);
									// g2d.setColor(Color.white);
									g2d.fillRect(0, -height, width * (int) elementZoomfactor,
											height * (int) elementZoomfactor);
									g2d.setTransform(oldTransform);

								} else {

									// saga yatık olan sondan 1. barcode-------

									x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
									y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
									width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
									height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;
									

									g2d.translate(x + width, y + height);
									g2d.rotate(Math.PI  / 2);
									// g2d.setColor(Color.white);
									g2d.fillRect( -width, -height, width * (int) elementZoomfactor,
											height * (int) elementZoomfactor);
									g2d.setTransform(oldTransform);

								}

								break;
							default:

								if (pectab.getOrientDegree().equals("A") || pectab.getOrientDegree().equals("B")) {

									x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
									y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
									width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
									height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

									g2d.translate(x + (width / 2), y + (height / 2));
									g2d.rotate(0 / Math.PI);
									// g2d.setColor(Color.white);
									g2d.fillRect(-width / 2, -height / 2, width * (int) elementZoomfactor,
											height * (int) elementZoomfactor);
									g2d.setTransform(oldTransform);

								} else if (pectab.getOrientDegree().equals("1")
										|| pectab.getOrientDegree().equals("2")) {

									x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
									y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
									width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
									height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

									g2d.translate(x, y + height);
									g2d.rotate(0);
									// g2d.setColor(Color.white);
									g2d.fillRect(0, -height, width * (int) elementZoomfactor,
											height * (int) elementZoomfactor);
									g2d.setTransform(oldTransform);

								} else {

									x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
									y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
									width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
									height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

									g2d.translate(x + width, y + height);
									g2d.rotate(0);
									// g2d.setColor(Color.white);
									g2d.fillRect(-width, 0, width * (int) elementZoomfactor,
											height * (int) elementZoomfactor);
									g2d.setTransform(oldTransform);
								}
								break;

							}

						}

					}

				} else if (pectab.getType().equals("C")) {

					for (StreamElement stream4 : st.getStreamElementList()) {

						if (pectab.getCommonData().equals(stream4.getElementNo())) {

							switch (pectab.getOrientDegree()) {
							case "5":
							case "6":
							case "E":
							case "F":
							case "M":
							case "N":

								if (pectab.getOrientDegree().equals("5") || pectab.getOrientDegree().equals("6")) {

									g2d.setFont(
											g.getFont().deriveFont(Font.BOLD, Integer.parseInt(pectab.getHeight())));

									FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
									int stringWidth = fontMetrics.stringWidth(stream4.getData());
									int stringHeight = fontMetrics.getHeight();

									g2d.translate(Integer.parseInt(pectab.getLocHorizontal()),
											Integer.parseInt(pectab.getLocVertical()));

									g2d.rotate(Math.PI);
									g2d.drawString(stream4.getData(), 0, 0);
									g2d.setTransform(oldTransform);

								} else if (pectab.getOrientDegree().equals("E")
										|| pectab.getOrientDegree().equals("F")) {

									g2d.setFont(
											g.getFont().deriveFont(Font.BOLD, Integer.parseInt(pectab.getHeight())));

									FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
									int stringWidth = fontMetrics.stringWidth(stream4.getData());
									int stringHeight = fontMetrics.getHeight();

									g2d.translate(Integer.parseInt(pectab.getLocHorizontal()) + stringWidth / 2,
											Integer.parseInt(pectab.getLocVertical()) - stringHeight / 4);

									g2d.rotate(Math.PI);
									g2d.drawString(stream4.getData(), -stringWidth / 2, +stringHeight / 4);
									g2d.setTransform(oldTransform);

								} else {

									g2d.setFont(
											g.getFont().deriveFont(Font.BOLD, Integer.parseInt(pectab.getHeight())));

									FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
									int stringWidth = fontMetrics.stringWidth(stream4.getData());
									int stringHeight = fontMetrics.getHeight();

									g2d.translate(Integer.parseInt(pectab.getLocHorizontal()) + stringWidth,
											Integer.parseInt(pectab.getLocVertical()));

									g2d.rotate(Math.PI);
									g2d.drawString(stream4.getData(), -stringWidth, 0);
									g2d.setTransform(oldTransform);

								}

								break;

							default:

								if (pectab.getOrientDegree().equals("1") || pectab.getOrientDegree().equals("2")) {

									g2d.setFont(
											g.getFont().deriveFont(Font.BOLD, Integer.parseInt(pectab.getHeight())));

									FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
									int stringWidth = fontMetrics.stringWidth(stream4.getData());
									int stringHeight = fontMetrics.getHeight();

									g2d.translate(Integer.parseInt(pectab.getLocHorizontal()),
											Integer.parseInt(pectab.getLocVertical()));

									g2d.rotate(0 / Math.PI);
									g2d.drawString(stream4.getData(), 0, 0);
									g2d.setTransform(oldTransform);

								} else if (pectab.getOrientDegree().equals("A")
										|| pectab.getOrientDegree().equals("B")) {

									g2d.setFont(
											g.getFont().deriveFont(Font.BOLD, Integer.parseInt(pectab.getHeight())));

									FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
									int stringWidth = fontMetrics.stringWidth(stream4.getData());
									int stringHeight = fontMetrics.getHeight();

									g2d.translate(Integer.parseInt(pectab.getLocHorizontal()) + stringWidth / 2,
											Integer.parseInt(pectab.getLocVertical()) - stringHeight / 4);

									g2d.rotate(0 / Math.PI);
									g2d.drawString(stream4.getData(), -stringWidth / 2, +stringHeight / 4);
									g2d.setTransform(oldTransform);

								} else {

									g2d.setFont(
											g.getFont().deriveFont(Font.BOLD, Integer.parseInt(pectab.getHeight())));

									FontMetrics fontMetrics = g.getFontMetrics(g.getFont());
									int stringWidth = fontMetrics.stringWidth(stream4.getData());
									int stringHeight = fontMetrics.getHeight();

									g2d.translate(Integer.parseInt(pectab.getLocHorizontal()) + stringWidth,
											Integer.parseInt(pectab.getLocVertical()));

									g2d.rotate(0 / Math.PI);
									g2d.drawString(stream4.getData(), -stringWidth, 0);
									g2d.setTransform(oldTransform);

								}

								break;

							}

						}

					}

				}
			} else if (pectab.getType().equals("I") && pectab.getElementNo().equals("02")) {

				for (StreamElement stream3 : st.getStreamElementList()) {

					if (pectab.getElementNo().equals(stream3.getElementNo())) {

						switch (pectab.getOrientDegree()) {
						case "5":
						case "6":
						case "E":
						case "F":
						case "M":
						case "N":
							// en alttaki barcode sıkıntısız 180 derece
							if (pectab.getOrientDegree().equals("E") || pectab.getOrientDegree().equals("F")) {

								x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
								y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
								width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
								height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;
								
								//System.out.println("fsdıofusdıofusıofjsdfsdfsdfsdfsdfsdfsdfsdf");

								g2d.translate(x + (width / 2), y + (height / 10));
								g2d.rotate(Math.PI);
								// g2d.setColor(Color.white);
								g2d.fillRect(-width / 2, -height /10, width * (int) elementZoomfactor,
										height * (int) elementZoomfactor);
								g2d.setTransform(oldTransform);

							} else if (pectab.getOrientDegree().equals("5") || pectab.getOrientDegree().equals("6")) {

								x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
								y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
								width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
								height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

								g2d.translate(x, y + height);
								g2d.rotate(Math.PI);
								// g2d.setColor(Color.white);
								g2d.fillRect(0, -height, width * (int) elementZoomfactor,
										height * (int) elementZoomfactor);
								g2d.setTransform(oldTransform);

							} else {

								x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
								y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
								width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
								height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

								g2d.translate(x + width, y + height);
								g2d.rotate(Math.PI);
								// g2d.setColor(Color.white);
								g2d.fillRect(-width, -height, width * (int) elementZoomfactor,
										height * (int) elementZoomfactor);
								g2d.setTransform(oldTransform);

							}

							break;

						case "3":
						case "4":
						case "C":
						case "D":
						case "K":
						case "L":

							// en alttaki barcode sıkıntısız 90 derece

							if (pectab.getOrientDegree().equals("C") || pectab.getOrientDegree().equals("D")) {

								x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
								y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
								width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
								height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

								g2d.translate(x + (width / 2), y + (height / 2));
								g2d.rotate(Math.PI / 2);
								// g2d.setColor(Color.white);
								g2d.fillRect(-width / 2, -height / 2, width * (int) elementZoomfactor,
										height * (int) elementZoomfactor);
								g2d.setTransform(oldTransform);

							} else if (pectab.getOrientDegree().equals("3") || pectab.getOrientDegree().equals("4")) {

								x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
								y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
								width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
								height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

								g2d.translate(x, y + height);
								g2d.rotate(Math.PI / 2);
								// g2d.setColor(Color.white);
								g2d.fillRect(0, -height, width * (int) elementZoomfactor,
										height * (int) elementZoomfactor);
								g2d.setTransform(oldTransform);

							} else {

								x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
								y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
								width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
								height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

								g2d.translate(x + width, y + height);
								g2d.rotate(Math.PI / 2);
								// g2d.setColor(Color.white);
								g2d.fillRect(-width, -height, width * (int) elementZoomfactor,
										height * (int) elementZoomfactor);
								g2d.setTransform(oldTransform);

							}

							break;
						// bulunmuyor 270 dereceli barcode
						case "7":
						case "8":
						case "G":
						case "H":
						case "O":
						case "P":

							if (pectab.getOrientDegree().equals("G") || pectab.getOrientDegree().equals("H")) {

								x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
								y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
								width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
								height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

								g2d.translate(x + (width / 2), y + (height / 2));
								g2d.rotate(Math.PI * 3 / 2);
								// g2d.setColor(Color.white);
								g2d.fillRect(-width / 2, -height / 2, width * (int) elementZoomfactor,
										height * (int) elementZoomfactor);
								g2d.setTransform(oldTransform);

							} else if (pectab.getOrientDegree().equals("7") || pectab.getOrientDegree().equals("8")) {

								x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
								y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
								width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
								height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

								g2d.translate(x, y + height);
								g2d.rotate(Math.PI * 3 / 2);
								// g2d.setColor(Color.white);
								g2d.fillRect(0, -height, width * (int) elementZoomfactor,
										height * (int) elementZoomfactor);
								g2d.setTransform(oldTransform);

							} else {

								x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
								y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
								width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
								height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

								g2d.translate(x + width, y + height);
								g2d.rotate(Math.PI * 3 / 2);
								// g2d.setColor(Color.white);
								g2d.fillRect(-width, -height, width * (int) elementZoomfactor,
										height * (int) elementZoomfactor);
								g2d.setTransform(oldTransform);
								// bulunmuyor 0 dereceli barcode
								x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
								y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;

								g2d.fillRect((int) x, (int) y,
										Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor,
										Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor);

								// g2d.drawString("0 derece", 0, 0);
							}

							break;
						default:

							if (pectab.getOrientDegree().equals("A") || pectab.getOrientDegree().equals("B")) {

								x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
								y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
								width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
								height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

								g2d.translate(x + (width / 2), y + (height / 2));
								g2d.rotate(0);
								// g2d.setColor(Color.white);
								g2d.fillRect(-width / 2, -height / 2, width * (int) elementZoomfactor,
										height * (int) elementZoomfactor);
								g2d.setTransform(oldTransform);

							} else if (pectab.getOrientDegree().equals("1") || pectab.getOrientDegree().equals("2")) {

								x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
								y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
								width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
								height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

								g2d.translate(x, y + height);
								g2d.rotate(0);
								// g2d.setColor(Color.white);
								g2d.fillRect(0, -height, width * (int) elementZoomfactor,
										height * (int) elementZoomfactor);
								g2d.setTransform(oldTransform);

							} else {

								x = Float.parseFloat(pectab.getLocHorizontal()) * elementZoomfactor;
								y = Float.parseFloat(pectab.getLocVertical()) * elementZoomfactor;
								width = Integer.parseInt(pectab.getWidth()) * (int) elementZoomfactor;
								height = Integer.parseInt(pectab.getHeight()) * (int) elementZoomfactor;

								g2d.translate(x + width, y + height);
								g2d.rotate(0);
								// g2d.setColor(Color.white);
								g2d.fillRect(-width, -height, width * (int) elementZoomfactor,
										height * (int) elementZoomfactor);
								g2d.setTransform(oldTransform);
							}
							break;

//										

						}

					} else {
					}

				}
			}
		}
	}
}
