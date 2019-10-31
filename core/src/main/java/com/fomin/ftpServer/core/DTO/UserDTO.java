package com.fomin.ftpServer.core.DTO;

import com.fomin.ftpServer.core.model.User;
import com.fomin.ftpServer.core.model.UserRole;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private Set<RoleDTO> roles;
}
