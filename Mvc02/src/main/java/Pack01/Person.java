package Pack01;
//같은 패키지 안에 있으니 import 필요없다.
public class Person{
	String id;
	int pwd;
	Person(){} // 사용하지 않아도 비어있는 생성자 만들어두기
	Person(String id, int pwd){
		this.id = id;
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	
	
}
