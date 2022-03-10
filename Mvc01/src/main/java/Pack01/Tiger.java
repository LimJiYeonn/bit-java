package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Tiger {
	@RequestMapping("/t1") //외부에서 나를 호출할 컨테이너 이름  // 경로 지정할 때 / 빼도 됨
	String func01() {
		System.out.println("호랑이1");
		//return "Tiger"; // Tiger.jsp를 찾는다. 
		//return "Tiger.jsp"; // Tiger.jsp.jsp를 찾아 경로를 이동함
		return "TigerView";
	}
	
}
