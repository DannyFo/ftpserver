package com.fomin.ftpServer.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Getter
@Entity
@Table(name = "notelist")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"path"})
public class NoteList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    @OneToMany(mappedBy = "notelist", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Note> notes;

}
