package com.example.apisecurity.controller;

import com.example.apisecurity.model.TestRequest;
import com.example.apisecurity.service.EncryptOpenService;
import com.example.apisecurity.util.KeyRequest;
import com.example.apisecurity.util.KeyResponse;
import com.example.apisecurity.util.RSAResponse;
import com.example.apisecurity.util.SingleResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public SingleResult<String> hello(@Valid @ApiParam(required = true) @RequestBody TestRequest request, BindingResult result){
        validate(result);
        return SingleResult.buildSuccess(null);
    }

    protected void validate(BindingResult result){
        if(result.hasFieldErrors()){
            List<FieldError> errorList = result.getFieldErrors();
            errorList.stream().forEach(item -> Assert.isTrue(false,item.getDefaultMessage()));
        }
    }
}