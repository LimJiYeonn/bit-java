package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Tiger {
	@RequestMapping("/t1") //�ܺο��� ���� ȣ���� �����̳� �̸�  // ��� ������ �� / ���� ��
	String func01() {
		System.out.println("ȣ����1");
		//return "Tiger"; // Tiger.jsp�� ã�´�. 
		//return "Tiger.jsp"; // Tiger.jsp.jsp�� ã�� ��θ� �̵���
		return "TigerView";
	}
	
}
