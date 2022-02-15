package Pack01;
//import java.io.FileWriter;
//import java.io.Writer;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
//ex
class Tiger{

}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();

	}
}
*/



//ex89

public class Hello {
	public static void main(String[] args) {
		System.out.println("여기는 헬로우");
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		System.out.println("헬로우 종료");
	}
}


/*
//ex88-7 UI : JavaFx
// 아예 상속을 받아서 class로 정의
// btn1.setText("호랑이"); 오류나는데 해결 방법
// 1. 생성자에서 버튼을 인수로 전달하기( + 주입을 위해 버튼 필드 생성)
// 컨트롤이 만약 5개가 필요하다면 문제가 생김 - 생성자의 필드를 5개 생성?? 너무 복잡하다.
// public Tiger(Button btn, TextField tf , ,,,,,) {}  -> 코드 지저분
// 2. this

class Tiger extends Thread{
	// 주입필요
//	Button btn;
//	public Tiger(Button btn) {
//		this.btn = btn;
//	}
	
	Hello hello;
	Tiger(Hello hello){
		this.hello = hello;
	}

	@Override
	public void run() {
		System.out.println("스레드 시작");
		System.out.println("스레드 종료");
		Platform.runLater( () -> {
//			btn.setText("호랑이"); 
			hello.btn1.setText("호랑이");
		} );
		System.out.println("독수리");
	}
}
public class Hello extends Application{ 
	Button btn1;
	Button btn2;
	@Override
	public void start(Stage stage) throws Exception {	
	// arg0 가독성안좋으니 stage로 변경
	HBox root = new HBox(); // 부모
	root.setPrefSize(400, 300);
	root.setSpacing(10); // 모든 간격에 10px
	
	btn1 = new Button("버튼1");
	btn2 = new Button("버튼2");
	// 익명 클래스는 this를 클래스로 감싸야함
	btn1.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
//			Tiger t = new Tiger(); // 메모리공유
			Tiger t = new Tiger(Hello.this); 
			t.start();
		}
	});
		

	root.getChildren().addAll(btn1, btn2);
		
	Scene scene = new Scene(root); 
	stage.setScene(scene); 
	stage.setTitle("호랑이");
	stage.show(); 
		
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch(); 
	}
}*/


/*//ex88-6
public class Hello extends Application{ 
@Override
	public void start(Stage arg0) throws Exception {	
	HBox root = new HBox(); // 부모
	root.setPrefSize(400, 300);
	root.setSpacing(10); // 모든 간격에 10px
	
	Button btn1 = new Button("버튼1");
	btn1.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
			// Thread - 익명 객체
			// 스레드안에서 속성값, 상태 변경하는 것은 조심해야한다.
			new Thread() {
				@Override
				public void run() {
					System.out.println("스레드 시작");
					// thread안에서 속성 변경시 클래스 사용
					Platform.runLater( () -> {
						btn1.setText("호랑이"); 
					} );
					System.out.println("스레드 종료");
				}
			}.start();
		}
	});
		

	root.getChildren().addAll(btn1);
		
	Scene scene = new Scene(root); 
	arg0.setScene(scene); 
	arg0.setTitle("호랑이");
	arg0.show(); 
		
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch(); 
	}
}*/


/*
//ex88-5
public class Hello extends Application{ 
@Override
	public void start(Stage arg0) throws Exception {	
	HBox root = new HBox(); // 부모
	root.setPrefSize(400, 300);
	root.setSpacing(10); // 모든 간격에 10px
	
	
	Button btn1 = new Button("버튼1");
	Button btn2 = new Button("버튼2");
	btn1.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
			btn2.setText("홍길동");
		}
	});
		
	btn2.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
			// 속성을 제어한다. 
			btn1.setVisible(!btn1.isVisible()); // 사라지기
//			btn1.setDisable(true); // 비활성화
//			btn1.setDisable(!btn1.isDisable()); 
		}
	});
	
	root.getChildren().addAll(btn1, btn2);
		
	Scene scene = new Scene(root); 
	arg0.setScene(scene); 
	arg0.setTitle("호랑이");
	arg0.show(); 
		
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch(); 
	}
}*/


/*
//ex88-4 채팅프로그램 예제
// import시 꼭 FX걸로 하기!
public class Hello extends Application{ 
	@Override
	public void start(Stage arg0) throws Exception {
	
	VBox root = new VBox(); // 부모
	root.setPrefSize(400, 300);
	root.setSpacing(10); // 모든 간격에 10px
	
	
	Button btn1 = new Button("버튼1");
	btn1.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
			System.out.println("클릭됨");
		}
	});
	
	TextArea textArea = new TextArea();
	
	TextField textField = new TextField();
	textField.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) { // enter을 누를 때 마다 이벤트 일어남
//			System.out.println("앵무새");
			String s = textField.getText();
//			System.out.println(s);
			textArea.appendText(s + "\n");
			textField.setText(" ");
		}
	});
	
	root.getChildren().addAll(btn1, textField, textArea);
	
	
	Scene scene = new Scene(root); 
	arg0.setScene(scene); 
	arg0.setTitle("호랑이");
	arg0.show(); 
		
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch(); 
	}
}
*/

/*
//ex88-3
//interface A<T>{
//	void f1();
//}
//// 1.상속받은 클래스 생성
//// 2. 익명 클래스
//// 이 두개 강조
//class Tiger{
//	void f100(A<Integer> tt) {
//		tt.f1();
//	}
//}
public class Hello extends Application{ 
@Override
	public void start(Stage arg0) throws Exception {
	// 객체 생성하지 않고 바로 함수인수전달자리에 익명클래스로 넣기
//	A<Integer> t = new A<Integer>() {
//		@Override
//		public void f1() {
//			
//		}
//	};
	
//	Tiger t = new Tiger();
//	t.f100(new A<Integer>() {
//		@Override
//		public void f1() {
//			System.out.println("test");
//		}
//	});
	
	
	HBox root = new HBox(); // 부모
	root.setPrefSize(400, 300);
	root.setSpacing(10); // 모든 간격에 10px
	
	
	Button btn1 = new Button("버튼1");
	// 인수로 익명 클래스를 원함
	// EventHandler가 인터페이스이고 안에 handle 메소드가 있다. 
	// 이 방법 아주 자주 사용
	// 인터페이스 분리의 원칙
	btn1.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
			System.out.println("클릭됨");
		}
	});
	
	
	Button btn2 = new Button("버튼2");
	btn2.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
			System.out.println("어흥");
		}
	});
	
	root.getChildren().addAll(btn1, btn2);
	
	
	Scene scene = new Scene(root); 
	arg0.setScene(scene); 
	arg0.setTitle("호랑이");
	arg0.show(); 
		
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch(); 
	}
}*/

/*//ex88-2
public class Hello extends Application{ 
@Override
	public void start(Stage arg0) throws Exception {
	HBox root = new HBox(); // 부모
	root.setPrefSize(400, 300);
	root.setSpacing(10); // 모든 간격에 10px
	
	// 방법1
//	Button btn1 = new Button("버튼1");
//	// root밑의 자식으로 등록 됨 -> 배치 완료
//	root.getChildren().add(btn1); // 체이닝
//	Button btn2 = new Button("버튼2");
//	root.getChildren().add(btn2); 
//	
	
	// 방법2
	Button btn1 = new Button("버튼1");
	Button btn2 = new Button("버튼2");
	Button btn3 = new Button("버튼3");
	root.getChildren().addAll(btn1, btn2, btn3);
	
	
	
	Scene scene = new Scene(root); 
	arg0.setScene(scene); 
	arg0.setTitle("호랑이");
	arg0.show(); 
		
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch(); 
	}
}*/


/*//ex88-1 UI
public class Hello extends Application{ 
@Override
	public void start(Stage arg0) throws Exception {
//	System.out.println(2);	
	
	VBox root = new VBox(); // 부모
	// 창 크기 설정
	root.setPrefSize(400, 300);
	
	// 배치 일어남
	
	
	
	// 스케지북, 화면상의 출력
	// 실제로 보여질 클래스 안에 눈에 보이지 않는 배치를 등록한다. 
	Scene scene = new Scene(root); // 객체 등록
	arg0.setScene(scene); // 등록된 객체를 인수로 받아서 넣기
	arg0.setTitle("호랑이"); // show 전에만 들어가면 됨
	arg0.show(); // scene으로 등록된 것을 화면에 출력
//	System.out.println(3); // 여기까지가 다이얼창이 나타났을 때
		
	}
	public static void main(String[] args) {
//		System.out.println(1);
		System.out.println("start");
		launch(); // 런처가 블로킹되어있고 창이 닫히니까 블로킹 풀림
//		System.out.println(4);

	}
}*/



/*
//ex87 UI 
abstract class MyApp{
	static void launch() {
//		start();
//		Hello h = new Hello();
//		h.start();
		try {
			Class<?> cls; 
			cls = Class.forName("Pack01.Hello");
			System.out.println(cls);
			
			// 내부적으로 생성자 호출해 메모리에 올림
			Constructor<?> constructor = cls.getConstructor();
			Object obj = constructor.newInstance();
			
//			Method m = cls.getMethod("start"); //start 함수만 가져옴, 메모리 없음
			Method start = cls.getMethod("start", String.class); 
//			System.out.println(m);
			System.out.println(start);
			
			// start 함수 호출
//			m.invoke(obj);
			start.invoke(obj, "호랑이");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	
	}
	abstract void start(String s);
}

public class Hello extends MyApp{ 
	//Application이 static launch()를 가지고 있다.
	//             abstract start(); 

	public void start(String s) { //public void start(String s)
		System.out.println(100);
		System.out.println(s);
	}

	public static void main(String[] args) {
		// static이다. static안에서는 static만 호출가능
		launch();

	}
}*/












// 2월 14일////////////////


/*//ex86 UI 
//Swing -> JavaFx - java 사용자들은 Swing 계속 사용
//c++ -> MFC -> WinForm -> WPF - c++ 사용자들은 새 버전나올 떄 마다 새 것 사용
public class Hello extends Application{ // ctrl + space 할 때 안나오니 다운받기
	// https://gluonhq.com/products/javafx/
	// LTS 안정화버전
@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		arg0.show();
		
	}
	public static void main(String[] args) {
		System.out.println(1);
		launch();

	}
}
*/

/*//ex85
//thread는 고유의 번호를 받는다. 
//들어오면 바로 while(true)로 묶인다. break만나면 중단
//블로킹이 실행되고 풀리면 다른 Thread로 넘어감
//real time 상태가 20개정도 되면 버벅거림
class Tiger extends Thread{
	public void run() {
		System.out.println(1);
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.start();

		
		// 업캐스팅 
		Thread t2 = new Tiger();
		t2.start();
		
		//익명클래스
		Thread t3 = new Thread() {
			public void run() {
				System.out.println(2);
			}
		};
		t3.start();
		
		// 익명객체
		new Thread() {
			public void run() {
				System.out.println(3);
			}
		}.start();
	}
}
*/

/*
//ex85 
//키보드만 입력받고 다른 스레드에게 제어권을 넘길 수도 있다.
//2줄 실행해야하는데 1줄만 실행하고 다른 스레드에게 제어권을 넘김
class Lion extends Thread{
	public void run() { 
		new Scanner(System.in).nextInt();
		System.out.println("독수리");
	}
}
class Tiger extends Thread{
	public void run() { 
		Lion t1 = new Lion();
		t1.start();
		new Scanner(System.in).nextInt();
		System.out.println("코끼리");
	} // 스코프 벗어나면 스레드 죽음
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.start();
		new Scanner(System.in).nextInt();
		System.out.println("호랑이");
	}
}
*/

/*
//ex84 multi Thread 증명 코드 
// 코끼리랑 호랑이랑 번갈아가면서 나옴
class Tiger extends Thread{
	public void run() { // run이 Thread
		for (int i = 0; i < 10; i++) {
			System.out.println("호랑이 : " + i);
			try {Thread.sleep(0);} catch (Exception e) {}
			// sleep(0) : 컴퓨터가 생각하기에 가장 짧은 시간을 쉬어라(안쉬는거 아님)
			// 잠깐이라도 다른 프로그램을 실행
			// 크롤링에 많이 사용됨 - 클릭 후 화면 뜰 때까지 잠깐 텀을 준다.  
		}
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("코끼리 : " + i);
			try {Thread.sleep(0);} catch (Exception e) {}
		}
	}
}
*/

/*//ex83
class Tiger extends Thread{// 표준 class
	public void run() { // 인터페이스 상속이기 때문에 앞에 public 붙여야한다.
		// B
		System.out.println("thread start");
		System.out.println("call");
		System.out.println("thread end");
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.start(); // 부모가 start 메소드 가짐 
		System.out.println("호랑이"); // A
		
		// (이론적으로 멀티태스킹에 의해)os가 제어권을 A, B중 누구에게 던질지 모른다.
		// main에 먼저 주고 프로세스 예약으로 남은 run을 실행시켜 뒤에 나왔다.
		// cpu는 자신의 프로세스인 main에게 100줄 정도 먼저 제어권을 줌
		
		// main이 끝나도 Thread가 계속 돌아갈 수 있다. 
	}
}*/

