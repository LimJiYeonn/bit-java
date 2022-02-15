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
		System.out.println("����� ��ο�");
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		System.out.println("��ο� ����");
	}
}


/*
//ex88-7 UI : JavaFx
// �ƿ� ����� �޾Ƽ� class�� ����
// btn1.setText("ȣ����"); �������µ� �ذ� ���
// 1. �����ڿ��� ��ư�� �μ��� �����ϱ�( + ������ ���� ��ư �ʵ� ����)
// ��Ʈ���� ���� 5���� �ʿ��ϴٸ� ������ ���� - �������� �ʵ带 5�� ����?? �ʹ� �����ϴ�.
// public Tiger(Button btn, TextField tf , ,,,,,) {}  -> �ڵ� ������
// 2. this

class Tiger extends Thread{
	// �����ʿ�
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
		System.out.println("������ ����");
		System.out.println("������ ����");
		Platform.runLater( () -> {
//			btn.setText("ȣ����"); 
			hello.btn1.setText("ȣ����");
		} );
		System.out.println("������");
	}
}
public class Hello extends Application{ 
	Button btn1;
	Button btn2;
	@Override
	public void start(Stage stage) throws Exception {	
	// arg0 �������������� stage�� ����
	HBox root = new HBox(); // �θ�
	root.setPrefSize(400, 300);
	root.setSpacing(10); // ��� ���ݿ� 10px
	
	btn1 = new Button("��ư1");
	btn2 = new Button("��ư2");
	// �͸� Ŭ������ this�� Ŭ������ ���ξ���
	btn1.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
//			Tiger t = new Tiger(); // �޸𸮰���
			Tiger t = new Tiger(Hello.this); 
			t.start();
		}
	});
		

	root.getChildren().addAll(btn1, btn2);
		
	Scene scene = new Scene(root); 
	stage.setScene(scene); 
	stage.setTitle("ȣ����");
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
	HBox root = new HBox(); // �θ�
	root.setPrefSize(400, 300);
	root.setSpacing(10); // ��� ���ݿ� 10px
	
	Button btn1 = new Button("��ư1");
	btn1.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
			// Thread - �͸� ��ü
			// ������ȿ��� �Ӽ���, ���� �����ϴ� ���� �����ؾ��Ѵ�.
			new Thread() {
				@Override
				public void run() {
					System.out.println("������ ����");
					// thread�ȿ��� �Ӽ� ����� Ŭ���� ���
					Platform.runLater( () -> {
						btn1.setText("ȣ����"); 
					} );
					System.out.println("������ ����");
				}
			}.start();
		}
	});
		

	root.getChildren().addAll(btn1);
		
	Scene scene = new Scene(root); 
	arg0.setScene(scene); 
	arg0.setTitle("ȣ����");
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
	HBox root = new HBox(); // �θ�
	root.setPrefSize(400, 300);
	root.setSpacing(10); // ��� ���ݿ� 10px
	
	
	Button btn1 = new Button("��ư1");
	Button btn2 = new Button("��ư2");
	btn1.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
			btn2.setText("ȫ�浿");
		}
	});
		
	btn2.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
			// �Ӽ��� �����Ѵ�. 
			btn1.setVisible(!btn1.isVisible()); // �������
//			btn1.setDisable(true); // ��Ȱ��ȭ
//			btn1.setDisable(!btn1.isDisable()); 
		}
	});
	
	root.getChildren().addAll(btn1, btn2);
		
	Scene scene = new Scene(root); 
	arg0.setScene(scene); 
	arg0.setTitle("ȣ����");
	arg0.show(); 
		
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch(); 
	}
}*/


/*
//ex88-4 ä�����α׷� ����
// import�� �� FX�ɷ� �ϱ�!
public class Hello extends Application{ 
	@Override
	public void start(Stage arg0) throws Exception {
	
	VBox root = new VBox(); // �θ�
	root.setPrefSize(400, 300);
	root.setSpacing(10); // ��� ���ݿ� 10px
	
	
	Button btn1 = new Button("��ư1");
	btn1.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
			System.out.println("Ŭ����");
		}
	});
	
	TextArea textArea = new TextArea();
	
	TextField textField = new TextField();
	textField.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) { // enter�� ���� �� ���� �̺�Ʈ �Ͼ
//			System.out.println("�޹���");
			String s = textField.getText();
//			System.out.println(s);
			textArea.appendText(s + "\n");
			textField.setText(" ");
		}
	});
	
	root.getChildren().addAll(btn1, textField, textArea);
	
	
	Scene scene = new Scene(root); 
	arg0.setScene(scene); 
	arg0.setTitle("ȣ����");
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
//// 1.��ӹ��� Ŭ���� ����
//// 2. �͸� Ŭ����
//// �� �ΰ� ����
//class Tiger{
//	void f100(A<Integer> tt) {
//		tt.f1();
//	}
//}
public class Hello extends Application{ 
@Override
	public void start(Stage arg0) throws Exception {
	// ��ü �������� �ʰ� �ٷ� �Լ��μ������ڸ��� �͸�Ŭ������ �ֱ�
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
	
	
	HBox root = new HBox(); // �θ�
	root.setPrefSize(400, 300);
	root.setSpacing(10); // ��� ���ݿ� 10px
	
	
	Button btn1 = new Button("��ư1");
	// �μ��� �͸� Ŭ������ ����
	// EventHandler�� �������̽��̰� �ȿ� handle �޼ҵ尡 �ִ�. 
	// �� ��� ���� ���� ���
	// �������̽� �и��� ��Ģ
	btn1.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
			System.out.println("Ŭ����");
		}
	});
	
	
	Button btn2 = new Button("��ư2");
	btn2.setOnAction(new EventHandler<ActionEvent>() { 
		@Override
		public void handle(ActionEvent arg0) {
			System.out.println("����");
		}
	});
	
	root.getChildren().addAll(btn1, btn2);
	
	
	Scene scene = new Scene(root); 
	arg0.setScene(scene); 
	arg0.setTitle("ȣ����");
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
	HBox root = new HBox(); // �θ�
	root.setPrefSize(400, 300);
	root.setSpacing(10); // ��� ���ݿ� 10px
	
	// ���1
//	Button btn1 = new Button("��ư1");
//	// root���� �ڽ����� ��� �� -> ��ġ �Ϸ�
//	root.getChildren().add(btn1); // ü�̴�
//	Button btn2 = new Button("��ư2");
//	root.getChildren().add(btn2); 
//	
	
	// ���2
	Button btn1 = new Button("��ư1");
	Button btn2 = new Button("��ư2");
	Button btn3 = new Button("��ư3");
	root.getChildren().addAll(btn1, btn2, btn3);
	
	
	
	Scene scene = new Scene(root); 
	arg0.setScene(scene); 
	arg0.setTitle("ȣ����");
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
	
	VBox root = new VBox(); // �θ�
	// â ũ�� ����
	root.setPrefSize(400, 300);
	
	// ��ġ �Ͼ
	
	
	
	// ��������, ȭ����� ���
	// ������ ������ Ŭ���� �ȿ� ���� ������ �ʴ� ��ġ�� ����Ѵ�. 
	Scene scene = new Scene(root); // ��ü ���
	arg0.setScene(scene); // ��ϵ� ��ü�� �μ��� �޾Ƽ� �ֱ�
	arg0.setTitle("ȣ����"); // show ������ ���� ��
	arg0.show(); // scene���� ��ϵ� ���� ȭ�鿡 ���
//	System.out.println(3); // ��������� ���̾�â�� ��Ÿ���� ��
		
	}
	public static void main(String[] args) {
//		System.out.println(1);
		System.out.println("start");
		launch(); // ��ó�� ���ŷ�Ǿ��ְ� â�� �����ϱ� ���ŷ Ǯ��
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
			
			// ���������� ������ ȣ���� �޸𸮿� �ø�
			Constructor<?> constructor = cls.getConstructor();
			Object obj = constructor.newInstance();
			
//			Method m = cls.getMethod("start"); //start �Լ��� ������, �޸� ����
			Method start = cls.getMethod("start", String.class); 
//			System.out.println(m);
			System.out.println(start);
			
			// start �Լ� ȣ��
//			m.invoke(obj);
			start.invoke(obj, "ȣ����");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	
	}
	abstract void start(String s);
}

public class Hello extends MyApp{ 
	//Application�� static launch()�� ������ �ִ�.
	//             abstract start(); 

	public void start(String s) { //public void start(String s)
		System.out.println(100);
		System.out.println(s);
	}

	public static void main(String[] args) {
		// static�̴�. static�ȿ����� static�� ȣ�Ⱑ��
		launch();

	}
}*/












// 2�� 14��////////////////


/*//ex86 UI 
//Swing -> JavaFx - java ����ڵ��� Swing ��� ���
//c++ -> MFC -> WinForm -> WPF - c++ ����ڵ��� �� �������� �� ���� �� �� ���
public class Hello extends Application{ // ctrl + space �� �� �ȳ����� �ٿ�ޱ�
	// https://gluonhq.com/products/javafx/
	// LTS ����ȭ����
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
//thread�� ������ ��ȣ�� �޴´�. 
//������ �ٷ� while(true)�� ���δ�. break������ �ߴ�
//���ŷ�� ����ǰ� Ǯ���� �ٸ� Thread�� �Ѿ
//real time ���°� 20������ �Ǹ� �����Ÿ�
class Tiger extends Thread{
	public void run() {
		System.out.println(1);
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.start();

		
		// ��ĳ���� 
		Thread t2 = new Tiger();
		t2.start();
		
		//�͸�Ŭ����
		Thread t3 = new Thread() {
			public void run() {
				System.out.println(2);
			}
		};
		t3.start();
		
		// �͸�ü
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
//Ű���常 �Է¹ް� �ٸ� �����忡�� ������� �ѱ� ���� �ִ�.
//2�� �����ؾ��ϴµ� 1�ٸ� �����ϰ� �ٸ� �����忡�� ������� �ѱ�
class Lion extends Thread{
	public void run() { 
		new Scanner(System.in).nextInt();
		System.out.println("������");
	}
}
class Tiger extends Thread{
	public void run() { 
		Lion t1 = new Lion();
		t1.start();
		new Scanner(System.in).nextInt();
		System.out.println("�ڳ���");
	} // ������ ����� ������ ����
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.start();
		new Scanner(System.in).nextInt();
		System.out.println("ȣ����");
	}
}
*/

