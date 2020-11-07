package spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.PectabEntity;
import spring.PectabRegister;

@RestController
public class PostPectabController {
	@RequestMapping(value = "/postBagtag", method = RequestMethod.POST)
	public ResponseEntity<PectabRegister> postPectab(@RequestBody PectabEntity pectabEntity) {
		
		PectabRegister register = new PectabRegister();
		register.setPectab(pectabEntity);
		
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection(
					"jdbc:h2:~/test", "root", "root");
			String sql = "INSERT INTO SPRING(PECTAB,STREAM) VALUES(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, pectabEntity.getPectab());
			ps.setString(2, pectabEntity.getStream());
			ps.executeUpdate();
			register.setRegisterResult("Kayit Basariyla Eklendi");

		} catch (ClassNotFoundException | SQLException exception) {
			register.setRegisterResult("Kayit Sirasinda Bir Hata Meydana Geldi! " + exception);
			exception.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		return new ResponseEntity<PectabRegister>(register, HttpStatus.OK);
	}
}
