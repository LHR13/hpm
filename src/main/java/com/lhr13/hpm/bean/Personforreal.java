package com.lhr13.hpm.bean;


import javax.persistence.*;
import java.sql.Date;


@Entity(name = "person")
public class Personforreal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column
    private String sex;
    @Column
    private String root;    //籍贯
    @Column
    private String political;   //政治面貌
    @Column
    private Date jobdate;   //参加工作时间
    @Column
    private Integer isProfessionDoc;    //是否是执业医师，非0为是
    @Column
    private Date PDdate;    //职业医师证书日期
    @Column
    private Integer ismediastinus;    //是否是助理医师，非0为是
    @Column
    private Date MDSdate;   //助理医师证书日期
    @Column
    private String CertificateID;   //资格证书编号
    @Column
    private String reference;   //执业范围
    @Column
    private String title;   //职称
    @Column
    private String IDNum;   //身份证号码
    @Column
    private String phone;   //电话
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public Date getJobdate() {
        return jobdate;
    }

    public void setJobdate(Date jobdate) {
        this.jobdate = jobdate;
    }

    public Integer getIsProfessionDoc() {
        return isProfessionDoc;
    }

    public void setIsProfessionDoc(Integer isProfessionDoc) {
        this.isProfessionDoc = isProfessionDoc;
    }

    public Date getPDdate() {
        return PDdate;
    }

    public void setPDdate(Date PDdate) {
        this.PDdate = PDdate;
    }

    public Integer getIsmediastinus() {
        return ismediastinus;
    }

    public void setIsmediastinus(Integer ismediastinus) {
        this.ismediastinus = ismediastinus;
    }

    public Date getMDSdate() {
        return MDSdate;
    }

    public void setMDSdate(Date MDSdate) {
        this.MDSdate = MDSdate;
    }

    public String getCertificateID() {
        return CertificateID;
    }

    public void setCertificateID(String certificateID) {
        CertificateID = certificateID;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getInfoState() {
        return infoState;
    }

    public void setInfoState(Integer infoState) {
        this.infoState = infoState;
    }

    public Personforreal() {
    }
}
