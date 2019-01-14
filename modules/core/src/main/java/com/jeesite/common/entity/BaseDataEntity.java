package com.jeesite.common.entity;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.shiro.cas.CasOutHandler;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;

import java.util.Date;

@Table(
//        extWhereKeys="",
        columns = {@Column(
                name = "u_version",
                attrName = "uVersion",
                label = "版本控制",
                isUpdate = true,
                comment = "版本控制"
        ) ,@Column(
                name = "create_id",
                attrName = "createBy",
                label = "创建者",
                isUpdate = false,
                isQuery=false
        ),@Column(
                name = "create_time",
                attrName = "createDate",
                label = "创建时间",
                isUpdate = false,
                isQuery = false
        ), @Column(
                name = "update_id",
                attrName = "updateBy",
                label = "更新者",
                isUpdate = true,
                isQuery=false
        ) , @Column(
                name = "update_time",
                attrName = "updateDate",
                label = "更新时间",
                isUpdate = true,
                isQuery = false
        ) }
)

public class BaseDataEntity<T extends DataEntity<?>> extends DataEntity<T> {

    public BaseDataEntity() {
    }

    private String createBy;

    public BaseDataEntity(String id) {
        super(id);
    }

    protected Integer uVersion;


    public void preDataInsert() {
        super.preInsert();
        if (super.createDate == null) {
          this.uVersion=1;
        }

    }

    public void preDataUpdate() {
       super.preUpdate();
        this.uVersion = uVersion==null?1: (uVersion+1)%127;
    }


    public Integer getuVersion() {
        return uVersion;
    }

    public void setuVersion(Integer uVersion) {
        this.uVersion = uVersion;
    }

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
