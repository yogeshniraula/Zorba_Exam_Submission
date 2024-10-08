package org.springMVC.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "studentInfo")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stud_id")
    private Integer studId;
    @Column(name = "stud_name")
    private String studName;
    @Column(name = "stud_address")
    private String studAddress;
    @Lob
    private byte[] studImage;
}
