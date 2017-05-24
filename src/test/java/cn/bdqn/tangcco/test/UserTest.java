package cn.bdqn.tangcco.test;

import cn.bdqn.tangcco.entity.Tbuser;
import cn.bdqn.tangcco.mapper.TbuserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by lei on 2017/5/23.
 */

public class UserTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private TbuserMapper tbuserMapper;
    @Before
    public void init(){
        try {
            this.sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sqlSession=this.sqlSessionFactory.openSession();
        this.tbuserMapper=this.sqlSession.getMapper(TbuserMapper.class);

    }

    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
}
    @Test
    public void testLogin(){

        System.out.println(this.tbuserMapper.login(new Tbuser("guolei","1234")));
    }
    @Test
    public void testAdd(){
        String datestr="1980-01-12 09:49:23";
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        try {
            date=format.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=new Date();
        try {
            date1=format1.parse("2017-06-03");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.tbuserMapper.add(new Tbuser(0,"guolei12","1212","02","老师",date,date1,new Date()));

    }


}
