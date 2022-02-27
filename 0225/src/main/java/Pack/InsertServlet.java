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

		// 1. 파라미터로 전송된 값을 얻어오기.
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

			// 2. 전송된 값을 db에 저장.

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/test?&useSSL=false";

			con = DriverManager.getConnection(url, "root", "1234");

			String sql = "insert into members values( ?,?,?,?, now() )";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);

			pstmt.setString(2, pwd);

			pstmt.setString(3, email);

			pstmt.setString(4, phone);
		
			

			//sql구문 실행하기

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

		

		// 3. 사용자(클라이언트)에 결과를 응답하기.

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter pw = response.getWriter();

		pw.println("<html>");

		pw.println("<head></head>");

		pw.println("<body>");

		if(n>0){

			pw.println( id + "님! 성공적으로 가입되었습니다.<br/>");
			
			if(id.contentEquals("admin")) {
				pw.println("관리자로 로그인 하였습니다.");	
			}

		}else{
			if (id.length() == 0 || id =="" )
			{
				pw.println("ID는 필수입니다.");				
			}
			else if (pwd.length() == 0 || pwd == "" ) 
			{
				pw.println("Password는 필수입니다.");
			}
			else if (email.length() == 0 || email == "" || email.contains("@"))
			{
				pw.println("E-Mail은 필수입니다.");	
			}

			pw.println("오류로 인해 가입에 실패했습니다.<br/>");

			pw.println("<a href='javascript:history.go(-1)'>이전페이지로 가기</a>");

		}
		pw.println("<a href='index.html'>메인페이지로 이동</a>");

		pw.println("</body>");

		pw.println("</html>");

	}

}


