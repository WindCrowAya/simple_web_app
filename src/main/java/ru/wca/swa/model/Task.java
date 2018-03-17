package ru.wca.swa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task_list")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "execution_status", nullable = false)
    private String executionStatus;

    @Column(name = "importance_status", nullable = false)
    private String importanceStatus;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "last_update_date")
    private Date lastUpdateDate = new Date(); //или здесь нужна нестатическая инициализация? проверить на наличие ошибок


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
