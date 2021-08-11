package phuoclet.test;


import phuoclet.core.driver.DriverModule;
import phuoclet.test.pages.abstractpages.ContactDetailPage;
import phuoclet.test.pages.abstractpages.ContactSearchPage;
import phuoclet.test.pages.android.AndroidContactDetailPage;
import phuoclet.test.pages.android.AndroidContactSearchPage;
import phuoclet.test.pages.ios.IosContactDetailPage;
import phuoclet.test.pages.ios.IosContactSearchPage;

public class PageModule extends DriverModule {

    @Override
    protected void configure() {
        String platform = getPlatform();
        if (platform.equalsIgnoreCase("android")) {
            bind(ContactSearchPage.class).to(AndroidContactSearchPage.class);
            bind(ContactDetailPage.class).to(AndroidContactDetailPage.class);
        } else if (platform.equalsIgnoreCase("ios")) {
            bind(ContactSearchPage.class).to(IosContactSearchPage.class);
            bind(ContactDetailPage.class).to(IosContactDetailPage.class);
        }
    }


}
