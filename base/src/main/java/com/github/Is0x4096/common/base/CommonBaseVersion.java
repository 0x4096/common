package com.github.Is0x4096.common.base;

/**
 * 获取当前 jar 包使用的 maven 版本 exp: 1.0.0
 *
 * @author 0x4096.peng@gmail.com
 * @date 2021/7/24
 */
public class CommonBaseVersion {

    private static final String version;

    static {
        Package pkg = CommonBaseVersion.class.getPackage();
        version = pkg != null ? pkg.getImplementationVersion() : null;
    }

    public static String getVersion() {
        return version;
    }

}
