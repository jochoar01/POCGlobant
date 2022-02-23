package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import util.BaseAppium;

import static org.junit.Assert.assertEquals;

;

public class FacebookRegisterPage extends BaseAppium {



    public static final String CREATE_NEW_FACEBOOK_ACCOUNT_BUTTON = "Create new Facebook account";
    public static final String CALENDAR_PICKER = "//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\"]";
    public static final By DENY_BUTTON = By.xpath("//android.widget.Button[@text=\"DENY\"]");
    public static final By NEXT_BUTTON = By.xpath("//android.widget.Button[@text=\"Next\"]");
    public static final By NAME_LABEL = By.xpath("//android.widget.EditText[@text=\"First Name\"]");
    public static final By LAST_NAME_LABEL = By.xpath("//android.widget.EditText[@text=\"Last Name\"]");
    public static final By GENDER_RADIO_BUTON = By.xpath("//android.widget.RadioButton[@text=\"Male\"]");
    public static final By WITH_EMAIL_ADRESS = By.xpath("//android.widget.Button[@text='Sign up with email address']");
    public static final By EMAIL_ADRESS = By.xpath("//android.widget.LinearLayout[@index=\"1\"]");
    public static final By TEXT_TO_VALIDATE = By.xpath("//android.widget.TextView[@text=\"Enter your email address\"]");

    public FacebookRegisterPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    public void go_to_register_page() {

        click(CREATE_NEW_FACEBOOK_ACCOUNT_BUTTON);
        click(NEXT_BUTTON);
        click(DENY_BUTTON);
        click(DENY_BUTTON);
    }

    public void fill_register_form(String nombre, String apellido, String fechaNacimiento) {

        type(NAME_LABEL, nombre);
        type(LAST_NAME_LABEL, apellido);
        click(NEXT_BUTTON);
        datePicker(fechaNacimiento, CALENDAR_PICKER);
        click(NEXT_BUTTON);
        click(GENDER_RADIO_BUTON);
        click(NEXT_BUTTON);
        click(WITH_EMAIL_ADRESS);
        click(EMAIL_ADRESS);
    }

    public void identify_text_in_screen(String text) {


        assertEquals(getText(TEXT_TO_VALIDATE), text);
        close();
    }
}