/*
//ex84 multi Thread ���� �ڵ� 
// �ڳ����� ȣ���̶� �����ư��鼭 ����
class Tiger extends Thread{
	public void run() { // run�� Thread
		for (int i = 0; i < 10; i++) {
			System.out.println("ȣ���� : " + i);
			try {Thread.sleep(0);} catch (Exception e) {}
			// sleep(0) : ��ǻ�Ͱ� �����ϱ⿡ ���� ª�� �ð��� �����(�Ƚ��°� �ƴ�)
			// ����̶� �ٸ� ���α׷��� ����
			// ũ�Ѹ��� ���� ���� - Ŭ�� �� ȭ�� �� ������ ��� ���� �ش�.  
		}
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("�ڳ��� : " + i);
			try {Thread.sleep(0);} catch (Exception e) {}
		}
	}
}
*/

/*//ex83
class Tiger extends Thread{// ǥ�� class
	public void run() { // �������̽� ����̱� ������ �տ� public �ٿ����Ѵ�.
		// B
		System.out.println("thread start");
		System.out.println("call");
		System.out.println("thread end");
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.start(); // �θ� start �޼ҵ� ���� 
		System.out.println("ȣ����"); // A
		
		// (�̷������� ��Ƽ�½�ŷ�� ����)os�� ������� A, B�� �������� ������ �𸥴�.
		// main�� ���� �ְ� ���μ��� �������� ���� run�� ������� �ڿ� ���Դ�.
		// cpu�� �ڽ��� ���μ����� main���� 100�� ���� ���� ������� ��
		
		// main�� ������ Thread�� ��� ���ư� �� �ִ�. 
	}
}*/

/*
//ex82
class A{
	void start() {
		System.out.println("start call");
		run();
	}
	// �޼ҵ� ������ �����Ͻ� run����(�ڽĿ��� �����ε����� �𸣴ϱ�)
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
		// A Ŭ������ �Ⱥ����ָ� start�� ��ݾ��� ���ͼ� �����ϱ� ���� �� �ִ�. 
		t1.start();
	}
}
*/

/*//ex81) Scanner, ���ŷ �Լ�, �޸� ����
public class Hello {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		Random rnd = new Random();
		// ��ü ���� �� �ٷ� ������ ���� ��
		int random = new Random().nextInt(100);

		// nextInt �Լ��� ���ŷ �Լ��̴�.
		// ���ŷ �Լ��� ��ӵ� Ư�� ������ ������ �� ����
		// ���α׷��� ���̻� �������� ���ϴ� �Լ�
		// sleep(); - Ư�� �ð��� ���������� ������Ŵ
		
		// �񵿱� �Լ� : �Է� �������� Ŀ���� �����̰� ������
		// ���ŷ�� Ǯ���� �ٸ� �ڵ尡 ����� ����
		// ���� ����� ���̴�. 
		
		for (int i = 0; i < 100; i++) {
			System.out.println("���ڸ� �Է��ϼ���");
			int num = sc.nextInt();
//			int num = new Scanner(System.in).nextInt(); // ����� ���� ���.
			// resource leak - ��ü ���� �� close�ؾ� ��
			System.out.println(num);
			if( num == 999 ) {
				break;
			}
		}
		sc.close();
		System.out.println("���α׷��� �����մϴ�.");
	}
}
*/

/*
//ex80-2 LinkedList �߿��� ����
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
		mm.add(new Book("�ڹٸ� ����.", "ȫ�浿", "���������ǻ�1", 100));
		mm.add(new Book("���� �ڴ� ��", "������", "���������ǻ�2", 150));
		mm.add(new Book("�����Ͷ� �����ΰ�", "�̼���", "���������ǻ�3", 300));
		mm.add(new Book("���� ���� ����", "������", "���������ǻ�4", 1000));
		System.out.println(mm.size());
//		System.out.println(mm); // �� ����
		
		//Read
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
		
		// �˻� ����
		Book oneBook = mm.get(2);
		System.out.println(oneBook);
		System.out.println("--------------------");
		
		// Update ����
		mm.set(1, new Book("���� ���� ��", "������", "���������ǻ�2",200));
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
		
		// Delete
		System.out.println("--------------------");
		mm.remove(3);
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
	
	
		// ���ڸ����� �˻�
		Book findBook = search(mm, "�̼���");
		if(findBook != null) {
			System.out.println("ã�Ҵ�.");
			System.out.println(findBook);
		}else {
			System.out.println("�׷� ���� ����!");
		}
	}
	
	static Book search(LinkedList<Book> mm, String name) { //main�Լ��� static�̴ϱ� static�ȿ��� static
		for (Book book : mm) {
			if(book.author.equals(name)) {//������ getAuthor�� �ؾ���, ���ڿ� equals ���
				return book;
			}
		}
		// ��ã�� ���
		return null;
	}
}
*/	

/*//ex80-1 LinkedList �߿��� ���� - ��ü�� �ְ� ���
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
//ex79-3) �ùٸ� �ڵ�
public class Hello {
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>(); 
		Random rnd = new Random();
		
		// �������� �־ ����
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


/*//ex79-2) �߸��� �ڵ�
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
		// ���� �� �� ���ھ� �� ���
		// ���� ���Ŀ� index ��ȣ�� ���� �����ȴ�. 
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
//ex79-1) �˻� ����
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
// 1. Collection Ŭ������ ���� ���� �� �ִ°�? �ڷᱸ��

// Java �ڷᱸ���� ����. 
// 2. �̹� ���۵� Ŭ������ �� ����� �� �ִ°�? 

