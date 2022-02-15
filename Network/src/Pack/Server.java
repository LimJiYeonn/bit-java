package Pack;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//���� �� ������ �ޱ�
class ClientThread extends Thread{
	Socket socket;
	
	public ClientThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			byte[] recvData = new byte[512];
//			int size = is.read(recvData); // ������ recvData�� �����
			// read�� ���ŷ �Լ��̴�. -> ���̻� ���� �ȵ�
			// ������ ���� ���� ��ȯ
			while(true) {
				int size = is.read(recvData);
				// Ŭ���̾�Ʈ�� ���� ������ -1�� ����
				if(size == -1) {
					System.out.println("Ŭ���̾�Ʈ ���� ����");
					break;
				}
				String s = new String(recvData, 0, size);
				System.out.println(s);
			}
		} catch (Exception e) {e.printStackTrace();}
		
	}
}


class ConnectThread extends Thread{
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket();
			System.out.println("���μ��� ���� ����");
			ss.bind(new InetSocketAddress("192.168.0.80", 5001)); //������ ip�ּ�
			// ���ε� = �ڽ��� �ּҸ� ����Ѵ�. 
			System.out.println("���ε��Ϸ�");
//			ss.accept(); // ���ŷ�Ǿ��־� �ٸ� ��ư �� ������ ���� �߻� - ���ѷ����� �ν� - Thread���
			// ���ӵǸ� (���� ����Ǿ� �����͸� �ְ� ���� �� �ִ� )������ ����
			Socket socket = ss.accept(); // try - catch
			System.out.println("������ ������ �õ�����.");
			
			ClientThread ct = new ClientThread(socket);
			ct.start();
			
		} catch (Exception e) {e.printStackTrace(); }
	}
}

public class Server extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(5);
		
		Button openBtn = new Button("���� ����");
		openBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ConnectThread cn = new ConnectThread();	
				cn.run();
			}
		});
		
		root.getChildren().add(openBtn);
		
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Server");
		stage.show();
		
	}
	public static void main(String[] args) {
		launch();
//		System.out.println("Server Start");
//		
//		try {
//			ServerSocket ss = new ServerSocket();
////			if(ss == null) {// ������� ���α׷�
////				System.out.println("������ ������ �� ����. ");
////				exit(0);
////			}
//			System.out.println("���μ��� ���� ����");
////			ss.bind("ip�ּ�", ��Ʈ��ȣ); 
//			// localhost�� 127.0.0.1�� ����. ���� pc�� ��Ʈ ���
//			// ���ε��ϱ� ���� ����
//			ss.bind(new InetSocketAddress("localhost", 5001));
//			
//			System.out.println("���ε��Ϸ�");
//			// ���ŷ �Լ��̴�. 
//			ss.accept(); // ���� ������ ���ָ� ���ŷ�� Ǯ��
//			System.out.println("������ ������ �õ�����.");
//			
//		} catch (Exception e) {
//			System.out.println("���� �ǵ������� �����ڵ� ����ߴ�");
//			e.printStackTrace(); // ����
//		}
//		
//		System.out.println("���ڸ� �Է��ϸ� Ŭ���̾�Ʈ�� �����մϴ�.");
//		new Scanner(System.in).nextInt();
//		System.out.println("Server End");
	}
}