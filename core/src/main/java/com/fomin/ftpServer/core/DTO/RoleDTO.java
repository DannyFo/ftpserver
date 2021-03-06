package com.fomin.ftpServer.core.DTO;

import com.fomin.ftpServer.core.model.User;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private Long id;
    private String role;
}
