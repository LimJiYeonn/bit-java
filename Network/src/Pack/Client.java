package Pack;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client extends Application{
	Socket cs; // ��ΰ� ����ϴ� field�� ����
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(5);
		
		Button ConnectBtn = new Button("���� ��ư");
		ConnectBtn.setOnAction(new EventHandler<ActionEvent>() {		
			@Override
			public void handle(ActionEvent event) {
				 cs = new Socket(); 
				try {
					cs.connect(new InetSocketAddress("192.168.0.80", 5001));					
				} catch (Exception e) {e.printStackTrace();}
			}
		});
		
		
		// ���� ���� ��
		Button btn2 = new Button("����������");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			int count = 0;
			@Override
			public void handle(ActionEvent event) {
				try {
					OutputStream os = cs.getOutputStream();
					String s = "apple : " + count++;
					byte[] data = s.getBytes(); // ������ �� ����
//					System.out.println(data[0]);
					os.write(data);
					System.out.println("������ ����");
				} catch (Exception e) {e.printStackTrace();}
			}
		});
		
		
		Button btn3 = new Button("���� ����");
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {cs.close();} catch (Exception e) {} // -1�� ������ ��ȯ
			}
		});
		root.getChildren().addAll(ConnectBtn, btn2, btn3);
		
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Client");
		stage.show();
	}
	public static void main(String[] args) {
		launch();
//		System.out.println("Client Start");
//		
//		Socket cs = new Socket(); 
//		try {
//			System.out.println("���ڸ� �Է��ϸ� ������ �õ��մϴ�.");
//			new Scanner(System.in).nextInt();
//			// ������ �ϱ����� ���� �ֱ�
//			cs.connect(new InetSocketAddress("localhost", 5001));
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		System.out.println("���ڸ� �Է��ϸ� Ŭ���̾�Ʈ�� �����մϴ�.");
//		new Scanner(System.in).nextInt();
//		System.out.println("Client End");
//		
		}
}
