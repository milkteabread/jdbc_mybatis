package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertTest {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	
		String userid = "SCOTT";
		String passwd = "TIGER";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection( url, userid , passwd );
			String sql = "insert into dept (deptno,dname, loc)"
						+ " values( ?, ?, ?)"; //? 는 바인딩 변수로써 나중에 값을 설정한다	
			pstmt = con.prepareStatement(sql);
			// ? 대신에 값 설정하기
			/*
			 * 	pstmt.setXXX(?위치, 값)
			 */
			pstmt.setInt(1,11);
			pstmt.setString(2,"개발");
			pstmt.setString(3, "서울");
			
			int num = pstmt.executeUpdate();
			System.out.println("레코드 생성갯수:" + num);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//역순
				if(pstmt != null)pstmt.close();
				if(con != null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			
	}

}