public class Hello {
	public static void main(String[] args) {
		LinkedList<Integer> mm = new LinkedList<Integer>(); 
		// CRUD(db���� ����ϴ� ���) + �˻�, ���� Ȯ��
		
		// Create
		System.out.println(mm.size());
		// create, add, insert �� add() - �Լ� ���� ��� ������� �۸�
		mm.add(100);
		System.out.println(mm.size());
		
		for (int i = 0; i < 10; i++) {
			mm.add(i * 10 + i);
		}
		System.out.println(mm.size());
		
		
		// Read
		// 1. Ȱ�뵵�� ��������. 
		System.out.println(mm); // mm.toString() toString ���� ����
		
		// 2. ���� ���� read, get, select
		for (int i = 0; i < mm.size(); i++) {
			System.out.print(mm.get(i) * 2 + " ");
		}
		System.out.println();
		
		// 3. for ���� ����ȭ ���� (forEach)- �����ڵ�(���� ������ ��)
		// data : ���� �������̵��� �ƴϸ� �ε����̴�. (java������ �����Ͱ� �Ѿ��)
		for (Integer data : mm) {
			System.out.print(data + " ");
		}System.out.println();
		
		// �迭�� forEach ����
		int[] ar = {10, 20, 30};
		
		// value, data, item ��� ���⵵ ��
		for (int data : ar) {
			System.out.print(data + " ");
		}
		System.out.println();

//		String s = "����ȭ�����Ǿ����ϴ�.";
//		for (int i : s) {} // java���� forEach���� ���ڿ� ���� �ȵ�
		
		
		// Update
		mm.set(5, 99); // index=5�� 99�� ����
		for (Integer data : mm) {
			System.out.print(data + " ");
		}System.out.println();
		
		
		// Delete
		// remove, delete, erase
		mm.remove(4);
		for (Integer data : mm) {
			System.out.print(data + " ");
		}System.out.println();
		
		
		// �˻�
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

// create(CRUD �� 1)�� Ưȭ�� �˰��� �׷��� ����� 
// 8���� ���̺귯�� ���� = Collection 



/*
//ex77 ���׸� ���
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

// ���׸� : �׻� ��ü�� �����Ǵ� ������ Ÿ���� ������
// �ش� ��ü�� ������ ��
class Dog<T>{ // <> == �����̳�
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
		// �������� integer�� t�� ��~
		// ����Ÿ�� ���X intX
		// Ŭ������ ��ȯ���ִ� Ÿ�� ��� Integer
		// <> �����̳� ���̴� ������ class�� �� �� �ִ�.
		
		
		Dog<Float> t5 = new Dog<Float>();
		t5.setData(100.0f);
		System.out.println(t5.getData());
		
		
	
		Tiger t1 = new Tiger();
		t1.setData(100);
		System.out.println(t1.getData());

		Lion t2 = new Lion();
		t2.setData("ȣ����");
		System.out.println(t2.getData());
		
		Cat t3 = new Cat();
		t3.setData(3.14f);
		System.out.println(t3.getData());		
	}
}*/

/*//ex76
// bmp ������ read, bmp ������ ���� ���� �� ������ �ڹٷν� ����������� ������°Ŵ�~
public class Hello {
	public static void main(String[] args) {
		try {
			Reader reader = new FileReader("sample.txt");
			// FileNotFoundException ��� �Ǵ� ���ϸ� ����
//			Reader reader = new FileReader("s.txt");
			
			System.out.println(1000); // �ͼ��ǽ� ���� �ڵ� ����X
			
			while(true) {
				// int java.io.Reader.read() throws IOException
				int readData = reader.read();
				if(readData == -1) { // EOF - end of file
					System.out.println("���� ������ ��� ����");
					break;
				}
				System.out.println((char)readData);
				
			}	
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace(); // �׻� �̷��� �ɾ�α�
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
// �������� ���� ����
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		rnd.nextInt(1);
		try {
			// open, ��ĳ����
			Writer writer = new FileWriter("ex75.txt"); // 2���� ��
			
			int width = 6, height = 5;
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					writer.write((i + j) % 2 == 0 ? "O " : "X ");
				}
				writer.write("\n");
			}
			
			// close
			writer.close(); // 2���� ��
			
		} catch (Exception e) {
			// TODO: handle exception
		}			
	}
}
*/
/*//ex74
// ���� ����� : ���� �ݱ� �߿�
// ������ resorce�� �־ ���� ������ �ٸ� �������α׷��� �ڿ��� ����� �� ����.
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);

		try {
			// open
			// ��ĳ���� (Writer���θ� OutputStreamWriter�θ� FileWriter�ڽ�)
			Writer writer = new FileWriter("sample.txt"); // 2���� ��
			// sample.txt ������ ����ų�, �����ϸ� ������. 
			
			writer.write("apple");
			writer.write("\n"); //ĳ���� ����?
			writer.write("ȣ����");			
			
			// close
			writer.close(); // 2���� ��
			
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
		System.out.println("ȣ����1");
		if(a > b) {
			System.out.println("ȣ����2");
		}else {
			// �Լ� ���� �ߴ�
			return; // ȣ����3�� ��¾ȵ�
		}		
		System.out.println("ȣ����3");
	}
	
	// return �� ȣ����3�� ��� ����ؾ��� ���
	static void m3(int a, int b) {
		try {
			System.out.println("ȣ����1");
			if(a > b) {
				System.out.println("ȣ����2");
			}else {
				return; // �ݵ�� finally�� ����.
			}		
		} catch (Exception e) {
			
		}finally {//�Լ� �ߴܵǾ ������ finally ����
			System.out.println("ȣ����3");
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
//		}finally { // ���û��������� ������ �����
//			System.out.println(2);
//		}
//		System.out.println(3);
	}
}
*/

/*//ex72 sleep
public class Hello {
	public static void main(String[] args) {
		// sleep 1�ʸ��� ���� ���, ��ü������ �ͼ��� �߻���
		
		for (int i = 0; i < 4; i++) {
			System.out.println(i);
//			try {
//				Thread.sleep(1000); // 1000ms(milli seconds) == 1��
//			} catch (Exception e) {
//			}
			// 1���̸� ����ó��
			try {Thread.sleep(1000);} catch (Exception e) {}
		}
	}
}
*/

/*//ex71
class Tiger{
	void f1() {
		System.out.println("�Լ� 1");
		// 1. catch�� �ͼ��� �޾Ƶ��̱�
		try {
			throw new Exception();
			// throw ���� ������
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	// 2. �ͼ��� ���ѱ��
	// �Լ� ���� �ڿ��� �߻��Ѵٶ�� �˸��� ȣ���� ����� ����
	// �� �Լ����� �� �ް� �� �Լ��� ȣ���� �ʿ��� �ͼ����� �ްڴ�. 
	void f2() throws Exception {
		System.out.println("�Լ� 2");
		throw new Exception();
	}
}
public class Hello {
	public static void main(String[] args) throws Exception{
		Tiger t1 = new Tiger();
		t1.f1();
		System.out.println("ȣ����1");
		
//		t1.f2(); 
		// Unhandled exception �ܿ��
		// �� �Լ��� ��ü������ �ͼ����� �߻��ϴ� �� ���� �ʰڴ�.
		// �� �Լ��� ����ϴ� ����� �޾ƶ�~ ��� ���̴�. 
		
		try {
			t1.f2(); 
		} catch (Exception e) {
			System.out.println("�߻�");
		}
		System.out.println("ȣ����2");

		
		// 3. main�� ���� ���Ѱ� ��������� os���� ���ѱ�
		// public static void main(String[] args) throws Exception{
		t1.f2(); 
		
		
		// 2�� ���� ���
		// ����(�پ���) ���� �߻� ���� - �Լ��� ȣ���� ������ Ȯ�� �� ������� ���α׷��� ¥���Ѵ�. 
		
	}
}*/

/*
//ex70 ����ó��
// ������ try catch�� ��������� �ʴ´�. 
public class Hello {
	public static void main(String[] args) {
//		Tiger t1 = new Tiger();
		int[] ar = new int[3]; // 0 1 2 ���� ����
		// 1. ArrayIndexOutOfBoundsException ���� ����
		System.out.println("ȣ����1");
		// ���� �߻��� ���α׷��� �ߴܵ�
		// try-catch : ���α׷� �ߴ��� ����

		//try�ϰ� ctrl + space
		// ������ try���� �迭 �ȳ��� - �����ϱ� ���ؼ� ����
		try {
			ar[3] = 10; // >> ���⼭ �ߴܵ�
		} catch (Exception e) {
			// �ͼ��ǹ߻��� catch ������� ���´�.
			System.out.println("�߻�");
			e.printStackTrace(); // ��� �߻��� �ͼ����� ������ ���
		}
		System.out.println("ȣ����2");
		
		// 2. ArithmeticException �������� ����
		try {
			System.out.println(5 / 0); // 0���� ���� = �Ҵɻ���
			
		} catch (Exception e) {
			System.out.println("�߻�");
		}
		System.out.println("ȣ����3");
		
		
		
		// 3. NullPointerException
		// ���� ���� �߻�
		String s = null;
		try {
			s.length(); // ��ü�� �ƴѵ� �޼ҵ� ���
		} catch (Exception e) {
			System.out.println("ȣ����4");
		}
		
		// ������� ���α׷� (open Lib���� �ʼ�) - �̷����������� ������ ������������, �ڵ尡 ���. 
		// s�� ��ü�� ������ �ȹ����� �𸣴� ����
		s = new String("������"); // null�� �ƴ� ���ɼ��� ������ ������̰� ¥��
		// ���̻��̿� �ڵ尡 �߰������� �� �� ������
		if(s != null) {
			s.length(); 
		}
		
	}
}
*/








//2�� 11��


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
		
		Bbb t2 = (n) -> { // �Ű����� �̸��� ������� �����ص� ��
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
		System.out.println(t4.f1("ȣ����", 3000));
		
		
		
		// �����ڵ尡 �� �ٸ� �ִ� ��쿡��
		// return �� {}�� ���� ������ �� �ִ�. 
		Ccc t5 = () -> 200;
		// t3�� ���� ���
		System.out.println(t5.f1());
		
		Ddd t6 = (s, n) -> s + n; 
		System.out.println(t6.f1("����", 4000));
		
	}
}
*/
/*//ex69
interface Tiger{
	void f1();	
}
class Lion{
	void f1(Tiger t) {
		t.f1(); // �������� �ش�
	}
}
public class Hello {
	public static void main(String[] args) {
		Lion lion = new Lion();
		lion.f1(new Tiger() {
			@Override
			public void f1() {
				System.out.println("ȣ����");
			}
		});
		
		lion.f1(new Tiger() {
			@Override
			public void f1() {
				System.out.println("������");
			}
		});
		
		
		Tiger t1 = new Tiger() {
			@Override
			public void f1() {	
			}
		};
		
		// �����Լ� (���ٽ�), -> = ���ο�
		Tiger t2 = () -> { // �μ����� ��� ()
				System.out.println("�޹���");
		};
		t2.f1();
		
		Tiger t3 = () -> {System.out.println("�޹���2");};
		t3.f1();
		
		
		lion.f1( () -> {
			System.out.println("�޹���3");
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
		// �̱��� �ڵ��̱� ������ ��ü ���� �Ұ�
//		Tiger t1 = new Tiger();
		
		// �������̽� ���1 - Lion Ŭ������ �̿�
		Lion t1 = new Lion();
		Tiger t2 = new Lion();
		
		// �������̽� ���2 
		// �͸�Ŭ������ �̿��ؼ� �������̽��� ����Ѵ�. - ���� ���� ���� �ǳ� ���Ŵ�!!(���ٽİ� ����ϳ�)
		Tiger t3 = new Tiger() {
			@Override
			public void f1() {
				System.out.println("ȣ����");
			}
		};
		t3.f1();
		
		// �������̽� ���3
		// ���ý����Լ�
		// �͸� ��ü ���
		new Tiger() {
			@Override
			public void f1() {
				System.out.println("�޹���");
			}
		}.f1();
	}
}*/





/*//a�� b�� ������ ���踦 ������ �ִ�. 
class Aaa{
	Bbb bbb;
	Aaa(Bbb bbb){ // ����
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
	public void f1() {System.out.println("���� ����");}
	
}


public class Hello {
	public static void main(String[] args) {
		Aaa t = new Aaa(new Ccc());
		t.f2();
	}
}

*/
//ex67-6 ��ü���� ���� �ڵ�
/*class Baduk{
	// �����ڿ��� �μ������� �ع���
	AI ai;
	
	//  �����ڴ� ����(InJection)�� �޴´�.
	 Baduk(AI ai){
		 this.ai = ai;
		 System.out.println("�뱹�� �����մϴ�.");
	 }
	 // ������ ���� ���� - �μ� �ʿ�X
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
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
	public void stop() {
		System.out.println("���İ� ������ ����մϴ�. ");
	}
}
class BetaGo implements AI{
	public void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
	}
	public void stop() {
		System.out.println("��Ÿ�� ������ ����մϴ�. ");
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


/*//ex67-3 �̱��� Ŭ������ ���� �ϴ� ���� ����
class Baduk{
	 Baduk(){
		 System.out.println("�뱹�� �����մϴ�.");
	 }
	 void play(AI alphaGo) { // �׻� ��ĳ��������
		 alphaGo.play();
	 }
	 
}

////ex67-4 �߻�Ŭ����ȭ ��Ŵ
//abstract class AI{
//	abstract void play(); 
//}

//ex67-5 �������̽�ȭ ��Ŵ
interface AI{
	void play(); 
}

class AlphaGo implements AI{
	public void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
}
class BetaGo implements AI{
	public void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
	}
}

public class Hello {
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play(new AlphaGo());
		baduk.play(new BetaGo());
		
	}
}*/

//ex67-2) �ٸ� �ΰ��������� ������ �� ���� Ŭ������ �Լ��� �߰��ؾ��ϴ� ����
/*class Baduk{
	 Baduk(){
		 System.out.println("�뱹�� �����մϴ�.");
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
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
}
class BetaGo{
	void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
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
//ex67-1) �ΰ������� ������ ���
class Baduk{
	 Baduk(){
		 System.out.println("�뱹�� �����մϴ�.");
	 }
	 void play() {
		 System.out.println("�ΰ������� ���İ��Դϴ�. ");
		 
	 }
}
public class Hello {
	public static void main(String[] args) {
		Baduk baduk = new Baduk();
		baduk.play();
		
	}
}
*/

