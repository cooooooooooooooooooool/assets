package com.poscoict.posledger.assets.model.vo;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class UserVo extends ResourceSupport {

	private String userId;
    
    private String name;
    
    private String password;
    
    private Date createDate;
}