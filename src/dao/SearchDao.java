package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbmgmt.ExecuteDB;
import model.Union;
import dbmgmt.ExecuteDB;


public class SearchDao {
	
	private ExecuteDB myExecuteDB;

		// 构造函数，初始化数据
	public SearchDao() {
		myExecuteDB = new ExecuteDB();
	}

	public List<Union> Selectage(int Age) throws Exception
	{
		ResultSet rs = null;
		List<Union> se=new ArrayList<Union>();
		Union myunion=null;
		String strSql ="select * from studentbasicinfo JOIN score on studentbasicinfo.stdName=score.stdName where StdAge<'"+Age+"'";
		try {
			rs = myExecuteDB.exeQuery(strSql);
		} catch (Exception e) {
				
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int pk_score=rs.getInt("pk_score");
				String stdNo = rs.getString("stdNo");
				String StdName = rs.getString("stdName");
				String math_score = rs.getString("math_score");
				String chinese_score = rs.getString("chinese_score");
				String english_score = rs.getString("english_score");
				String term = rs.getString("term");
				int stdAge=rs.getInt("stdAge");
				
				myunion = new Union();
				myunion.setPk_score(pk_score);
				myunion.setStdNo(stdNo);
				myunion.setStdName(StdName);
				myunion.setMath_score(math_score);
				myunion.setChinese_score(chinese_score);
				myunion.setEnglish_score(english_score);
				myunion.setTerm(term);
				myunion.setStdAge(stdAge);

				se.add(myunion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			myExecuteDB.closedbobj();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		
		return se;
	}
}
