package com.example.apisecurity;

import com.example.apisecurity.service.EncryptOpenService;
import com.example.apisecurity.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiSecurityApplicationTests {
    @Autowired
    private EncryptOpenService encryptOpenService;

    @Test
    public void contextLoads() throws Exception {
        Map<String, String> keyMap = RSAUtils.createKeys(1024);
        String publicKey = keyMap.get("publicKey");
        String privateKey = keyMap.get("privateKey");
        System.out.println("publicKey: " + publicKey);
        System.out.println("privateKey: " + privateKey);
        SingleResult<RSAResponse> result = encryptOpenService.getRSA();
        String serverPublicKey = result.getData().getServerPublicKey();
        System.out.println("serverPublicKey: " + serverPublicKey);

        String publicEncrypt = RSAUtils.publicEncrypt(publicKey, RSAUtils.getPublicKey(serverPublicKey));

        KeyRequest keyRequest = new KeyRequest();
        keyRequest.setClientEncryptPublicKey(publicEncrypt);
        SingleResult<KeyResponse> keyResponseSingleResult = encryptOpenService.getKey(keyRequest);
        String decryptKey = keyResponseSingleResult.getData().getKey();
        System.out.println("decryptKey: " + decryptKey);
        String key = RSAUtils.privateDecrypt(decryptKey, RSAUtils.getPrivateKey(privateKey));
        System.out.println("key: " + key);
    }

}
