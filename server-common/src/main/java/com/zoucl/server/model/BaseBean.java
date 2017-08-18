package com.zoucl.server.model;

import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by vicqiang on 2017/5/27 0027.
 */
@Data
public class BaseBean implements Serializable{
    private String id;

    private String dateCreated;

    private String createId;

    private String createIp;

    private String dateUpdated;

    private String updateId;

    private String updateIp;

    private Integer version;

    private String delFlag;


    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;
}
