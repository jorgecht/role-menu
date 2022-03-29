package com.ingytal.roles.appmenu.repository.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table (name = "role")
@AllArgsConstructor @NoArgsConstructor @Builder
//@JsonIdentityInfo(
		  //generator = ObjectIdGenerators.PropertyGenerator.class, 
		  //property = "id")
public class RoleEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message = "El rol no debe ser vacio")
    private String name;
	
    private String description;
    
    private String status;
    
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
    private Date create_at;
	
	@JsonIgnoreProperties("role")
	@ManyToMany(mappedBy = "role")
    private List<UserEntity> user;

}
