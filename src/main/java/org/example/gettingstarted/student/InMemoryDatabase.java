package org.example.gettingstarted.student;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class InMemoryDatabase {
    private List<Student> students;
    public InMemoryDatabase() {
        students = new ArrayList<>();
        students.add(new Student(1, "Keo Dara", "Male", 90D));
        students.add(new Student(2, "Sok Pisey", "Female", 85D));
        students.add(new Student(3, "Chan Sophea", "Male", 78D));
        students.add(new Student(4, "Ly Sreymom", "Female", 92D));
        students.add(new Student(5, "Phan Vuthy", "Male", 88D));
        students.add(new Student(6, "Kim Sreypich", "Female", 76D));
        students.add(new Student(7, "Chea Rith", "Male", 81D));
        students.add(new Student(8, "Ouk Sreyneang", "Female", 89D));
        students.add(new Student(9, "Hem Dara", "Male", 95D));
        students.add(new Student(10, "Touch Leakena", "Female", 87D));
    }


}