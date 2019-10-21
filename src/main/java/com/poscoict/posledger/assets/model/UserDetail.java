package com.poscoict.posledger.assets.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_detail")
public class UserDetail {

    @Id
    @Column(length=100)
    private String id;
    
    @MapsId
    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
    private User user;
    
    @Column
    private int age;
    
    @Column(nullable = true, length = 200)
    private String address;

    @Column(nullable = true, length = 500)
    private String description;
    
    private Date createDate;
}