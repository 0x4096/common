package com.github.Is0x4096.common.base.pojo;

import com.github.Is0x4096.common.base.extend.ToString;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 0x4096.peng@gmail.com
 * @date 2021/7/24
 */
@Setter
@Getter
public class ReqPageDTO extends ToString implements Serializable {

    private static final long serialVersionUID = -4743016309643940010L;

    /**
     * 当前页
     */
    private int pageNum = 1;

    /**
     * 当前页数据量
     */
    private int pageSize = 10;

}
