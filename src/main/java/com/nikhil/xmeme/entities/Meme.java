package com.nikhil.xmeme.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Meme {

    @Id
    private String id;

    private String name;

    private String url;

    private String description;

    @JsonIgnore
    private LocalDateTime timeStamp;

}
