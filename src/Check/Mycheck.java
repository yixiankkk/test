package Check;

public class Mycheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 检查年龄范围是否在10-25
	 * @param age
	 * @return 超出范围返回0，在年龄范围内返回1
	 */
	public int checkstdAge(int age){
		if(age<10||age>25){
			//年龄不在10-25之间
			return 0;
		}
		return 1;
	}

}
