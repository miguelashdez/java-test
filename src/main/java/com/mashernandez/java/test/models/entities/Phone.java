package com.mashernandez.java.test.models.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phones")
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phone")
    private Long idPhone;

    private String number;

    @Column(name = "city_code")
    private Integer cityCode;

    @Column(name = "country_code")
    private Integer countryCode;

    public Phone() {
    }

    public Long getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Long idPhone) {
        this.idPhone = idPhone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "idPhone=" + idPhone +
                ", number='" + number + '\'' +
                ", cityCode=" + cityCode +
                ", countryCode=" + countryCode +
                '}';
    }

}