package com.cignex.security.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "User Model description")
public class User {

	private Integer id;
	@Size(max = 10, min = 5, message = "name must be 5 to 10 character")
	@ApiModelProperty(notes = "name must be 5 to 10 character")
	private String name;
	@Past
	@ApiModelProperty(notes = "date not in future")
	private Date birthdate;
}
