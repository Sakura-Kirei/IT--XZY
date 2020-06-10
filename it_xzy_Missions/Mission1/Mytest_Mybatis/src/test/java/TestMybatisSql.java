import com.jnshu.entity.Student;
import com.jnshu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

/**
 * 类名采用UpperCamelCase风格
 * @author 王振宇
 * 2020.6.10
 *
 * 测试所有StudentMapper.xml中的SQL语句
 */
public class TestMybatisSql {
    /**
     * 类、属性、方法的注释必须符合Javadoc规范
     *
     * 方法名全部采用lowerCamelCase风格
     *
     * 所有局部变量必须使用基本数据类型
     *
     */

    @Test
    public void queryDataBase() throws Exception{
        SqlSession sqlSession = MybatisUtil.getSeesion();
        Student student = new Student();
        // 后面必须跟一个空格
        // student.setNameInMysql("王振宇");
        student.setNumberInMysql(7777);
        List<Student> students = sqlSession.selectList("com.jnshu.dao.StudentMapper.query",student);
        // if for while switch do必须与括号之间有空格
        for (Student student1 : students){
            System.out.println(student1.toString());
        }
        sqlSession.close();
    }


    @Test
    public void updateDataBase() throws Exception{
        SqlSession sqlSession = MybatisUtil.getSeesion();
        Student student = new Student();

        student.setNameInMysql("787878");
        // student.setCity("北X京");
        student.setIdInMysql(54);
        int rows = sqlSession.update("com.jnshu.dao.StudentMapper.update",student);

        /**
         * 少用if-else方式
         */

        // ()左右不允许有空格
        if (rows > 0) {
            System.out.println("成功修改了" + rows + "条数据");
        }
        if (rows == 0) {
            System.out.println("修改数据失败");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertIntoDataBase() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSeesion();
        Student student = new Student();

        student.setNameInMysql("无敌");
        student.setSchoolInMysql("矮子");
        student.setOnlineOrUnInMysql("天上");
        student.setNumberInMysql(788);
        student.setCityInMysql("跑路");

        Integer rows = sqlSession.insert("com.jnshu.dao.StudentMapper.insert", student);

        /**
         * 少用if-else方式
         */
        if (rows > 0){
            System.out.println("添加数据"+rows+"条");
            System.out.println("添加数据的主键ID是："+student.getIdInMysql());
        }
        if (rows == 0){
            System.out.println("添加数据失败");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteFromDataBase()throws Exception{
        SqlSession sqlSession = MybatisUtil.getSeesion();
        Student student = new Student();

        student.setIdInMysql(16546);
        Integer rows = sqlSession.delete("com.jnshu.dao.StudentMapper.delete",student);
        if (rows > 0){
            System.out.println("成功删除:"+rows+"条数据");
        }
        else {
            System.out.println("删除数据失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    // 依次插入100W条数据
    public void insertAllToDataBase() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSeesion();
        Student student = new Student();

        student.setNameInMysql("无敌");
        student.setSchoolInMysql("矮子");
        student.setOnlineOrUnInMysql("天上");
        student.setNumberInMysql(788);
        student.setCityInMysql("跑路");
        Integer rows = 0;
        for (int i = 0; i <= 1000000;i++) {
            rows = rows +sqlSession.insert("com.jnshu.dao.StudentMapper.insert", student);
            sqlSession.commit();
        }

        /**
         * 少用if-else方式
         */
        if (rows > 0) {
            System.out.println("添加数据" + rows + "条");
        }
        System.out.println("添加数据失败");

        sqlSession.close();
    }

    @Test
    // 批量插入100W条数据
    public void insertAllToDataBaseByForEach() throws Exception{
        SqlSession sqlSession = MybatisUtil.getSeesion();
        List<Student> user = new ArrayList<Student>();
        Integer rows = 0;
        for (int i = 0 ; i <= 1000000 ; i++){
            Student student = new Student();
            student.setNameInMysql("无敌");
            student.setSchoolInMysql("矮子");
            student.setOnlineOrUnInMysql("天上");
            student.setNumberInMysql(788);
            student.setCityInMysql("跑路");
            user.add(student);
        }

        rows = sqlSession.insert("com.jnshu.dao.StudentMapper.insertall",user);
        System.out.println(rows);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    /**
     *测试异常捕捉代码是否能正常执行
     */
    public void test_DateBase_connection(){

        SqlSession sqlSession = MybatisUtil.getSeesion();
        Student student = new Student();
        student.setNameInMysql("无敌");
        student.setSchoolInMysql("矮子");
        student.setOnlineOrUnInMysql("天上");
        student.setNumberInMysql(788);
        student.setCityInMysql("跑路");

        try{

            // 方法内部单行注释，在被注释的语句上方另起一行，使用//注释
            // 手动关闭数据库测试异常代码是否正常执行
            sqlSession.close();
            Integer rows = sqlSession.insert("com.jnshu.dao.StudentMapper.insert", student);

            sqlSession.commit();

            /**
             * 少用if-else方式
             */
            if (rows > 0 ){
                System.out.println("添加数据"+rows+"条");
                System.out.println("添加数据的主键ID是："+student.getIdInMysql());
            }
            if (rows == 0 ){ System.out.println("添加数据失败"); }

            }catch(Exception e){
                System.out.println("数据库连接失败:"+e);
            }
            // finally块必须对资源对象、流对象进行关闭，不要在finally块中使用return
            finally {
                // 关闭连接数据库
                sqlSession.close();
            }

    }

}