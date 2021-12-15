package com.example.shortening.urls.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "SHOT_URLS")
@SequenceGenerator(
        name = "SHOT_URLS_GENERATOR",
        sequenceName = "SHOT_URLS_SEQ",
        initialValue = 1000000,
        allocationSize = 1
)
public class ShortUrls {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHOT_URLS_GENERATOR")
    private Long uid;

    @Column(length = 255, nullable = false)
    private String orgUrl;

    @ColumnDefault("1")
    private Integer callCount;

    @Builder
    public ShortUrls(Long uid, String orgUrl, Integer callCount){
        this.uid = uid;
        this.orgUrl = orgUrl;
        this.callCount = callCount;
    }
}
