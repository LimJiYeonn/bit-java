package Pack01;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Tiger {
	@RequestMapping("/t1") 
	String func01() {
		System.out.println("호랑이1");
		return "TigerView";
	}
	@RequestMapping("/t2") 
	String func02() {
		System.out.println("호랑이1");
		return "TigerView";
	}
	
	// 클라이언트에서 컨트롤러로 데이터 전송(view까지는 데이터를 보내지 않음) 3, 4, 5
	// @RequestParam(value = "name") : 클라이언트에서 name 이라는 이름으로 전송된다. 
	@RequestMapping("/t3") 
	String func03(@RequestParam(value = "name") String name) {
		System.out.println("f3 call");
		System.out.println(name);
		return "TigerView";
	}
	//인수전달 여러 개면 콤마사용
	@RequestMapping("/t4") 
	String func04(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "age") String age) {
		System.out.println("f4 call");
		System.out.println(name + " " + age);
		return "TigerView";
	}
	// 서블릿 방식으로 서블릿 객체 이용해 데이터 받기
	@RequestMapping("/t5") 
	String func05(HttpServletRequest request) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("f5 call");
		System.out.println(name + " " + age);
		return "TigerView";
	}
	
	
	
	// view로 데이터 전송
	@RequestMapping("/t6") 
	String func06(Model model) {  
		System.out.println("t6 call");
		model.addAttribute("name", "독수리"); // 저쪽에서 받을 변수명, 데이터 값
		model.addAttribute("age", "200"); // 저쪽에서 받을 변수명, 데이터 값
		return "TigerView";
	}
	
	
	// client -> controller -> view로 데이터 보내기
	@RequestMapping("/t7") 
	String func07(
			Model model,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "age") String age) {  
		System.out.println("t7 call");
		model.addAttribute("name", name); // 저쪽에서 받을 변수명, 데이터 값
		model.addAttribute("age", age); // 저쪽에서 받을 변수명, 데이터 값
		return "TigerView";
	}
	
	
	// model and view 클래스 객체 이용
	@RequestMapping("/t8") 
	ModelAndView func08() {   // return 할 타입
		System.out.println("t8 call");
		
		// 제어
//		String s = null;
//		if(3> 2) {
//			s = "TigerView";
//		}else {
//			s = "LionView";
//		}
//		ModelAndView mv = new ModelAndView(s);
		
		ModelAndView mv = new ModelAndView("TigerView");
		mv.addObject("name", "앵무새");
		mv.addObject("age", "400");
		return mv;
	}
	
	//t9는 컨트롤러를 거치지 않고 바로 뷰로 가게 설정함
	
	@RequestMapping("/t10") 
	String func10(Person person) { // 클래스 확인 후 객체 생성 후 던짐
		// 속성이 10개를 보냈다고 했을 때 
		// 객체로 10을 한꺼번에 받으려고 한다.
		// DTO (커맨드command 객체)
		// 클래스 생성해서 데이터 받기
		// DTO -> VO -> Entity
		System.out.println("f10");
		System.out.println(person.getId()); //같은 패키지 안에 있으니 import 필요없다.
		System.out.println(person.getPwd());
		
		// 뷰로 보내는 코드 작성하면 화면에 출력될거다~
		
		return "TigerView";
	}
	
	
	
	// data 던지기
	@RequestMapping("/t11") 
	String func11(Model model) {
		// 1. 정수
		int num = 10;
		model.addAttribute("num", num);
		
		// 2. String 
		String str = "문자열";
		model.addAttribute("str", str);
		
		// 3. Array 전달
		int[] ar = {10, 20, 30};
		model.addAttribute("ar", ar);
		// 배열 자체가 전송됨
		
		
		// 4. 객체 전송
		Person person = new Person();
		person.setId("소나무");
		person.setPwd(1234);
		model.addAttribute("person", person);
		
		
		// 5. Collection 전송
		LinkedList<Integer> list01 = new LinkedList<Integer>();
		list01.add(40);
		list01.add(50);
		list01.add(60);
		model.addAttribute("list01", list01);
		
		
		// 6. Collection 전송(String)
		LinkedList<String> list02 = new LinkedList<String>();
		list02.add("독수리0");
		list02.add("독수리1");
		list02.add("독수리2");
		model.addAttribute("list02", list02);
		
		
		// 7. Collection 전송(Person)
		LinkedList<Person> list03 = new LinkedList<Person>();
		list03.add(new Person("독수리3", 10));
		list03.add(new Person("독수리4", 20));
		list03.add(new Person("독수리5", 30));
		model.addAttribute("list03", list03);
		
		LinkedList<Person> list04 = new LinkedList<Person>();
		list04.add(new Person("독수리6", 10));
		list04.add(new Person("독수리7", 20));
		list04.add(new Person("독수리8", 30));
		model.addAttribute("list04", list04);
		
		return "LionView";
	}
	
	
}