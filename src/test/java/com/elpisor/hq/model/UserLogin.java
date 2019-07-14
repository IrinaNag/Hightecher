package com.elpisor.hq.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserLogin {
    String email;
    String password;
}
