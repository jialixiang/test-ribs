package com.uber.rib.root.logged_in;

import android.support.annotation.Nullable;

import android.view.ViewGroup;
import com.uber.rib.core.Router;
import com.uber.rib.root.logged_in.off_game.OffGameBuilder;
import com.uber.rib.root.logged_in.off_game.OffGameRouter;

/**
 * Adds and removes children of {@link LoggedInBuilder.LoggedInScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
public class LoggedInRouter
    extends Router<LoggedInInteractor, LoggedInBuilder.Component> {

  private final ViewGroup parentView;
  private final OffGameBuilder offGameBuilder;
  @Nullable private OffGameRouter offGameRouter;

  public LoggedInRouter(
      LoggedInInteractor interactor,
      LoggedInBuilder.Component component,
      ViewGroup parentView,
      OffGameBuilder offGameBuilder) {
    super(interactor, component);
    this.parentView = parentView;
    this.offGameBuilder = offGameBuilder;
  }

  @Override
  protected void willDetach() {
    super.willDetach();
    detachOffGame();
  }

  void attachOffGame() {
    offGameRouter = offGameBuilder.build(parentView);
    attachChild(offGameRouter);
    parentView.addView(offGameRouter.getView());
  }

  void detachOffGame() {
    if (offGameRouter != null) {
      detachChild(offGameRouter);
      parentView.removeView(offGameRouter.getView());
      offGameRouter = null;
    }
  }

}
