import com.jnshu.entity.Student;
import com.jnshu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class ThreadInsertAllMemoryTest {
        public static void main(String[] args) {
            testMemory tm = new testMemory();
            //33个线程 一个3W数据 一共99W 差1W。。。
            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();

            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();

            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();

            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();

            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();

            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();

            new Thread(tm).start();
            new Thread(tm).start();
            new Thread(tm).start();

        }
}


    class testMemory implements Runnable{

        //设置成公共资源
        private List<Student> user = new ArrayList<Student>();
        public testMemory(){
            for (int i = 0 ; i <= 30000 ; i++){
                Student student = new Student();
                student.setNameInMysql("无敌");
                student.setSchoolInMysql("矮子");
                student.setOnlineOrUnInMysql("天上");
                student.setNumberInMysql(788);
                student.setCityInMysql("跑路");
                user.add(student);
            }
        }
        public void run(){
            SqlSession sqlSession = MybatisUtil.getSeesion();
            sqlSession.insert("com.jnshu.dao.StudentMapper.insertAll", user);
            sqlSession.commit();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                sqlSession.close();
            }
        }
    }