/*//ex66 final(������)
// 1. �ʵ� final
// 2. Ŭ���� final
// 3. �޼��� final
class Tiger{
	// 1. �ʵ� final (���� �ʱ�ȭ�ϴ°� ���Ⱑ �������̴�.)
	// ��𼱰� ���Կ����� �ѹ��̶� ����(������ �Ǵ� �ʵ� ������) ��𿡼����� ���� �� ��
	// �빮�ڷ� ���°� �Ϲ����� ���̴�. 
	// 2. ���ȭ �Ǿ� ������. (������ �������� ����̴�. )
	// const
//	final int NUM = 10; // 1
	final int NUM; // 1.2
	Tiger(){
		NUM = 30; //1.2
	}
	void f1() {
//		this.NUM = 20; // ���� �Ұ�
	}
}


class Aaa{}
final class Bbb extends Aaa{} 
// class�� �տ� ���� ����� �������� ���� ���� class���� ��Ӹ���
//// �ش� Ŭ������ �ڽ��� ����� ����
//class Ccc1 extends Aaa{}
////class Ccc2 extends Bbb{}
//class Ddd  extends String{}
//class Eee extends Thread{}

class Fff{
	final void f1() {} // �������̵� �Ұ�
	// ������ �θ���� ����ϰ� �� final�� ����
	void f2() { 
		f1();
	}
}
class Ggg extends Fff{
//	void f1() {} // �θ��� �޼��忡�� final �����߱� ������ �������̵� �Ұ�
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
//		t1.NUM = 20; // ���� �Ұ�
//		Math.PI;
	}
}*/



/*//ex65
// ���� �������̽� ���� -> ��ĳ���ð� ���õ� ������ ����ϱ� ���� �̸� ��������
// line Ŭ������ ������� �� ������ Ȥ�� �𸣴ϱ� �������̽� �����س���
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

@FunctionalInterface // ���� �Լ��� �ϳ� ������ �˸�, �� �̻� �ۼ��� ����
// @ = ������ ������ ���� ã��
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
//	// �����ڵ��� �����ؼ� �����ؾ� �� �������̽�(interface)�̴�.
//	// ���� ���� �������ϰ� ������ ���� ���� ���̴�. 
//	abstract void message(); 
//	abstract void tel();
//	abstract void appStore();
//	abstract void fold();
//	abstract void charge();
////	void f2() {} // �߻� Ŭ�����ȿ� �Ϲ� �Լ� �־ ��� ����
//	
//}
//class Android extends SmartPhone{
//	
//}
//class IOS extends SmartPhone{
//	
//}


abstract class Aaa{
	// �����ڵ��� �����ؼ� �����ؾ� �� �������̽�(interface)�̴�.
	// ���� ���� �������ϰ� ������ ���� ���� ���̴�. 
	abstract void f1(); 
	abstract void f2();
}
class Bbb extends Aaa{ // ���
	void f1() {}
	void f2() {}
}


interface Ccc{ // �߻�Ŭ������ ������ �ٸ��� ������ ������,
	// Ŭ������ ���� ��� �ȵ����� �������̽��� ���� ����� �Ǵ� ū �������� �ִ�. 
	void f1(); // abstract void f1(); 
	void f2(); // abstract void f2();
}
class Ddd implements Ccc{ // ����
	// interface�� ������ �޼ҵ�� ������ public
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
		// java������ ���ϱ� ����x
		int r1 = 100 * 3; // 100+100+100 
		int r2 = 3 * 100; // 3 + 3 + 3 + 3+...
		
		System.out.println(r1);
		System.out.println(r2);
		
		int test = 6; // 110(=6)
					// 1100(=12)  << 1 
					// 11000(=24) << 2
		System.out.println(test << 1); // 6 * 2�� 1��
		System.out.println(test << 2); // 6 * 2�� 2��
		System.out.println(test << 3); // 6 * 2�� 3��
		System.out.println(test << 4); // 6 * 2�� 4��
		
		int a = 23;
		for (int i = 0; i < 600; i++) {
			for (int j = 0; j < 800; j++) {
				System.out.println(800 * a);
				System.out.println((a<<9) + (a<<8) + (a<<5)); // ����
				System.out.println((a<<9) | (a<<8) | (a<<5)); // + ��� | ����غ��� ����� ������ |�� ���
				
			}
		}
		
		
	}
}*/

/*
//ex61
// & | >> << ~ ^ ������ ��ȣ �Ǵ� ����, ������ ���� ���
public class Hello {
	static String hexaToBinary(int n) { // StringBuffer �ϸ鰻�� �����ϴ�
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
		// ����ũ ������ : �ɸ��� �� �߰����� = ffff0000
		System.out.println(hexaToBinary(0xffff0000));
		System.out.println("---------------------------------------");
		System.out.println(hexaToBinary(n1 & 0xffff0000)); // 1. & ������
		
		// ������ �ռ� �� ���� ���� (���� �ٸ� ������ ��Ʈ�� ������ ���� ���)
		System.out.println(hexaToBinary(n1 | 0xffff0000));	// 2. | ������
		
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
		
		
		// shift ����
		int e = 0xf09;
		System.out.println(hexaToBinary(e));
		System.out.println(hexaToBinary(e<<4)); // �������� 4ĭ�� �̵�
		System.out.println(hexaToBinary(e>>4)); // ���������� 4ĭ�� �̵�
		System.out.println("------------------------------");
		
		int data = 0xabcd;
		// 21 30 13
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 5��,6��,5���� bit�� ������ 10������ ȯ���ϸ�?
		// 0000 0000 0000 0000 10101 011110 01101
		System.out.println(hexaToBinary(data));
		
		
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 0000 0000 0001 1111 
//		System.out.println(hexaToBinary(data & 0x1f)); // ����ŷ
		System.out.println(data & 0x1f);
		
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 0000 0111 1110 0000 
//		System.out.println(data & 0x7e0); // �ڿ� 0�� ���Ƽ� ũ�� ����(���ϴ� ������x)
		System.out.println((data & 0x7e0)>>5); 
		
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 1111 1000 0000 0000 
		  
		// ���� 
		System.out.println((data & 0xf800)>>11); 
		
		// ������ ������
//		System.out.println((data >> 11) & 0x1f); 
		
		
		System.out.println("--------------------------");
		// 3. ��Ʈ����������
		System.out.println(hexaToBinary(data));
		System.out.println(hexaToBinary(~data));
		
		
		// 4. XOR ������
		// ������ 0, �ٸ��� 1
		System.out.println(hexaToBinary(data));
		System.out.println(hexaToBinary(0x0000ffff));
		System.out.println(hexaToBinary(data^0x0000ffff));
	}
}
*/
/*//ex60
public class Hello {
	static String hexaToBinary(int n) { // StringBuffer �ϸ鰻�� �����ϴ�
		// ���� �Ұ��� String Ÿ������
		String s = Integer.toBinaryString(n);
//		System.out.println(s); // log�� ���� ����� = �����ڵ�
//		System.out.println(s.length()); // 31��
		
		// 32bit�� �ش��ϴ� ���ڿ� ����
		while(s.length() < 32) {
			s = "0" + s; // 0 ���ڿ� �߰�
		}
//		System.out.println(s.length());
//		System.out.println(s);
		// string�� ����ȵǴϱ� ��� ���� ���� ��ü�̴�.
		
		// String�� insert ����X
		StringBuffer sb = new StringBuffer(s);
//		System.out.println(sb);
		// insert�� �տ��� " " �߰��ϸ� ������� ���� ��Ģ������ -> �ں���
		for (int i = 0; i < 7; i++) {
			sb.insert((7-i)*4, " ");
//			System.out.println((7-i)*4);
		}
//		System.out.println(sb);
		return sb.toString();
		
	}
	public static void main(String[] args) {
		// ���� ���ϴ� ����(32bit, 4�ڸ��� ����)���� 2���� ���
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
		
		// 1�ڸ��� 4bit ����, 4�ڸ�=2byte, 
		// 8�ڸ�=4byte, int�� 4byte���� ����  
		// -> 16������ 4byte�� ���� �� ���� �� ����. (FF FF FF FF)	
		
		int num1 = 100;
		System.out.println(num1);
		
		// �տ� 0x �Ǵ� 0X �ٿ� 16������ ����
		int num2 = 0x100;
		System.out.println(num2);
		
		int num3 = 0xABCD;
		System.out.println(num3);
		
		int num4 = 0x63ce7bcd;
		// 0110 0011 1100 1110 0111 1011 1100 1101	 
		System.out.println(num4);
		
		// 0 ~ 80 00 00 00 : �� / ������ �� : 80 00 00 00~ FF FF FF FF 
		int num;
		//Integer: int ���� �ϳ��� ����, ������ ���õ� �Լ� �����ϴ� Ŭ����
		// 16������ 2������ ����
		System.out.println(Integer.toBinaryString(num4));
		int num5 = 0xab;
		// 10101011
		// 0000 0000 0000 0000 0000 0000 1010 1011 �� ���� �۾�
		// ������ 32�ڸ��̴�. �տ� ��� 0�� �����ؼ� ����
		// ��� ����� 4���� ���� ����غ���~
		System.out.println(Integer.toBinaryString(num5));		
	}
}*/

