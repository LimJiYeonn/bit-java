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
	public synchronized static Printer getInstance() { // 성능 좋지 않다. 
		// 멀티스레드 환경에서 두 개 이상의 스레드가 인스턴스를 동시에 생성 못하게
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

// 가장 많이 사용하는 방법
class Printer2{
	private Printer2(){}
	public static Printer2 getInstance() {
		// 호출하는 순간 class가 로딩되며 초기화가 되고 이 시점에 thread-safe를 보장
		return LazyHolder.INSTANCE;	
	}
	private static class LazyHolder{
	// JVM에게 객체의 초기화를 떠넘긴다. 
	// LazyHolder 클래스 초기화 과정에서 JVM이 Thread-Safe 하게 instance 를 생성
		private static final Printer2 INSTANCE = new Printer2();
	}
}





// 스프링에게 객체를 생성할 환경설정하는 클래스라는 것을 알린다. 
@Configuration
class AppConfig{
	// 여기 안에서 객체를 생성시킨다. 
	
	@Bean
	Printer printer() {
		return Printer.getInstance();
	}
	
	@Bean
	Printer2 printer2() {
		return Printer2.getInstance();
	}
	
	// 스프링이 생성시킨 객체(모두) = Bean , 빈객체
	// @Bean 없으면 객체 생성안되고 함수호출이 안된다. 
	@Bean
	// 싱글톤 객체 = default 값이다. 
//	@Scope("singleton")
//	@Scope("prototype")
	Apple apple() { // 객체의 소문자를 적는게 암묵적인 룰
//		System.out.println(1000);
		return new Apple();
	}
	// apple이라는 객체를 내부적으로 만듬
	// Apple apple = new Apple(); 과 같은 의미
	// 객체를 모아둔 곳 = 컨테이너
	// 스프링은 내부 컨테이너에서 빈 객체를 관리함
	
	
	// 이론상 가능하지만 코드에서는 전부 싱글톤으로 코딩한다. 
//	@Bean
//	Apple applebanana() {
//		return new Apple();
//	}
	
	
	@Bean
	Greeter greeter() { // 객체의 소문자를 적는게 암묵적인 룰
		return new Greeter();
	}
	
	
	
}




public class Hello {
	public static void main(String[] args) {
		
		// spring과 관련없이 사용
//				Greeter g = new Greeter();
//				g.setFormat("%s 안녕하세요");
//				System.out.println(g.f1("호랑이"));
		
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		// 내부적으로 호출해서 코드안써도 됨
		
		
//		밑의 코드는 내가 객체를 생성하는 것
//		Apple apple = new Apple(); 
		
		// getBean 객체를 얻어옴
		// 인수를 주는 방법 1. 객체 이름으로
		// 2.가져올 객체의 타입 apple 타입의 클래스를 주세요
		// 1 이름은 생략 가능
		Apple a1 = ctx.getBean("apple", Apple.class);
//		Apple apple = ctx.getBean(Apple.class); 가능
		a1.f1();
		System.out.println(a1.hashCode());
		
		
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
//		Apple apple = ctx.getBean(Apple.class); 가능
		g1.setFormat("%s 식사하세요");
		System.out.println(g1.f1("독수리"));
		
		
		
		// 객체를 한번 더 달라
		Apple a2 = ctx.getBean("apple", Apple.class);
//		Apple a2 = ctx.getBean("applebanana", Apple.class);
		// a1과 a2는 같은 객체인가? 
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

		// ctx의 메모리 해제는 직접 해야한다. db처럼 짝으로 사용해 손실 일어나지 않게
		ctx.close();
		
	}

}