/*
//ex82
class A{
	void start() {
		System.out.println("start call");
		run();
	}
	// 메소드 없으면 컴파일시 run오류(자식에서 오버로딩할지 모르니까)
	void run() {
		System.out.println("A class Run Call");
	}
}
class B extends A{
	void run() {
		System.out.println("B class Run Call");
	}
}
public class Hello {
	public static void main(String[] args) {
		A t1 = new B();
		// A 클래스를 안보여주면 start가 뜬금없이 나와서 이해하기 힘들 수 있다. 
		t1.start();
	}
}
*/

/*//ex81) Scanner, 블로킹 함수, 메모리 누수
public class Hello {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		Random rnd = new Random();
		// 객체 생성 후 바로 버리고 싶을 때
		int random = new Random().nextInt(100);

		// nextInt 함수는 블로킹 함수이다.
		// 블로킹 함수란 약속된 특정 조건이 만족될 때 까지
		// 프로그램이 더이상 진행하지 못하는 함수
		// sleep(); - 특정 시간이 지날때까지 슬립시킴
		
		// 비동기 함수 : 입력 받으려고 커서를 깜빡이고 있지만
		// 블로킹이 풀려서 다른 코드가 진행된 상태
		// 자주 사용할 것이다. 
		
		for (int i = 0; i < 100; i++) {
			System.out.println("숫자를 입력하세요");
			int num = sc.nextInt();
//			int num = new Scanner(System.in).nextInt(); // 비용이 많이 든다.
			// resource leak - 객체 생성 후 close해야 함
			System.out.println(num);
			if( num == 999 ) {
				break;
			}
		}
		sc.close();
		System.out.println("프로그램을 종료합니다.");
	}
}
*/

/*
//ex80-2 LinkedList 중요한 내용
class Book{
	String title;
	String author;
	String publisher;
	int price;
	public Book(String title, String author, String publisher, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", price=" + price + "]";
	}
	
}
public class Hello {
	public static void main(String[] args) {
		LinkedList<Book> mm = new LinkedList<Book>();
		// Create
		mm.add(new Book("자바를 배운다.", "홍길동", "열심히출판사1", 100));
		mm.add(new Book("늦잠 자는 법", "게으름", "열심히출판사2", 150));
		mm.add(new Book("빅데이터란 무엇인가", "이순신", "열심히출판사3", 300));
		mm.add(new Book("남을 돕고 살자", "을지문", "열심히출판사4", 1000));
		System.out.println(mm.size());
//		System.out.println(mm); // 다 나옴
		
		//Read
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
		
		// 검색 리딩
		Book oneBook = mm.get(2);
		System.out.println(oneBook);
		System.out.println("--------------------");
		
		// Update 갱신
		mm.set(1, new Book("일찍 깨는 법", "일찍이", "열심히출판사2",200));
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
		
		// Delete
		System.out.println("--------------------");
		mm.remove(3);
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
	
	
		// 저자명으로 검색
		Book findBook = search(mm, "이순신");
		if(findBook != null) {
			System.out.println("찾았다.");
			System.out.println(findBook);
		}else {
			System.out.println("그런 저자 없다!");
		}
	}
	
	static Book search(LinkedList<Book> mm, String name) { //main함수가 static이니까 static안에는 static
		for (Book book : mm) {
			if(book.author.equals(name)) {//원래는 getAuthor로 해야함, 문자열 equals 사용
				return book;
			}
		}
		// 못찾은 경우
		return null;
	}
}
*/	

/*//ex80-1 LinkedList 중요한 내용 - 객체를 넣고 사용
class Tiger{}
class Lion<T>{
	T age;
	void setAge(T age) {
		this.age = age;
	}
}
public class Hello {
	public static void main(String[] args) {
		Lion<Tiger> t1 = new Lion<>();		
	}
}*/


/*
//ex79-3) 올바른 코드
public class Hello {
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>(); 
		Random rnd = new Random();
		
		// 랜덤으로 넣어서 검토
		for (int i = 0; i < 20; i++) {
			mm.add(rnd.nextInt(100));
		}
				
		System.out.println(mm);
				
		for (int i = 0; i < mm.size();) {
			int num = mm.get(i);
			if( num % 2 == 0) {
				mm.remove(i);
			}else {
				i++;
			}
		}
		System.out.println(mm);
		
	}
}*/


/*//ex79-2) 잘못된 코드
public class Hello {
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>(); 
		for (int i = 0; i < 10; i++) {
			mm.add(i * 10 + i);
		}
		mm.add(100);
		mm.add(102);
		mm.add(104);
		mm.add(106);
		mm.add(108);
		System.out.println(mm);
		
		// [0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 100, 102, 104]
		// 제거 후 한 숫자씩 안 물어봄
		// 제거 이후에 index 번호가 새로 조정된다. 
		for (int i = 0; i < mm.size(); i++) {
			if(mm.get(i) % 2 == 0) {
				mm.remove(i);
			}
		}
		System.out.println(mm);
		
	}
}
*/
/*
//ex79-1) 검색 제거
public class Hello {
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>(); 
		for (int i = 0; i < 10; i++) {
			mm.add(i * 10 + i);
		}
		System.out.println(mm);
		
		for (int i = 0; i < mm.size(); i++) {
			if(mm.get(i) == 55) {
				mm.remove(i);
				break;
			}
		}
		System.out.println(mm);
	}
}
*/

/*
//ex78
// C / C++
// 1. Collection 클래스를 내가 만들 수 있는가? 자료구조

// Java 자료구조가 없다. 
// 2. 이미 제작된 클래스를 잘 사용할 수 있는가? 

public class Hello {
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>(); 
		// CRUD(db에서 사용하는 용어) + 검색, 정렬 확인
		
		// Create
		System.out.println(mm.size());
		// create, add, insert 중 add() - 함수 만든 사람 마음대로 작명
		mm.add(100);
		System.out.println(mm.size());
		
		for (int i = 0; i < 10; i++) {
			mm.add(i * 10 + i);
		}
		System.out.println(mm.size());
		
		
		// Read
		// 1. 활용도가 떨어진다. 
		System.out.println(mm); // mm.toString() toString 생략 가능
		
		// 2. 가공 가능 read, get, select
		for (int i = 0; i < mm.size(); i++) {
			System.out.print(mm.get(i) * 2 + " ");
		}
		System.out.println();
		
		// 3. for 문의 간략화 버전 (forEach)- 슈가코드(삼항 연산자 등)
		// data : 실제 데이터이든지 아니면 인덱스이다. (java에서는 데이터가 넘어옴)
		for (Integer data : mm) {
			System.out.print(data + " ");
		}System.out.println();
		
		// 배열도 forEach 가능
		int[] ar = {10, 20, 30};
		
		// value, data, item 라고 쓰기도 함
		for (int data : ar) {
			System.out.print(data + " ");
		}
		System.out.println();

//		String s = "무궁화꽃이피었습니다.";
//		for (int i : s) {} // java에서 forEach문에 문자열 지원 안됨
		
		
		// Update
		mm.set(5, 99); // index=5를 99로 변경
		for (Integer data : mm) {
			System.out.print(data + " ");
		}System.out.println();
		
		
		// Delete
		// remove, delete, erase
		mm.remove(4);
		for (Integer data : mm) {
			System.out.print(data + " ");
		}System.out.println();
		
		
		// 검색
		for (Integer data : mm) {
			if(data == 77) {
				System.out.println("find");
				break;
			}
		}System.out.println();
		
		for (int i = 0; i < mm.size(); i++) {
			Integer value = mm.get(i);
			if(value == 77) {
				System.out.println(i + " : find");
				break;
			}
			else if(i == mm.size() -1) {
				System.out.println("not find");
			}
		}
		
		
	}
}
*/

// create(CRUD 중 1)만 특화된 알고리즘 그룹을 만들어 
// 8가지 라이브러리 제공 = Collection 



/*
//ex77 제네릭 사용
class Tiger{
	private int data;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}	
}
class Lion{
	private String data;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}	
}

class Cat{
	private float data;
	public float getData() {
		return data;
	}
	public void setData(float data) {
		this.data = data;
	}	
}

// 제네릭 : 항상 객체를 생성되는 시점에 타입이 결정됨
// 해당 객체로 컴파일 됨
class Dog<T>{ // <> == 컨테이너
	private T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}

//class Dog2<U, K>{ 
//	private U data;
//	private K data2;
//	public K getData() {
//		return data2;
//	}
//	public void setData(U data) {
//		this.data = data;
//	}
//}


public class Hello {
	public static void main(String[] args) {
		Dog<Integer> t4 = new Dog<Integer>();
		t4.setData(100);
		System.out.println(t4.getData());
//		Dog<Float>
//		Dog<Boolean>
		// 이제부터 integer를 t로 봐~
		// 원시타입 사용X intX
		// 클래스로 변환되있는 타입 사용 Integer
		// <> 컨테이너 사이는 무조건 class만 들어갈 수 있다.
		
		
		Dog<Float> t5 = new Dog<Float>();
		t5.setData(100.0f);
		System.out.println(t5.getData());
		
		
	
		Tiger t1 = new Tiger();
		t1.setData(100);
		System.out.println(t1.getData());

		Lion t2 = new Lion();
		t2.setData("호랑이");
		System.out.println(t2.getData());
		
		Cat t3 = new Cat();
		t3.setData(3.14f);
		System.out.println(t3.getData());		
	}
}*/

/*//ex76
// bmp 파일을 read, bmp 파일을 직접 만들 수 있으면 자바로써 파일입출력의 정점찍는거다~
public class Hello {
	public static void main(String[] args) {
		try {
			Reader reader = new FileReader("sample.txt");
			// FileNotFoundException 경로 또는 파일명 오류
//			Reader reader = new FileReader("s.txt");
			
			System.out.println(1000); // 익셉션시 뒤의 코드 실행X
			
			while(true) {
				// int java.io.Reader.read() throws IOException
				int readData = reader.read();
				if(readData == -1) { // EOF - end of file
					System.out.println("파일 끝까지 모두 읽음");
					break;
				}
				System.out.println((char)readData);
				
			}	
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace(); // 항상 이렇게 걸어두기
		}
		System.out.println(2000);
		
	}
}*/

/*
//ex75
//O X O X O X 
//X O X O X O 
//O X O X O X 
//X O X O X O 
//O X O X O X 
// 나오도록 파일 생성
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		rnd.nextInt(1);
		try {
			// open, 업캐스팅
			Writer writer = new FileWriter("ex75.txt"); // 2개는 쌍
			
			int width = 6, height = 5;
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					writer.write((i + j) % 2 == 0 ? "O " : "X ");
				}
				writer.write("\n");
			}
			
			// close
			writer.close(); // 2개는 쌍
			
		} catch (Exception e) {
			// TODO: handle exception
		}			
	}
}
*/
/*//ex74
// 파일 입출력 : 열고 닫기 중요
// 정해진 resorce가 있어서 닫지 않으면 다른 응용프로그램이 자원을 사용할 수 없다.
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);

		try {
			// open
			// 업캐스팅 (Writer조부모 OutputStreamWriter부모 FileWriter자식)
			Writer writer = new FileWriter("sample.txt"); // 2개는 쌍
			// sample.txt 파일을 만들거나, 존재하면 덮어씌운다. 
			
			writer.write("apple");
			writer.write("\n"); //캐리지 리턴?
			writer.write("호랑이");			
			
			// close
			writer.close(); // 2개는 쌍
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		System.out.println(2);		
	}
}*/

/*//ex73
public class Hello {
	static int m1() {
		return 100;
	}
	static void m2(int a, int b) {
		System.out.println("호랑이1");
		if(a > b) {
			System.out.println("호랑이2");
		}else {
			// 함수 실행 중단
			return; // 호랑이3이 출력안됨
		}		
		System.out.println("호랑이3");
	}
	
	// return 과 호랑이3을 모두 출력해야할 경우
	static void m3(int a, int b) {
		try {
			System.out.println("호랑이1");
			if(a > b) {
				System.out.println("호랑이2");
			}else {
				return; // 반드시 finally로 간다.
			}		
		} catch (Exception e) {
			
		}finally {//함수 중단되어도 무조건 finally 실행
			System.out.println("호랑이3");
		}
	}
	
	public static void main(String[] args) {
		System.out.println(m1());
//		m2(3,2);
		m3(3,2);
		m3(1,2);
		
//		try {
////			System.out.println(2/0);
//			System.out.println(2/1);
//		} catch (Exception e) {
//			System.out.println(1);
//		}finally { // 선택사항이지만 무조건 실행됨
//			System.out.println(2);
//		}
//		System.out.println(3);
	}
}
*/

