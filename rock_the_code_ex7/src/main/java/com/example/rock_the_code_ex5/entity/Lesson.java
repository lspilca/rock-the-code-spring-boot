package com.example.rock_the_code_ex5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "lessons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true, updatable = false)
    private UUID externalId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rider_id", nullable = false, foreignKey = @ForeignKey(name = "fk_lessons_rider"))
    private Rider rider;

    @Column(name = "lesson_date", nullable = false)
    private LocalDate lessonDate;

    @Column(name = "lesson_time", nullable = false)
    private LocalTime lessonTime;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @PrePersist
    void assignExternalId() {
        if (externalId == null) {
            externalId = UUID.randomUUID();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lesson other)) return false;
        return id != null && Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Lesson{id=" + id + ", externalId=" + externalId + ", lessonDate=" + lessonDate
                + ", lessonTime=" + lessonTime + ", duration=" + duration + "}";
    }
}
