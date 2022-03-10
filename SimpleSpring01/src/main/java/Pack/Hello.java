package Pack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Apple{
	void f1() {
		System.out.println("f1 call");
	}
	
}

class Greeter{
	String format;
	void setFormat(String format) {
		this.format = format;
	}
	String f1(String guest) {
		return String.format(format, guest);
		
	}
	
}



class Printer{
	private static Printer printer = null;
	private static int count = 0;
	private Printer(){}
	public synchronized static Printer getInstance() { // ���� ���� �ʴ�. 
		// ��Ƽ������ ȯ�濡�� �� �� �̻��� �����尡 �ν��Ͻ��� ���ÿ� ���� ���ϰ�
			if(printer == null) {
				printer = new Printer();
			}
			return printer;	
	}
	public void print(String input) {
		count++;
		System.out.println(input + "count : "+ count);
//		System.out.println(input);
	}
}

// ���� ���� ����ϴ� ���
class Printer2{
	private Printer2(){}
	public static Printer2 getInstance() {
		// ȣ���ϴ� ���� class�� �ε��Ǹ� �ʱ�ȭ�� �ǰ� �� ������ thread-safe�� ����
		return LazyHolder.INSTANCE;	
	}
	private static class LazyHolder{
	// JVM���� ��ü�� �ʱ�ȭ�� ���ѱ��. 
	// LazyHolder Ŭ���� �ʱ�ȭ �������� JVM�� Thread-Safe �ϰ� instance �� ����
		private static final Printer2 INSTANCE = new Printer2();
	}
}





// ���������� ��ü�� ������ ȯ�漳���ϴ� Ŭ������� ���� �˸���. 
@Configuration
class AppConfig{
	// ���� �ȿ��� ��ü�� ������Ų��. 
	
	@Bean
	Printer printer() {
		return Printer.getInstance();
	}
	
	@Bean
	Printer2 printer2() {
		return Printer2.getInstance();
	}
	
	// �������� ������Ų ��ü(���) = Bean , ��ü
	// @Bean ������ ��ü �����ȵǰ� �Լ�ȣ���� �ȵȴ�. 
	@Bean
	// �̱��� ��ü = default ���̴�. 
//	@Scope("singleton")
//	@Scope("prototype")
	Apple apple() { // ��ü�� �ҹ��ڸ� ���°� �Ϲ����� ��
//		System.out.println(1000);
		return new Apple();
	}
	// apple�̶�� ��ü�� ���������� ����
	// Apple apple = new Apple(); �� ���� �ǹ�
	// ��ü�� ��Ƶ� �� = �����̳�
	// �������� ���� �����̳ʿ��� �� ��ü�� ������
	
	
	// �̷л� ���������� �ڵ忡���� ���� �̱������� �ڵ��Ѵ�. 
//	@Bean
//	Apple applebanana() {
//		return new Apple();
//	}
	
	
	@Bean
	Greeter greeter() { // ��ü�� �ҹ��ڸ� ���°� �Ϲ����� ��
		return new Greeter();
	}
	
	
	
}




public class Hello {
	public static void main(String[] args) {
		
		// spring�� ���þ��� ���
//				Greeter g = new Greeter();
//				g.setFormat("%s �ȳ��ϼ���");
//				System.out.println(g.f1("ȣ����"));
		
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		// ���������� ȣ���ؼ� �ڵ�Ƚᵵ ��
		
		
//		���� �ڵ�� ���� ��ü�� �����ϴ� ��
//		Apple apple = new Apple(); 
		
		// getBean ��ü�� ����
		// �μ��� �ִ� ��� 1. ��ü �̸�����
		// 2.������ ��ü�� Ÿ�� apple Ÿ���� Ŭ������ �ּ���
		// 1 �̸��� ���� ����
		Apple a1 = ctx.getBean("apple", Apple.class);
//		Apple apple = ctx.getBean(Apple.class); ����
		a1.f1();
		System.out.println(a1.hashCode());
		
		
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
//		Apple apple = ctx.getBean(Apple.class); ����
		g1.setFormat("%s �Ļ��ϼ���");
		System.out.println(g1.f1("������"));
		
		
		
		// ��ü�� �ѹ� �� �޶�
		Apple a2 = ctx.getBean("apple", Apple.class);
//		Apple a2 = ctx.getBean("applebanana", Apple.class);
		// a1�� a2�� ���� ��ü�ΰ�? 
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		System.out.println(a1 == a2); 
		
		
		
		
		Printer p1 = ctx.getBean(Printer.class);
		Printer p2 = ctx.getBean(Printer.class);
		p2.print("hi 2");
		p1.print("hi 1");
		System.out.println(p1 == p2); 
		
		
		
		Printer2 p3 = ctx.getBean(Printer2.class);
		Printer2 p4 = ctx.getBean(Printer2.class);
		System.out.println(p3 == p4); 

		// ctx�� �޸� ������ ���� �ؾ��Ѵ�. dbó�� ¦���� ����� �ս� �Ͼ�� �ʰ�
		ctx.close();
		
	}

}
