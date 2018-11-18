package com.uber.rib.root.logged_out;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.uber.rib.core.RibTestBasePlaceholder;
import com.uber.rib.core.InteractorHelper;

import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LoggedOutInteractorTest extends RibTestBasePlaceholder {

  @Mock LoggedOutInteractor.Listener listener;
  @Mock LoggedOutInteractor.LoggedOutPresenter presenter;
  @Mock LoggedOutRouter router;

  private LoggedOutInteractor interactor;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    interactor = TestLoggedOutInteractor.create(listener, presenter);
  }

  @Test
  public void attach_whenViewEmitsName_shouldCallListener() {
    when(presenter.loginName()).thenReturn(Observable.just("fakename"));

    InteractorHelper.attach(interactor, presenter, router, null);
    verify(listener).login(any(String.class));
  }

  @Test
  public void attach_whenViewEmitsEmptyName_shouldNotCallListener() {
    when(presenter.loginName()).thenReturn(Observable.just(""));

    InteractorHelper.attach(interactor, presenter, router, null);
    // This test will fail because the interactor doesn’t have any logic for handling empty strings.
    // You’ll need to fix this as discussed above the code snippet.
    verify(listener, never()).login(any(String.class));
  }

}