/*//ex58) ���� (bit ����) : 2(��), 10(�ΰ�), 16(�����)
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
		String s1 = "����ȭ�����Ǿ����ϴ�. ";
		// ex1)
		// int String.length()
		// �Լ��� Ŀ�� ��� ���� -> �������̱�
		System.out.println(s1.length());
		
		// ex2)
		// char java.lang.String.charAt(int index)
		System.out.println(s1.charAt(3));
		
		// ex3)
		// int String.indexOf(String str)
		System.out.println(s1.indexOf("���Ǿ�"));
		
		// ���н� ���� or -1�� ����
		System.out.println(s1.indexOf("���ϴ�."));
		
		if(s1.indexOf("���ϴ�") == -1) {
			System.out.println("�˻�����");
		}else {
			System.out.println("�˻�����");
		}
		
		// ex4)
		//String replace(
		//			CharSequence target, 
		//			CharSequence replacement)
//		String s2 = s1.replace("����", "������");
		// ���� : ������ �Ͼ �����Ͱ� ���� �����͸� �����ϴ°� ���� �ʴ°�? - class ���� ��� ����
		// String class�� ����� ������ �������� �ʴ´�.
		
		// StringBufferŬ������ ���� �����͸� ������ �� �ִ�.
		
		//���� �����Ͱ� ����(����)�� �� ���� �ƴϰ� s1�� �޸𸮰� ������
//		System.out.println(s1);
		// s1�� �޸𸮰� ������ (��ü�� �������)
		// s1�� �޸𸮰� ���Ҵ� �޴´�. (���ο� ��ü�� ����� �� ��)
		// �� ���� ��ü�� ���� �ٸ�
//		s1 = "ȣ����";
//		System.out.println(s1);
		System.out.println(s1.replace("����", "������"));
		
		
		// ���� XString Ŭ������ �����ȴٸ� ���� �����͸� �����ϴ��� ���ϴ��� ���� �˾Ƶ־� �Ѵ�.
		// �Լ��ϳ� �������� �� Ȯ���ϰ� ����ؾ���

		
		// ex5) sub string
		System.out.println(s1.substring(3)); //i = 3���� ������
		// start ~ end-1
		// end - start = ���� �� 
		System.out.println(s1.substring(3,5)); 
	
		// ex6)
		s1 = "Apple"; //��ü�� �ٲ�
		
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());
		// ex. ��� �빮�ڳ� �ҹ��ڷ� ���� �� �ܾ� �� ����
		// 	   ���̵� �빮�ڸ� ���� �� ��� 
		
		// ex7)
		s1 = "  A p p l e  ";
		System.out.print(s1);
		System.out.println(1000);
		System.out.print(s1.trim()); // �յڸ� ��������
		System.out.println(2000);
		// �޸��ص� ���̵� �����ؼ� ������ �α����ϴ� ���
		
		
	}
}*/







////2�� 10�� �����
/*//ex57
// 4. �߻� �Լ��� ���� Ŭ������ �ݵ�� �߻�Ŭ�������� �Ѵ�. 
// 5. �߻� Ŭ������ ��ü�� ������ �� ����.
abstract class A{
	// 1. �������̵��� ��ǥ�� �Ѵ�. 
	// 2. ���� ������ �ڵ带 �ۼ��� ������ ����. 
	// 3. {}�����, �����ݷ��� ��� ���� �̿ϼ� �ڵ尡 �ȴ�. -> �߻�(=�̿ϼ�) 
	abstract void f1();
	
	 
}
class B extends A{
	// ��ӹ��� Ŭ������ �θ��� �߻�޼ҵ带 �ݵ�� �ϼ� ���Ѿ��Ѵ�. 
	// ctrl + space �ϸ� �߻�޼ҵ� ������
	@Override
	void f1() {
		System.out.println(1);
	}
}
public class Hello {
	public static void main(String[] args) {
		A t1 = new B();
		t1.f1();
		
		// �߻� Ŭ������ ��ü ���� �Ұ�
//		A t2 = new A(); 
	}
}*/


/*
//ex56
class Animal{
	void cry() {
		System.out.println("�Ҹ� ���� ����");
	}
}
class Tiger extends Animal{
	void cry() {System.out.println("����");}
}
class Cat extends Animal{
	void cry() {System.out.println("�߿�");}
}
class Dog extends Animal{
	void cry() {System.out.println("�۸�");}
}
class Snake extends Animal{
	
}
class Lion extends Animal{
	void cry() {System.out.println("�������~");}
}
// �ܺ� �ڵ� ������ ���� �ڵ�� �������ϰԲ� �ϴ°� ��Ģ
// ���� ����� ��Ģ = �μ��� ����, ��� = ���� ���� ����
// SOLID

class Zoo{
	// �ڽĸ��� �θ�� �ޱ� -> ��ĳ����
	// ��ĳ�����ϸ� �ڵ����� ���⼺ �����
	// ������ : �پ��� ������ ���� �� �ִ�.
	void sound(Animal t) {
		t.cry();
	}
//	void sound(Tiger t) {
//		t.cry();
//	}
//	void sound(Cat c) { // �����ε�
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
		System.out.println("�Ҹ��� �� �� ����");
	}
}
class Tiger extends Animal{
	@Override
	void cry() {
		System.out.println("����");
	}
}
class Cat extends Animal{
	@Override
	void cry() {
		System.out.println("�߿�");
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
		// ��ĳ���� ���� Ȱ�� ��� �� 1���� �ش�
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
		System.out.println("�Ҹ��� �� �� ����");
	}
}
class Tiger extends Animal{
	@Override
	void cry() {
		System.out.println("����");
	}
}
class Cat extends Animal{
	@Override
	void cry() {
		System.out.println("�߿�");
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
//		s0 = "ȣ����0";
//		s1 = "ȣ����1";
//		s2 = "ȣ����2";
//		s3 = "ȣ����3";
		// �迭 �Ⱦ��� ���ؿ�
		 
		
//		String[] ar = new String[4]; // ��ü 4���� �ƴ϶� �迭 ���� 4�ڸ� ����
//		ar[0] = "ȣ����0";
//		ar[1] = "ȣ����1";
//		ar[2] = "ȣ����2";
//		ar[3] = "ȣ����3";
		
		
		String[] ar = new String[] {"ȣ����0", "ȣ����1", "ȣ����2", "ȣ����3"}; // ��ü ������
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		
		Test[] br = new Test[4]; //test �ޱ� ���� ������ �������, ��ü�� ��������� �ƴ�
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
	void f4() { // �ڽĿ��� �������̵��ϱ�
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
		t1.f3(); // �ڽ��߿� �������̵� �Ͼ���� Ȯ��
		// �Ͼ���� �ڽ� ���� ���, ���Ͼ���� �ٽ� ���ƿͼ� �ڽ�(�θ�) ���� ���
		t1.f4();
	
		B t2 = new B();
		t2.f3();
		t2.f4();
	}
}*/


/*//ex52 ���� �߿�!!***********
// ������, ��ĳ����

class A{
	void f1() {}
}
class B extends A{
	void f2() {}
}
public class Hello {
	public static void main(String[] args) {
		// ��Ӱ� ���� ����
		A t1 = new A(); // �� = ��
		t1.f1();
		
		
		// ��ĳ����(UpCasting)
		A t2 = new B(); // �� = ��
		t2.f1();
		// f2 �޸𸮰� �������� �ұ��ϰ� ����� ����� ����. 
		
		
		// �ڽİ��� ���������� ���� ����
		// �޸𸮴� �ִµ� ������ ������
		// -> ���������� �ذ�
		
		// �ٿ�ĳ���� - �����ؼ� java������ ���� �� ��
//		B t3 = new A(); // �� = ��
		B t4 = new B(); // �� = ��
		t4.f1();
		t4.f2();
		
		// = ������ ���� �������� �޸� ����
		
	}
}
*/

/*//ex51
// this�� 4��° ���
// this �����ڴ� �ݵ�� �ڵ� ù�ٿ� �;��Ѵ�. 
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
		this(b*c); // �ι�° �����ڰ� 100�̶�� �μ��� ����
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
// ��� class�� Object�� ���� ��� ����.
class A{ // class A extends Object �����Ǿ� �ִ�. 
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
// �����ڰ� ȣ��Ǵ� �������: 
// �θ� -> �ڽ� : <------------- �߸��� �ؼ�
// �ڽĺ��� call�ϴµ� �ڽ� ������ �ȿ��� �θ� �����ڸ� call��� �ڵ尡 �����Ǿ��־�
// ������ ������ �θ���� call�ϴ� �ɷ� ����
// ��¥�� �ڽ� ����
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
		// �θ� �����ڸ� call��� �ڵ尡 �����Ǿ� �ִ�.
//		super();
		super(100); // �ڽ��� ���������� �θ� �����ڸ� ������ �� �ִ�. 
		System.out.println(2);
	}
	B(int a, int b){
		super(); // �ڽ� class ���� ����
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
class A { // ����
	void f1() {System.out.println(1);}
} 
class B extends A { // �θ�

}
class C extends B{ // �ڽ�
	
}
class D extends B{ // �ڽ�
	
}
// c, d ���� 
public class Hello {
	public static void main(String[] args) {
		C t1 = new C();
		t1.f1();
	}
}
*/

/*//ex47 ���
class Aaa { // �θ�
	void f1() {
		System.out.println(1);
	}
	// �Լ� ����(method prototype) = void f3()
	void f3() {
		System.out.println(31);
	}
	String f5(int a, int b, String t) {
		return null;
	}
}
class Bbb extends Aaa{ // �ڽ�
	void f2() {
		System.out.println(2);
	}
	
	// �������̵� (Overriding)
	// �θ��� �Լ� ������ �״�� ������ Ȱ��
	@Override
	// ��Ÿ�� ���� ���ٶ��̵� ���� �ʾ��� �� �����߻� ��Ŵ
	void f3() {
		System.out.println(32);
	}
	void f4() {
		f3();  // = this.f3(); // �ش� class�� f3 ȣ��
		super.f3(); // �θ��� f3
	}
	@Override //�������̵��̶�� ǥ���ϱ� @�ϰ� ctrl + space�ϸ� ����
	String f5(int a, int b, String t) {
		return null;
	}
}
public class Hello {
	public static void main(String[] args) {
		Bbb t1 = new Bbb();
		t1.f1(); // �ڽ��� ������ �θ��� f1�� ȣ��
		t1.f2(); // �ڽ��� ������ �ڽ��� f2ȣ��
		t1.f3(); // �ڽ��� f3 
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
	String ����() {
		return "����";
	}
	
}
class Women{
	boolean marry(Man info) {
		String str = info.����();
		return str == "����" ? false : true;
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
		// hello ��ü(this)�� con.make�� ����
		// this�� �μ��� �������� ��� : ���� Ŭ�������� �� ����(Ŭ����)�� �ʿ�� ��
		con.makeButton(this, "�ؽ�Ʈ", "����");
//		this.ĥ�ϴ�();
	}
	void ĥ�ϴ�() {
		System.out.println(1);
	}
}
*/