/*//ex72 sleep
public class Hello {
	public static void main(String[] args) {
		// sleep 1초마다 숫자 출력, 자체적으로 익셉션 발생함
		
		for (int i = 0; i < 4; i++) {
			System.out.println(i);
//			try {
//				Thread.sleep(1000); // 1000ms(milli seconds) == 1초
//			} catch (Exception e) {
//			}
			// 1줄이면 단줄처리
			try {Thread.sleep(1000);} catch (Exception e) {}
		}
	}
}
*/

/*//ex71
class Tiger{
	void f1() {
		System.out.println("함수 1");
		// 1. catch로 익셉션 받아들이기
		try {
			throw new Exception();
			// throw 예외 던지기
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	// 2. 익셉션 떠넘기기
	// 함수 원형 뒤에다 발생한다라고 알리면 호출한 사람이 받음
	// 이 함수에서 안 받고 이 함수를 호출한 쪽에서 익셉션을 받겠다. 
	void f2() throws Exception {
		System.out.println("함수 2");
		throw new Exception();
	}
}
public class Hello {
	public static void main(String[] args) throws Exception{
		Tiger t1 = new Tiger();
		t1.f1();
		System.out.println("호랑이1");
		
//		t1.f2(); 
		// Unhandled exception 외우기
		// 이 함수는 자체적으로 익셉션이 발생하는 걸 받지 않겠다.
		// 이 함수를 사용하는 사람이 받아라~ 라는 뜻이다. 
		
		try {
			t1.f2(); 
		} catch (Exception e) {
			System.out.println("발생");
		}
		System.out.println("호랑이2");

		
		// 3. main도 예외 떠넘겨 결과적으로 os에게 떠넘김
		// public static void main(String[] args) throws Exception{
		t1.f2(); 
		
		
		// 2번 많이 사용
		// 여러(다양한) 예외 발생 가능 - 함수를 호출한 측에서 확인 후 방어적인 프로그램을 짜야한다. 
		
	}
}*/

/*
//ex70 에러처리
// 실제로 try catch를 사용하지는 않는다. 
public class Hello {
	public static void main(String[] args) {
//		Tiger t1 = new Tiger();
		int[] ar = new int[3]; // 0 1 2 범위 가능
		// 1. ArrayIndexOutOfBoundsException 범위 예외
		System.out.println("호랑이1");
		// 예외 발생시 프로그램이 중단됨
		// try-catch : 프로그램 중단을 방지

		//try하고 ctrl + space
		// 실제로 try문에 배열 안넣음 - 공부하기 위해서 넣음
		try {
			ar[3] = 10; // >> 여기서 중단됨
		} catch (Exception e) {
			// 익셉션발생시 catch 블록으로 들어온다.
			System.out.println("발생");
			e.printStackTrace(); // 방금 발생한 익셉션의 내용을 출력
		}
		System.out.println("호랑이2");
		
		// 2. ArithmeticException 수학적인 예외
		try {
			System.out.println(5 / 0); // 0으로 나눔 = 불능상태
			
		} catch (Exception e) {
			System.out.println("발생");
		}
		System.out.println("호랑이3");
		
		
		
		// 3. NullPointerException
		// 실제 자주 발생
		String s = null;
		try {
			s.length(); // 객체가 아닌데 메소드 사용
		} catch (Exception e) {
			System.out.println("호랑이4");
		}
		
		// 방어적인 프로그램 (open Lib에서 필수) - 미래지향적으로 봤을때 안정적이지만, 코드가 길다. 
		// s가 객체를 받은지 안받은지 모르는 상태
		s = new String("독수리"); // null이 아닐 가능성이 높지만 방어적이게 짜기
		// 사이사이에 코드가 추가적으로 들어갈 수 있으니
		if(s != null) {
			s.length(); 
		}
		
	}
}
*/








//2월 11일


/*
//ex70
interface Aaa{
	void f1();
}
interface Bbb{
	void f1(int num);
}
interface Ccc{
	int f1();
}
interface Ddd{
	String f1(String s, int n);
}
public class Hello {
	public static void main(String[] args) {
		Aaa t1 = () -> {
			System.out.println(1);
		};
		t1.f1();
		
		Bbb t2 = (n) -> { // 매개변수 이름은 마음대로 지정해도 됨
			System.out.println(n);
		};
		t2.f1(10);
		
		Ccc t3 = () -> {
			System.out.println("test1");
			return 200;
		};
		System.out.println(t3.f1());
		
		Ddd t4 = (s, n) -> {
			return s + n;
		}; 
		System.out.println(t4.f1("호랑이", 3000));
		
		
		
		// 리턴코드가 한 줄만 있는 경우에는
		// return 과 {}를 같이 생략할 수 있다. 
		Ccc t5 = () -> 200;
		// t3와 같은 결과
		System.out.println(t5.f1());
		
		Ddd t6 = (s, n) -> s + n; 
		System.out.println(t6.f1("맘모스", 4000));
		
	}
}
*/
/*//ex69
interface Tiger{
	void f1();	
}
class Lion{
	void f1(Tiger t) {
		t.f1(); // 다형성에 해당
	}
}
public class Hello {
	public static void main(String[] args) {
		Lion lion = new Lion();
		lion.f1(new Tiger() {
			@Override
			public void f1() {
				System.out.println("호랑이");
			}
		});
		
		lion.f1(new Tiger() {
			@Override
			public void f1() {
				System.out.println("독수리");
			}
		});
		
		
		Tiger t1 = new Tiger() {
			@Override
			public void f1() {	
			}
		};
		
		// 람다함수 (람다식), -> = 에로우
		Tiger t2 = () -> { // 인수전달 없어서 ()
				System.out.println("앵무새");
		};
		t2.f1();
		
		Tiger t3 = () -> {System.out.println("앵무새2");};
		t3.f1();
		
		
		lion.f1( () -> {
			System.out.println("앵무새3");
		});
		
	}
}*/

/*//ex68
interface Tiger{
	void f1();	
}
class Lion implements Tiger{
	public void f1() {}
}
public class Hello {
	public static void main(String[] args) {
		// 미구현 코드이기 때문에 객체 생성 불가
//		Tiger t1 = new Tiger();
		
		// 인터페이스 사용1 - Lion 클래스를 이용
		Lion t1 = new Lion();
		Tiger t2 = new Lion();
		
		// 인터페이스 사용2 
		// 익명클래스를 이용해서 인터페이스를 사용한다. - 완전 자주 사용됨 맨날 볼거다!!(람다식과 비슷하네)
		Tiger t3 = new Tiger() {
			@Override
			public void f1() {
				System.out.println("호랑이");
			}
		};
		t3.f1();
		
		// 인터페이스 사용3
		// 적시실행함수
		// 익명 객체 사용
		new Tiger() {
			@Override
			public void f1() {
				System.out.println("앵무새");
			}
		}.f1();
	}
}*/





/*//a와 b는 의존적 관계를 가지고 있다. 
class Aaa{
	Bbb bbb;
	Aaa(Bbb bbb){ // 주입
		this.bbb = bbb;
	}
	void f2() {
		bbb.f1();
	}
}

interface Bbb{
	void f1();
}
class Ccc implements Bbb{
	public void f1() {System.out.println("의존 주입");}
	
}


public class Hello {
	public static void main(String[] args) {
		Aaa t = new Aaa(new Ccc());
		t.f2();
	}
}

*/
//ex67-6 객체지향 정석 코드
/*class Baduk{
	// 생성자에서 인수전달을 해버림
	AI ai;
	
	//  생성자는 주입(InJection)을 받는다.
	 Baduk(AI ai){
		 this.ai = ai;
		 System.out.println("대국을 시작합니다.");
	 }
	 // 문제의 소지 높음 - 인수 필요X
	 void play() { 
		 ai.play();
	 }
	 void stop() {
		 ai.stop();
	 }
}

interface AI{
	void play(); 
	void stop();
}

class AlphaGo implements AI{
	public void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
	public void stop() {
		System.out.println("알파고가 점수를 계산합니다. ");
	}
}
class BetaGo implements AI{
	public void play() {
		System.out.println("인공지능은 베타고입니다.");
	}
	public void stop() {
		System.out.println("베타고가 점수를 계산합니다. ");
	}
}


public class Hello {
	public static void main(String[] args) {
		Baduk baduk1 = new Baduk(new AlphaGo());
		baduk1.play();
		baduk1.stop();
		
		Baduk baduk2 = new Baduk(new BetaGo());
		baduk2.play();
		baduk2.stop();
	}
}*/


/*//ex67-3 미구현 클래스가 존재 하는 것이 문제
class Baduk{
	 Baduk(){
		 System.out.println("대국을 시작합니다.");
	 }
	 void play(AI alphaGo) { // 항상 업캐스팅으로
		 alphaGo.play();
	 }
	 
}

////ex67-4 추상클래스화 시킴
//abstract class AI{
//	abstract void play(); 
//}

//ex67-5 인터페이스화 시킴
interface AI{
	void play(); 
}

class AlphaGo implements AI{
	public void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
}
class BetaGo implements AI{
	public void play() {
		System.out.println("인공지능은 베타고입니다.");
	}
}

public class Hello {
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play(new AlphaGo());
		baduk.play(new BetaGo());
		
	}
}*/

//ex67-2) 다른 인공지능으로 수정될 때 마다 클래스에 함수를 추가해야하는 문제
/*class Baduk{
	 Baduk(){
		 System.out.println("대국을 시작합니다.");
	 }
	 void play(AlphaGo alphaGo) {
		 alphaGo.play();
	 }
	 void play(BetaGo betaGo) {
		 betaGo.play();
	 }
}

class AlphaGo{
	void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
}
class BetaGo{
	void play() {
		System.out.println("인공지능은 베타고입니다.");
	}
}

public class Hello {
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play(new AlphaGo());
		baduk.play(new BetaGo());
		
	}
}*/

/*
//ex67-1) 인공지능이 수정된 경우
class Baduk{
	 Baduk(){
		 System.out.println("대국을 시작합니다.");
	 }
	 void play() {
		 System.out.println("인공지능은 알파고입니다. ");
		 
	 }
}
public class Hello {
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play();
		
	}
}
*/

/*//ex66 final(마지막)
// 1. 필드 final
// 2. 클래스 final
// 3. 메서드 final
class Tiger{
	// 1. 필드 final (값을 초기화하는게 여기가 마지막이다.)
	// 어디선가 대입연산자 한번이라도 쓰면(생성자 또는 필드 생성시) 어디에서든지 절대 못 씀
	// 대문자로 적는게 암묵적인 룰이다. 
	// 2. 상수화 되어 버린다. (대입을 못받으면 상수이다. )
	// const
//	final int NUM = 10; // 1
	final int NUM; // 1.2
	Tiger(){
		NUM = 30; //1.2
	}
	void f1() {
//		this.NUM = 20; // 갱신 불가
	}
}


class Aaa{}
final class Bbb extends Aaa{} 
// class명 앞에 들어가면 상속이 마지막을 뜻함 뒤의 class부터 상속못함
//// 해당 클래스의 자식이 상속을 못함
//class Ccc1 extends Aaa{}
////class Ccc2 extends Bbb{}
//class Ddd  extends String{}
//class Eee extends Thread{}

class Fff{
	final void f1() {} // 오버라이딩 불가
	// 무조건 부모것을 사용하게 끔 final로 지정
	void f2() { 
		f1();
	}
}
class Ggg extends Fff{
//	void f1() {} // 부모의 메서드에서 final 지정했기 때문에 오버라이딩 불가
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
//		t1.NUM = 20; // 갱신 불가
//		Math.PI;
	}
}*/



/*//ex65
// 굳이 인터페이스 만듬 -> 업캐스팅과 관련된 문법을 사용하기 위해 미리 만들어놓음
// line 클래스가 만들어질 수 있으니 혹시 모르니까 인터페이스 생성해놓음
interface ParentsTiger{
	void f1();
}
class Tiger implements ParentsTiger{
	public void f1() {}
}
class Lion implements ParentsTiger{
	public void f1() {}
}
public class Hello {
	public static void main(String[] args) {
		ParentsTiger t1 = new Tiger();

	}
}
*/
/*//ex64
class Aaa{
	void f1() {}
}
interface Bbb{
	void f2();
}
interface Ccc{
	void f3();
}
class Ddd extends Aaa implements Bbb, Ccc{ 
	public void f2() {}
	public void f3() {}
}

@FunctionalInterface // 구현 함수가 하나 있음을 알림, 둘 이상 작성시 에러
// @ = 컴파일 직전에 오류 찾기
interface Eee{
	void f1();
}
public class Hello {
	public static void main(String[] args) {
		String s;
		Thread t;
		StringBuffer sb;
	}
}*/


