package com.example.apisecurity.controller;

import com.example.apisecurity.service.EncryptOpenService;
import com.example.apisecurity.util.KeyRequest;
import com.example.apisecurity.util.KeyResponse;
import com.example.apisecurity.util.RSAResponse;
import com.example.apisecurity.util.SingleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("open/encrypt")
public class EncryptController {

    @Autowired
    private EncryptOpenService encryptOpenService;

    @RequestMapping(value = "getRSA", method = RequestMethod.POST)
    //@DisabledEncrypt
    public SingleResult<RSAResponse> getRSA() {
        return encryptOpenService.getRSA();
    }

    @RequestMapping(value = "getKey", method = RequestMethod.POST)
    //@DisabledEncrypt
    public SingleResult<KeyResponse> getKey(@Valid @RequestBody KeyRequest request) throws Exception {
        return encryptOpenService.getKey(request);
    }
}