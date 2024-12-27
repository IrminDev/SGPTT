package com.sgpttt.UtilsService.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long activityId;

    @Temporal(TemporalType.DATE)
    private Date openDate;

    @Temporal(TemporalType.DATE)
    private Date closeDate;

    @Column(name = "activity", length = 255, nullable = false)
    private String activity;

    // Getters and Setters

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