/*//ex46-2) this ���2
// channing�� �������� �Ѵ�.
class Tiger{
	//Tiger this; �� �����Ǿ� ����
	Tiger f1() {
//		System.out.println("��ħ");
		System.out.println("id ");
//		return null;
//		return new Tiger(); // �� ��ü ���� �� ����
		return this;
	}
	
	Tiger f2() {
//		System.out.println("����");
		System.out.println("password");
		return this; //f(2)�� �ڿ� ü�̴��� �� �� �ִ�. 
	}
	void f3() {
//		System.out.println("����");
		System.out.println("��ȿ���˻�");
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		
		t1.f1().f2().f3(); //f1()�� tigerŬ���� ȣ��
		System.out.println("----------------------------");
	
		//channing�� ������ ������ �ڵ� �ۼ�
		// intercept �� �� ����. -> �۾��� �帧 ���� ���ϰ� ��
		t1.
		f1().
		f2().
		f3();
		
		// intercept ����
		t1.f1();
		System.out.println("�ζ�..������");
		t1.f2();
		t1.f3();
	}
}
*/
/*//ex46-1) this ���1
// �Լ��� �����μ��� �ʵ带 �����ϱ� ���� �뵵
// �ڵ� : 1. ������, 2. setter, getter, 3. toString
class Tiger{
	String name;
	int age;
	
	public Tiger(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	Tiger(String name, int age){ // �Ű����� �ۼ��� � �뵵���� ���� ����
		this.name = name; // �ʵ� <= �μ�
		this.age = age;
	}
	void f1() {
		System.out.println(name + " " + age);
//		System.out.println(this.name + " " + this.age); // this ���� ����
	}
	void f2() {
		f1();
		this.f1(); // ���� ���� �ǹ�
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
		Tiger t1 = new Tiger("ȣ����", 10);
		System.out.println(t1);
		t1.f3("������", 20);
		System.out.println(t1);
	}
}*/

/*
//ex45
// this = ��� ������ ��ü
class Lion{}
class Tiger{
//	Lion lion;
//	Tiger tiger;
	Tiger(){
//		this = ??????; -> new�� ���� ��ü�� �����Ǹ� ��ü���� this�� ���Ե�
//		this = t1; this = t2; 
		// ��ü��� this�� �޸𸮸� �����Ѵ�. 
		System.out.println(this.hashCode());
	}
	// ������ �ڵ�
//	Tiger this; ��� Ŭ������ �� �ڵ尡 �����Ǿ� �ִ�.
	
	
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
	private Tiger(){ // ��ü ������ ���Ƶ�
		
	}
}
public class Hello {
	public static void main(String[] args) {
//		Tiger t = new Tiger();
		
//		Thread.sleep(0);
		
		//Math m = new Math();
		System.out.println(Math.abs(-10)); // abs�� static �޼ҵ�

	}
}
*/
/*//ex43-3
class Tiger{
	static int count = 0;
	int num = 0; // ��ü �����ø��� ���������� ����
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
		
		System.out.println("������ ��ü ���� : " + Tiger.count);
		 //���α׷� ����ÿ��� ��ü �� = 0
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
		// hello ��ü 2�� = ���� ���� + os�� ����
		
		
	}
}
*/
/*//ex43-1
// static �ȿ����� static�� ����� �� �ִ�. 
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
	static void f1() { // ��� ���� -> �ӵ� ������ �� �� ���
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
	// ������(Entry Point)
	// main ȣ���� OS�� �Ѵ�. 
	// Hello h = new Hello();
	// h.main();
	// Hello.main(); -> os�� �θ��� ����
	public static void main(String[] args) { // static - ��ü ����x���� main�Լ� ���o
		// ��ü ���� ����� ���� ���. 
		// static �޼���� ��ü ���� �ʿ���� �ٷ� 
		// Ŭ������ �̿��ؼ� ����ϴϱ� ��� ����
		Tiger.f1();

	}
	void f2() {}
	
}
*/
/*//ex43-1
class Tiger{
	// static
	// ó������ �������ƾ���(��ü�� �ֵ縻��)
	// �����Ͻ� static �ڵ尡 class �ٱ����� ����
	// �ѹ� ��������� ��� ��ü�� ������ �ȴ�.
	
	// ����
	// ��� ��ü�� �������� ����� ���̸� ��ü �����ø��� ���� ���� �ʿ����.
	static int n1;
	int n2; // Ŭ������ �����Ǿ� �ʵ忡 �޸𸮸� �Ҵ�����
	static void ����ž() { 
		System.out.println("��");
	}
	void ����() { 
		
	}
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		Tiger.����ž(); //���α׷� ���ۺ��� �޸𸮰� �������
		t1.����();
		t1.����ž();
		System.out.println(Tiger.n1);
		System.out.println(t1.n2);
	}
}*/

/*
//ex42
class Tiger{
	// ��ǰ ��� - ���縦 �ܺο� ���� �ʿ�X
	// ������ ����
	private int age; //private class�ȿ����� / public �� / ������ default
	private String name;
	
	
	String getName() {
		return name;
	}
	void setName(String n) {
		name = n;
	}
	
	// getter, setter �Լ� - ���û���
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
		f1(); // f1�� f2�� f3������ ���Ǵϱ� ���ο����� ���̵��� private�� ���ܵ� �ȴ�.
		f2();
	}
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		
		// ����ʵ�� ��ü�� �������Ѽ�
		// ���� ����ϴ°��� ���� �ҹ�!!!!!!
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
	
	// �����ڸ� �ƿ� �Ⱦ��� �����Ͻ� default ������ �ڵ� ������
	// ������ 1���� ������ default ������ �ڵ� ���� ����
	Tiger(){} // ���� �ȳ��� �� Ŭ���� ������ �̰͵� ������ ���� ���̱�
	Tiger(int data){
//		name = null;
		name = "�͸�";
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
		// return this �����Ǿ��ִ�.
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger(100);
		t1.showData();
		Tiger t2 = new Tiger("ȫ�浿", 200);
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
	int age;						// �ʱ�ȭ ���1 (���� ����)
	Tiger(){						// �ʱ�ȭ ���2 (���� ����)
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
// ������
// 1. ��� ����: �ʵ� �ʱ�ȭ
// 2. ������ �޼ҵ��� �Ѵ�.(�Լ��̴�.)
// 3. �Լ��� �̸��� �ݵ�� Ŭ���� �̸��� ����
// 4. �μ��� ���޹��� ���� ������, return�� ���� �� ����. 
// 5. �μ������� ���� �����ڸ� ����Ʈ �����ڶ�� �Ѵ�. 
// 6. ȣ���� newŰ���带 ����� �� �� �� �� ȣ��ȴ�. 
// 	  ���α׷��Ӱ� ���Ƿ� ȣ���� �� ����. 
// 7. �Լ�(�޼ҵ�)�̱� ������ �����ε��� �� �� �ִ�. 
// 8. ������ �ڵ带 �ۼ����� ������ �ڵ����� ����Ʈ �����ڰ� ���������. 
//    - ������ �ڵ带 �ۼ��ϸ� �ڵ����� �����ڰ� ��������� �ʴ´�. 

class Tiger{
	// �ʵ�
	int age;
	
	// default ������
	Tiger() {
		System.out.println("������ ��");
		age = 100;
	} 
	
	// �޼ҵ�
	
}
public class Hello {
	public static void main(String[] args) {
		System.out.println("1");
		Tiger t1 = new Tiger();
		System.out.println("2");
		Tiger t2 = new Tiger();
		System.out.println("3");
		System.out.println("------------");
		for (int i = 0; i < 3; i++) { // ������ 3�� ��������� �����
			Tiger temp = new Tiger(); 
			System.out.println(temp.hashCode());
		}
		
	}
}
*/

// 2�� 9��
/*
// ex38-2
// �����ε� Ȱ��
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
	// return �� ����X ����ϴ� ���忡���� ������ �� ����.
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
// "�����ε� (Overloading)"
// �Լ��̸��� �����ϰ� �۸��� ������ ���
//1. �μ� ���� ������ �ٸ� ���
//2. ���� �μ� ������ ������ Ÿ���� �ٸ� ���
class Tiger{
	// 1. �μ� ���� ������ �ٸ� ���
	void showMeTheMoney() {
		System.out.println(1);
	}
	void showMeTheMoney(int a) {
		System.out.println(2);
	}
	void showMeTheMoney(int a, int b) {
		System.out.println(3);
	}
	// 2. ���� �μ� ������ ������ Ÿ���� �ٸ� ���
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
		
		float f = 3; // ������ ����X
		// type casting �� ���� �������ϴ� ���� ��Ȯ�ϰ� ����
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
	// Tiger bbb = aaa; //����
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
		//aaa=bbb=ccc ���� ��ü
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
		Tiger t1 = new Tiger();// ��ü ������ ����(�ֹ�)��ȣ ����
		System.out.println(t1.hashCode());
		Tiger t2 = new Tiger();
		System.out.println(t2.hashCode());
		Tiger t3 = null;
		// null point exception 
//		System.out.println(t3.hashCode());
		
		// ��� �޸𸮸� ����, �����Ѵ�.
		t3 = t1; // �г��Ӹ� �ٸ��� ���� ����. �����̶� �����ϸ� ��
		//t1 = ȫ�浿�̶� �θ� t3 = �����ƶ�� �θ�
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
		t1.m1(10, "ȣ����", new Tiger(), new Lion()); // null�� ������ ������ m1���� �ش� class ��� ����
		t1.m1(10, null, null, null); // null = ��ü�� ���������� ���X
	}
}
*/

