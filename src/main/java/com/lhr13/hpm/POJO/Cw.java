package com.lhr13.hpm.POJO;

import javax.persistence.*;

@Entity(name = "cw")
public class Cw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column
    private Integer normal;         //正常出勤次数
    @Column
    private Integer abnormal;       //异常出勤次数
    @Column
    private Integer late;           //迟到次数
    @Column
    private Integer goearly;        //早退次数
    @Column
    private Integer leave;          //请假次数

    @OneToOne(mappedBy = "cw")
    private Person person;

    public Integer getNormal() {
        return normal;
    }

    public void setNormal(Integer normal) {
        this.normal = normal;
    }

    public Integer getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(Integer abnormal) {
        this.abnormal = abnormal;
    }

    public Integer getLate() {
        return late;
    }

    public void setLate(Integer late) {
        this.late = late;
    }

    public Integer getGoearly() {
        return goearly;
    }

    public void setGoearly(Integer goearly) {
        this.goearly = goearly;
    }

    public Integer getLeave() {
        return leave;
    }

    public void setLeave(Integer leave) {
        this.leave = leave;
    }

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

    public Cw() {
    }
}
