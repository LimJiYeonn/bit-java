package Pack;

import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



public class InsertServlet extends HttpServlet{

	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		// 1. �Ķ���ͷ� ���۵� ���� ������.
		System.out.println(111111111);
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String pwd= request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String blood_type = request.getParameter("blood_type");

		

		int n=0;

		PreparedStatement pstmt = null;

		Connection con = null;
		

		try{

			// 2. ���۵� ���� db�� ����.

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/test?&useSSL=false";

			con = DriverManager.getConnection(url, "root", "1234");

			String sql = "insert into members values( ?,?,?,?, now() )";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);

			pstmt.setString(2, pwd);

			pstmt.setString(3, email);

			pstmt.setString(4, phone);
		
			

			//sql���� �����ϱ�

			n=pstmt.executeUpdate();

			

		}catch(ClassNotFoundException ce){

			System.out.println(ce.getMessage());

		}catch(SQLException se){

			System.out.println(se.getMessage());

		}finally{

			try{

				if(pstmt!=null) pstmt.close();

				if(con!=null) con.close();

			}catch(SQLException se){

				System.out.println(se.getMessage());

			}

		}

		

		// 3. �����(Ŭ���̾�Ʈ)�� ����� �����ϱ�.

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter pw = response.getWriter();

		pw.println("<html>");

		pw.println("<head></head>");

		pw.println("<body>");

		if(n>0){

			pw.println( id + "��! ���������� ���ԵǾ����ϴ�.<br/>");
			
			if(id.contentEquals("admin")) {
				pw.println("�����ڷ� �α��� �Ͽ����ϴ�.");	
			}

		}else{
			if (id.length() == 0 || id =="" )
			{
				pw.println("ID�� �ʼ��Դϴ�.");				
			}
			else if (pwd.length() == 0 || pwd == "" ) 
			{
				pw.println("Password�� �ʼ��Դϴ�.");
			}
			else if (email.length() == 0 || email == "" || email.contains("@"))
			{
				pw.println("E-Mail�� �ʼ��Դϴ�.");	
			}

			pw.println("������ ���� ���Կ� �����߽��ϴ�.<br/>");

			pw.println("<a href='javascript:history.go(-1)'>������������ ����</a>");

		}
		pw.println("<a href='index.html'>������������ �̵�</a>");

		pw.println("</body>");

		pw.println("</html>");

	}

}


