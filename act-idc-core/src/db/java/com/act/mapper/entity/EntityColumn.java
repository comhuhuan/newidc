package com.act.mapper.entity;

import javax.persistence.Transient;

/**
 * 数据库表对应的列
 *
 * @author liuzh
 */
public class EntityColumn {
//	private final static String Entity_Version_Property = "entityVersion"; 
    private EntityTable table;
    private String property;
    private String column;
    private String title;
    private Class<?> javaType;
    private String sequenceName;
    private boolean id = false;
    private boolean uuid = false;
    //自动增长列
    private boolean identity = false;
    private String generator;
    private String orderBy;
    //字段最大长度
    private int maxLength;
    //是否必填
    private boolean mandatory;
    private ColumnRef columnRef;
    
    public EntityColumn() {
    }

    public EntityColumn(EntityTable table) {
        this.table = table;
    }

    public EntityTable getTable() {
        return table;
    }

    public void setTable(EntityTable table) {
        this.table = table;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public Class<?> getJavaType() {
        return javaType;
    }

    public void setJavaType(Class<?> javaType) {
        this.javaType = javaType;
    }

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public boolean isId() {
        return id;
    }

    public void setId(boolean id) {
        this.id = id;
    }

    public boolean isUuid() {
        return uuid;
    }

    public void setUuid(boolean uuid) {
        this.uuid = uuid;
    }

    public boolean isIdentity() {
        return identity;
    }

    public void setIdentity(boolean identity) {
        this.identity = identity;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public ColumnRef getColumnRef() {
		return columnRef;
	}

	public void setColumnRef(ColumnRef columnRef) {
		this.columnRef = columnRef;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityColumn that = (EntityColumn) o;

        if (id != that.id) return false;
        if (identity != that.identity) return false;
        if (uuid != that.uuid) return false;
        if (column != null ? !column.equals(that.column) : that.column != null) return false;
        if (generator != null ? !generator.equals(that.generator) : that.generator != null) return false;
        if (javaType != null ? !javaType.equals(that.javaType) : that.javaType != null) return false;
        if (orderBy != null ? !orderBy.equals(that.orderBy) : that.orderBy != null) return false;
        if (property != null ? !property.equals(that.property) : that.property != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (sequenceName != null ? !sequenceName.equals(that.sequenceName) : that.sequenceName != null)
            return false;
        if (mandatory!= that.mandatory) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = property != null ? property.hashCode() : 0;
        result = 31 * result + (column != null ? column.hashCode() : 0);
        result = 31 * result + (javaType != null ? javaType.hashCode() : 0);
        result = 31 * result + (sequenceName != null ? sequenceName.hashCode() : 0);
        result = 31 * result + (id ? 1 : 0);
        result = 31 * result + (uuid ? 1 : 0);
        result = 31 * result + (identity ? 1 : 0);
        result = 31 * result + (generator != null ? generator.hashCode() : 0);
        result = 31 * result + (orderBy != null ? orderBy.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (mandatory? 1 : 0);
        return result;
    }
    
    @Transient
    public boolean isGenerateColumn() {
    	return (this.sequenceName!=null&&this.sequenceName.length()>0)||isIdentity()||isUuid();
    }
    
//    public boolean isEntityVersionColumn(){
//    	return Entity_Version_Property.equals(this.property)&&this.javaType==Integer.class;
//    }
}
