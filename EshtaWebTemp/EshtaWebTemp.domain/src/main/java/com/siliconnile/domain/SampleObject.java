package com.siliconnile.domain;

import com.pearlox.framework.domain.BasicObject;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: Andrew
 * Date: 6/18/13
 */
@Entity
@Table(name = "sample", schema = "public")
public class SampleObject extends BasicObject {

}
