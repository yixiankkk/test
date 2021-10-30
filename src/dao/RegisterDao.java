package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import dbmgmt.ExecuteDB;
import model.User;

public class RegisterDao {

	private ExecuteDB myExecuteDB;

	// 构造函数，初始化数据
	public RegisterDao() {
		myExecuteDB = new ExecuteDB();
	}
	public int CheckRepeatRcd(User myuser) throws Exception {
		int reCrdNumber = 0;
		String strSql = "";
		strSql = "select count(*) as reCrdNumber from tuser where Uname='" + myuser.getUname()
				+ "' and Upwd='" + myuser.getUpwd() + "'";
		System.out.println(strSql);
		ExecuteDB myExecuteDB = new ExecuteDB();
		ResultSet rs = null;
		rs = myExecuteDB.exeQuery(strSql);
		try {
			while (rs.next()) {
				reCrdNumber = rs.getInt("reCrdNumber");
			}
			System.out.println("reCrdNumber:" + reCrdNumber);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		//关闭数据库对象
		try {
			myExecuteDB.closedbobj();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reCrdNumber;
	}
	public boolean addStdInfo(User myuser) throws Exception {
		String myfsql = "insert into tuser (Uname,Upwd) values('" +myuser.getUname()+ "','" + myuser.getUpwd()+ "')";
		System.out.println(myfsql);

		boolean succ = false;

		// 没有做关键字重复性检查，根据关键字检查是否重复。
		try {
			succ = myExecuteDB.updateSql(myfsql);
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
		//关闭数据库对象
		try {
			myExecuteDB.closedbobj();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return succ;
	}
}
