package com.lhr13.hpm.POJO;


import javax.persistence.*;
import java.sql.Date;

@Entity(name = "personfortest")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String Dep;
    @Column
    private Date jobdate;   //参加工作时间
    @Column
    private Integer infoState;  //状态，非0为存在

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cw_id", referencedColumnName = "id")
    private Cw cw;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDep() {
        return Dep;
    }

    public void setDep(String dep) {
        Dep = dep;
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
