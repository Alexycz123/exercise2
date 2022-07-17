package com.ycz.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class style extends BaseRowModel implements Serializable {
    /**
     * 日期 YYYY/MM/DD HH:MM:SS
     */
    @ExcelProperty(value = "时间", index = 0)
    @ColumnWidth(12)
    @ApiModelProperty(value = "时间")
    private String dateTime;

    @ExcelProperty(value = "交易时间", index = 1)
    @ColumnWidth(12)
    @ApiModelProperty(value = "交易时间")
    private String dealDatetime;

    @ExcelProperty(value = "个人账户", index = 2)
    @ColumnWidth(15)
    @ApiModelProperty(value = "个人账户")
    private String accountName;

    @ExcelProperty(value = "组名", index = 3)
    @ColumnWidth(15)
    @ApiModelProperty(value = "组名")
    private String groupName;


}
