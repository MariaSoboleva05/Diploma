package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class MySQLTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
       // Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Покупка тура по карте, для которой задан статус APPROVED")
    void successfulPaymentWithApprovedCard() {
        var homePage = new HomePage();
        var cardPaymentPage = homePage.cardPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getValidDataWithApproveCardNumber1();
        cardPaymentPage.fillCardInfo(cardInfo);
        cardPaymentPage.successfulPaymentNotification();
        Assertions.assertEquals("APPROVED", SQLHelper.getCardPaymentStatus());
    }

    @Test
    @DisplayName("Покупка тура по карте, для которой задан статус DECLINED")
    void unsuccessfulPaymentWithDeclinedCard() {
        var homePage = new HomePage();
        var cardPaymentPage = homePage.cardPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getValidDataWithDeclinedCardNumber();
        cardPaymentPage.fillCardInfo(cardInfo);
        cardPaymentPage.unsuccessfulPaymentNotification();
        Assertions.assertEquals("DECLINED", SQLHelper.getCardPaymentStatus());
    }

    @Test
    @DisplayName("Покупка тура по карте, которой нет в базе")
    void unsuccessfulPaymentWithRandomCard() {
        var homePage = new HomePage();
        var cardPaymentPage = homePage.cardPayment();
        DataHelper.CardInfo cardInfo = DataHelper.getDataWithRandomCardNumber();
        cardPaymentPage.fillCardInfo(cardInfo);
        cardPaymentPage.unsuccessfulPaymentNotification();
        Assertions.assertNull(SQLHelper.getCardPaymentStatus());
    }
}
