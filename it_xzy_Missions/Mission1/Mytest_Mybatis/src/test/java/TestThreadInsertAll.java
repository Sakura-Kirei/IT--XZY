import com.jnshu.entity.Student;
import com.jnshu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class TestThreadInsertAll {

    public static void main(String[] args) {
        insertAll all = new insertAll();
        //33个线程 一个3W数据 一共99W 差1W。。。
        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();

        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();

        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();

        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();

        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();

        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();

        new Thread(all).start();
        new Thread(all).start();
        new Thread(all).start();

    }
}


    class insertAll implements Runnable{
        public void run(){
                SqlSession sqlSession = MybatisUtil.getSeesion();
                List<Student> user = new ArrayList<Student>();
                Integer rows = 0;
                for (int i = 0; i <= 30000; i++) {
                    Student student = new Student();
                    student.setNameInMysql("无敌");
                    student.setSchoolInMysql("矮子");
                    student.setOnlineOrUnInMysql("天上");
                    student.setNumberInMysql(788);
                    student.setCityInMysql("跑路");
                    user.add(student);
                }
                rows = sqlSession.insert("com.jnshu.dao.StudentMapper.insertAll", user);
                System.out.println(rows);
                sqlSession.commit();
                sqlSession.close();

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

