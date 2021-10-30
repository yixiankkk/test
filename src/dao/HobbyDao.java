package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbmgmt.ExecuteDB;
import model.Hobby;
import model.Student;
public class HobbyDao {

	private ExecuteDB myExecuteDB;

	// 构造函数，初始化数据
	public HobbyDao() {
		myExecuteDB = new ExecuteDB();
	}

	/**
	 * 查询全部学生信息
	 * 
	 * @return 返回学生model链表
	 */
	public List<Hobby> QueryStdInfoAll() {
		ResultSet rs = null;
		String strSql = "select StdName,StdNo,Major,Hobby from hobby";
		try {
			rs = myExecuteDB.exeQuery(strSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Hobby> Hobbylist = new ArrayList<Hobby>();
		Hobby myHobby = null;
		try {
			while (rs.next()) {
				String StdNo = rs.getString("StdNo");
				String StdName = rs.getString("StdName");
				String Major = rs.getString("Major");
				String Hobby = rs.getString("Hobby");

				myHobby = new Hobby();
				myHobby.setStdNo(StdNo);
				myHobby.setStdName(StdName);
				myHobby.setMajor(Major);
				myHobby.setHobby(Hobby);
				Hobbylist.add(myHobby);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			myExecuteDB.closedbobj();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Hobbylist;
	}

	// 查询全部学生信息，返回结果集
	public ResultSet show_all_StdInfo() {
		ResultSet rs = null;
		String strSql = "select StdName,StdNo,Major,Hobby from hobby";
		try {
			rs = myExecuteDB.exeQuery(strSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 条件查询学生信息-根据学号查询
	 * 
	 * @return 返回学生model链表
	 */
	public List<Student> QueryStdInfobyid(String stdNo) {
		List<Student> studlist = new ArrayList<Student>();
		ResultSet rs = null;
		String strSql = "select stdNo,stdName,stdAge,stdMajor from studentbasicinfo where stdNo='" + stdNo + "'";
		System.out.println(strSql);
		try {
			rs = myExecuteDB.exeQuery(strSql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Student myStudent = null;
		try {
			while (rs.next()) {
				// String stdNo = rs.getString("stdNo");
				String stdName = rs.getString("stdName");
				int stdAge = rs.getInt("stdAge");
				String stdMajor = rs.getString("stdMajor");

				myStudent = new Student();
				myStudent.setStdNo(stdNo);
				myStudent.setStdName(stdName);
				myStudent.setstdAge(stdAge);
				myStudent.setStdmajor(stdMajor);
				studlist.add(myStudent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//关闭数据库对象
		try {
			myExecuteDB.closedbobj();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return studlist;
	}

	// 返回指定条件的记录信息结果集
	public ResultSet show_StdInfobyid(String stdNo) {
		ResultSet rs = null;
		String strSql = "select stdNo,stdName,stdAge,stdMajor from studentbasicinfo where stdNo='" + stdNo + "'";
		System.out.println(strSql);
		try {
			rs = myExecuteDB.exeQuery(strSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//这种返回结果集的方式，需要在外部关闭数据库对象，容易造成泄露
//		try {
		    //关闭数据库对象
//			myExecuteDB.closedbobj();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return rs;
	}

	// 执行添加、更新、删除学生记录的sql语句，以满足特定需求。
	public boolean ExStdInfoSql(String StdInfoSql) {
		boolean succ = false;
		try {
			succ = myExecuteDB.updateSql(StdInfoSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//关闭数据库对象
		try {
			myExecuteDB.closedbobj();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return succ;
	}

	/**
	 * 对model对相应的数据库记录进行更新，其中学号不能更改
	 * 
	 * @param myStudent
	 * @return
	 */
	public boolean updateStdinfobyid(Hobby myHobby) {
		boolean succ = false;
		String strSql = "update hobby set StdName='" + myHobby.getStdName() + "',Major="
				+"'"+ myHobby.getMajor() + "'"+",Hobby='" + myHobby.getHobby() + "' where StdNo='"
				+ myHobby.getStdNo() + "'";
		System.out.println(strSql);
		try {
			succ = myExecuteDB.updateSql(strSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//关闭数据库对象
		try {
			myExecuteDB.closedbobj();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return succ;
	}

	/*
	 * // 根据学生ID更新记录 public boolean updateStdinfobyid(String stdNostr, String
	 * stdNamestr, int stdAge, String stdMajor) { boolean succ = false; String
	 * strSql = "update studentbasicinfo set stdName='" + stdNamestr +
	 * "',stdAge=" + stdAge + ",stdMajor='" + stdMajor + "' where stdNo='" +
	 * stdNostr + "'"; System.out.println(strSql); try { succ =
	 * myExecuteDB.updateSql(strSql); } catch (Exception e) {
	 * e.printStackTrace(); } return succ; }
	 */
	/**
	 * 将model插入到数据库记录中
	 * 
	 * @param myStudent
	 * @return
	 * @throws Exception
	 */
	public boolean addStdInfo(Hobby myHobby) throws Exception {
		String myfsql = "insert into hobby (StdNo,StdName,Hobby,Major) values('" + myHobby.getStdNo()
				+ "','" + myHobby.getStdName() + "','" + myHobby.getHobby() + "','" + myHobby.getMajor()
				+ "')";
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
	/*
	 * public boolean addStdInfo(String stdNostr, String StdNamestr, int stdAge,
	 * String stdMajor) throws Exception { String myfsql =
	 * "insert into studentbasicinfo (stdNo,stdName,stdAge,stdMajor) values('" +
	 * stdNostr + "','" + StdNamestr + "','" + stdAge + "','" + stdMajor + "')";
	 * System.out.println(myfsql);
	 * 
	 * boolean succ = false;
	 * 
	 * try { succ = myExecuteDB.updateSql(myfsql); } catch (Exception e) {
	 * e.printStackTrace(); throw (e); } return succ; }
	 */
	/*
	 * //和前面的ExStdInfoSql方法功能相同 public boolean addStdInfo(String addsql) {
	 * boolean succ = false; try { succ = myExecuteDB.updateSql(addsql); } catch
	 * (Exception e) { e.printStackTrace(); } return succ; }
	 */

	/**
	 * 重复记录查询
	 * 
	 * @param studnet对象
	 * @return 返回重复记录数，无重复记录返回-1
	 * @throws Exception
	 */
	public int CheckRepeatRcd(Hobby myHobby) throws Exception {
		int reCrdNumber = 0;
		String strSql = "";
		strSql = "select count(*) as reCrdNumber from hobby where StdNo='" + myHobby.getStdNo()
				+ "' and StdName='" + myHobby.getStdName() + "' and Hobby='" + myHobby.getHobby()
				+ "' and Major='" + myHobby.getMajor() + "'";
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

	/**
	 * 重复记录查询
	 * 
	 * @param stdNostr
	 * @param stdName
	 * @param stdAge
	 * @param stdMajor
	 * @return 返回重复记录数，无重复记录返回-1
	 * @throws Exception
	 */
	/*
	 * public int CheckRepeatRcd(String stdNostr, String stdName, int stdAge,
	 * String stdMajor) throws Exception { int reCrdNumber = 0; String strSql =
	 * ""; strSql =
	 * "select count(*) as reCrdNumber from studentbasicinfo where stdNo='" +
	 * stdNostr + "' and StdName='" + stdName + "' and stdAge='" + stdAge +
	 * "' and stdMajor='" + stdMajor + "'"; System.out.println(strSql);
	 * ExecuteDB myExecuteDB = new ExecuteDB(); ResultSet rs = null; rs =
	 * myExecuteDB.exeQuery(strSql); try { while (rs.next()) { reCrdNumber =
	 * rs.getInt("reCrdNumber"); } System.out.println("reCrdNumber:" +
	 * reCrdNumber); } catch (Exception e) { e.printStackTrace(); return -1; }
	 * return reCrdNumber; }
	 */
	/**
	 * 删除学生对象，根据学号删除记录
	 * 
	 * @param StdNo
	 * @return
	 * @throws Exception
	 */
	public boolean DeleteStdInfo(Hobby myHobby) throws Exception {
		String myfsql = "delete from hobby where StdNo='" + myHobby.getStdNo() + "'";
		System.out.println(myfsql);
		boolean succ = false;
		try {
			succ = myExecuteDB.updateSql(myfsql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//关闭数据库对象
		try {
			myExecuteDB.closedbobj();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return succ;
	}

	/**
	 * 根据学号删除记录
	 * 
	 * @param StdNo
	 * @return
	 * @throws Exception
	 */
	public boolean DeleteStdInfo(String StdNo) throws Exception {
		String myfsql = "delete from hobby where StdNo='" + StdNo + "'";
		System.out.println(myfsql);
		boolean succ = false;
		try {
			succ = myExecuteDB.updateSql(myfsql);
		} catch (Exception e) {
			e.printStackTrace();
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
