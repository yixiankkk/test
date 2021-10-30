package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbmgmt.ExecuteDB;
import model.Score;

public class Scoredao {
	private ExecuteDB myExecuteDB;

	// 构造函数，初始化数据
	public Scoredao() {
		myExecuteDB = new ExecuteDB();
	}

	/**
	 * 查询全部学生信息
	 * 
	 * @return 返回学生model链表
	 */
	public List<Score> QueryStdInfoAll() {
		ResultSet rs = null;
		String strSql ="select pk_score,StdNo,stdName,math_score,chinese_score,english_score,term from score";
		try {
			rs = myExecuteDB.exeQuery(strSql);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		List<Score> scorelist = new ArrayList<Score>();
		Score myScore = null;
		try {
			while (rs.next()) {
				int pk_score=rs.getInt("pk_score");
				String stdNo = rs.getString("StdNo");
				String StdName = rs.getString("stdName");
				String math_score = rs.getString("math_score");
				String chinese_score = rs.getString("chinese_score");
				String english_score = rs.getString("english_score");
				String term = rs.getString("term");
				
				myScore = new Score();
				myScore.setPk_score(pk_score);
				myScore.setStdNo(stdNo);
				myScore.setStdName(StdName);
				myScore.setMath_score(math_score);
				myScore.setChinese_score(chinese_score);
				myScore.setEnglish_score(english_score);
				myScore.setTerm(term);
			

				scorelist.add(myScore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			myExecuteDB.closedbobj();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return scorelist;
	}

	// 查询全部学生信息，返回结果集
	public ResultSet show_all_StdInfo() {
		ResultSet rs = null;
		String strSql = "select pk_score,StdNo,stdName,math_score,chinese_score,english_score,term from score";
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
	public List<Score> QueryStdInfobyid(String stdNo) {
		List<Score> scorelist = new ArrayList<Score>();
		ResultSet rs = null;
		String strSql = "select pk_score,stdNo,stdName,math_score,chinese_score,english_score,term from score where stdNo='" + stdNo + "'";
		System.out.println(strSql);
		try {
			rs = myExecuteDB.exeQuery(strSql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Score myScore = null;
		try {
			while (rs.next()) {
				// String stdNo = rs.getString("stdNo");
				int pk_score=rs.getInt("pk_score");
				String StdName = rs.getString("StdName");
				String math_score = rs.getString("math_score");
				String chinese_score = rs.getString("chinese_score");
				String english_score = rs.getString("english_score");
				String term = rs.getString("term");
				
				myScore = new Score();
				myScore.setPk_score(pk_score);
				myScore.setStdNo(stdNo);
				myScore.setStdName(StdName);
				myScore.setMath_score(math_score);
				myScore.setChinese_score(chinese_score);
				myScore.setEnglish_score(english_score);
				myScore.setTerm(term);
				scorelist.add(myScore);
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

		return scorelist;
	}

	// 返回指定条件的记录信息结果集
	public ResultSet show_StdInfobyid(String stdNo) {
		ResultSet rs = null;
		String strSql = "select pk_score,stdNo,stdName,math_score,chinese_score,english_score,term from score where stdNo='" + stdNo + "'";
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

	// 执行添加、更新、删除成绩记录的sql语句，以满足特定需求。
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
	 * 对model对相应的数据库记录进行更新，其中学号，编号不能更改
	 * 
	 * @param myScore
	 * @return
	 */
	public boolean updateStdinfobyid(Score myScore) {
		boolean succ = false;
		String strSql = "update score set stdName='" + myScore.getStdName() 
				+ "',math_score="+ myScore.getMath_score() 
				+ ",chinese_score='" + myScore.getChinese_score() 
				+"',english_score="+ myScore.getEnglish_score() 
				+"',term="+ myScore.getTerm() 
				+"' where stdNo='"
				+ myScore.getStdNo() + "'";
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
	public boolean addStdInfo(Score myScore) throws Exception {
		String myfsql = "insert into score (pk_score,stdNo,stdName,math_score,chinese_score,english_score,term) values('" +myScore.getPk_score()+ "','" + myScore.getStdNo()+ "','" +
				myScore.getStdName()+ "','" +myScore.getMath_score()+ "','" +myScore.getChinese_score()+ "','" +myScore.getEnglish_score()
				+ "','" + myScore.getTerm() + "')";
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
	public int CheckRepeatRcd(Score myScore) throws Exception {
		int reCrdNumber = 0;
		String strSql = "";
		strSql = "select count(*) as reCrdNumber from score where stdNo='" + myScore.getStdNo()
				+ "' and StdName='" + myScore.getStdName() 
				+ "' and math_score='" + myScore.getMath_score()
				+ "' and chinese_score='" + myScore.getChinese_score() 
				+ "' and english_score='" + myScore.getEnglish_score()
				+ "' and term='" + myScore.getTerm() + "'";
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
	public boolean DeleteStdInfo(Score myScore) throws Exception {
		String myfsql = "delete from score where stdNo='" + myScore.getStdNo() + "'";
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
		String myfsql = "delete from score where stdNo='" + StdNo + "'";
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
