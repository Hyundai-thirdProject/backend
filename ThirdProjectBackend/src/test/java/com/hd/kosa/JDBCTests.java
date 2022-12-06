package com.hd.kosa;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;


@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}// end static

	@Test
	public void TestConnection() {
	
		Connection con = null;
		try {
			String url = 
			"jdbc:log4jdbc:oracle:thin:@dgdg_high?TNS_ADMIN=C:\\Dev\\OracleWallet\\Wallet_dgdg";
			String uid = "dgdg";
			String pwd = "EndrkEndrkvmfhwprxm1123";
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, pwd);
			System.out.println(con);
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} // end try	
			
	}//end test
}// end class