/*//ex63
//abstract class SmartPhone{
//	// 개발자들이 참고해서 개발해야 할 인터페이스(interface)이다.
//	// 나는 직접 구현안하고 참조를 통해 사용될 것이다. 
//	abstract void message(); 
//	abstract void tel();
//	abstract void appStore();
//	abstract void fold();
//	abstract void charge();
////	void f2() {} // 추상 클래스안에 일반 함수 있어도 상관 없음
//	
//}
//class Android extends SmartPhone{
//	
//}
//class IOS extends SmartPhone{
//	
//}


abstract class Aaa{
	// 개발자들이 참고해서 개발해야 할 인터페이스(interface)이다.
	// 나는 직접 구현안하고 참조를 통해 사용될 것이다. 
	abstract void f1(); 
	abstract void f2();
}
class Bbb extends Aaa{ // 상속
	void f1() {}
	void f2() {}
}


interface Ccc{ // 추상클래스와 문법만 다르고 내용은 같지만,
	// 클래스는 다중 상속 안되지만 인터페이스는 다중 상속이 되는 큰 차이점이 있다. 
	void f1(); // abstract void f1(); 
	void f2(); // abstract void f2();
}
class Ddd implements Ccc{ // 구현
	// interface를 구현한 메소드는 무조건 public
	public void f1() {}  
	public void f2() {}  
}

public class Hello {
	public static void main(String[] args) {
		
	}
}
*/
/*//ex62

public class Hello {
	public static void main(String[] args) {
//		int num = 100;
		// java에서는 곱하기 지원x
		int r1 = 100 * 3; // 100+100+100 
		int r2 = 3 * 100; // 3 + 3 + 3 + 3+...
		
		System.out.println(r1);
		System.out.println(r2);
		
		int test = 6; // 110(=6)
					// 1100(=12)  << 1 
					// 11000(=24) << 2
		System.out.println(test << 1); // 6 * 2의 1승
		System.out.println(test << 2); // 6 * 2의 2승
		System.out.println(test << 3); // 6 * 2의 3승
		System.out.println(test << 4); // 6 * 2의 4승
		
		int a = 23;
		for (int i = 0; i < 600; i++) {
			for (int j = 0; j < 800; j++) {
				System.out.println(800 * a);
				System.out.println((a<<9) + (a<<8) + (a<<5)); // 빠름
				System.out.println((a<<9) | (a<<8) | (a<<5)); // + 대신 | 사용해보기 결과가 같으면 |로 사용
				
			}
		}
		
		
	}
}*/

/*
//ex61
// & | >> << ~ ^ 데이터 암호 또는 압축, 가공시 많이 사용
public class Hello {
	static String hexaToBinary(int n) { // StringBuffer 하면갱신 가능하니
		String s = Integer.toBinaryString(n);
		while(s.length() < 32) 
			s = "0" + s;
		
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < 7; i++) 
			sb.insert((7-i)*4, " ");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int n1 = 0x1234abcd;
		
		System.out.println(hexaToBinary(n1));
		// 마스크 데이터 : 걸리질 때 중간역할 = ffff0000
		System.out.println(hexaToBinary(0xffff0000));
		System.out.println("---------------------------------------");
		System.out.println(hexaToBinary(n1 & 0xffff0000)); // 1. & 연산자
		
		// 데이터 합성 시 많이 쓰임 (서로 다른 영역의 비트를 가지고 있을 경우)
		System.out.println(hexaToBinary(n1 | 0xffff0000));	// 2. | 연산자
		
//		int a = 0xf3;
//		int b = 0x3600;
//		int c = 0xec0000;

		int a = 0x000000f3;
		int b = 0x00003600;
		int c = 0x00ec0000;
		int d = a | b | c;
		System.out.println("---------------------------");
		System.out.println(hexaToBinary(d));
		System.out.println("------------------------------");
		
		
		// shift 연산
		int e = 0xf09;
		System.out.println(hexaToBinary(e));
		System.out.println(hexaToBinary(e<<4)); // 왼쪽으로 4칸씩 이동
		System.out.println(hexaToBinary(e>>4)); // 오른쪽으로 4칸씩 이동
		System.out.println("------------------------------");
		
		int data = 0xabcd;
		// 21 30 13
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 5개,6개,5개의 bit로 나눠서 10진수로 환산하면?
		// 0000 0000 0000 0000 10101 011110 01101
		System.out.println(hexaToBinary(data));
		
		
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 0000 0000 0001 1111 
//		System.out.println(hexaToBinary(data & 0x1f)); // 마스킹
		System.out.println(data & 0x1f);
		
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 0000 0111 1110 0000 
//		System.out.println(data & 0x7e0); // 뒤에 0이 많아서 크게 나옴(원하는 데이터x)
		System.out.println((data & 0x7e0)>>5); 
		
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 1111 1000 0000 0000 
		  
		// 정석 
		System.out.println((data & 0xf800)>>11); 
		
		// 가독성 떨어짐
//		System.out.println((data >> 11) & 0x1f); 
		
		
		System.out.println("--------------------------");
		// 3. 비트반전연산자
		System.out.println(hexaToBinary(data));
		System.out.println(hexaToBinary(~data));
		
		
		// 4. XOR 연산자
		// 같으면 0, 다르면 1
		System.out.println(hexaToBinary(data));
		System.out.println(hexaToBinary(0x0000ffff));
		System.out.println(hexaToBinary(data^0x0000ffff));
	}
}
*/
/*//ex60
public class Hello {
	static String hexaToBinary(int n) { // StringBuffer 하면갱신 가능하니
		// 갱신 불가한 String 타입으로
		String s = Integer.toBinaryString(n);
//		System.out.println(s); // log를 많이 남기기 = 더미코드
//		System.out.println(s.length()); // 31개
		
		// 32bit에 해당하는 문자열 생성
		while(s.length() < 32) {
			s = "0" + s; // 0 문자열 추가
		}
//		System.out.println(s.length());
//		System.out.println(s);
		// string은 변경안되니까 계속 새로 만든 객체이다.
		
		// String은 insert 제공X
		StringBuffer sb = new StringBuffer(s);
//		System.out.println(sb);
		// insert시 앞에서 " " 추가하면 공백까지 세서 규칙없어짐 -> 뒤부터
		for (int i = 0; i < 7; i++) {
			sb.insert((7-i)*4, " ");
//			System.out.println((7-i)*4);
		}
//		System.out.println(sb);
		return sb.toString();
		
	}
	public static void main(String[] args) {
		// 내가 원하는 포맷(32bit, 4자리씩 끊기)으로 2진수 출력
		int num = 0x63ce7bcd;
		System.out.println(hexaToBinary(num));	
		System.out.println(hexaToBinary(0xab));	
		System.out.println(hexaToBinary(123456));	
		System.out.println(hexaToBinary(123456));	
		
		int num2 = 100;
		System.out.println(hexaToBinary(num2));
		System.out.println(hexaToBinary(0x7fffffff));
		System.out.println(hexaToBinary(0x80000000));
		
		
		
	}
}*/

/*//ex59
public class Hello {
	public static void main(String[] args) {
		
		// 1자리당 4bit 차지, 4자리=2byte, 
		// 8자리=4byte, int도 4byte까지 가능  
		// -> 16진수는 4byte를 넘을 수 없을 수 없다. (FF FF FF FF)	
		
		int num1 = 100;
		System.out.println(num1);
		
		// 앞에 0x 또는 0X 붙여 16진수로 저장
		int num2 = 0x100;
		System.out.println(num2);
		
		int num3 = 0xABCD;
		System.out.println(num3);
		
		int num4 = 0x63ce7bcd;
		// 0110 0011 1100 1110 0111 1011 1100 1101	 
		System.out.println(num4);
		
		// 0 ~ 80 00 00 00 : 반 / 나머지 반 : 80 00 00 00~ FF FF FF FF 
		int num;
		//Integer: int 숫자 하나를 관리, 정수와 관련된 함수 제공하는 클래스
		// 16진수를 2진수로 리턴
		System.out.println(Integer.toBinaryString(num4));
		int num5 = 0xab;
		// 10101011
		// 0000 0000 0000 0000 0000 0000 1010 1011 을 보며 작업
		// 원래는 32자리이다. 앞에 모든 0을 생략해서 나옴
		// 출력 결과를 4개씩 끊어 출력해보자~
		System.out.println(Integer.toBinaryString(num5));		
	}
}*/

/*//ex58) 진법 (bit 연산) : 2(컴), 10(인간), 16(절충안)
class Tiger{
	// A 10
	// B 11
	// C 12
	// D 13
	// E 14
	// F 15
	
	
	
	// 9 > A
	// 1F > 20
	// 9F > A0 AFx
	// FFF > 1000
	// CF > D0
}*/


/*//ex57
public class Hello {
	public static void main(String[] args) {
		String s1 = "무궁화꽃이피었습니다. ";
		// ex1)
		// int String.length()
		// 함수에 커서 대면 나옴 -> 습관들이기
		System.out.println(s1.length());
		
		// ex2)
		// char java.lang.String.charAt(int index)
		System.out.println(s1.charAt(3));
		
		// ex3)
		// int String.indexOf(String str)
		System.out.println(s1.indexOf("이피었"));
		
		// 실패시 음수 or -1이 리턴
		System.out.println(s1.indexOf("숩니다."));
		
		if(s1.indexOf("숩니다") == -1) {
			System.out.println("검색실패");
		}else {
			System.out.println("검색성공");
		}
		
		// ex4)
		//String replace(
		//			CharSequence target, 
		//			CharSequence replacement)
//		String s2 = s1.replace("꽃이", "나무가");
		// 주의 : 수정이 일어난 데이터가 원본 데이터를 변경하는가 하지 않는가? - class 만든 사람 마음
		// String class는 절대로 원본을 변경하지 않는다.
		
		// StringBuffer클래스는 원본 데이터를 변경할 수 있다.
		
		//원본 데이터가 변경(수정)이 된 것이 아니고 s1의 메모리가 삭제됨
//		System.out.println(s1);
		// s1의 메모리가 삭제됨 (객체가 사라지고)
		// s1의 메모리가 재할당 받는다. (새로운 객체가 만들어 진 것)
		// 두 개의 객체가 완전 다름
//		s1 = "호랑이";
//		System.out.println(s1);
		System.out.println(s1.replace("꽃이", "나무가"));
		
		
		// 만약 XString 클래스가 제공된다면 원본 데이터를 변경하는지 안하는지 먼저 알아둬야 한다.
		// 함수하나 쓸때마다 잘 확인하고 사용해야함

		
		// ex5) sub string
		System.out.println(s1.substring(3)); //i = 3부터 끝까지
		// start ~ end-1
		// end - start = 글자 수 
		System.out.println(s1.substring(3,5)); 
	
		// ex6)
		s1 = "Apple"; //객체가 바뀜
		
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());
		// ex. 모두 대문자나 소문자로 변경 후 단어 수 세기
		// 	   아이디를 대문자만 들어가게 한 경우 
		
		// ex7)
		s1 = "  A p p l e  ";
		System.out.print(s1);
		System.out.println(1000);
		System.out.print(s1.trim()); // 앞뒤만 공백제거
		System.out.println(2000);
		// 메모해둔 아이디를 복붙해서 가져와 로그인하는 경우
		
		
	}
}*/







////2월 10일 목요일
/*//ex57
// 4. 추상 함수를 가진 클래스는 반드시 추상클래스여야 한다. 
// 5. 추상 클래스는 객체를 생성할 수 없다.
abstract class A{
	// 1. 오버라이딩을 목표로 한다. 
	// 2. 정작 본인은 코드를 작성할 생각이 없다. 
	// 3. {}지우고, 세미콜론을 찍는 순간 미완성 코드가 된다. -> 추상(=미완성) 
	abstract void f1();
	
	 
}
class B extends A{
	// 상속받은 클래스는 부모의 추상메소드를 반드시 완성 시켜야한다. 
	// ctrl + space 하면 추상메소드 보여줌
	@Override
	void f1() {
		System.out.println(1);
	}
}
public class Hello {
	public static void main(String[] args) {
		A t1 = new B();
		t1.f1();
		
		// 추상 클래스는 객체 생성 불가
//		A t2 = new A(); 
	}
}*/


