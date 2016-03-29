package me.gacl.domain;

import me.gacl.mybatis.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;

public class TestOneLevelCache extends MyObject {
	 /*
     * 一级缓存: 也就Session级的缓存(默认开启)
     */
       public void testCache1() {
        SqlSession session = MyBatisUtil.getSqlSession();
        String statement = "me.gacl.mapping.userMapper.getUser";
        User user = session.selectOne(statement, 1);
        mout.println(user);
        
        /*
         * 一级缓存默认就会被使用
         */
        user = session.selectOne(statement, 1);
        mout.println(user);
       //session.clearCache(); 
       session.close();
        /*
         1. 必须是同一个Session,如果session对象已经close()过了就不可能用了 
         */
        session = MyBatisUtil.getSqlSession();
        user = session.selectOne(statement, 1);
        mout.println(user);
        
        /*
         2. 查询条件是一样的
         */
        user = session.selectOne(statement, 2);
        mout.println(user);
        
        /*
         3. 没有执行过session.clearCache()清理缓存
         */
        //session.clearCache(); 
        user = session.selectOne(statement, 2);
        mout.println(user);
        
        /*
         4. 没有执行过增删改的操作(这些操作都会清理缓存)
         */
        User user1=new User();
        user1.setId(2);//2, "user", 23
        user1.setAge(23);
        user1.setName("user");
        session.update("me.gacl.mapping.userMapper.updateUser",  user1);
        user = session.selectOne(statement, 2);
       mout.println(user);
        
    }
}
