package com.uber.rib.root.logged_in.off_game;

import android.support.annotation.Nullable;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;
import io.reactivex.Observable;
import com.uber.rib.core.Presenter;
import com.uber.rib.core.Router;

import io.reactivex.functions.Consumer;
import javax.inject.Inject;

/**
 * Coordinates Business Logic for {@link OffGameScope}.
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class OffGameInteractor
    extends Interactor<OffGameInteractor.OffGamePresenter, OffGameRouter> {

  @Inject Listener listener;
  @Inject OffGamePresenter presenter;

  @Override
  protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
    super.didBecomeActive(savedInstanceState);

    presenter
      .startGameRequest()
      .subscribe(new Consumer<Object>() {
        @Override
        public void accept(Object object) throws Exception {
          listener.onStartGame();
        }
      });
  }

  public interface Listener {
    void onStartGame();
  }

  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface OffGamePresenter {
    Observable<Object> startGameRequest();
  }
}
