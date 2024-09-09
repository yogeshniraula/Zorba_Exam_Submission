package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "teacher")


public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    @Column(name = "teacher_name", length = 255)
    private String name;

    @Column(name = "specialization", length = 255)
    private String specialization;
    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "mobile", length = 11)
    private Long mobile;

    @Column(name = "address", length = 20)
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", fetch = FetchType.LAZY)
    private Set<Student> students;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_department_mapping",
     joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Set<Department> departments;

//    @Override
//    public String toString(){
//        return "Teacher{" +
//                "teacherId=" + teacherId +
//
//    }

}
