import com.jnshu.entity.Student;
import com.jnshu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class test{
    @Test
    public void query() throws Exception{
        SqlSession sqlSession = MybatisUtil.getSeesion();
        Student student = new Student();
        //student.setName("万晶");
        //student.setNumber(6666);
        List<Student> students = sqlSession.selectList("com.jnshu.dao.StudentMapper.query",student);

        for(Student student1 : students){
            System.out.println(student1.toString());
        }
        sqlSession.close();
    }


    @Test
    public void update() throws Exception{
        SqlSession sqlSession = MybatisUtil.getSeesion();
        Student student = new Student();

        student.setName("787878");
        //student.setCity("北X京");
        student.setID(2);
        int rows = sqlSession.update("com.jnshu.dao.StudentMapper.update",student);

        if (rows > 0 ){
            System.out.println("成功修改了"+rows+"条数据");
        }
        else {
            System.out.println("修改数据失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insert() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSeesion();
        Student student = new Student();

        student.setName("无敌");
        student.setSchool("矮子");
        student.setOnline_un("天上");
        student.setNumber(788);
        student.setCity("跑路");

        Integer rows = sqlSession.insert("com.jnshu.dao.StudentMapper.insert", student);

        if (rows > 0 ){
            System.out.println("添加数据"+rows+"条");
            System.out.println("添加数据的主键ID是："+student.getID());
        }
        else {
            System.out.println("添加数据失败");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delete()throws Exception{
        SqlSession sqlSession = MybatisUtil.getSeesion();
        Student student = new Student();

        student.setID(12316546);
        Integer rows = sqlSession.delete("com.jnshu.dao.StudentMapper.delete",student);
        if (rows > 0 ){
            System.out.println("成功删除:"+rows+"条数据");
        }
        else {
            System.out.println("删除数据失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //依次插入100W条数据
    public void insertall() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSeesion();
        Student student = new Student();

        student.setName("无敌");
        student.setSchool("矮子");
        student.setOnline_un("天上");
        student.setNumber(788);
        student.setCity("跑路");
        Integer rows = 0;
        for(int i = 0; i <= 1000000;i++) {
            rows = rows +sqlSession.insert("com.jnshu.dao.StudentMapper.insert", student);
            sqlSession.commit();
        }

        if (rows > 0) {
            System.out.println("添加数据" + rows + "条");
        } else {
            System.out.println("添加数据失败");
        }

        sqlSession.close();
    }

    @Test
    //批量插入100W条数据
    public void insertall_forEach() throws Exception{
        SqlSession sqlSession = MybatisUtil.getSeesion();
        List<Student> user = new ArrayList<Student>();
        Integer rows = 0;
        for(int i = 0 ; i <= 1000000 ; i++){
            Student student = new Student();
            student.setName("无敌");
            student.setSchool("矮子");
            student.setOnline_un("天上");
            student.setNumber(788);
            student.setCity("跑路");
            user.add(student);
        }

        rows = sqlSession.insert("com.jnshu.dao.StudentMapper.insertall",user);
        System.out.println(rows);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //测试DB关闭后异常代码
    public void test_DateBase_connection(){

        SqlSession sqlSession = MybatisUtil.getSeesion();
        Student student = new Student();
        student.setName("无敌");
        student.setSchool("矮子");
        student.setOnline_un("天上");
        student.setNumber(788);
        student.setCity("跑路");


        try{

            sqlSession.close();//手动关闭数据库测试异常代码是否正常执行
            Integer rows = sqlSession.insert("com.jnshu.dao.StudentMapper.insert", student);

            sqlSession.commit();

            if (rows > 0 ){
                System.out.println("添加数据"+rows+"条");
                System.out.println("添加数据的主键ID是："+student.getID());
            }
            else {
                System.out.println("添加数据失败");
            }

            }catch(Exception e){
                System.out.println("数据库连接失败:"+e);
            }

    }

}