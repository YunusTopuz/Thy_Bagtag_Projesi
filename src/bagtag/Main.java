package bagtag;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RepaintManager;

import org.springframework.util.StringUtils;

import spring.PectabEntity;

//import pectab.Gui;

public class Main {

	public static void main(String[] args) {

		//String pectab = "BTT0100[F0510233=_02I1 E526251041_03C0 E531250402_04C0 5489430302_05C0 5315361207_06C0 A197301006_07C0 A217301006_08C0 A237301006_09C0 1190050503_0AC0 1212050503_0BC0 1231050503_0CC0 I190480302_0DC0 I212480302_0EC0 I231480302_0FC0 5494430302_10C0 M301070302_11C0 1262350302_12C0 E306250302_13C0 5504430201_14C0 5501430201_15C0 5498430201_16C0 5301440302_17C0 1254250302_18C0 A043250202=02_19C0 A027250202=02_20C0 A011250202=02_21C0 5494250302=11_22I1 A035250741=02_23C0 I032450201=03_24C0 1032050201=0F_29I1 A003250741=02_30C0 I000450201=03_31C0 1000050201=0F_34C0 K177030302_35C0 3342030302=34_36I1 A019250741=02_37C0 I016450201=03_38C0 1016050201=0F_40C0 E515250202=02_41C0 K167500302_42C0 K357480302=41_43C0 5508430201_44C0 5511430201_45C0 1248150302=44_46C0 1266050302=02_50C0 1224050502_51C0 1204050502_52C0 1246050502_81I1 A136255041=02_82I1 3082515141=02_84C0 1262050302=03_85C0 1258050302=04_86I1 E382255041=02_87I1 O397015141=02_8FC0 1254050302=0F_A0S0 A302260850_A1S0 A210260850_A2S0 A229260850_A3S0 A252260850_A4S0 A317260850_A5C0 A284251006_A6C0 A272250806_A7C0 E465250402_A8C0 E483250402_A9C0 A052250402_B5C0 B284251006_B6C0 A272250402_B7C0 F465250804_B9C0 B057250804_";
		//String pectab = "BTT0100[F0510233=_02I1 E529251041_03C0 E534250402_04C0 5492430302_05C0 5318361207_06C0 A200301006_07C0 A220301006_08C0 A240301006_09C0 1193050503_0AC0 1215050503_0BC0 1234050503_0CC0 I193480302_0DC0 I215480302_0EC0 I234480302_0FC0 5497430302_10C0 M304070302_11C0 1265350302_12C0 E309250302_13C0 5507430201_14C0 5504430201_15C0 5501430201_16C0 5304440302_17C0 1257250302_18C0 A046250202=02_19C0 A030250202=02_20C0 A014250202=02_21C0 5497250302=11_22I1 A038250741=02_23C0 I035450201=03_24C0 1035050201=0F_29I1 A006250741=02_30C0 I003450201=03_31C0 1003050201=0F_34C0 K180030302_35C0 3345030302=34_36I1 A022250741=02_37C0 I019450201=03_38C0 1019050201=0F_40C0 E518250202=02_41C0 K170500302_42C0 K360480302=41_43C0 5511430201_44C0 5514430201_45C0 1251150302=44_46C0 1269050302=02_50C0 1227050502_51C0 1207050502_52C0 1249050502_81I1 A139255041=02_82I1 3085515141=02_84C0 1265050302=03_85C0 1261050302=04_86I1 E385255041=02_87I1 O400015141=02_8FC0 1257050302=0F_A0S0 A305260850_A1S0 A213260850_A2S0 A232260850_A3S0 A255260850_A4S0 A320260850_A5C0 A287251006_A6C0 A275250806_A7C0 E468250402_A8C0 E486250402_A9C0 A055250402_B5C0 B287251006_B6C0 A275250402_B7C0 F468250804_B9C0 B060250804_";
		DB a = new DB();
//		System.out.println(a.pectabGetir());
		DB b = new DB();
		Pectab pt = Pectab.parse(a.pectabGetir());
		System.out.println(pt);
		//String stream = "020235653345_03TK 653345_04CULLEN   MOIRAANN _05073_06_07IST_08MBA_09_0ATK 1988_0BTK 675_0C_0D27OCT_0E27OCT_0FTBBUJU_1011D_112/1_12_14IST-TK 1988/27_15MBA-TK 675/27_161._1727OCT/LHR/SC_34_41_43LHR/SC 27OCT_44MBA-MOMBASA_50VIA_52TO_A5TURKISH_A6AIRLINES_A7TURKISH AIRLINES_A8TURKISH AIRLINES_A9TURKISH AIRLINES";
		Stream st = Stream.parse(b.streamGetir());
		System.out.println(st);
		JFrame f = new JFrame("BAGTAG");
		f.setLayout(new BorderLayout());
		JScrollPane scroll = new JScrollPane(new guii(st, pt));
		// f.getContentPane().setLayout(new BorderLayout());
		f.add(scroll);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 500);
		f.setVisible(true);
		
//		JFrame f = new JFrame("BOARDING PASS");
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setSize(1500, 1000);
//		f.setVisible(true);
//		Gui g = new Gui(st, pt);
//		
//		f.add(g);

	}

}
