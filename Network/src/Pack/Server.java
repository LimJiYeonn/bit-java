package Pack;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
				new Thread() { // �����带 ����ϴ� ����
					@Override
					public void run() {
						try {
							ServerSocket ss = new ServerSocket();
							System.out.println("���μ��� ���� ����");
							ss.bind(new InetSocketAddress("localhost", 5001));
							System.out.println("���ε��Ϸ�");
							ss.accept(); // ���ŷ�Ǿ��־� �ٸ� ��ư �� ������ ���� �߻� - ���ѷ����� �ν� - Thread���
							System.out.println("������ ������ �õ�����.");
						} catch (Exception e) {e.printStackTrace(); }
					}
				}.start();
				
				
				
				
				
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