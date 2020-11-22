package common;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CommonElements extends ElementHandler{

    @FindBy(css = "#imdbHeader-navDrawerOpen--desktop")
    protected WebElementFacade buttonSideMenu;

    @FindBy(css = "#suggestion-search")
    protected WebElementFacade searchBar;

    @FindBy(css = "a[href='/registration/signin?ref=nv_generic_lgin']")
    protected WebElementFacade linkSignIn;

    @FindBy(css = "label.ipc-icon-button.BoMErbIIt00tb_ZoTOWZv.ipc-icon-button--baseAlt.ipc-icon-button--onBase")
    protected WebElementFacade buttonCloseMenu;





}
