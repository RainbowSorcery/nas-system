package com.lyra.nas.execption;

import com.lyra.nas.common.ResponseStatusEnums;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.common
 * @className: LyraException
 * @author: lyra
 * @description: 统一异常处理
 * @date: 2024-01-12 19:31
 * @version: 1.0
 */
public class LyraException extends RuntimeException {
    private ResponseStatusEnums resultCode;

    public LyraException(ResponseStatusEnums resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public ResponseStatusEnums getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResponseStatusEnums resultCode) {
        this.resultCode = resultCode;
    }
}
