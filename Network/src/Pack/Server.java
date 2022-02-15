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

//접속 후 데이터 받기
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
//			int size = is.read(recvData); // 읽으면 recvData에 저장됨
			// read가 블로킹 함수이다. -> 더이상 진행 안됨
			// 읽으면 읽은 개수 반환
			while(true) {
				int size = is.read(recvData);
				// 클라이언트가 접속 끊으면 -1을 받음
				if(size == -1) {
					System.out.println("클라이언트 접속 종료");
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
			System.out.println("메인서버 소켓 생성");
			ss.bind(new InetSocketAddress("192.168.0.80", 5001)); //서버의 ip주소
			// 바인딩 = 자신의 주소를 기억한다. 
			System.out.println("바인딩완료");
//			ss.accept(); // 블로킹되어있어 다른 버튼 못 누르는 문제 발생 - 무한루프라 인식 - Thread사용
			// 접속되면 (서로 연결되어 데이터를 주고 받을 수 있는 )소켓을 받음
			Socket socket = ss.accept(); // try - catch
			System.out.println("누군가 접속을 시도했음.");
			
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
		
		Button openBtn = new Button("서버 오픈");
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
////			if(ss == null) {// 방어적인 프로그램
////				System.out.println("소켓을 생성할 수 없다. ");
////				exit(0);
////			}
//			System.out.println("메인서버 소켓 생성");
////			ss.bind("ip주소", 포트번호); 
//			// localhost은 127.0.0.1과 같다. 현재 pc의 포트 써라
//			// 바인딩하기 위한 정보
//			ss.bind(new InetSocketAddress("localhost", 5001));
//			
//			System.out.println("바인딩완료");
//			// 블로킹 함수이다. 
//			ss.accept(); // 누가 접슥을 해주면 블로킹이 풀림
//			System.out.println("누군가 접속을 시도했음.");
//			
//		} catch (Exception e) {
//			System.out.println("내가 의도적으로 에러코드 출력했다");
//			e.printStackTrace(); // 습관
//		}
//		
//		System.out.println("숫자를 입력하면 클라이언트를 종료합니다.");
//		new Scanner(System.in).nextInt();
//		System.out.println("Server End");
	}
}