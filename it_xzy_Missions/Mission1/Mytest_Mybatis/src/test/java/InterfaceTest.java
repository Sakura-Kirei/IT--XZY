import com.jnshu.dao.StudentMapper;
import com.jnshu.entity.Student;
import com.jnshu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class InterfaceTest implements StudentMapper {

    @Test
    public void queryAll() {
        SqlSession sqlSession = MybatisUtil.getSeesion();
        Student student = new Student();
         student.setNameInMysql("王振宇");
        //student.setNumberInMysql(7777);
        List<Student> students = sqlSession.selectList("com.jnshu.dao.StudentMapper.query", student);
        // if for while switch do必须与括号之间有空格
        for (Student student1 : students) {
            System.out.println(student1.toString());
        }
        sqlSession.close();
    }
}

