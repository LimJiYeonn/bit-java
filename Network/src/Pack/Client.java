package Pack;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		System.out.println("Client Start");
		
		Socket cs = new Socket(); 
		try {
			System.out.println("���ڸ� �Է��ϸ� ������ �õ��մϴ�.");
			new Scanner(System.in).nextInt();
			// ������ �ϱ����� ���� �ֱ�
			cs.connect(new InetSocketAddress("localhost", 5001));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("���ڸ� �Է��ϸ� Ŭ���̾�Ʈ�� �����մϴ�.");
		new Scanner(System.in).nextInt();
		System.out.println("Client End");
	}
}
