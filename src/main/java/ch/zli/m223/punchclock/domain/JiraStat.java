package ch.zli.m223.punchclock.domain;

import javax.persistence.*;

@Entity
public class JiraStat {
    @Id
    private Long id;

    @Column
    private String jiraNumber;

    @Column
    private String achievement;

    @OneToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJiraNumber() {
        return jiraNumber;
    }

    public void setJiraNumber(String jiraNumber) {
        this.jiraNumber = jiraNumber;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
