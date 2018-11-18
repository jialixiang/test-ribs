package com.uber.rib.root.logged_in.off_game;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;

import android.widget.TextView;
import com.jakewharton.rxbinding2.view.RxView;
import com.uber.rib.core.Initializer;
import com.uber.rib.app.R;
import io.reactivex.Observable;

/**
 * Top level view for {@link OffGameBuilder.OffGameScope}.
 */
class OffGameView extends LinearLayout implements OffGameInteractor.OffGamePresenter {

  private Button button;
  private TextView playerOneName;
  private TextView playerTwoName;
  private TextView playerOneScore;
  private TextView playerTwoScore;


  public OffGameView(Context context) {
    this(context, null);
  }

  public OffGameView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public OffGameView(Context context, @Nullable AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Initializer
  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();
    button = (Button) findViewById(R.id.start_game_button);
    playerOneName = (TextView) findViewById(R.id.player_one_name);
    playerTwoName = (TextView) findViewById(R.id.player_two_name);
    playerOneScore = (TextView) findViewById(R.id.player_one_win_count);
    playerTwoScore = (TextView) findViewById(R.id.player_two_win_count);
  }

  @Override
  public Observable<Object> startGameRequest() {
    return RxView.clicks(button);
  }

}
