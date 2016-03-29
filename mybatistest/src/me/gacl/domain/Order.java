package me.gacl.domain;

import java.io.PrintWriter;
import java.util.List;

import me.gacl.mybatis.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;

public class Order extends MyObject {
	/**
	 * @author gacl
	 * 定义orders表对应的实体类
	 */
 
	    /**
	     * 
	    CREATE TABLE orders(
	        order_id INT PRIMARY KEY AUTO_INCREMENT,
	        order_no VARCHAR(20), 
	        order_price FLOAT
	    );
	     */
	    
	    //Order实体类中属性名和orders表中的字段名是不一样的
	    private int id;                //id===>order_id
	    private String orderNo;        //orderNo===>order_no
	    private float price;        //price===>order_price

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getOrderNo() {
	        return orderNo;
	    }

	    public void setOrderNo(String orderNo) {
	        this.orderNo = orderNo;
	    }

	    public float getPrice() {
	        return price;
	    }

	    public void setPrice(float price) {
	        this.price = price;
	    }

	    @Override
	    public String toString() {
	        return "Order [id=" + id + ", orderNo=" + orderNo + ", price=" + price+ "]";
	    }
	    
		 
		
		public void testGetOrderAll(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession();
	        /**
	         * 映射sql的标识字符串，
	         * me.gacl.mapping.orderMapper是orderMapper.xml文件中mapper标签的namespace属性的值，
	         * selectOrderResultMap是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "me.gacl.mapping.orderMapper.getAllOrders";//映射sql的标识字符串
	        //执行查询操作，将查询结果自动封装成Order对象返回
	       List<Order> order = sqlSession.selectList(statement);//查询orders表中id为1的记录
	        //使用SqlSession执行完SQL之后需要关闭SqlSession
	        sqlSession.close();
	        mout.println(order);//打印结果：Order [id=1, orderNo=aaaa, price=23.0]
	    }
	    public void testGetOrderById3(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession();
	        /**
	         * 映射sql的标识字符串，
	         * me.gacl.mapping.orderMapper是orderMapper.xml文件中mapper标签的namespace属性的值，
	         * selectOrderResultMap是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "me.gacl.mapping.orderMapper.selectOrderResultMap";//映射sql的标识字符串
	        //执行查询操作，将查询结果自动封装成Order对象返回
	        Order order = sqlSession.selectOne(statement,1);//查询orders表中id为1的记录
	        //使用SqlSession执行完SQL之后需要关闭SqlSession
	        sqlSession.close();
	        mout.println(order);//打印结果：Order [id=1, orderNo=aaaa, price=23.0]
	    }
	    public void testGetOrderById(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession();
	        /**
	         * 映射sql的标识字符串，
	         * me.gacl.mapping.orderMapper是orderMapper.xml文件中mapper标签的namespace属性的值，
	         * getOrderById是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "me.gacl.mapping.orderMapper.getOrderById";//映射sql的标识字符串
	        //执行查询操作，将查询结果自动封装成Order对象返回
	        Order order = sqlSession.selectOne(statement,1);//查询orders表中id为1的记录
	        //使用SqlSession执行完SQL之后需要关闭SqlSession
	        sqlSession.close();
	        mout.println(order);//打印结果：null，也就是没有查询出相应的记录
	    }
	    public void testGetOrderById2(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession();
	        /**
	         * 映射sql的标识字符串，
	         * me.gacl.mapping.orderMapper是orderMapper.xml文件中mapper标签的namespace属性的值，
	         * selectOrder是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "me.gacl.mapping.orderMapper.selectOrder";//映射sql的标识字符串
	        //执行查询操作，将查询结果自动封装成Order对象返回
	        Order order = sqlSession.selectOne(statement,1);//查询orders表中id为1的记录
	        //使用SqlSession执行完SQL之后需要关闭SqlSession
	        sqlSession.close();
	       mout.println(order);//打印结果：Order [id=1, orderNo=aaaa, price=23.0]
	    }
}
