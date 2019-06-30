package com.telran.hq.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DBase {
    private String uri;
    private String databaseName;

}
