package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "SprEmployee")
public class Employee {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "sprUserId",
            referencedColumnName = "id",
            nullable = false)
    private long userId;

    @Column(name = "freeTimePerWeek")
    private long freeTimePerWeek;

    @Column(name = "freeTimeUntilDate")
    private Date freeTimeUntilDate;

    public Employee(){
    }

    public Employee(long userId,
                    long freeTimePerWeek,
                    Date freeTimeUntilDate) {
        this.userId = userId;
        this.freeTimePerWeek = freeTimePerWeek;
        this.freeTimeUntilDate = freeTimeUntilDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getFreeTimePerWeek() {
        return freeTimePerWeek;
    }

    public void setFreeTimePerWeek(long freeTimePerWeek) {
        this.freeTimePerWeek = freeTimePerWeek;
    }

    public Date getFreeTimeUntilDate() {
        return freeTimeUntilDate;
    }

    public void setFreeTimeUntilDate(Date freeTimeUntilDate) {
        this.freeTimeUntilDate = freeTimeUntilDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", freeTimePerWeek=" + freeTimePerWeek +
                ", freeTimeUntilDate=" + freeTimeUntilDate +
                '}';
    }
}
