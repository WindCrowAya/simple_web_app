package ru.wca.swa.model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Task {

    private int id;

    private String description;

    private String executionStatus;

    private String importanceStatus;

    @Temporal(value = TemporalType.DATE)
    private Date lastUpdateDate;


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

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    public String getImportanceStatus() {
        return importanceStatus;
    }

    public void setImportanceStatus(String importanceStatus) {
        this.importanceStatus = importanceStatus;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
