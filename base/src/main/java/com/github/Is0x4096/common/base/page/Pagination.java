package com.github.Is0x4096.common.base.page;

import com.github.Is0x4096.common.base.extend.ToString;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 0x4096.peng@gmail.com
 * @date 2021/4/8
 */
@Setter
@Getter
@Builder
@Accessors(chain = true)
public class Pagination extends ToString implements Serializable {

    private static final long serialVersionUID = -7062171843681053758L;

    /**
     * 当前页
     */
    private int pageNum = 1;

    /**
     * 当前页数据量
     */
    private int pageSize = 10;

    /**
     * 总数据量
     */
    private long total;

    public Pagination() {
    }

    public Pagination(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Pagination(int pageNum, int pageSize, long total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
    }

}
