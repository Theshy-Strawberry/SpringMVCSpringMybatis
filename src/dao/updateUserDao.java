package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.MySQLUtil;


public class updateUserDao {
    Connection con = null;
    Statement sm = null;
    ResultSet rs  = null;
	private PreparedStatement ps = null;
	public boolean update(String name,String pwd,String sex){
		int result=0;
		try {
			con = MySQLUtil.getConnection();
			StringBuffer sql = new StringBuffer("update user set pwd=? , sex=? where name=?");
			ps = con.prepareStatement(sql.toString());
			ps.setString(3, name);
			ps.setString(1, pwd);
			ps.setString(2, sex);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.closeAll(rs, sm, con, null);
		}
		return result>0?true:false;
	}
}
