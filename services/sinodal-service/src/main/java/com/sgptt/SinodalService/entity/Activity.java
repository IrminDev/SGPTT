package com.sgptt.SinodalService.entity;

import com.sgptt.SinodalService.model.ActivityName;
import jakarta.persistence.*;

import java.util.Date;

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

    @Enumerated(EnumType.ORDINAL)
    private ActivityName activity;

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

    public ActivityName getActivity() {
        return activity;
    }

    public void setActivity(ActivityName activity) {
        this.activity = activity;
    }
}