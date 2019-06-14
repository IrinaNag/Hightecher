package com.telran.hq.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DB {
    private String uri;
    private String databaseName;

}
