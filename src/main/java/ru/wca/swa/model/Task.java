package ru.wca.swa.model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Task {

    private int id;

    private String description;

    private String isExecute;

    @Temporal(value = TemporalType.DATE)
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String isExecute() {
        return isExecute;
    }

    public void setExecute(String execute) {
        isExecute = execute;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
