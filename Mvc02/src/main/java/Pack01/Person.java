package Pack01;
//���� ��Ű�� �ȿ� ������ import �ʿ����.
public class Person{
	String id;
	int pwd;
	Person(){} // ������� �ʾƵ� ����ִ� ������ �����α�
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
