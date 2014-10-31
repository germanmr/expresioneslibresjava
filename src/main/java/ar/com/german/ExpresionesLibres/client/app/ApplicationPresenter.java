package ar.com.german.ExpresionesLibres.client.app;

/**
 * Copyright 2012 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import javax.inject.Inject;

import ar.com.german.ExpresionesLibres.client.place.NameTokens;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {
	public interface MyView extends View {

		MenuBar getMenuBar();
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetMainContent = new Type<RevealContentHandler<?>>();

	@ProxyStandard
	@NameToken(NameTokens.inicio)
	public interface MyProxy extends Proxy<ApplicationPresenter> {
	}

	final private PlaceManager placeManager;

	@Inject
	ApplicationPresenter(EventBus eventBus, MyView view, MyProxy proxy, final PlaceManager placeManager) {
		super(eventBus, view, proxy, RevealType.Root);
		this.placeManager = placeManager;
	}

	@Override
	protected void onBind() {

		MenuItem generadorReglas = new MenuItem("Generador de Reglas", false, new Command() {

			public void execute() {
				PlaceRequest request = new PlaceRequest.Builder().nameToken(NameTokens.generadorDeReglas).build();
				placeManager.revealPlace(request);
			}
		});

		getView().getMenuBar().addItem(generadorReglas);

		MenuItem probarReglas = new MenuItem("Probar Reglas", false, new Command() {
			public void execute() {
				PlaceRequest request = new PlaceRequest.Builder().nameToken(NameTokens.probador).build();
				placeManager.revealPlace(request);
			}
		});

		getView().getMenuBar().addItem(probarReglas);

		MenuItem archivos = new MenuItem("HTML 5 File API", false, new Command() {
			public void execute() {
				PlaceRequest request = new PlaceRequest.Builder().nameToken(NameTokens.filesystem).build();
				placeManager.revealPlace(request);
			}
		});

		getView().getMenuBar().addItem(archivos);

		super.onBind();

	}
}