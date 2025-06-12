package org.example.gettingstarted.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements MyService<Student, Integer>{
    InMemoryDatabase db;

    @Autowired
    public StudentService(InMemoryDatabase db) {
        this.db = db;
    }
    @Override
    public void insert(Student student) {
        db.getStudents().add(student);
    }

    @Override
    public List<Student> selectAll() {
        return db.getStudents();
    }

    @Override
    public Student selectById(Integer id) {
        return db.getStudents().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean updateById(Integer id, Student student) {
        Student getStudent = selectById(id);
        if(getStudent != null) {
            db.getStudents().remove(getStudent);
            db.getStudents().add(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        for (Student s : db.getStudents()) {
            if (s.getId().equals(id)) {
                db.getStudents().remove(s);
                return true;
            }
        }
        return false;
    }
}
