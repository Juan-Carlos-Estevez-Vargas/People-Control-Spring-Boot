package com.juan.estevez.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PERSON")
public class Person implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSON")
    private Long idPerson;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "PHONE")
    private String phone;
}
