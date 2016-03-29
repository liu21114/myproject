import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  import org.json.JSONArray;
 import org.json.JSONException;
import org.json.JSONObject;

public class myjson extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public myjson() {
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
		//声明一个Hash对象并添加数据
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		Map params =  new HashMap();

		params.put("username", "username");
		params.put("user_json", "user");
		//声明JSONArray对象并输入JSON字符串
		JSONArray array=null;
		 String result = "[{\"username\": \"your name\", \"user_json\": {\"username\": \"your name\", \"nickname\": \"your nickname\"}}]";
		try {			 
			array = new JSONArray(result);		 
		} catch (JSONException e) {
			// TODO Auto-generated catch block			
			out.println( e.getMessage());
			e.printStackTrace();
		} 				
		out.println("array ="+array.toString());
		try {
			out.println("jsonToString="+jsonToString());
			out.println("arraytoString="+arraytoString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}
    String jsonToString() throws JSONException
    {
        //创建JSONObject对象
        JSONObject json = new JSONObject();
        
        //向json中添加数据
        json.put("username", "wanglihong");
        json.put("height", 12.5);
        json.put("age", 24);
        
        //创建JSONArray数组，并将json添加到数组
        JSONArray array = new JSONArray();
        array.put(json);
        
        //转换为字符串
        String jsonStr = array.toString();
        return jsonStr;
    }
    String arraytoString()
    {
        //初始化ArrayList集合并添加数据
        List<String> list = new ArrayList<String>();
        list.add("username");
        list.add("age");
        list.add("sex");
        
        //初始化HashMap集合并添加数组
        Map map = new HashMap();
        map.put("bookname", "CSS3实战");
        map.put("price", 69.0);
        
        //初始化JSONArray对象，并添加数据
        JSONArray array = new JSONArray();
        array.put(list);
        array.put(map);
        return array.toString();
        //生成的JSON字符串为：[["username","age","sex"],{"price":69,"bookname":"CSS3实战"}]
        
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
