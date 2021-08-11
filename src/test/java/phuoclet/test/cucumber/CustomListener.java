package phuoclet.test.cucumber;


import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestStep;
import io.cucumber.plugin.event.TestStepStarted;


public class CustomListener implements EventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestStepStarted.class, this::handleTestStepStarted);
    }


    private void handleTestStepStarted(TestStepStarted event) {
        TestStep step = event.getTestStep();
        if (step instanceof PickleStepTestStep)
            System.out.println("TESTSTEP STARTED: " + ((PickleStepTestStep) step).getStep().getText());
    }
}
