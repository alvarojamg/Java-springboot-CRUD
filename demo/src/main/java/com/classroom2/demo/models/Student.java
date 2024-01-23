package com.classroom2.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Data
@AllArgsConstructor
@Entity
@Table(name="students")
@Embeddable
@EntityListeners(AuditingEntityListener.class)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name= "StudentId")
    private String studentId;

    @NotBlank
    @NotEmpty
    @Column(name = "Address")
    private String address;

    @NotBlank(message ="Email cannot be blank")
    @NotEmpty
    @Email
    @Column(name = "Email")
    private String email;

    @NotBlank(message ="Phone cannot be blank")
    @NotEmpty
    @Column(name = "Phone")
    private String phone;

    @NotBlank(message ="Lastname cannot be blank")
    @NotEmpty
    @Column(name = "LastName")
    private String lastName;

    @NotBlank(message ="Name cannot be blank")
    @NotEmpty
    @Column(name = "Name")
    private String name;

    @Column(name = "Cdate")
    private String cdate;

    @Column(name = "Enable")
    private boolean enable;

    public Student(){
    }
}


