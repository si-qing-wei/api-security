package com.example.apisecurity.service;

import com.example.apisecurity.util.KeyRequest;
import com.example.apisecurity.util.KeyResponse;
import com.example.apisecurity.util.RSAResponse;
import com.example.apisecurity.util.SingleResult;

/**
 * API传输加解密相关接口
 */
public interface EncryptOpenService {

    /**
     * 生成RSA公私钥
     * @return
     */
    SingleResult<RSAResponse> getRSA();

    /**
     * 获得加解密用的密钥
     * @param request
     * @return
     */
    SingleResult<KeyResponse> getKey(KeyRequest request) throws Exception;
}