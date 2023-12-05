package com.hli.modules.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName hli_staff
 */
@TableName(value ="hli_staff")
@Data
public class HliStaff implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String empName;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private String daptName;

    /**
     * 
     */
    private String empDegreeName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HliStaff other = (HliStaff) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmpName() == null ? other.getEmpName() == null : this.getEmpName().equals(other.getEmpName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getDaptName() == null ? other.getDaptName() == null : this.getDaptName().equals(other.getDaptName()))
            && (this.getEmpDegreeName() == null ? other.getEmpDegreeName() == null : this.getEmpDegreeName().equals(other.getEmpDegreeName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmpName() == null) ? 0 : getEmpName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getDaptName() == null) ? 0 : getDaptName().hashCode());
        result = prime * result + ((getEmpDegreeName() == null) ? 0 : getEmpDegreeName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", empName=").append(empName);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", daptName=").append(daptName);
        sb.append(", empDegreeName=").append(empDegreeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}