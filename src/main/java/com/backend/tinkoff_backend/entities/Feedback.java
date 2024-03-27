package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SprFeedback")
public class Feedback {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name ="comment", nullable = false)
    private String comment;

    @JoinColumn(name = "sprDemandEmployeeId",
            referencedColumnName = "id",
            nullable = false)
    private long demandEmployeeId;

    @Column(name = "reviewerName", nullable = false)
    private String reviewerName;

    public Feedback() {
    }

    public Feedback(int rating,
                    String comment,
                    long demandEmployeeId,
                    String reviewerName) {
        this.rating = rating;
        this.comment = comment;
        this.demandEmployeeId = demandEmployeeId;
        this.reviewerName = reviewerName;
    }


    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getDemandEmployeeId() {
        return demandEmployeeId;
    }

    public void setDemandEmployeeId(long demandEmployeeId) {
        this.demandEmployeeId = demandEmployeeId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", demandEmployeeId=" + demandEmployeeId +
                ", reviewerName='" + reviewerName + '\'' +
                '}';
    }
}