/*
//ex56
class Animal{
	void cry() {
		System.out.println("소리 내지 못함");
	}
}
class Tiger extends Animal{
	void cry() {System.out.println("어흥");}
}
class Cat extends Animal{
	void cry() {System.out.println("야옹");}
}
class Dog extends Animal{
	void cry() {System.out.println("멍멍");}
}
class Snake extends Animal{
	
}
class Lion extends Animal{
	void cry() {System.out.println("어흥어흥~");}
}
// 외부 코드 수정시 안의 코드는 수정안하게끔 하는게 원칙
// 개방 폐쇄의 원칙 = 인수는 개방, 폐쇄 = 수정 거의 안함
// SOLID

class Zoo{
	// 자식말고 부모로 받기 -> 어캐스팅
	// 어캐스팅하면 자동으로 다향성 적용됨
	// 다형성 : 다양한 모형이 나올 수 있다.
	void sound(Animal t) {
		t.cry();
	}
//	void sound(Tiger t) {
//		t.cry();
//	}
//	void sound(Cat c) { // 오버로딩
//		c.cry();
//	}
//	void sound(Dog d) {
//		d.cry();
//	}
//	void sound(Snake s) {
//		s.cry();
//	}
}

public class Hello {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.sound(new Tiger());
		zoo.sound(new Cat());
		zoo.sound(new Dog());
		zoo.sound(new Snake());
		zoo.sound(new Lion());
		
		
	}
}
*/
/*//ex55
class Animal{
	void cry() {
		System.out.println("소리를 낼 수 없음");
	}
}
class Tiger extends Animal{
	@Override
	void cry() {
		System.out.println("어흥");
	}
}
class Cat extends Animal{
	@Override
	void cry() {
		System.out.println("야옹");
	}
}
class Snake extends Animal{
	
}
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		Tiger t0 = new Tiger();
		Cat t1 = new Cat();
		Snake t2 = new Snake();
		for (int i = 0; i < 6; i++) {
			switch(rnd.nextInt(3)) {
			case 0:
				t0.cry();
				break;
			case 1:
				t1.cry();
				break;
			case 2:
				t2.cry();
				break;
			}
		}
		
		System.out.println("-----------------------");
		// 업캐스팅 여러 활용 방법 중 1개에 해당
		Animal[] ani = new Animal[] {new Tiger(), new Cat(), new Snake()};
		for (int i = 0; i < 6; i++) {
			ani[rnd.nextInt(3)].cry();
		}
		
//		Animal[] ani = new Animal[3];
//		ani[0] = new Tiger();
//		ani[1] = new Cat();
//		ani[2] = new Snake();
		
		

	}
}
*/
/*//ex54
class Animal{
	void cry() {
		System.out.println("소리를 낼 수 없음");
	}
}
class Tiger extends Animal{
	@Override
	void cry() {
		System.out.println("어흥");
	}
}
class Cat extends Animal{
	@Override
	void cry() {
		System.out.println("야옹");
	}
}
class Snake extends Animal{
	
}
public class Hello {
	public static void main(String[] args) {
		System.out.println("-----------------");
		
		Animal t1 = new Tiger();
		t1.cry();
		Animal t2 = new Cat();
		t2.cry();
		Animal t3 = new Snake();
		t3.cry();
		
		Tiger t4 = new Tiger();
		t4.cry();
		Cat t5 = new Cat();
		t5.cry();
		Snake t6 = new Snake();
		t6.cry();
		
//		String s0, s1, s2, s3;
//		s0 = "호랑이0";
//		s1 = "호랑이1";
//		s2 = "호랑이2";
//		s3 = "호랑이3";
		// 배열 안쓰고 뭐해요
		 
		
//		String[] ar = new String[4]; // 객체 4개가 아니라 배열 변수 4자리 만듬
//		ar[0] = "호랑이0";
//		ar[1] = "호랑이1";
//		ar[2] = "호랑이2";
//		ar[3] = "호랑이3";
		
		
		String[] ar = new String[] {"호랑이0", "호랑이1", "호랑이2", "호랑이3"}; // 객체 생성함
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		
		Test[] br = new Test[4]; //test 받기 위한 변수가 만들어짐, 객체가 만들어진게 아님
		br[0] = new Test();
		
		Test[] br2 = new Test[] {new Test(), new Test(), new Test(), new Test()}; 
		for (int i = 0; i < br2.length; i++) {
			br2[i].f1();
		}
	
	}
}
class Test{
	void f1() {System.out.println(1);}
}*/

/*//ex53
class A{
	void f1() {}
	void f3() {
		System.out.println(10);
	}
	void f4() { // 자식에게 오버라이딩하기
		System.out.println(20);
	}
}
class B extends A{
	void f2() {}
	void f4() { 
		System.out.println(40);
	}
}
public class Hello {
	public static void main(String[] args) {
		A t1 = new B();
		t1.f3(); // 자식중에 오버라이딩 일어났는지 확인
		// 일어났으면 자식 것을 사용, 안일어났으면 다시 돌아와서 자신(부모) 것을 사용
		t1.f4();
	
		B t2 = new B();
		t2.f3();
		t2.f4();
	}
}*/


/*//ex52 완전 중요!!***********
// 다형성, 업캐스팅

class A{
	void f1() {}
}
class B extends A{
	void f2() {}
}
public class Hello {
	public static void main(String[] args) {
		// 상속과 관련 없음
		A t1 = new A(); // 부 = 부
		t1.f1();
		
		
		// 업캐스팅(UpCasting)
		A t2 = new B(); // 부 = 자
		t2.f1();
		// f2 메모리가 있음에도 불구하고 사용할 방법이 없다. 
		
		
		// 자식것은 문법적으로 구사 못함
		// 메모리는 있는데 문법은 사용못함
		// -> 다형성으로 해결
		
		// 다운캐스팅 - 위험해서 java에서는 지원 안 함
//		B t3 = new A(); // 자 = 부
		B t4 = new B(); // 자 = 자
		t4.f1();
		t4.f2();
		
		// = 왼쪽은 문법 오른쪽은 메모리 지정
		
	}
}
*/

/*//ex51
// this의 4번째 용법
// this 생성자는 반드시 코드 첫줄에 와야한다. 
class Tiger{
	int num;
	int age;
	
	Tiger(){
		age = 10000;
		System.out.println(1);
	}
	Tiger(int a){
//		this();
		num = a;
		System.out.println(2);
	}
	Tiger(int b, int c){
		this(b*c); // 두번째 생성자가 100이라는 인수를 받음
		System.out.println(3);
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger(10);
		Tiger t2 = new Tiger(2, 3);

	}
}
*/
/*//ex50
// 모든 class는 Object로 부터 상속 당함.
class A{ // class A extends Object 생략되어 있다. 
	void f1() {}
}
class B extends A{
	void f2() {}
}
class C extends B{
	void f3(){}
	void f4(){}
}
public class Hello {
	public static void main(String[] args) {
		C t1 = new C();
		StringBuffer sb;
	}
}*/

/*
//ex49
// 생성자가 호출되는 실행순서: 
// 부모 -> 자식 : <------------- 잘못된 해석
// 자식부터 call하는데 자식 생성자 안에는 부모 생성자를 call라는 코드가 생략되어있어
// 겉으로 볼때는 부모먼저 call하는 걸로 보임
// 진짜는 자식 먼저
class A{
	A(){
		System.out.println(1);
	}
	A(int a){
		System.out.println(3);
	}
}
class B extends A{
	B(){
		// 부모 생성자를 call라는 코드가 생략되어 있다.
//		super();
		super(100); // 자식은 선택적으로 부모 생성자를 선택할 수 있다. 
		System.out.println(2);
	}
	B(int a, int b){
		super(); // 자식 class 생략 가능
		System.out.println(4);
	}
}

public class Hello {
	public static void main(String[] args) {
		B t1 = new B();
		B t2 = new B(3,4);

	}
}*/

/*//ex48
class A { // 조부
	void f1() {System.out.println(1);}
} 
class B extends A { // 부모

}
class C extends B{ // 자식
	
}
class D extends B{ // 자식
	
}
// c, d 남남 
public class Hello {
	public static void main(String[] args) {
		C t1 = new C();
		t1.f1();
	}
}
*/

/*//ex47 상속
class Aaa { // 부모
	void f1() {
		System.out.println(1);
	}
	// 함수 원형(method prototype) = void f3()
	void f3() {
		System.out.println(31);
	}
	String f5(int a, int b, String t) {
		return null;
	}
}
class Bbb extends Aaa{ // 자식
	void f2() {
		System.out.println(2);
	}
	
	// 오버라이딩 (Overriding)
	// 부모의 함수 원형을 그대로 가져와 활용
	@Override
	// 오타가 나서 오바라이딩 되지 않았을 때 에러발생 시킴
	void f3() {
		System.out.println(32);
	}
	void f4() {
		f3();  // = this.f3(); // 해당 class의 f3 호출
		super.f3(); // 부모의 f3
	}
	@Override //오버라이딩이라고 표시하기 @하고 ctrl + space하면 나옴
	String f5(int a, int b, String t) {
		return null;
	}
}
public class Hello {
	public static void main(String[] args) {
		Bbb t1 = new Bbb();
		t1.f1(); // 자식이 없으니 부모의 f1을 호출
		t1.f2(); // 자식이 있으니 자식의 f2호출
		t1.f3(); // 자식의 f3 
		t1.f4();
	}
}*/


/*
//ex46-3
class Man{
	void f1() {
		Women w = new Women();
		boolean result = w.marry(this);
		System.out.println(result ? "^^" : "--");
	}
	String 성격() {
		return "포악";
	}
	
}
class Women{
	boolean marry(Man info) {
		String str = info.성격();
		return str == "포악" ? false : true;
	}
}
class Control{
	void makeButton(Hello h, String text, String color) {
		System.out.println(3);
	}
}
public class Hello {
	public static void main(String[] args) {
		Man t1 = new Man();
		t1.f1();
		
		Control con = new Control();
		// hello 객체(this)를 con.make에 던짐
		// this를 인수로 가져가는 경우 : 상대방 클래스에서 내 정보(클래스)를 필요로 함
		con.makeButton(this, "텍스트", "색상");
//		this.칠하다();
	}
	void 칠하다() {
		System.out.println(1);
	}
}
*/

/*//ex46-2) this 용법2
// channing을 목적으로 한다.
class Tiger{
	//Tiger this; 가 생략되어 있음
	Tiger f1() {
//		System.out.println("아침");
		System.out.println("id ");
//		return null;
//		return new Tiger(); // 새 객체 생성 후 리턴
		return this;
	}
	
	Tiger f2() {
//		System.out.println("점심");
		System.out.println("password");
		return this; //f(2)도 뒤에 체이닝을 걸 수 있다. 
	}
	void f3() {
//		System.out.println("저녁");
		System.out.println("유효성검사");
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		
		t1.f1().f2().f3(); //f1()이 tiger클래스 호출
		System.out.println("----------------------------");
	
		//channing시 밑으로 내려서 코드 작성
		// intercept 할 수 없다. -> 작업의 흐름 깨지 못하게 함
		t1.
		f1().
		f2().
		f3();
		
		// intercept 가능
		t1.f1();
		System.out.println("로또..끼어들기");
		t1.f2();
		t1.f3();
	}
}
*/
/*//ex46-1) this 용법1
// 함수의 전달인수와 필드를 구분하기 위한 용도
// 자동 : 1. 생성자, 2. setter, getter, 3. toString
class Tiger{
	String name;
	int age;
	
	public Tiger(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	Tiger(String name, int age){ // 매개변수 작성시 어떤 용도인지 변수 설정
		this.name = name; // 필드 <= 인수
		this.age = age;
	}
	void f1() {
		System.out.println(name + " " + age);
//		System.out.println(this.name + " " + this.age); // this 생략 가능
	}
	void f2() {
		f1();
		this.f1(); // 위와 같은 의미
	}
	
	void f3(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Tiger [name=" + name + ", age=" + age + "]";
	}
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger("호랑이", 10);
		System.out.println(t1);
		t1.f3("독수리", 20);
		System.out.println(t1);
	}
}*/

/*
//ex45
// this = 방금 생성된 객체
class Lion{}
class Tiger{
//	Lion lion;
//	Tiger tiger;
	Tiger(){
//		this = ??????; -> new를 통해 객체가 생성되면 객체명이 this에 대입됨
//		this = t1; this = t2; 
		// 객체명과 this는 메모리를 공유한다. 
		System.out.println(this.hashCode());
	}
	// 생략된 코드
//	Tiger this; 모든 클래스는 이 코드가 생략되어 있다.
	
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.hashCode());
		
		Tiger t2 = new Tiger();
		System.out.println(t2.hashCode());
	}
}
*/
/*//ex44
class Tiger{
	private Tiger(){ // 객체 생성을 막아둠
		
	}
}
public class Hello {
	public static void main(String[] args) {
//		Tiger t = new Tiger();
		
//		Thread.sleep(0);
		
		//Math m = new Math();
		System.out.println(Math.abs(-10)); // abs가 static 메소드

	}
}
*/
/*//ex43-3
class Tiger{
	static int count = 0;
	int num = 0; // 객체 생성시마다 전역변수로 생성
	Tiger(){
		count++;
		num++;
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		Tiger t3 = new Tiger();
		
		System.out.println(t1.num);
		System.out.println(t2.num);
		System.out.println(t3.num);
		
		System.out.println("생성된 객체 수는 : " + Tiger.count);
		 //프로그램 종료시에는 객체 수 = 0
	}
}
*/
/*//ex43-2
class Tiger{
	void f1() {
		Tiger t = new Tiger();
	}
}
public class Hello {
	int n1;
	static int n2;
	void f1() {}
	static void f2() {}
	public static void main(String[] args) {
//		Tiger t1 = new Tiger();
//		f1();
		f2();
//		n1 = 10;
		n2 = 10;
		
		Hello h = new Hello();
		h.n1 = 10;
		h.n2 = 20;
		h.f1();
		h.f2();
		// hello 객체 2개 = 내가 생성 + os가 생성
		
		
	}
}
*/
/*//ex43-1
// static 안에서는 static만 사용할 수 있다. 
class Tiger{
	int n1;
	static int n2;
	static void f1() {
//		n1 = 100;
		n2 = 100;
//		f2();
		f3();
	}
	void f2() {f1();}
	static void f3() {}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();

	}
}*/

