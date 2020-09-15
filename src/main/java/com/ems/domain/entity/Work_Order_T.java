package com.ems.domain.entity;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "T_WORK_ORDER_TB")
public class Work_Order_T {

	@Id @GeneratedValue
	private Long WO_NO;
	private Date WO_YMD;
	private String WO_NM;
	private String EQUIP_CD;
	private String LINE_CD;
	private String GBM_CD;
	private String TYPE_CD;
	private String STATUS_CD;
	private String ComponentBill_ST;
	
}