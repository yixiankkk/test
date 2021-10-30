package Check;

public class Scorecheck {
	public int checkstdScore(float...score){
		for(int i=0;i<score.length;i++)
		if(score[i]<0||score[i]>100){
			//成绩不在0-100之间
			return 0;
		}
		return 1;
	}
	
	public Boolean checkstdName(String name){
		
		if(name==""||name==null)
			return true;
		else 
			return false;
	}
}
