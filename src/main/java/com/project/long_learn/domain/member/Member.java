package com.project.long_learn.domain.member;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@EqualsAndHashCode(of = {"name", "reporting"})
@Getter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ColumnDefault("0")
    private Integer reporting;

    @Builder
    public Member(String name, int reporting) {
        this.name = name;
        this.reporting = reporting;
    }

    public void report() {
        this.reporting++;
    }

}
