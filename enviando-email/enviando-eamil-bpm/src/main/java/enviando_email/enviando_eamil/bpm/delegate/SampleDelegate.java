package enviando_email.enviando_eamil.bpm.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named
@Dependent
public class SampleDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("########################################################################");
        System.out.println("******  ATENCAO !!!! FALTA IMPLEMENTACAO DESSE DELEGATE !!!");
        System.out.println("########################################################################");

    }
}
