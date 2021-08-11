package phuoclet.core.driver;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import phuoclet.core.capability.*;

public class DriverModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DriverManager.class).annotatedWith(Names.named("android")).to(AndroidDriverManager.class).in(Scopes.SINGLETON);
        bind(DriverManager.class).annotatedWith(Names.named("ios")).to(iOSDriverManager.class).in(Scopes.SINGLETON);
        bind(DriverManager.class).toProvider(DriverManagerProvider.class).in(Scopes.SINGLETON);

        // bind for capability
        bind(Capability.class).annotatedWith(Names.named("cli")).to(CommandLineCapability.class);
        bind(Capability.class).annotatedWith(Names.named("properties")).to(PropertiesFileCapability.class);
        bind(String.class).annotatedWith(Names.named("platform")).toInstance(getPlatform());

        // bind service
        bind(Service.class).to(CapabilityService.class).in(Scopes.SINGLETON);
    }

    protected String getPlatform() {
        // get platform tu command line va file properties
        String platform = System.getProperty("mobile.platform");
        return platform;
    }
}
