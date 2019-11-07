package com.fomin.ftpServer.core.DTO;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteListDTO {
    private Long id;
    private String path;
    private Set<NoteDTO> notes;
}
