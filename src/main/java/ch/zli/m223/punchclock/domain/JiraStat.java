package ch.zli.m223.punchclock.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JiraStat {
    @Id
    private Long id;

    @Column
    private String jiraNumber;

    @Column
    private String achievement;

}
