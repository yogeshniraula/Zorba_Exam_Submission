package entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student")


public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(name = "student_name", length = 255)
    private String name;

    @Column(name = "location", length = 255)
    private String location;
    @Column(name = "course", length = 255)
    private String course;

    @Column(name = "email", length = 255)
    private Long email;

    @Column(name = "mobile", length = 11)
    private Long mobile;

    @Column(name = "score", length = 10)
    private Integer score;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
