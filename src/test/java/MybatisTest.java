import mybatis.entity.Student;
import mybatis.mapper.dao.StudentDao;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MybatisTest {
    private StudentDao studentDao = new StudentDao();

    @Test
    public void testMybatisAdd() {
        Student student = new Student();
        student.setAge(333);
        student.setName("addCai");
        studentDao.addStudent(student);
    }

    @Test
    public void testMybatisSelect () {
        Student student = new Student();
      /*  student.setAge(20);
        student.setName("caicaicai");*/
        studentDao.getStudentList(student);
    }

    @Test
    public void testMybatisUpdate() {
        Student student = new Student();
        student.setId(1);
        student.setName("SchuylerChanged");
        studentDao.updateStudent(student);
    }

    @Test
    public void testMybatisDelete() {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        studentDao.deleteStudents(ids);
    }

    @Test
    public void testMybatisAddAll() {
        List<Student> students = new ArrayList<>();
        Student studentOne = new Student();
        studentOne.setName("caiOne");
        studentOne.setAge(111);
        Student studentTwo = new Student();
        studentTwo.setName("caiTwo");
        studentTwo.setAge(222);
        students.add(studentOne);
        students.add(studentTwo);
        studentDao.addStudents(students);
    }
}
