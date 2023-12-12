package com.example.cafekiosk.spring.api.service.mail;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.example.cafekiosk.spring.client.mail.MailSendClient;
import com.example.cafekiosk.spring.domain.history.mail.MailSendHistory;
import com.example.cafekiosk.spring.domain.history.mail.MailSendHistoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MailServiceTest {
    @Mock
//    @Spy
    private MailSendClient mailSendClient;

    @Mock
    private MailSendHistoryRepository mailSendHistoryRepository;

    @InjectMocks
    private MailService mailService;

    @DisplayName("메일 전송 테스트")
    @Test
    void sendMail(){
        //given
//        when(mailSendClient.sendEmail(any(String.class), any(String.class), any(String.class), any(String.class)))
//            .thenReturn(true);
        given(mailSendClient.sendEmail(any(String.class), any(String.class), any(String.class), any(String.class)))
            .willReturn(true);
//        doReturn(true)
//            .when(mailSendClient)
//            .sendEmail(anyString(), anyString(), anyString(), anyString());
        //when
        boolean result = mailService.sendMail("", "", "", "");

        //then
        assertThat(result).isTrue();
        Mockito.verify(mailSendHistoryRepository, times(1)).save(any(MailSendHistory.class));
    }
}