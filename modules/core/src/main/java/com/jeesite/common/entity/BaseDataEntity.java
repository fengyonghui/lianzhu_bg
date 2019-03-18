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
        columns = {
            @Column(
                name = "u_version",
                attrName = "uVersion",
                label = "版本控制",
                isUpdate = true,
                comment = "版本控制"
            ) }
)

public class BaseDataEntity<T extends DataEntity<?>> extends DataEntity<T> {

    public BaseDataEntity() {
    }


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


}