/*//ex43-2
class Tiger{
	static void f1() { // 비용 절감 -> 속도 빠르게 할 때 사용
		System.out.println(2);
	}
	void f2() {
		
	}
}
public class Hello {
	int age;
	Hello(){
	}
	void f1() {}
	// 진입점(Entry Point)
	// main 호출은 OS가 한다. 
	// Hello h = new Hello();
	// h.main();
	// Hello.main(); -> os가 부르는 형식
	public static void main(String[] args) { // static - 객체 생성x에도 main함수 사용o
		// 객체 생성 비용이 많이 든다. 
		// static 메서드는 객체 생성 필요없이 바로 
		// 클래스명만 이용해서 사용하니까 비용 절감
		Tiger.f1();

	}
	void f2() {}
	
}
*/
/*//ex43-1
class Tiger{
	// static
	// 처음부터 만들어놓아야함(객체가 있든말든)
	// 컴파일시 static 코드가 class 바깥으로 나감
	// 한번 만들어지면 모든 객체의 공용이 된다.
	
	// 이점
	// 모든 객체가 공용으로 사용할 것이면 객체 생성시마다 새로 만들 필요없다.
	static int n1;
	int n2; // 클래스가 생성되야 필드에 메모리를 할당해줌
	static void 관제탑() { 
		System.out.println("콜");
	}
	void 날다() { 
		
	}
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		Tiger.관제탑(); //프로그램 시작부터 메모리가 만들어짐
		t1.날다();
		t1.관제탑();
		System.out.println(Tiger.n1);
		System.out.println(t1.n2);
	}
}*/

/*
//ex42
class Tiger{
	// 부품 취급 - 나사를 외부에 노출 필요X
	// 데이터 은닉
	private int age; //private class안에서만 / public 다 / 생략시 default
	private String name;
	
	
	String getName() {
		return name;
	}
	void setName(String n) {
		name = n;
	}
	
	// getter, setter 함수 - 선택사항
	int getAge() {
		return age;
	}
	void setAge(int data) {
		age = data; 
	}
	
	
	Tiger(){
		age = 100;
	}
	private void f1() {
	}
	private void f2() {
	}
	void f3() {
		f1(); // f1과 f2는 f3에서만 사용되니까 내부에서만 보이도록 private로 숨겨도 된다.
		f2();
	}
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		
		// 멤버필드는 객체를 생성시켜서
		// 직접 사용하는것은 거의 불법!!!!!!
		t1.setAge(1000);
		System.out.println(t1.getAge());
		
	
	}
}
*/
/*
//ex41
class Tiger{
	String name;
	int age;
	
	// 생성자를 아예 안쓰면 컴파일시 default 생성자 자동 생성됨
	// 생성자 1개라도 있으면 default 생성자 자동 생성 안함
	Tiger(){} // 오류 안나게 끔 클래스 생성시 이것도 쓰도록 습관 들이기
	Tiger(int data){
//		name = null;
		name = "익명";
		age = data;
	}
	Tiger(String n, int data){
		name = n;
		age = data;
	}
	void showData() {
		System.out.println(name + " " + age);
	}
	@Override
	public String toString() {
		return "Tiger [name=" + name + ", age=" + age + "]";
		// return this 생략되어있다.
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger(100);
		t1.showData();
		Tiger t2 = new Tiger("홍길동", 200);
		t2.showData();
		Tiger t3 = new Tiger();
		System.out.println(t1.toString());
		System.out.println(t1);
	}
}
*/

/*
//ex40-2
class Tiger{
	int age = 10;
	Tiger(int data){
		age = data;
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger(100);
		Tiger t2 = new Tiger(200);
		System.out.println(t1.age);
		System.out.println(t2.age);
	}
}
*/

/*
//ex40 - 1)
class Tiger{
	int age;						// 초기화 방법1 (먼저 실행)
	Tiger(){						// 초기화 방법2 (나중 실행)
		System.out.println(1);
		age = 100;
	}
	Tiger(int data){
		System.out.println(2);
		age = data;
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.age);
		Tiger t2 = new Tiger(999);
		System.out.println(t2.age);
		
	}
}
*/

/*
//ex39)
// 생정자
// 1. 사용 목적: 필드 초기화
// 2. 생성자 메소드라고 한다.(함수이다.)
// 3. 함수의 이름은 반드시 클래스 이름과 동일
// 4. 인수를 전달받을 수는 있지만, return을 가질 수 없다. 
// 5. 인수전달이 없는 생성자를 디폴트 생성자라고 한다. 
// 6. 호출은 new키워드를 사용할 때 딱 한 번 호출된다. 
// 	  프로그래머가 임의로 호출할 수 없다. 
// 7. 함수(메소드)이기 때문에 오버로딩을 할 수 있다. 
// 8. 생성자 코드를 작성하지 않으면 자동으로 디폴트 생성자가 만들어진다. 
//    - 생성자 코드를 작성하면 자동으로 생성자가 만들어지지 않는다. 

class Tiger{
	// 필드
	int age;
	
	// default 생성자
	Tiger() {
		System.out.println("생성자 콜");
		age = 100;
	} 
	
	// 메소드
	
}
public class Hello {
	public static void main(String[] args) {
		System.out.println("1");
		Tiger t1 = new Tiger();
		System.out.println("2");
		Tiger t2 = new Tiger();
		System.out.println("3");
		System.out.println("------------");
		for (int i = 0; i < 3; i++) { // 생성자 3번 만들어지고 사라짐
			Tiger temp = new Tiger(); 
			System.out.println(temp.hashCode());
		}
		
	}
}
*/

// 2월 9일
/*
// ex38-2
// 오버로딩 활용
class Tiger{
	int getArea(int w, int h) {
		return w * h;
	}
	int getArea(int x1, int y1, int x2, int y2) {
		int width = x2 - x1 + 1;
		int height = y2 - y1 + 1;
		return width * height;
	}
	int getArea(int x) {
		return x * x;
	}
	// return 은 구분X 사용하는 입장에서는 구분할 수 없다.
	int test() {
		return 0;
	}
	int test() {
		return 0.0f;
	}
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.getArea(10, 5));
		System.out.println(t1.getArea(10, 5, 20, 15));
		System.out.println(t1.getArea(25));
		
		
	}
}
*/

/*
//ex38-1
// "오버로딩 (Overloading)"
// 함수이름을 동일하게 작명이 가능한 경우
//1. 인수 전달 개수가 다른 경우
//2. 전달 인수 개수가 같더라도 타입이 다른 경우
class Tiger{
	// 1. 인수 전달 개수가 다른 경우
	void showMeTheMoney() {
		System.out.println(1);
	}
	void showMeTheMoney(int a) {
		System.out.println(2);
	}
	void showMeTheMoney(int a, int b) {
		System.out.println(3);
	}
	// 2. 전달 인수 개수가 같더라도 타입이 다른 경우
	void showMeTheMoney(float a) {
		System.out.println(4);
	}
	void showMeTheMoney(Tiger t) {
		System.out.println(5);
	}
	void showMeTheMoney(short a) {
		System.out.println(6);
	}
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.showMeTheMoney();
		t1.showMeTheMoney(10);
		t1.showMeTheMoney(10, 20);
		t1.showMeTheMoney(3.14f);
		t1.showMeTheMoney(new Tiger());
		
		float f = 3; // 컴파일 오류X
		// type casting 을 통해 가고자하는 곳을 명확하게 지시
		t1.showMeTheMoney((float)3);
		t1.showMeTheMoney((short)10);
		
	
	}
}
*/

/*
//ex37
class Tiger{
	int number;
}
class Lion{
	// Tiger bbb = aaa; //공유
	Tiger m1(Tiger bbb) {
		System.out.println(bbb.number);
		System.out.println(bbb.hashCode());
		bbb.number = 888;
		return bbb;
	}
}
public class Hello {
	public static void main(String[] args) {
		Lion t1 = new Lion();
		Tiger aaa = new Tiger();
		aaa.number = 999;
		System.out.println(aaa.hashCode());
		
		Tiger ccc = t1.m1(aaa);
		System.out.println(aaa.number);
		
		System.out.println(ccc.hashCode());
		System.out.println(ccc.number);
		//aaa=bbb=ccc 같은 객체
	}
}
*/

/*
//ex36
class Tiger{
	int num = 100;
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();// 객체 생성시 고유(주민)번호 가짐
		System.out.println(t1.hashCode());
		Tiger t2 = new Tiger();
		System.out.println(t2.hashCode());
		Tiger t3 = null;
		// null point exception 
//		System.out.println(t3.hashCode());
		
		// 사용 메모리를 공유, 참조한다.
		t3 = t1; // 닉네임만 다르고 완전 같다. 별명이라 생각하면 됨
		//t1 = 홍길동이라 부름 t3 = 곰돌아라고 부름
		System.out.println(t3.hashCode());
		System.out.println(t1.num);
		t1.num = 200;
		System.out.println(t3.num);
	}
}
*/

/*
//ex35
class Tiger{

}
class Lion{
	// Tiger t = new Tiger();
	void m1(int a, String s, Tiger t, Lion l) {
		if(s != null) {
		}
	}
	
	Tiger m2() {
		return null;
	}
	
	Tiger m3() {
		return new Tiger();
	}
	
	Tiger m4() {
		Tiger t = new Tiger();
		return t;
	}
	
	Tiger m5(Tiger t) {
		return t;
	}
}
public class Hello {
	public static void main(String[] args) {
		Lion t1 = new Lion();
		t1.m1(10, "호랑이", new Tiger(), new Lion()); // null을 던져도 되지만 m1에서 해당 class 사용 못함
		t1.m1(10, null, null, null); // null = 객체를 직접적으로 사용X
	}
}
*/

/*
//ex34
class Tiger{
	// 인수전달의 종류 : 8 + class
	void m1(float a, String s) { // class를 인수로 받기 o - 수백만가지
//		System.err.println(a); // error처럼 출력
		System.out.println(a + " " + s);
		System.out.println(s.length());
	}
	String m2() {
		// 방법1
//		return "호랑이";
	
		// 방법2
		String s = "독수리";
		return s;
	}
	
	String m3() {
		return null; // error 피하기 위해
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.m1(3.14f, "호랑이");
		// 1
		t1.m2();
		
		// 2
		String s = t1.m2();
		System.out.println(s);
		
		// 3
		System.out.println(t1.m2());
		
		//String s2; // 사용할 이름만 정의, 객체 생성한 것x 문자열이나 new로 초기화 필요
		String s2 = null; // 아직 객체가 아니다라는 것ㅇ르 명시적으로 표시한다. 
		String s3 = "코끼리";
		
		//적당하게 사용하다가 자격을 박탈하고 싶으면
		s3 = null;		
	}
}*/

/*
//ex33
class Tiger{
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();

		// 문자열을 전문적으로 관리
		// 첫글자가 대문자 -> 자바에서 제공하는 표준 클래스이다. 
		// 도움을 줄만한 method가 뭐가 있는지가 궁금하다.
		
		// 정식 코드
		String s1 = new String(); 
		s1 = "호랑이";
		System.out.println(s1);
		System.out.println(s1.length());
		
		// 약식 코드
		String s2 = "앵무새"; 
		System.out.println(s2);
		System.out.println(s2.length());
		
		Thread t;
		Math m;
	}
}*/

/*
//ex32
class Tiger{
	int a, b;
	void showData() {
		System.out.println(a + " " + b);
	}
	int add() {
		return a + b;
	}
	// 변수명이 중첩된경우 지역변수({}이 사이에 허용된 변수) 우선 사용
	void m1(int a, int b) {
		// 지역변수를 먼저 사용
		// 인수값이 먼저 사용
		int result = a + b;
		System.out.println(result);
		
		// field의 a, b 사용하고 싶다면
		result = this.a + this.b;
		System.out.println(result);
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.a = 10;
		t1.b = 20;
		t1.showData();
		System.out.println(t1.add());
		t1.m1(100, 400);
	}
}
*/

