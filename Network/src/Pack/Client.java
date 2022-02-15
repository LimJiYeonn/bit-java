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
	Socket cs; // 모두가 사용하니 field로 정의
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(5);
		
		Button ConnectBtn = new Button("접속 버튼");
		ConnectBtn.setOnAction(new EventHandler<ActionEvent>() {		
			@Override
			public void handle(ActionEvent event) {
				 cs = new Socket(); 
				try {
					cs.connect(new InetSocketAddress("192.168.0.80", 5001));					
				} catch (Exception e) {e.printStackTrace();}
			}
		});
		
		
		// 서버 접속 후
		Button btn2 = new Button("데이터전송");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			int count = 0;
			@Override
			public void handle(ActionEvent event) {
				try {
					OutputStream os = cs.getOutputStream();
					String s = "apple : " + count++;
					byte[] data = s.getBytes(); // 생략된 건 보류
//					System.out.println(data[0]);
					os.write(data);
					System.out.println("데이터 보냄");
				} catch (Exception e) {e.printStackTrace();}
			}
		});
		
		
		Button btn3 = new Button("접속 종료");
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {cs.close();} catch (Exception e) {} // -1이 서버로 반환
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
//			System.out.println("숫자를 입력하면 접속을 시도합니다.");
//			new Scanner(System.in).nextInt();
//			// 접속을 하기위한 정보 넣기
//			cs.connect(new InetSocketAddress("localhost", 5001));
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		System.out.println("숫자를 입력하면 클라이언트를 종료합니다.");
//		new Scanner(System.in).nextInt();
//		System.out.println("Client End");
//		
		}
}
