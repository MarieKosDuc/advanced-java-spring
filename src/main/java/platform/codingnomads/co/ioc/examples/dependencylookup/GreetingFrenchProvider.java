package platform.codingnomads.co.ioc.examples.dependencylookup;

public class GreetingFrenchProvider implements GreetingProvider {
    @Override
    public String getGreeting() {
        return "Bonjour bonjour !";
    }
}
