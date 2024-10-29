package com.sandbox.hyunwoo.email.controller;


import com.sandbox.hyunwoo.email.dto.RequestAuthEmail;
import com.sandbox.hyunwoo.email.dto.RequestEmail;
import com.sandbox.hyunwoo.email.service.EmailSendService;
import com.sandbox.hyunwoo.email.service.EmailVerificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailSendService emailSendService;
    private final EmailVerificationService emailVerificationService;

    @PostMapping
    public ResponseEntity<?> sendCodeToEmail(@Validated @RequestBody RequestEmail requestEmail, BindingResult bindingResult) {
        log.info("userEmail: {}", requestEmail);
        return emailSendService.handleEmailSend(requestEmail, bindingResult);
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> authCodeVerification(@Validated @RequestBody RequestAuthEmail requestAuthEmail, BindingResult bindingResult) {
        log.info("입력받은 사용자 Email, AuthCode: {}", requestAuthEmail);
        return emailVerificationService.handleAuthCodeVerification(requestAuthEmail, bindingResult);
    }
}