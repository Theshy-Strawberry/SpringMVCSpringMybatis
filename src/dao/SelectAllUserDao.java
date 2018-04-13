package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import util.MySQLUtil;


public class SelectAllUserDao {
    Connection con = null;
    Statement sm = null;
    ResultSet rs  = null;
	 PreparedStatement ps = null;
	//private PreparedStatement ps = null;
	public List<User> selectall(){
		List<User> templist = new ArrayList<User>();
		try {
			con = MySQLUtil.getConnection();
			StringBuffer sql = new StringBuffer("select goods_name ,goods_sn,goods_price from ecs_change_goods ");
			sm = con.createStatement();
			rs = sm.executeQuery(sql.toString());
			while(rs.next()){
				User user = new User();
				user.setName(rs.getString(1));
				user.setPwd(rs.getString(2));
				user.setSex(rs.getString(3));
				templist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.closeAll(rs, sm, con, null);
		}
		return templist;
	}
	public List<User> selectallBykey(String key){
		List<User> templist = new ArrayList<User>();
		try {
			con = MySQLUtil.getConnection();
			StringBuffer sql = new StringBuffer("select goods_name ,goods_sn,goods_price from ecs_change_goods  where name like ?");
			ps=con.prepareStatement(sql.toString());
			ps.setString(1, "%" + key+ "%");
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setName(rs.getString(1));
				user.setPwd(rs.getString(2));
				user.setSex(rs.getString(3));
				templist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.closeAll(rs, sm, con, null);
		}
		return templist;
	}
	
	
	//  test  inter
	public List<User> testInterface(String id) {
		List<User> templist = new ArrayList<User>();
		try {
			con = MySQLUtil.getConnection();
			StringBuffer sql = new StringBuffer("select goods_id ,goods_name,goods_price from ecs_change_goods  where cid = ?");
			ps=con.prepareStatement(sql.toString());
			ps.setString(1,  id);
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setName(rs.getString(1));
				user.setPwd(rs.getString(2));
				user.setSex(rs.getString(3));
				templist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.closeAll(rs, sm, con, null);
		}
		return templist;
	}
}
