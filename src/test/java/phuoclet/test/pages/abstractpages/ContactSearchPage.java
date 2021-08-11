package phuoclet.test.pages.abstractpages;

import phuoclet.core.BasePage;

public abstract class ContactSearchPage extends BasePage {

    public abstract void search(String name);

    public abstract void navigateToSearchResultDetails();

    public abstract String getFirstContact();

    public abstract void select(String name);
}