/*//ex31
class Tiger{
	void f1() {
		System.out.println(1);
	}
	void f2() {
		f1();
		System.out.println(2);
	}
	void f3() {
		f2();
		System.out.println(3);
	}
	
	// 상호 호출 -> 돌아올 수 없다. 
	// StackOverflowError: 사용할 수 있는 메모리가 없다. 
	void f4() {
		System.out.println(4);
		f5();
	}
	void f5() {
		System.out.println(5);
		f4();
	}
	
	// 재귀 호출(recursive call)
	// 잘 쓰면 굉장히 유용
	void f6() {
		System.out.println(5);
		f6();
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.f3();
		//t1.f5();
		t1.f6();
	}
}
*/
/*//ex30
class Tiger{
	// 리턴이 있다. FuncName(){}
	// ....가 없다. 
	// return 값이 없다. 
	void func01() {
		System.out.println("호랑이");
	}
	
	int func02() {
		System.out.println(1);
		return 100;
	}
	
	// 메소드에서 return 키워드를 만나면 함수가 중단된다. 
	// 어떤 식으로 코드가 진행이 되더라도 return 을 만나야 한다. 
	int func03() {
		if(false) {
			return 100;
		}else if(false){
			return 200;
		}else {
			System.out.println(1000);
			return 300;
		}
//		return 100; // 함수 실행 종료
//		System.out.println(1000);
	}
	
	// void이지만 return 키워드를 사용할 수 있다. 
	void func04() {
		for (int i = 0; i < 10; i++) {
			if(i == 5) {
//				break;
				return;
			}
		}
		System.out.println("for 중단됨"); // break 코드시 실행됨, return시 실행 안 됨 
	}
	
	// 4번째 형태
	int func05(int num) {	
//		return num * num;
		// 사연이 있어 변수를 받아 사용
		int result = num * num; 
//		System.out.println(result);
		return result;
	}
	
	int func06(int num) {	
		// 둘의 함수 역할이 다름
		System.out.println(num*num); // 출력 용도로만
		return num*num; // return 값을 출력말고도 다른 용도로 사용가능
	}
	
	// 규칙과 메뉴얼을 만든다. 
	// -1이 리턴된 경우는 음수인 경우이다.
	// 1이 리턴된 경우는 정상 작동된 경우이다.
	int func07(int num) {	
		if(num < 0) {
//			System.out.println("음수입니다."); -> 고정 -> 응용, 활용할 수 없다.
			// 시스템 내용 안알랴줌~~~
			return -1;
		}
		
		if(num % 2 == 0) {
			System.out.println("짝");
		}else {
			System.out.println("홀");
		}
		return 1;
	}
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		// 함수의 리턴값 활용
		// 1. 외면하는 경우
		t1.func02();
		
		// 2. 변수
		int num = t1.func02();
		System.out.println(num);
		
		// 3.
		System.out.println(t1.func02());
		
		// 에러원인 찾기 힘듬
//		System.out.println(t1.func01());
		System.out.println(t1.func03());
		t1.func04();
		System.out.println(t1.func05(5));
		System.out.println(t1.func06(6)+200); // 응용 
		System.out.println(t1.func06(5) + t1.func06(6));
		
		if(t1.func07(-40) == -1) { // 응용 o
			System.out.println("음수입니다. ");
		}
		
		
		
		
	}
}
*/

/*//ex29
class Tiger{
	void m1() {
		System.out.println("멍");
	}
	
	void m2(int num) { // 대입 연산 : num이 함수로 대입됨
		System.out.println("멍 " + num);
	}
	
	void m3(int num) { 
		for (int i = 0; i < num; i++) {
			System.out.print("멍");
		}
		System.out.println();
	}
	
	//void m4(int a,b)
	void m4(int a, int b) { 
		System.out.println(a + " * " + b + " = ");
		System.out.println(a * b);
	}
//	void m5(int w, int h, char ch) { 
//	void m5(int w, int h, char ch, boolean b) { 
	void m5(int width, int height, char ch) { 
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(ch + " ");
			}
			System.out.println();
		}
	}
	
	void m6(int num) {
		for (int i = 0; i < 10; i++) {
			System.out.println(num + " * " + i + " = " + num * i);
		}
	}
	
	void m7(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	
	void m8(int w, int h, char ch1, char ch2) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if( (i+j) % 2 == 0) {
					System.out.print(ch1 + " ");
				}else {
					System.out.print(ch2 + " ");
				}
				// 복잡하면 이런 방식 사용
				System.out.print( 
					((i+j) % 2 == 0 ? ch1 : ch2) + " "
				);
			}System.out.println();
		}
	}
	
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.m1();
		t1.m2(3);
		t1.m3(5);
		t1.m4(3,4);
		
		// 첫번째 인수를 가로로 많이 씀, 두번째는 세로
		t1.m5(5, 4, '*');
		t1.m6(7);
		t1.m7(10);
		t1.m8(8, 7, '한', '글');
	}
}*/

/*//ex28
class Tiger{
	// 1. void f1() {}
	// 2. void f1(int a) {}
	// 3. int f1() {}
	// 4. int f1(int a) {}
	
	// 1. 리턴없다 f1(인수전달 없음) {}
	// 2. 리턴없다 f1(인수전달 있음) {}
	// 3. 리턴있다 f1(인수전달 없음) {}
	// 4. 리턴있다 f1(인수전달 있음) {}
	
	// 1. X f1(X) {}
	// 2. X f1(O) {}
	// 3. O f1(X) {}
	// 4. O f1(O) {}

	// 1 변수작명규칙 = 메소드 작명 규칙
	void method01() { // 메모리 한번 할당되서 객체끼리 공유해서 사용
		System.out.println("method01");
		System.out.println("method01");
		System.out.println("method01");
	}
	
	void method02() {
		System.out.println("method02");
	}
	
}
public class Hello {
	public static void main(String[] args) {
		// 코드의 재활용
		// 함수(메서드) : 자주 사용되는 코드를 저장해서 재활용한다. 
		Tiger t1 = new Tiger();
		System.out.println(1000);
		t1.method01(); // 함수를 호출
		System.out.println(2000);
		t1.method01();
		System.out.println(3000);
		
		Tiger t2 = new Tiger();
		t2.method01();
		System.out.println("----------------");
		
		t1.method02();
		t2.method02();
	}
}
*/
//ex27
/*// 관례적으로 클래스 이름의 첫글자는 대문자
// 설계도
class Airplane{
	// 멤버 종류
	// 1. 필드((멤버) 변수) -> 속성 
	int a; //int fuel;
	float b;
	int seat;
//	int[] ar; // 0개의 메모리 요청, 선언일 뿐
	int[] ar = new int[4]; // 16byte * 객체 수
	int num = 99; // 객체 생성시마다 99 가지고 태어남, 할당됨
	
	// 2. 생성자
	
	// 3. 메서드(함수)
}

public class Hello {
	public static void main(String[] args) {
//		Airplane a = new Airplane();
//		Airplane airplane = new Airplane(); // 1객체만 만들 때 사용
		
		// 실제 비행기 만들어짐
		Airplane air = new Airplane(); // new 하고 ctrl + space - 빠르게 가능
		// 실무 관습적으로 air1이라고 잘 안함, "air" 라고 한다.
		Airplane air2 = new Airplane(); 
//		air.a = 10;
		air.b = 20.0f;
		air.seat = 30;
		System.out.println(air.b);
		System.out.println(air.a);
		
		air2.seat = 40;
		// 완전히 서로 다른 메모리이다. 
		System.out.println(air2.seat + " " + air2.seat);
		
		System.out.println(air.ar.length);
		for (int i = 0; i < air.ar.length; i++) { // 이중 체이닝
			air.ar[i] = i * 10;
		}
		for (int i = 0; i < air.ar.length; i++) { 
			System.out.print(air.ar[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < air2.ar.length; i++) { 
			System.out.print(air2.ar[i] + " ");
		}
		System.out.println();
		
		air.ar = new int[8]; // 이전 메모리 사라지고 새로 생성됨
		for (int i = 0; i < air.ar.length; i++) { 
			System.out.print(air.ar[i] + " ");
		}
		System.out.println();
		
		// 서로 값은 같지만 메모리 다름
		System.out.println(air.num);
		System.out.println(air2.num);
		air.num = 1000;
		System.out.println(air.num);
		
		int[] ar;
		ar = new int[10]; // 이 때 메모리에 할당됨
		// ar을 사용했다고 치고...
		// 이전의 10개는 사라진다. 
		// 그리고 새로운 20개가 생성된다. 
		ar = new int[20]; 
		
		// 메모리 반납코드
		// delete ar;
		// java 가 자동으로 반납
			}
}
*/

/*//ex26)
public class Hello {
	public static void main(String[] args) {
		// 0 0 0 0 0 0  1+6 , 2+5, 3+4 의 결과 출력 -> 꼭 배열 사용
		Random rnd = new Random();
		int num = 30;
		int[] ar = new int[num];
		for (int i = 0; i < ar.length; i++) {
			// 데이터 갱신(초기화)
			ar[i] = rnd.nextInt(20);
		}
		for (int i = 0; i < ar.length; i++) {
			// 데이터 출력
			System.out.print(ar[i] + " ");
		}
		System.out.println();
		// 갱신(초기화)과 출력 코드 합치지(같이 놓지) 않고 다른 곳에 구현 
		// 사이에 상당한 코드가 들어가는게 일반적
		
		// ar[0] + ar[9]
		// ar[1] + ar[8]
		// ar[2] + ar[7]
		// ar[3] + ar[6]
		// ar[4] + ar[5]
		for (int i = 0; i < ar.length/2; i++) {
			System.out.print(ar[i] + ar[num-1-i] + " ");
		}
		System.out.println();
	}
}*/

/*//ex25 배열(array)
public class Hello {
	public static void main(String[] args) {
		// 1. 정석 -> "자주 사용"
		// 호랑이[] arr = new 호랑이[10]; o
		// 호랑이[] arr = new int[10]; x
		int[] arr = new int[10];
		int arr0, arr1, arr2, arr3; // 위랑 같은 메모리 요구
		
		// 2. 초기값 할당, 실전에서 사용x, 예제 샘플에서 사용
		int[] brr = new int[] {10, 20, 30}; // 개수 입력X
		
		// 3. 약식법 - new int[] 생략
		int[] crr = {10, 20, 30};
		
		// arr은 변수가 10개 있다.
		arr[0] = 10;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		arr[9] = 20;
		System.out.println(arr[9]);
		
		//ex2
		// 0-9
		// arr[-5] = 100; // 오류나서 중단됨
		// arr[10] = 100;
		// ArrayIndexOutOfBoundsException
		System.out.println("호랑이");
		
		
		//ex3) 변수 사용 및 산술 연산 가능
		int num = 4;
		arr[num] = 10;
		arr[num*2] = 20; // 산술 연산 유효범위 조심해서 사용
		arr[num*2-7] = 999; 
		System.out.println(arr[num*2]);
		System.out.println(arr[1]);
		
		//ex4)
		arr[5] = 7;
		arr[7] = 999;
		arr[arr[5]*2-7] = 888;
		System.out.println(arr[7]);
		
		
		// ex5)
		System.out.println("------------");
		System.out.println(arr.length);
		
		// ex6)
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(); //64~67 한 쌍
		System.out.println("독수리");
		
		
	}
}
*/

/////////////////////////////////////////////2월 8일
//ex24
/*public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		int num = rnd.nextInt(30);
		switch (num % 2) { //0 또는 1    nextInt(10) -> 0~9
		case 0:{ // 들어가는 코드 여러 줄
			for (int i = 0; i < 10; i++) {
				System.out.println( num + " * " + i + " = " + num*i);
			}
		}break;
		case 1:{
			int sum = 0;
			for (int i = 0; i <= num; i++) {
				sum += i;
			}
			System.out.println(num + " 까지의 합은: " +sum);
		}break;
		
		default: break; // 들어가는 코드 없을 떄
		}
	}
}*/

/*//ex23
public class Hello {
	public static void main(String[] args) {
		int score = 100;
		switch (score / 10) {
		case 10:  // break; break 주석처리 -> 의도적으로 생략 알림
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;

		default:
			System.out.println("F");
			break;
		}
	}
}*/

/*//ex22
public class Hello {
	public static void main(String[] args) {
		// 1. switch 안에 변수를 사용할 수 있다. 
		// 2. case 뒤에 변수 사용할 수 없다. 
		// 3. break를 생략하면 switch를 빠져나오지 않는다.
		// 4. 만족하는 분기문이 없을때는 default로 이동한다.
		// 5. 정수, 문자, 문자열 모두 분기가 가능하다. 
		// 6. 의도적으로 break를 생략하기도 한다. 
		
		int num = 40;
		//int nn = 10;
		char ch = '한';
		switch ("호랑이") {
		//case nn: -> 사용X
		case "호랑이":
			System.out.println(1);
			break;
			
		case "어흥":
			System.out.println(2);
			break;
			
		case "호랭이":
			System.out.println(3);
			break;

		default:
			System.out.println("호랑이");
			break;
		}
	}
}*/

/*//ex21 난수 발생
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		int num = rnd.nextInt(); //+-20억
		if(num < 0) {
			num = -num;
		}
		System.out.println(num);
		
		int sum = 0;
		while(num >= 10) {
			sum += num % 10;
			num /= 10;
		}
		sum += num;
		System.out.println(sum);
	}
}*/

/*//ex20
public class Hello {
	public static void main(String[] args) {
		int num = 18564;
		
		while(true) {
			System.out.println(num);
			if( num % 2 == 0) {
				num = num / 2;
			}else {
				num = num * 3 + 1;
			}
			num = ( num % 2 == 0) ? num / 2 : num * 3 + 1; 
			if(num == 1) {
				System.out.println(num);
				break;
			}
		}
	}
}*/

