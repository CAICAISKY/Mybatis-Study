package mybatis.mapper.dao;

import mybatis.entity.Student;
import mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

/**
 * @author Schuyler
 */
public class StudentDao {
    private SqlSession sqlSession = MybatisUtil.getSqlSession();
    /**
     * 增加一个学生
     * @param student
     */
    public void addStudent(Student student) {
        try {
            sqlSession.insert("StudentMapper.addStudent", student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.close();
        }
    }

    /**
     * 获取对应条件的学生列表
     * @param student
     */
    public void getStudentList(Student student) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", student.getName());
        map.put("age", student.getAge());
        try {
            List<Student> students = sqlSession.selectList("StudentMapper.getStudentList", student);
            for (Student studentResult : students) {
                System.out.println(studentResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.close();
        }
    }

    /**
     * 更新
     * @param student
     */
    public void updateStudent(Student student) {
        try {
            sqlSession.update("StudentMapper.updateStudent", student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.close();
        }
    }

    /**
     * 删除指定id的student
     * @param ids
     */
    public void deleteStudents(List<Integer> ids) {
        try {
            sqlSession.delete("StudentMapper.deleteStudents", ids);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.close();
        }
    }

    /**
     * 批量插入
     * @param students
     */
    public void addStudents(List<Student> students) {
        try {
            sqlSession.insert("StudentMapper.addStudents", students);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.close();
        }
    }
}
