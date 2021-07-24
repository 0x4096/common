package com.github.Is0x4096.common.base.enums;

import com.github.Is0x4096.common.base.interf.IEnum;
import lombok.AllArgsConstructor;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * 状态枚举
 *
 * @author 0x4096.peng@gmail.com
 * @date 2021/3/13
 */
@AllArgsConstructor
public enum StatusEnum implements IEnum<StatusEnum> {

    FAILURE("0", "失败"),
    SUCCESS("200", "成功"),
    MOVED_PERMANENTLY("301", "重定向"),
    NOT_MODIFIED("304", "未修改"),
    NOT_MODIFIED_SAVE("304", "已存在"),
    BAD_REQUEST("400", "请求语法错误"),
    UNAUTHORIZED("401", "无权访问"),
    FORBIDDEN("403", "拒绝服务"),
    NOT_FOUND("404", "操作资源不存在"),
    REQUEST_TIMEOUT("408", "请求超时"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),

    ;

    @NotNull
    private final String code;

    @NotNull
    private final String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }


    @Nullable
    @Override
    public StatusEnum parseByCode(String code) {
        if (Objects.isNull(code)) {
            return null;
        }

        for (StatusEnum statusEnum : values()) {
            if (code.equalsIgnoreCase(statusEnum.code)) {
                return statusEnum;
            }
        }

        return null;
    }

}
