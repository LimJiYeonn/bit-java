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
		System.out.println("ȣ����1");
		return "TigerView";
	}
	@RequestMapping("/t2") 
	String func02() {
		System.out.println("ȣ����1");
		return "TigerView";
	}
	
	// Ŭ���̾�Ʈ���� ��Ʈ�ѷ��� ������ ����(view������ �����͸� ������ ����) 3, 4, 5
	// @RequestParam(value = "name") : Ŭ���̾�Ʈ���� name �̶�� �̸����� ���۵ȴ�. 
	@RequestMapping("/t3") 
	String func03(@RequestParam(value = "name") String name) {
		System.out.println("f3 call");
		System.out.println(name);
		return "TigerView";
	}
	//�μ����� ���� ���� �޸����
	@RequestMapping("/t4") 
	String func04(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "age") String age) {
		System.out.println("f4 call");
		System.out.println(name + " " + age);
		return "TigerView";
	}
	// ���� ������� ���� ��ü �̿��� ������ �ޱ�
	@RequestMapping("/t5") 
	String func05(HttpServletRequest request) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("f5 call");
		System.out.println(name + " " + age);
		return "TigerView";
	}
	
	
	
	// view�� ������ ����
	@RequestMapping("/t6") 
	String func06(Model model) {  
		System.out.println("t6 call");
		model.addAttribute("name", "������"); // ���ʿ��� ���� ������, ������ ��
		model.addAttribute("age", "200"); // ���ʿ��� ���� ������, ������ ��
		return "TigerView";
	}
	
	
	// client -> controller -> view�� ������ ������
	@RequestMapping("/t7") 
	String func07(
			Model model,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "age") String age) {  
		System.out.println("t7 call");
		model.addAttribute("name", name); // ���ʿ��� ���� ������, ������ ��
		model.addAttribute("age", age); // ���ʿ��� ���� ������, ������ ��
		return "TigerView";
	}
	
	
	// model and view Ŭ���� ��ü �̿�
	@RequestMapping("/t8") 
	ModelAndView func08() {   // return �� Ÿ��
		System.out.println("t8 call");
		
		// ����
//		String s = null;
//		if(3> 2) {
//			s = "TigerView";
//		}else {
//			s = "LionView";
//		}
//		ModelAndView mv = new ModelAndView(s);
		
		ModelAndView mv = new ModelAndView("TigerView");
		mv.addObject("name", "�޹���");
		mv.addObject("age", "400");
		return mv;
	}
	
	//t9�� ��Ʈ�ѷ��� ��ġ�� �ʰ� �ٷ� ��� ���� ������
	
	@RequestMapping("/t10") 
	String func10(Person person) { // Ŭ���� Ȯ�� �� ��ü ���� �� ����
		// �Ӽ��� 10���� ���´ٰ� ���� �� 
		// ��ü�� 10�� �Ѳ����� �������� �Ѵ�.
		// DTO (Ŀ�ǵ�command ��ü)
		// Ŭ���� �����ؼ� ������ �ޱ�
		// DTO -> VO -> Entity
		System.out.println("f10");
		System.out.println(person.getId()); //���� ��Ű�� �ȿ� ������ import �ʿ����.
		System.out.println(person.getPwd());
		
		// ��� ������ �ڵ� �ۼ��ϸ� ȭ�鿡 ��µɰŴ�~
		
		return "TigerView";
	}
	
	
	
	// data ������
	@RequestMapping("/t11") 
	String func11(Model model) {
		// 1. ����
		int num = 10;
		model.addAttribute("num", num);
		
		// 2. String 
		String str = "���ڿ�";
		model.addAttribute("str", str);
		
		// 3. Array ����
		int[] ar = {10, 20, 30};
		model.addAttribute("ar", ar);
		// �迭 ��ü�� ���۵�
		
		
		// 4. ��ü ����
		Person person = new Person();
		person.setId("�ҳ���");
		person.setPwd(1234);
		model.addAttribute("person", person);
		
		
		// 5. Collection ����
		LinkedList<Integer> list01 = new LinkedList<Integer>();
		list01.add(40);
		list01.add(50);
		list01.add(60);
		model.addAttribute("list01", list01);
		
		
		// 6. Collection ����(String)
		LinkedList<String> list02 = new LinkedList<String>();
		list02.add("������0");
		list02.add("������1");
		list02.add("������2");
		model.addAttribute("list02", list02);
		
		
		// 7. Collection ����(Person)
		LinkedList<Person> list03 = new LinkedList<Person>();
		list03.add(new Person("������3", 10));
		list03.add(new Person("������4", 20));
		list03.add(new Person("������5", 30));
		model.addAttribute("list03", list03);
		
		LinkedList<Person> list04 = new LinkedList<Person>();
		list04.add(new Person("������6", 10));
		list04.add(new Person("������7", 20));
		list04.add(new Person("������8", 30));
		model.addAttribute("list04", list04);
		
		return "LionView";
	}
	
	
}