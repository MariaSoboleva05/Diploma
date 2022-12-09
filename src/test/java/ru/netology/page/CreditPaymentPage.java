package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreditPaymentPage {

    private SelenideElement cardNumber = $("[placeholder=\"0000 0000 0000 0000\"]");
    private SelenideElement month = $("[placeholder=\"08\"]");
    private SelenideElement year = $("[placeholder=\"22\"]");
    private SelenideElement owner = $x("//*[text()='Владелец']/following-sibling::span/input");
    private SelenideElement cvv = $("[placeholder=\"999\"]");
    private SelenideElement continueButton = $x("//span[text()=\"Продолжить\"]");
    private SelenideElement cardNumberError = $x("//*[text()='Номер карты']/following-sibling::span[2]");
    private SelenideElement monthError = $x("//*[text()='Месяц']/following-sibling::span[2]");
    private SelenideElement yearError = $x("//*[text()='Год']/following-sibling::span[2]");
    private SelenideElement ownerError = $x("//*[text()='Владелец']/following-sibling::span[2]");
    private SelenideElement cvvError= $x("//*[text()='CVC/CVV']/following-sibling::span[2]");
}