/*
//ex34
class Tiger{
	// �μ������� ���� : 8 + class
	void m1(float a, String s) { // class�� �μ��� �ޱ� o - ���鸸����
//		System.err.println(a); // erroró�� ���
		System.out.println(a + " " + s);
		System.out.println(s.length());
	}
	String m2() {
		// ���1
//		return "ȣ����";
	
		// ���2
		String s = "������";
		return s;
	}
	
	String m3() {
		return null; // error ���ϱ� ����
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.m1(3.14f, "ȣ����");
		// 1
		t1.m2();
		
		// 2
		String s = t1.m2();
		System.out.println(s);
		
		// 3
		System.out.println(t1.m2());
		
		//String s2; // ����� �̸��� ����, ��ü ������ ��x ���ڿ��̳� new�� �ʱ�ȭ �ʿ�
		String s2 = null; // ���� ��ü�� �ƴϴٶ�� �ͤ��� ��������� ǥ���Ѵ�. 
		String s3 = "�ڳ���";
		
		//�����ϰ� ����ϴٰ� �ڰ��� ��Ż�ϰ� ������
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

		// ���ڿ��� ���������� ����
		// ù���ڰ� �빮�� -> �ڹٿ��� �����ϴ� ǥ�� Ŭ�����̴�. 
		// ������ �ٸ��� method�� ���� �ִ����� �ñ��ϴ�.
		
		// ���� �ڵ�
		String s1 = new String(); 
		s1 = "ȣ����";
		System.out.println(s1);
		System.out.println(s1.length());
		
		// ��� �ڵ�
		String s2 = "�޹���"; 
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
	// �������� ��ø�Ȱ�� ��������({}�� ���̿� ���� ����) �켱 ���
	void m1(int a, int b) {
		// ���������� ���� ���
		// �μ����� ���� ���
		int result = a + b;
		System.out.println(result);
		
		// field�� a, b ����ϰ� �ʹٸ�
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
	
	// ��ȣ ȣ�� -> ���ƿ� �� ����. 
	// StackOverflowError: ����� �� �ִ� �޸𸮰� ����. 
	void f4() {
		System.out.println(4);
		f5();
	}
	void f5() {
		System.out.println(5);
		f4();
	}
	
	// ��� ȣ��(recursive call)
	// �� ���� ������ ����
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
	// ������ �ִ�. FuncName(){}
	// ....�� ����. 
	// return ���� ����. 
	void func01() {
		System.out.println("ȣ����");
	}
	
	int func02() {
		System.out.println(1);
		return 100;
	}
	
	// �޼ҵ忡�� return Ű���带 ������ �Լ��� �ߴܵȴ�. 
	// � ������ �ڵ尡 ������ �Ǵ��� return �� ������ �Ѵ�. 
	int func03() {
		if(false) {
			return 100;
		}else if(false){
			return 200;
		}else {
			System.out.println(1000);
			return 300;
		}
//		return 100; // �Լ� ���� ����
//		System.out.println(1000);
	}
	
	// void������ return Ű���带 ����� �� �ִ�. 
	void func04() {
		for (int i = 0; i < 10; i++) {
			if(i == 5) {
//				break;
				return;
			}
		}
		System.out.println("for �ߴܵ�"); // break �ڵ�� �����, return�� ���� �� �� 
	}
	
	// 4��° ����
	int func05(int num) {	
//		return num * num;
		// �翬�� �־� ������ �޾� ���
		int result = num * num; 
//		System.out.println(result);
		return result;
	}
	
	int func06(int num) {	
		// ���� �Լ� ������ �ٸ�
		System.out.println(num*num); // ��� �뵵�θ�
		return num*num; // return ���� ��¸��� �ٸ� �뵵�� ��밡��
	}
	
	// ��Ģ�� �޴����� �����. 
	// -1�� ���ϵ� ���� ������ ����̴�.
	// 1�� ���ϵ� ���� ���� �۵��� ����̴�.
	int func07(int num) {	
		if(num < 0) {
//			System.out.println("�����Դϴ�."); -> ���� -> ����, Ȱ���� �� ����.
			// �ý��� ���� �Ⱦ˷���~~~
			return -1;
		}
		
		if(num % 2 == 0) {
			System.out.println("¦");
		}else {
			System.out.println("Ȧ");
		}
		return 1;
	}
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		// �Լ��� ���ϰ� Ȱ��
		// 1. �ܸ��ϴ� ���
		t1.func02();
		
		// 2. ����
		int num = t1.func02();
		System.out.println(num);
		
		// 3.
		System.out.println(t1.func02());
		
		// �������� ã�� ����
//		System.out.println(t1.func01());
		System.out.println(t1.func03());
		t1.func04();
		System.out.println(t1.func05(5));
		System.out.println(t1.func06(6)+200); // ���� 
		System.out.println(t1.func06(5) + t1.func06(6));
		
		if(t1.func07(-40) == -1) { // ���� o
			System.out.println("�����Դϴ�. ");
		}
		
		
		
		
	}
}
*/

/*//ex29
class Tiger{
	void m1() {
		System.out.println("��");
	}
	
	void m2(int num) { // ���� ���� : num�� �Լ��� ���Ե�
		System.out.println("�� " + num);
	}
	
	void m3(int num) { 
		for (int i = 0; i < num; i++) {
			System.out.print("��");
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
				// �����ϸ� �̷� ��� ���
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
		
		// ù��° �μ��� ���η� ���� ��, �ι�°�� ����
		t1.m5(5, 4, '*');
		t1.m6(7);
		t1.m7(10);
		t1.m8(8, 7, '��', '��');
	}
}*/

/*//ex28
class Tiger{
	// 1. void f1() {}
	// 2. void f1(int a) {}
	// 3. int f1() {}
	// 4. int f1(int a) {}
	
	// 1. ���Ͼ��� f1(�μ����� ����) {}
	// 2. ���Ͼ��� f1(�μ����� ����) {}
	// 3. �����ִ� f1(�μ����� ����) {}
	// 4. �����ִ� f1(�μ����� ����) {}
	
	// 1. X f1(X) {}
	// 2. X f1(O) {}
	// 3. O f1(X) {}
	// 4. O f1(O) {}

	// 1 �����۸��Ģ = �޼ҵ� �۸� ��Ģ
	void method01() { // �޸� �ѹ� �Ҵ�Ǽ� ��ü���� �����ؼ� ���
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
		// �ڵ��� ��Ȱ��
		// �Լ�(�޼���) : ���� ���Ǵ� �ڵ带 �����ؼ� ��Ȱ���Ѵ�. 
		Tiger t1 = new Tiger();
		System.out.println(1000);
		t1.method01(); // �Լ��� ȣ��
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
/*// ���������� Ŭ���� �̸��� ù���ڴ� �빮��
// ���赵
class Airplane{
	// ��� ����
	// 1. �ʵ�((���) ����) -> �Ӽ� 
	int a; //int fuel;
	float b;
	int seat;
//	int[] ar; // 0���� �޸� ��û, ������ ��
	int[] ar = new int[4]; // 16byte * ��ü ��
	int num = 99; // ��ü �����ø��� 99 ������ �¾, �Ҵ��
	
	// 2. ������
	
	// 3. �޼���(�Լ�)
}

