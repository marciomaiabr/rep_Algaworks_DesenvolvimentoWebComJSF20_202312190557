package pkgs.als.teste01;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

//@javax.faces.bean.ManagedBean
public class TesteAL02 implements ActionListener {

	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		System.out.println("TesteAL02.processAction()[event.getComponent().getId()="+event.getComponent().getId()+"]");
	}

}
