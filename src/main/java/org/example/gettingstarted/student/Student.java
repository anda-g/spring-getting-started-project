package org.example.gettingstarted.student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private Integer id;
    private String fullName;
    private String gender;
    private Double score;
}