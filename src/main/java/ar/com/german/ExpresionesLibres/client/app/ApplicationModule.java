package ar.com.german.ExpresionesLibres.client.app;

import ar.com.german.ExpresionesLibres.client.app.filesystem.ArchivosPresenter;
import ar.com.german.ExpresionesLibres.client.app.filesystem.ArchivosView;
import ar.com.german.ExpresionesLibres.client.app.generadordereglas.GeneradorDeReglasPresenter;
import ar.com.german.ExpresionesLibres.client.app.generadordereglas.GeneradorDeReglasView;
import ar.com.german.ExpresionesLibres.client.app.probarreglas.ProbarReglasPresenter;
import ar.com.german.ExpresionesLibres.client.app.probarreglas.ProbarReglasView;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
	@Override
	protected void configure() {

		bindPresenter(GeneradorDeReglasPresenter.class, GeneradorDeReglasPresenter.MyView.class, GeneradorDeReglasView.class,
				GeneradorDeReglasPresenter.MyProxy.class);
		bindPresenter(ProbarReglasPresenter.class, ProbarReglasPresenter.MyView.class, ProbarReglasView.class,
				ProbarReglasPresenter.MyProxy.class);

		bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
				ApplicationPresenter.MyProxy.class);

		bindPresenter(ArchivosPresenter.class, ArchivosPresenter.MyView.class, ArchivosView.class, ArchivosPresenter.MyProxy.class);

	}
}