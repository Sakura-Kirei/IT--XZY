import com.jnshu.entity.Student;
import com.jnshu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


public class ThreadInsertOneByOneTest {

    public static void main(String[]args){
        InsertIntoDataBase insertIntoDataBase = new InsertIntoDataBase();

        // 5个线程单次插入 一个线程20W数据
        new Thread(insertIntoDataBase).start();
        new Thread(insertIntoDataBase).start();
        new Thread(insertIntoDataBase).start();
        new Thread(insertIntoDataBase).start();
        new Thread(insertIntoDataBase).start();
    }

    }

    class InsertIntoDataBase implements Runnable{
        public void run(){
            SqlSession sqlSession = MybatisUtil.getSeesion();
            Student student = new Student();

            student.setNameInMysql("无敌");
            student.setSchoolInMysql("矮子");
            student.setOnlineOrUnInMysql("天上");
            student.setNumberInMysql(788);
            student.setCityInMysql("跑路");
            Integer rows = 0;

            //一个线程20W数据
            for (int i = 0; i <= 200000;i++) {
                rows = rows +sqlSession.insert("com.jnshu.dao.StudentMapper.insert", student);
                sqlSession.commit();
            }

            /**
             * 少用if-else方式
             */
            if (rows > 0) System.out.println("添加数据" + rows + "条");
            if (rows == 0) System.out.println("添加数据失败");

            try{
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                sqlSession.close();
            }

    }

}
