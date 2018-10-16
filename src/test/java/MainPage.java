public class MainPage {

    String youPersInfoTitleXpass = "//h3[text()=\'Your personal information\']";

    String iconHomeXpass = "//i[@class = 'icon-home']";
    String iconHomeCss = ".icon-home";

    String radioButtonMrXpass = "//input[@id='id_gender1']";
    String radioButtonMrCss = "#id_gender1";

    String firstNameLabelXpass = "//label[@for='customer_firstname']";
    String firstNameLabelCss = "label[for='customer_firstname']";

    String firstNameFormXpass = "//input[@id='customer_firstname']";
    String firstNameFormCss = "#customer_firstname";

    String dateOfBith14Xpass = "//select[@id='days']/option[@value = '14']";
    String dateOfBith14Css = "#days>option[value = '14']";

    String signUpNewsLetterLabelXpass = "//label[@for='newsletter']";
    String signUpNewsLetterLabelCss = "label[for='newsletter']";

    String signUoNewsLetterCheckBoxXpass = "//input[@id='newsletter']";
    String signUoNewsLetterCheckBoxCss = "/#newsletter";

    String inlineIhfosXpass = "//span[contains (text(),\"Street address, P.O.\")]";

    String stateList52Xpass = "//select[@id = 'id_state']/option[@value='52']";
    String stateList52Css = "#id_state>option[value='52']";

    String submitButtonXpass = "//button[@id = 'submitAccount']";
    String submitButtonCss = "#submitAccount";

    String InfoFooterLabelXpass = "//section[@id = 'block_various_links_footer']/h4";
    String InfoFooterLabelCss = "#block_various_links_footer>h4";

    String contactUsLinkXpass = "//ul[@class='toggle-footer']/li[5]/a[@title='Contact us']";
    String contactUsLinkCss = "ul a[title='Contact us']";

    String faceboohLinkXpass = "//a[contains(@href,\"525066904174158\")]";
    String faceboohLinkCss = "a[href*='525066904174158']";

    String supportMailLinkXpass = "//a[contains(@href,\"%6b.%63%6f%6d\")]";
    String supportMailLinkCss = "a[href*='%6b.%63%6f%6d']";

}
