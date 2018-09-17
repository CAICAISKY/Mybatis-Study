package mybatis.mapper.dao;

import mybatis.entity.Student;
import mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Schuyler
 */
public class StudentDao {

    public void addStudent(Student student) {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
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
}
