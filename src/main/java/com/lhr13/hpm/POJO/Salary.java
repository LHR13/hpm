package com.lhr13.hpm.POJO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "salary")
@NamedEntityGraph(name = "salaryList", attributeNodes = @NamedAttributeNode("person"))
public class Salary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double bwage;       //基本工资
    @Column
    private Double mwage;       //绩效工资
    @Column
    private Double reward;      //奖金
    @Column
    private Double subsidy;      //补贴
    @Column
    private Double sodeductions;    //社保扣款
    @Column
    private Double incometax;       //个人所得税
    @Column
    private Double fine;            //罚款
    @Transient
    private Double finalSalary;     //最终工资

    @OneToOne()
    @JsonIgnoreProperties({"salary", "checkwork"})
    private Person person;


    //构造函数和Getter、Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Double getBwage() {
        return bwage;
    }

    public void setBwage(Double bwage) {
        this.bwage = bwage;
    }

    public Double getMwage() {
        return mwage;
    }

    public void setMwage(Double mwage) {
        this.mwage = mwage;
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public Double getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(Double subsidy) {
        this.subsidy = subsidy;
    }

    public Double getSodeductions() {
        return sodeductions;
    }

    public void setSodeductions(Double sodeductions) {
        this.sodeductions = sodeductions;
    }

    public Double getIncometax() {
        return incometax;
    }

    public void setIncometax(Double incometax) {
        this.incometax = incometax;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    public Double getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(Double finalSalary) {
        this.finalSalary = finalSalary;
    }

    public Salary() {
    }
}
