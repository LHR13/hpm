package com.lhr13.hpm.bean;


import javax.persistence.*;
import java.sql.Date;


@Entity(name = "personfortest")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column
    private Date jobdate;   //参加工作时间
    @Column
    private Integer infoState;  //状态，非0为存在

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJobdate() {
        return jobdate;
    }

    public void setJobdate(Date jobdate) {
        this.jobdate = jobdate;
    }
    
    public Integer getInfoState() {
        return infoState;
    }

    public void setInfoState(Integer infoState) {
        this.infoState = infoState;
    }

    public Person() {
    }
}