/*//ex19 while(for 비슷)
public class Hello {
	public static void main(String[] args) {
		int num = 0;
		while(true) {
			num++;
			System.out.println(num);
		}
		
		int num = 0;
		while(num < 4) {
			System.out.println(num);
			num++;
		}
		
		num = 0;
		while(true) {
			if(num == 4) {
				System.out.println("탈출 전");
				break;
//				System.out.println("unreach code");
			}
			System.out.println(num);
			num++;
		}
	}
}*/

/*
//ex18-2
public class Hello {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) { // 세로
			for (int j = 0; j < 4; j++) { // 가로
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 0; i < 3; i++) { // 세로
			for (int j = 0; j < 4; j++) { // 가로
				System.out.print("[" + i + " " + j + "]"); // 알고리즘 규칙 출력시 도움
			}
			System.out.println();
		}
		System.out.println();
		
		// 체스판
		int width = 8, height = 7;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if((i + j) % 2 == 0) {
					System.out.print("O ");
				}else {
					System.out.print("X ");
				}
				System.out.println((i + j) % 2 == 0 ? "O " : "X ");
			}
			System.out.println();
		}
		System.out.println();
		
		int result;
		if(3 > 2) {
			result = 10;
		}else {
			result = 20;
		}
		
		// 무조건 삼항연산으로 수정한다. 
		result = (3 > 2) ? 10 : 20;
		
		// 잘못된 예시
//		(3 > 2) ? result =10 : result =20;
		
		int func() {
			if( 3 > 2 ) {
				return 100;
			}else {
				return 200;
			}
		}
		return 3>2 ? 100 : 200;
		// 잘못된 예시 3 > 2 ? return 100 : return 200
	}
}*/

/*//ex18-1
public class Hello {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			System.out.println("-------------");
			for (int j = 0; j < 4; j++) {
				System.out.println(1);
			}
			System.out.println("*************");
		}
	}
}*/

/*//ex17 
public class Hello {
	public static void main(String[] args) {
		int num = 5;
		for (int i = 0; i < 10; i++) {
			System.out.println( num + " * " + i + " = " + num*i);
		}
		System.out.println("---------------");
		
		
		int sum = 0;
		int num2 = 1000;
		for (int i = 1; i <= num2; i++) { 
			sum += i;
//			System.out.println(sum);
		}
		System.out.println(sum);
		System.out.println("---------------");
		
		
		int sum3 = 1;
		int a = 2, b = 8;
		// a의 b승
		for (int i = 0; i < b; i++) { // n=반복횟수
			sum3 *= a;
		}
		System.out.println(sum3);
	}
}*/

/*//ex16 for문
public class Hello {
	public static void main(String[] args) {
		// 유형1
		for (int i = 0; i < 4; i++) { // n=반복횟수
			System.out.println(i);
		}
		
		// 유형2
		for (int i = 1; i <= 4; i++) {
			System.out.println(i);
		}
		
		// 유형3
		for (int i = -3; i < 3; i++) { // 원점기준 좌표, 시간 최적화시 사용, 2*n+1
			System.out.println(i);
		}
		
	}
}*/

/*//ex15
public class Hello {
	public static void main(String[] args) {
		int score = 87;
		if(score >= 90) {
			System.out.println('A');
		}else if(score >= 80){
			System.out.println('B');
		}else if(score >= 70){
			System.out.println('C');
		}else {
			System.out.println('F');
		}
		// 실행속도 평준화를 위해 else if -> swich 사용
		
	}
}*/

/*//ex14
public class Hello {
	public static void main(String[] args) {
		// 1. if() {}
		// 2. if() {} else{}
		// 3. if() {} else if(){} else if(){}
		int num = 10;
		if(num % 2 == 0) {
			System.out.println("Even");
		}else {
			System.out.println("Odd");
		}
		
		
		int password = 1234;
		// if - else 내용과 코드가 같아야함
		// 잘못된 예
		if(password != 1234) {
			System.out.println("틀림");
		}else {
			System.out.println("맞음");
			System.out.println("유저가 로그인 하였음");
			System.out.println("다음 정보 확인");
		}
		
		// 수정 후
		if(password != 1234) {
			System.out.println("틀림");
			//break;
		}
		System.out.println("맞음");
		System.out.println("유저가 로그인 하였음");
		System.out.println("다음 정보 확인");
		
		
		
		int nn = 10;
		if (nn < 0) {
//			sin(); // 속도에 민감
			nn = -nn;
		}else { // 실행속도의 평준화를 위해
//			sin();
			nn = +nn; // 자기 대입 - 가치X
		}
		// else 를 붙여야 속도 동일하므로 else 들어가는게 맞음 - 실행 속도 안정적		
	}
}
*/

/*//ex13
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		if(3 > 2) {
			System.out.println(2);
			if(3 != 4) {
				System.out.println(3);
			}
			System.out.println(4);
			if(3 + 4 >= 7) {
				System.out.println(5);
			}
			System.out.println(6);
		}
		System.out.println(7);
		
		
	}
}*/

/*//ex11) if, for, while, switch 
public class Hello {
	public static void main(String[] args) {
		if(true) {
			System.out.println(1);
			System.out.println(2);
		}
		
		if(false) {
			System.out.println(3);
			System.out.println(4);
		}
		
		System.out.println(5);
		System.out.println("------------------------");
		
		if(true) {
			System.out.println(6);
			if(true) {
				System.out.println(7);
			}
			System.out.println(8);
		}
		System.out.println(9);
		
	}
}*/

/*//ex10
public class Hello {
	public static void main(String[] args) {
		// 두 변수의 값 교환
		int a = 10, b = 20;
		int t; // temp
		System.out.println(a + " " + b);
		
		t = a;
		a = b;
		b = t;
		System.out.println(a + " " + b);
		
	}
}*/

/*
//ex9
public class Hello {
	public static void main(String[] args) {
		int n = 10;
		n = 20;
		System.out.println(n);
		//1
		n = n + 10; //add연산, move 연산 실행됨
		System.out.println(n);
		//2
		n += 10;
		System.out.println(n);
		
		n = n + 1;
		n+= 1;
		n++; // 단항연산자, 실행 속도 제일 빠름, inc라는 어셈블리어 명령이 실행됨 매우 빠름
		++n;
		
		n = 10;
		int a, b;
		a = n++; // 대입증가 : 대입 후 증가
		System.out.println(a + " " + n);
		
		n = 10;
		b = ++n; // 증가대입 : 증가 후 대입
		System.out.println(b+ " " + n);
	}
}*/

/*//ex8
public class Hello {
	public static void main(String[] args) {
		// 1. 변수이름은 중복될 수 없다. 
		int apple;
//		int apple; (x)
		
		// 2. 대소 구분된다. 
		int Apple;
		
		// 3. 첫글자가 숫자가 아니라면 숫자 사용가능
		int Apple123;
//		int 9Apple; (x)
		
		// 4. _ $ 2개의 특수문자만 사용 가능
		int apple_num;
		int _34; //3행 4열 처럼 숫자를 변수로 적고 싶을 때 _
		
		// 5. 한글 사용 가능(가급적 피하기)
		int 사과 = 10;
		System.out.println(사과);
		
		// 6. 단어 합성시에는 카멜표기법 사용 (낙타등처럼)
		int bananaNumber = 10;
		
	}
}*/

/*//ex7
public class Hello {
	public static void main(String[] args) {
		System.out.println("안녕");
		System.out.println("반");
		System.out.println("가워");
	}
}*/

/*
//ex6
public class Hello {
	public static void main(String[] args) {
		// 기본타입(정수관련) : byte, short, int, long 
		// 기본타입: boolean(1), char(2) , float(4 소숫점), double(8 소숫점)
		byte apple; // 변수(변화O) <-> 상수(변화X)
		// = 대입연산자
		apple = 10;
		System.out.println(apple);
		apple = 20;
		System.out.println(apple);
		apple = 127; // byte 범위 -128 ~ 127
		
		// short  	type 
		// banana   variable 
		// = 		대입연산 
		// 20 	 	리터럴(대입되는 모든 값)
		short banana = 20; // 선언 동시에 초기화	
		int orange = 30;		
		long kiwi = 2992599;
		
		// 기본타입: boolean(byte 1개의 크기), char(2) , float(4 소숫점), double(8 소숫점)
		boolean t1 = true;
		char t2 = 'A';
		char t3 = '한';
		// 밑의 프로그램은 가급적 피한다. 
		char t4 = 65; // t2랑 같지만 가독성이 떨어짐
		
		System.out.println(t2);
		System.out.println(t3);
		System.out.println((int)t2);
		System.out.println((int)t3);
		System.out.println((char)(t3+1)); // +1 해서 숫자가 된 것을 char타입으로 출력해라
		
		// char 는 음수x : 0~6만
		System.out.println((int)Character.MIN_VALUE);
		System.out.println((int)Character.MAX_VALUE);
		
		char a = 'A', b = 20;
		System.out.println(a + b);
		
		
		float t5 = 3.14f; //float 뒤에 무조건 f, 4byte
		double t6 = 3.14; //double 뒤에 f 안 붙음, 8byte, 정밀한 작업
		
		float sum = 0.0f;
		for(int i = 0; i < 100; i++) {
			sum += 0.1f;
		}
		System.out.println(sum);
		
		double sum2 = 0.0;
		for(int i = 0; i < 100; i++) {
			sum2 += 0.1;
		}
		System.out.println(sum2);
		
		if (sum == 10.0f) {
			System.out.println(true);
		}		
	}
}
*/

/*
//ex5
public class Hello {
	public static void main(String[] args) {
		// 1byte
		System.out.println(Byte.MIN_VALUE); 
		System.out.println(Byte.MAX_VALUE);
		
		// 2byte = Short
		System.out.println(Short.MIN_VALUE); 
		System.out.println(Short.MAX_VALUE);
		
		// 4byte = Integer
		System.out.println(Integer.MIN_VALUE); 
		System.out.println(Integer.MAX_VALUE);
		
		// 8byte = Long
		System.out.println(Long.MIN_VALUE); 
		System.out.println(Long.MAX_VALUE);
		
		
	}
}
*/

/*
//ex4
public class Hello {
	public static void main(String[] args) {
		//관계 연산자, 비교 연산자
		System.out.println(10 > 5);
		System.out.println(10 >= 5);
		System.out.println(10 < 5);
		System.out.println(10 <= 5);
		System.out.println(10 == 5);
		System.out.println(10 != 5);
		System.out.println("---------");
		
		// 논리 연산자
		System.out.println(false || false);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(true || true);
		System.out.println("---------");
		
		System.out.println(false && false);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(true && true);
		
		System.out.println(!true);
		System.out.println(!(3 > 2));
	
		// 연산 순위 : 산술 > 관계 > 논리
		System.out.println(3 + 2 > 7 || 2 + 6 <= 8);
		
		
	}
}
*/

/*
//ex3
public class Hello {
	public static void main(String[] args) {
		System.out.println(17 + 3);
		System.out.println(17 - 3);
		System.out.println(17 * 3);
		System.out.println(17 / 3);
		System.out.println(17 % 3); // 경우의 수, 많이 사용
		
		System.out.println(3 + 4 * 5); // 우선순위
		System.out.println( (3 + 4) * 5); 
		System.out.println((2 + 3) * (4 + 5)); 
	}
}
*/

/*
//ex2
public class Hello {
	public static void main(String[] args) {
		System.out.println(100); // 정수
		System.out.println('한'); // 문자 - 1개 (띄어쓰기 1개도 가능)
		System.out.println("호랑이"); // 문자열
		
		System.out.println(100+200); // 산술연산 : 숫자 + 숫자
		System.out.println(100 + " 호랑이"); // 숫자+문자열 - 결과: 문자열
		System.out.println("호랑이 " + 100); // 문자열
		System.out.println("호랑이 " + "사자");
		System.out.println("100"); // 문자열 형식
		System.out.println("100 " + 100); // 문자열 + 숫자 -> 결과 : 문자열
		
		// 책 읽듯이 앞부터 차례대로
		System.out.println(10 + 20 + "호랑이"); // 숫자(연산o) + 문자열 -> 결과 : 문자열
		System.out.println("호랑이"+ 10 + 20); // 문자열 + 숫자(연산x) -> 결과 : 문자열
		System.out.println(10 + " " + 20 + " " + "호랑이" + " " + 30); // 숫자 여러개를 한줄에 출력하고 싶을 때 " " 사용
		
		System.out.println(10 + " " + 20 + " " + 'a' + " " + 30);
		System.out.println(1 +'A'); // ASCII
		System.out.println((char)(1 +'A')); // type casting
		
	}
}
*/

/*
//ex1
public class Hello {

	public static void main(String[] args) {
		System.out.println(1000);
		System.out.println(4000);
		System.out.println(2000);
		System.out.println(3000);
//		System.out.println();

	}
}
*/
