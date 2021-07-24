package com.github.Is0x4096.common.base.result;

import com.github.Is0x4096.common.base.extend.ToString;
import com.github.Is0x4096.common.base.page.Pagination;
import lombok.*;
import lombok.experimental.Accessors;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一结果包装
 * ResultWrapper<String> resultWrapper = ResultWrapper.<String>builder()
 * .success(true)
 * .data("success")
 * .build();
 *
 * @author 0x4096.peng@gmail.com
 * @date 2021/3/5
 */
@Setter
@Getter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ResultWrapper<T> extends ToString implements Serializable {

    private static final long serialVersionUID = 945314152507157220L;

    /**
     * 本次处理成功与否, 默认为 true
     */
    @Builder.Default
    private boolean success = true;

    /**
     * 本业务系统状态码
     */
    @Nullable
    private String code;

    /**
     * 本业务系统响应信息
     */
    @Nullable
    private String message;

    /**
     * 下游业务系统状态码
     */
    @Nullable
    private String subCode;

    /**
     * 下游业务系统响应信息
     */
    @Nullable
    private String subMessage;

    /**
     * 链路追踪ID
     */
    @Nullable
    private String traceId;

    /**
     * 响应数据
     */
    @Nullable
    private T data;

    /**
     * 分页数据
     */
    @Nullable
    private Pagination page;

    /**
     * 扩展Map
     */
    private Map<String, Object> extensionMap = new HashMap<>();

}
