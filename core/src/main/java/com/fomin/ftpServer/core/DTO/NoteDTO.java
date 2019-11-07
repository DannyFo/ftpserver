package com.fomin.ftpServer.core.DTO;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {
    private Long id;
    private String text;
    private String date;
}
