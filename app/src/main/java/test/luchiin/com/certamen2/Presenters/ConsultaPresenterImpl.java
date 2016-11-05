package test.luchiin.com.certamen2.Presenters;

import test.luchiin.com.certamen2.Interactors.ConsultaInteractorImpl;
import test.luchiin.com.certamen2.Interfaces.ConsultaInteractor;
import test.luchiin.com.certamen2.Interfaces.ConsultaPresenter;
import test.luchiin.com.certamen2.Interfaces.ConsultaView;

/**
 * Created by Luchiin on 04-11-2016.
 */

public class ConsultaPresenterImpl implements ConsultaPresenter {
    private ConsultaView view;
    private ConsultaInteractor interac;

    public ConsultaPresenterImpl(ConsultaView view) {
        this.view = view;
        interac = new ConsultaInteractorImpl();
    }


    @Override
    public void buscarUser(String user) {
        interac.BuscarU(user);
    }
}
