import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionTrack extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SessionTrack() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doDelete method of the servlet. <br>
	 *
	 * This method is called when a HTTP delete request is received.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 // 如果不存在 session 会话，则创建一个 session 对象
	      HttpSession session = request.getSession(true);
	      // 获取 session 创建时间
	      Date createTime = new Date(session.getCreationTime());
	      // 获取该网页的最后一次访问时间
	      Date lastAccessTime = 
	                        new Date(session.getLastAccessedTime());

	      String title = "欢迎回到我的网站";
	      Integer visitCount = new Integer(0);
	      String visitCountKey = new String("visitCount");
	      String userIDKey = new String("userID");
	      String userID = new String("ABCD");

	      // 检查网页上是否有新的访问者
	      if (session.isNew()){
	         title = "欢迎来到我的网站";
	         session.setAttribute(userIDKey, userID);	        
	      } else {
	    	 
	         visitCount = (Integer)session.getAttribute(visitCountKey);
	         if (visitCount==null) visitCount=0;
	         visitCount = visitCount + 1;
	         userID = (String)session.getAttribute(userIDKey);
	      }
	      session.setAttribute(visitCountKey,  visitCount);

	      // 设置响应内容类型
	      response.setCharacterEncoding("utf8");
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();

	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                 "<h2 align=\"center\">Session 信息</h2>\n" +
	                "<table border=\"1\" align=\"center\">\n" +
	                "<tr bgcolor=\"#949494\">\n" +
	                "  <th>Session 信息</th><th>值</th></tr>\n" +
	                "<tr>\n" +
	                "  <td>id</td>\n" +
	                "  <td>" + session.getId() + "</td></tr>\n" +
	                "<tr>\n" +
	                "  <td>Creation Time</td>\n" +
	                "  <td>" + createTime + 
	                "  </td></tr>\n" +
	                "<tr>\n" +
	                "  <td>Time of Last Access</td>\n" +
	                "  <td>" + lastAccessTime + 
	                "  </td></tr>\n" +
	                "<tr>\n" +
	                "  <td>User ID</td>\n" +
	                "  <td>" + userID + 
	                "  </td></tr>\n" +
	                "<tr>\n" +
	                "  <td>Number of visits</td>\n" +
	                "  <td>" + visitCount + "</td></tr>\n" +
	                "</table>\n" +
	                "</body></html>");
	  }

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPut method of the servlet. <br>
	 *
	 * This method is called when a HTTP put request is received.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Put your code here
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
