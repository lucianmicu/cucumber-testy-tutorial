package org.fasttrackit.workshop.Preferences;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;

/**
 * Created by lucian.micu on 7/4/2015.
 */
public class PreferencesView {

    private WebLocator window = new WebLocator().setId("preferences-win");

    private Button preferencesButton = new Button().setText("Preferences");
    private TextField currentPassword = new TextField().setLabel("Current Password");
    private TextField newPassword = new TextField().setLabel("New Password");
    private TextField repeatPassword = new TextField().setLabel("Repeat Password");
    private Button saveButton = new Button().setText("Save").setContainer(window);
    private Button closeButton = new Button().setText("Close").setContainer(window);


    public static void main(String[] args) {
        PreferencesView preferencesView = new PreferencesView();

        System.out.println(preferencesView.closeButton.getPath());
        System.out.println(preferencesView.saveButton.getPath());
        System.out.println(preferencesView.window.getPath());
    }

    public void open() {
        preferencesButton.click();
        Utils.sleep(1000);
    }

    public void inputCurrent(String validEmail) {
        currentPassword.setValue(validEmail);
    }

    public void inputNewPass(String validEmail) {
        newPassword.setValue(validEmail);
    }

    public void repeatPass(String s) {
        repeatPassword.setValue(s);
    }


    public void doSave() {
        saveButton.click();
    }
}