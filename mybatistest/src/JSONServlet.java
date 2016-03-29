import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.gacl.domain.Classes;
import me.gacl.domain.Order;
import me.gacl.domain.TestOneLevelCache;
import me.gacl.domain.TestTwoLevelCache;
import me.gacl.domain.User;
import me.gacl.mybatis.test;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class JSONServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	PrintWriter mout;
	public JSONServlet() {
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
		mout= response.getWriter();  
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
		response.setContentType("text/json;charset=UTF-8;pageEncoding=UTF-8");
 
		 mout= response.getWriter();  
		 String action=request.getParameter("a");
		 if (action==null || action.isEmpty()) return ;
		switch (Integer.parseInt(action))
		{
		   case 1:
			   test();
			   break;
		   case 2:
			   this.jsonobject();
			   break;
		   case 3:
			   this.JavaBean();
			   break;
		   case 4:
			   this.listtojson();
			   break;
		   case 5:
			   getdatacount();
		   case 6:
			   testmybatis();
			   break;
		   case 7:
			   test _test=new test(mout);
			   _test.testAdd();
			   _test.testGetAll();
			   break;
		   case 8:
			 //  _test=new test(mout);
			   //_test.testGetOrderById2();
			   Order _order=   new Order();
			   _order.setMout(mout);
			   _order .testGetOrderById3();
			   break;
		   case 9:
			   Classes _Classes=   new Classes();
			   _Classes.setMout(mout);
			   _Classes.testGetClass();
			   _Classes.testGetClass3();
			   _Classes.testGetClass4();
			   break;
			   
		   case 10:
			     User _user=new User();
			     _user.setMout(mout);
			     _user.testGetUserCount();
			   break;
		   case 11:
			   TestOneLevelCache _TestOneLevelCache=new TestOneLevelCache();
			   _TestOneLevelCache.setMout(mout);
			   _TestOneLevelCache.testCache1();
			   break;
		   case 12:
			   TestTwoLevelCache _TestTwoLevelCache=new TestTwoLevelCache();
			   _TestTwoLevelCache.setMout(mout);
			   _TestTwoLevelCache.testCache2();
			   break;
		}
		 doPost(request,response);
	}
	 SqlSession session ;
	 void initmybatis()
	 {
	        String resource = "conf.xml";
	        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
	        InputStream is = JSONServlet.class.getClassLoader().getResourceAsStream(resource);
	        //构建sqlSession的工厂
	        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
	        //Reader reader = Resources.getResourceAsReader(resource); 
	        //构建sqlSession的工厂
	        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	        //创建能执行映射文件中sql的sqlSession
	          session = sessionFactory.openSession();
	 }
	void testmybatis()
	{
		 //mybatis的配置文件
		initmybatis();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "me.gacl.mapping.userMapper.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);
        mout.println(user);
	}
	void JavaBean()
	{
		 // JavaBean对象转json字符串  
        Student stu1 = new Student("lwc", "111111");  
        JSONObject jsonObject = JSONObject.fromObject(stu1);  
        mout.println(jsonObject);  
  
        // json字符串转JavaBean  
        String jsondata = "{\"id\":\"111111\",\"name\":\"lwc\"}";  
        JSONObject jsonObject1 = JSONObject.fromObject(jsondata);  
         Student stu2 = (Student) JSONObject.toBean(jsonObject1, Student.class);  
         
        mout.println(stu2.getId()+":"+stu2.getName());  
	}
	//http://localhost:8087/service/servlet/json?a=5
	void getdatacount()
	{ 
		String sql1="Select * From base_users";
		mout.println(DBHelper.getCount(sql1));
		mout.println("end");
	}
	
	void listtojson()
	{
		  // List转json字符串  
        List  list = new ArrayList();  
       list.add(new Student("lwc", "111111"));  
        list.add(new Student("nxj", "222222")); 
         
        JSONArray jsonArray = JSONArray.fromObject(list);
 
   
       mout.println(jsonArray);  
  
//        // json字符串转List  
         List  list1 = new ArrayList ();  
         String jsondata = "[{\"id\":\"111111\",\"name\":\"lwc\"},{\"id\":\"222222\",\"name\":\"nxj\"}]";  
        JSONArray jsonArray1 = JSONArray.fromObject(jsondata);  
        for (int i = 0; i < jsonArray1.size(); i++) {  
            JSONObject jsonObject2 = jsonArray1.getJSONObject(i);  
            Student stu2 = (Student) JSONObject.toBean(jsonObject2,  
                    Student.class);  
            list1.add(stu2);  
        }  
        mout.println(list1);
	}
        /**
	}
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
		//initmybatis();
	}
	void test()
	{
		 //使用JSONArray测试  
        JSONArray jsonArray = new JSONArray();  
        jsonArray.add("MCA");  
        jsonArray.add("kevin");  
        jsonArray.add("15-12-1998");  
        jsonArray.add(new Double(12.3));  
        List<String> list = new ArrayList<String>();   
        list.add("a collection added");  
        list.add("kevin collection test");  
        jsonArray.addAll(list);  
          
        //页面输出JSONArray的内容  
        
        mout.print(jsonArray);  
        mout.println("======================================");  
        for(int i=0;i<jsonArray.size();i++){  
        	mout.print(jsonArray.getString(i));  
        }  
	}
	void jsonobject()
	{
		 // 创建JSONObject  
        JSONObject jsonObject = new JSONObject();  
        jsonObject.put("username", "lwc");  
        jsonObject.put("password", "123");  
        // 打印:1  
        System.out.println(jsonObject);  
  
        // 增加属性,打印:2  
        jsonObject.element("sex", "男");  
        System.out.println(jsonObject);  
          
        // 根据key返回,打印:3  
        System.out.println(jsonObject.get("sex"));  
  
        // 判读输出对象的类型  
        boolean isArray = jsonObject.isArray();  
        boolean isEmpty = jsonObject.isEmpty();  
        boolean isNullObject = jsonObject.isNullObject();  
        // 打印:4  
        System.out.println("是否数组:" + isArray + " 是否空:" + isEmpty + " 是否空对象:"  
                + isNullObject);  
          
        // 把JSONArray增加到JSONObject中  
        JSONArray jsonArray = new JSONArray();  
        jsonArray.add(0, "lwc");  
        jsonArray.add(1, "nxj");  
        // 开始增加  
        jsonObject.element("student", jsonArray);  
        mout.print(jsonObject); 
	}

}
