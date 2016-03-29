package me.gacl.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import me.gacl.mybatis.MyBatisUtil;

public class User  extends MyObject  {
	/**
	 * @author gacl
	 * users表所对应的实体类
	 */
 

	    //实体类的属性和表的字段名称一一对应
	    private int id;
	    private String name;
	    private int age;
       
//	    public User(int id,String name,int age)
//	    {
//	    	this.id=id;
//	    	this.name=name;
//	    	this.age=age;
//	    }
	    
//	    public User() {
//			// TODO Auto-generated constructor stub
//		}

		public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    @Override
	    public String toString() {
	        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	    }
	    
	    
	    public void testGetUserCount(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession();
	        /**
	         * 映射sql的标识字符串，
	         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
	         * getUserCount是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "me.gacl.mapping.userMapper.getUserCount";//映射sql的标识字符串
	        Map<String, Integer> parameterMap = new HashMap<String, Integer>();
	        parameterMap.put("sexid", 1);
	        parameterMap.put("usercount", -1);
	        sqlSession.selectOne(statement, parameterMap);
	        Integer result = parameterMap.get("usercount");
	        mout.println(result);
	        sqlSession.close();
	    }
}
