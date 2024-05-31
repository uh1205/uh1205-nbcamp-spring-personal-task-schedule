package com.sparta.schedule.entity;

import com.sparta.schedule.dto.schedule.ScheduleRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "schedule")
    private final List<Comment> comments = new ArrayList<>();

    public Schedule(ScheduleRequest request, User user) {
        this.title = request.getTitle();
        this.content = request.getContent();
        this.user = user;
    }

    public void update(ScheduleRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}
