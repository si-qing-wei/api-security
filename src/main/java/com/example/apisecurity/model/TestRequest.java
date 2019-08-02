package com.example.apisecurity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "测试对象", description = "测试对象")
public class TestRequest{

    @ApiModelProperty(value = "主键", required = true)
    @NotNull(message = "id不能为空")
    private Integer id;

    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "name不能为空")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}