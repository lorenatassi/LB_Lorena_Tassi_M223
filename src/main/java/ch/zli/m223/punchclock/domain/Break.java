package ch.zli.m223.punchclock.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Break {
    @Id
    private Long id;

    @Column
    private Long hours;

    @ManyToOne(mappedBy = "break")
    private Entry entry;

}
