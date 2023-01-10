package com.uniyaz.common;

import com.uniyaz.common.domain.BaseEntity;
import org.hibernate.Criteria;

import java.io.Serializable;

public abstract class BaseCriteriaFilterDto implements Serializable {
    public abstract void  addFilter(Criteria criteria);
}
