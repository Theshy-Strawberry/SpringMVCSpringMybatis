package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.MySQLUtil;


public class deleteUserDao {
    Connection con = null;
    Statement sm = null;
    ResultSet rs  = null;
	private PreparedStatement ps = null;
	public boolean delete(String name){
		int result=0;
		try {
			con = MySQLUtil.getConnection();
			StringBuffer sql = new StringBuffer("delete from user where name=?");
			
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, name);
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
	public boolean deletes(String name) throws SQLException{
		String []  nameList = name.split(",");
		int result=0;
		con = MySQLUtil.getConnection();
		con.setAutoCommit(false); 
		try {
			
			for(int i=0;i<nameList.length;i++){
				String para= nameList[i];
				StringBuffer sql = new StringBuffer("delete from ecs_change_goods where goods_name=?");
				ps = con.prepareStatement(sql.toString());
				ps.setString(1, para);
				result = ps.executeUpdate();
				if(result==0){
					break;
				}
			}
			if(result>0){
				con.commit();     
			}
		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			MySQLUtil.closeAll(rs, sm, con, null);
		}
		return result>0?true:false;
	}
}
