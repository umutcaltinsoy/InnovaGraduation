package com.patika.creditscorems.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@EqualsAndHashCode
@Getter
@Document
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Indexed(unique = true)
    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "credit_score")
    private Integer creditScore;
}