public class Hello {
	public static void main(String[] args) {
//		Airplane a = new Airplane();
//		Airplane airplane = new Airplane(); // 1��ü�� ���� �� ���
		
		// ���� ����� �������
		Airplane air = new Airplane(); // new �ϰ� ctrl + space - ������ ����
		// �ǹ� ���������� air1�̶�� �� ����, "air" ��� �Ѵ�.
		Airplane air2 = new Airplane(); 
//		air.a = 10;
		air.b = 20.0f;
		air.seat = 30;
		System.out.println(air.b);
		System.out.println(air.a);
		
		air2.seat = 40;
		// ������ ���� �ٸ� �޸��̴�. 
		System.out.println(air2.seat + " " + air2.seat);
		
		System.out.println(air.ar.length);
		for (int i = 0; i < air.ar.length; i++) { // ���� ü�̴�
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
		
		air.ar = new int[8]; // ���� �޸� ������� ���� ������
		for (int i = 0; i < air.ar.length; i++) { 
			System.out.print(air.ar[i] + " ");
		}
		System.out.println();
		
		// ���� ���� ������ �޸� �ٸ�
		System.out.println(air.num);
		System.out.println(air2.num);
		air.num = 1000;
		System.out.println(air.num);
		
		int[] ar;
		ar = new int[10]; // �� �� �޸𸮿� �Ҵ��
		// ar�� ����ߴٰ� ġ��...
		// ������ 10���� �������. 
		// �׸��� ���ο� 20���� �����ȴ�. 
		ar = new int[20]; 
		
		// �޸� �ݳ��ڵ�
		// delete ar;
		// java �� �ڵ����� �ݳ�
			}
}
*/

/*//ex26)
public class Hello {
	public static void main(String[] args) {
		// 0 0 0 0 0 0  1+6 , 2+5, 3+4 �� ��� ��� -> �� �迭 ���
		Random rnd = new Random();
		int num = 30;
		int[] ar = new int[num];
		for (int i = 0; i < ar.length; i++) {
			// ������ ����(�ʱ�ȭ)
			ar[i] = rnd.nextInt(20);
		}
		for (int i = 0; i < ar.length; i++) {
			// ������ ���
			System.out.print(ar[i] + " ");
		}
		System.out.println();
		// ����(�ʱ�ȭ)�� ��� �ڵ� ��ġ��(���� ����) �ʰ� �ٸ� ���� ���� 
		// ���̿� ����� �ڵ尡 ���°� �Ϲ���
		
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

/*//ex25 �迭(array)
public class Hello {
	public static void main(String[] args) {
		// 1. ���� -> "���� ���"
		// ȣ����[] arr = new ȣ����[10]; o
		// ȣ����[] arr = new int[10]; x
		int[] arr = new int[10];
		int arr0, arr1, arr2, arr3; // ���� ���� �޸� �䱸
		
		// 2. �ʱⰪ �Ҵ�, �������� ���x, ���� ���ÿ��� ���
		int[] brr = new int[] {10, 20, 30}; // ���� �Է�X
		
		// 3. ��Ĺ� - new int[] ����
		int[] crr = {10, 20, 30};
		
		// arr�� ������ 10�� �ִ�.
		arr[0] = 10;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		arr[9] = 20;
		System.out.println(arr[9]);
		
		//ex2
		// 0-9
		// arr[-5] = 100; // �������� �ߴܵ�
		// arr[10] = 100;
		// ArrayIndexOutOfBoundsException
		System.out.println("ȣ����");
		
		
		//ex3) ���� ��� �� ��� ���� ����
		int num = 4;
		arr[num] = 10;
		arr[num*2] = 20; // ��� ���� ��ȿ���� �����ؼ� ���
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
		System.out.println(); //64~67 �� ��
		System.out.println("������");
		
		
	}
}
*/

/////////////////////////////////////////////2�� 8��
//ex24
/*public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		int num = rnd.nextInt(30);
		switch (num % 2) { //0 �Ǵ� 1    nextInt(10) -> 0~9
		case 0:{ // ���� �ڵ� ���� ��
			for (int i = 0; i < 10; i++) {
				System.out.println( num + " * " + i + " = " + num*i);
			}
		}break;
		case 1:{
			int sum = 0;
			for (int i = 0; i <= num; i++) {
				sum += i;
			}
			System.out.println(num + " ������ ����: " +sum);
		}break;
		
		default: break; // ���� �ڵ� ���� ��
		}
	}
}*/

/*//ex23
public class Hello {
	public static void main(String[] args) {
		int score = 100;
		switch (score / 10) {
		case 10:  // break; break �ּ�ó�� -> �ǵ������� ���� �˸�
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
		// 1. switch �ȿ� ������ ����� �� �ִ�. 
		// 2. case �ڿ� ���� ����� �� ����. 
		// 3. break�� �����ϸ� switch�� ���������� �ʴ´�.
		// 4. �����ϴ� �б⹮�� �������� default�� �̵��Ѵ�.
		// 5. ����, ����, ���ڿ� ��� �бⰡ �����ϴ�. 
		// 6. �ǵ������� break�� �����ϱ⵵ �Ѵ�. 
		
		int num = 40;
		//int nn = 10;
		char ch = '��';
		switch ("ȣ����") {
		//case nn: -> ���X
		case "ȣ����":
			System.out.println(1);
			break;
			
		case "����":
			System.out.println(2);
			break;
			
		case "ȣ����":
			System.out.println(3);
			break;

		default:
			System.out.println("ȣ����");
			break;
		}
	}
}*/

/*//ex21 ���� �߻�
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		int num = rnd.nextInt(); //+-20��
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

/*//ex19 while(for ���)
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
				System.out.println("Ż�� ��");
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
		for (int i = 0; i < 3; i++) { // ����
			for (int j = 0; j < 4; j++) { // ����
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 0; i < 3; i++) { // ����
			for (int j = 0; j < 4; j++) { // ����
				System.out.print("[" + i + " " + j + "]"); // �˰��� ��Ģ ��½� ����
			}
			System.out.println();
		}
		System.out.println();
		
		// ü����
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
		
		// ������ ���׿������� �����Ѵ�. 
		result = (3 > 2) ? 10 : 20;
		
		// �߸��� ����
//		(3 > 2) ? result =10 : result =20;
		
		int func() {
			if( 3 > 2 ) {
				return 100;
			}else {
				return 200;
			}
		}
		return 3>2 ? 100 : 200;
		// �߸��� ���� 3 > 2 ? return 100 : return 200
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
		// a�� b��
		for (int i = 0; i < b; i++) { // n=�ݺ�Ƚ��
			sum3 *= a;
		}
		System.out.println(sum3);
	}
}*/

/*//ex16 for��
public class Hello {
	public static void main(String[] args) {
		// ����1
		for (int i = 0; i < 4; i++) { // n=�ݺ�Ƚ��
			System.out.println(i);
		}
		
		// ����2
		for (int i = 1; i <= 4; i++) {
			System.out.println(i);
		}
		
		// ����3
		for (int i = -3; i < 3; i++) { // �������� ��ǥ, �ð� ����ȭ�� ���, 2*n+1
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
		// ����ӵ� ����ȭ�� ���� else if -> swich ���
		
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
		// if - else ����� �ڵ尡 ���ƾ���
		// �߸��� ��
		if(password != 1234) {
			System.out.println("Ʋ��");
		}else {
			System.out.println("����");
			System.out.println("������ �α��� �Ͽ���");
			System.out.println("���� ���� Ȯ��");
		}
		
		// ���� ��
		if(password != 1234) {
			System.out.println("Ʋ��");
			//break;
		}
		System.out.println("����");
		System.out.println("������ �α��� �Ͽ���");
		System.out.println("���� ���� Ȯ��");
		
		
		
		int nn = 10;
		if (nn < 0) {
//			sin(); // �ӵ��� �ΰ�
			nn = -nn;
		}else { // ����ӵ��� ����ȭ�� ����
//			sin();
			nn = +nn; // �ڱ� ���� - ��ġX
		}
		// else �� �ٿ��� �ӵ� �����ϹǷ� else ���°� ���� - ���� �ӵ� ������		
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
		// �� ������ �� ��ȯ
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
		n = n + 10; //add����, move ���� �����
		System.out.println(n);
		//2
		n += 10;
		System.out.println(n);
		
		n = n + 1;
		n+= 1;
		n++; // ���׿�����, ���� �ӵ� ���� ����, inc��� ������� ����� ����� �ſ� ����
		++n;
		
		n = 10;
		int a, b;
		a = n++; // �������� : ���� �� ����
		System.out.println(a + " " + n);
		
		n = 10;
		b = ++n; // �������� : ���� �� ����
		System.out.println(b+ " " + n);
	}
}*/

/*//ex8
public class Hello {
	public static void main(String[] args) {
		// 1. �����̸��� �ߺ��� �� ����. 
		int apple;
//		int apple; (x)
		
		// 2. ��� ���еȴ�. 
		int Apple;
		
		// 3. ù���ڰ� ���ڰ� �ƴ϶�� ���� ��밡��
		int Apple123;
//		int 9Apple; (x)
		
		// 4. _ $ 2���� Ư�����ڸ� ��� ����
		int apple_num;
		int _34; //3�� 4�� ó�� ���ڸ� ������ ���� ���� �� _
		
		// 5. �ѱ� ��� ����(������ ���ϱ�)
		int ��� = 10;
		System.out.println(���);
		
		// 6. �ܾ� �ռ��ÿ��� ī��ǥ��� ��� (��Ÿ��ó��)
		int bananaNumber = 10;
		
	}
}*/

/*//ex7
public class Hello {
	public static void main(String[] args) {
		System.out.println("�ȳ�");
		System.out.println("��");
		System.out.println("����");
	}
}*/

/*
//ex6
public class Hello {
	public static void main(String[] args) {
		// �⺻Ÿ��(��������) : byte, short, int, long 
		// �⺻Ÿ��: boolean(1), char(2) , float(4 �Ҽ���), double(8 �Ҽ���)
		byte apple; // ����(��ȭO) <-> ���(��ȭX)
		// = ���Կ�����
		apple = 10;
		System.out.println(apple);
		apple = 20;
		System.out.println(apple);
		apple = 127; // byte ���� -128 ~ 127
		
		// short  	type 
		// banana   variable 
		// = 		���Կ��� 
		// 20 	 	���ͷ�(���ԵǴ� ��� ��)
		short banana = 20; // ���� ���ÿ� �ʱ�ȭ	
		int orange = 30;		
		long kiwi = 2992599;
		
		// �⺻Ÿ��: boolean(byte 1���� ũ��), char(2) , float(4 �Ҽ���), double(8 �Ҽ���)
		boolean t1 = true;
		char t2 = 'A';
		char t3 = '��';
		// ���� ���α׷��� ������ ���Ѵ�. 
		char t4 = 65; // t2�� ������ �������� ������
		
		System.out.println(t2);
		System.out.println(t3);
		System.out.println((int)t2);
		System.out.println((int)t3);
		System.out.println((char)(t3+1)); // +1 �ؼ� ���ڰ� �� ���� charŸ������ ����ض�
		
		// char �� ����x : 0~6��
		System.out.println((int)Character.MIN_VALUE);
		System.out.println((int)Character.MAX_VALUE);
		
		char a = 'A', b = 20;
		System.out.println(a + b);
		
		
		float t5 = 3.14f; //float �ڿ� ������ f, 4byte
		double t6 = 3.14; //double �ڿ� f �� ����, 8byte, ������ �۾�
		
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
		//���� ������, �� ������
		System.out.println(10 > 5);
		System.out.println(10 >= 5);
		System.out.println(10 < 5);
		System.out.println(10 <= 5);
		System.out.println(10 == 5);
		System.out.println(10 != 5);
		System.out.println("---------");
		
		// �� ������
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
	
		// ���� ���� : ��� > ���� > ��
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
		System.out.println(17 % 3); // ����� ��, ���� ���
		
		System.out.println(3 + 4 * 5); // �켱����
		System.out.println( (3 + 4) * 5); 
		System.out.println((2 + 3) * (4 + 5)); 
	}
}
*/

/*
//ex2
public class Hello {
	public static void main(String[] args) {
		System.out.println(100); // ����
		System.out.println('��'); // ���� - 1�� (���� 1���� ����)
		System.out.println("ȣ����"); // ���ڿ�
		
		System.out.println(100+200); // ������� : ���� + ����
		System.out.println(100 + " ȣ����"); // ����+���ڿ� - ���: ���ڿ�
		System.out.println("ȣ���� " + 100); // ���ڿ�
		System.out.println("ȣ���� " + "����");
		System.out.println("100"); // ���ڿ� ����
		System.out.println("100 " + 100); // ���ڿ� + ���� -> ��� : ���ڿ�
		
		// å �е��� �պ��� ���ʴ��
		System.out.println(10 + 20 + "ȣ����"); // ����(����o) + ���ڿ� -> ��� : ���ڿ�
		System.out.println("ȣ����"+ 10 + 20); // ���ڿ� + ����(����x) -> ��� : ���ڿ�
		System.out.println(10 + " " + 20 + " " + "ȣ����" + " " + 30); // ���� �������� ���ٿ� ����ϰ� ���� �� " " ���
		
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
