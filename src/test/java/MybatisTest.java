import mybatis.entity.Student;
import mybatis.mapper.dao.StudentDao;
import org.junit.Test;

public class MybatisTest {

    @Test
    public void testMybatis () {
        Student student = new Student();
        student.setAge(20);
        student.setName("caicaicai");
        StudentDao studentDao = new StudentDao();
        studentDao.addStudent(student);
    }
}
