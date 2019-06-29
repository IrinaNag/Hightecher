package com.elpisor.hq.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Collection {
    public DBase database;
    public String collectionName;
}
