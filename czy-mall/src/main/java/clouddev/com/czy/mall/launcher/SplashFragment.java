package clouddev.com.czy.mall.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;
import clouddev.com.czy.fragment.CoreFragment;
import clouddev.com.czy.mall.R;
import clouddev.com.czy.mall.R2;
import clouddev.com.czy.storage.appPreference;
import clouddev.com.czy.ui.ScrollLauncherTag;
import clouddev.com.czy.util.timer.BaseTimerTask;
import clouddev.com.czy.util.timer.iTimerListener;

/**
 * Created by 29737 on 2018/1/1.
 */

public class SplashFragment extends CoreFragment implements iTimerListener
{
    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView appCompatTextView = null;

    private Timer timer = null;
    private int mCount = 5;

    @OnClick(R2.id.tv_launcher_timer)
    void onClick()
    {
        if(timer != null)
        {
            timer.cancel();
            timer = null;
            checkIsShow();
        }
    }

    private void initTimer()
    {
        timer = new Timer();
        final BaseTimerTask timerTask = new BaseTimerTask(this);
        timer.schedule(timerTask,0,1000);
    }

    @Override
    public Object setLayout()
    {
        return R.layout.splash_fragment;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView)
    {
        initTimer();
    }

    private void checkIsShow()
    {
        if(!appPreference.getAppFlag(ScrollLauncherTag.FIRST_LAUNCHER_APP.name()))
        {
            start(new SplashScrollFragment(),SINGLETASK);
        }
        else
        {
            //TODO:check if user has login
        }
    }

    @Override
    public void onTimer()
    {
       getFVActivity().runOnUiThread(new Runnable() {
           @Override
           public void run()
           {
               if(appCompatTextView != null)
               {
                   appCompatTextView.setText(MessageFormat.format("跳过\n{0}s",mCount));
                   mCount--;
               }
               if(mCount < 0)
               {
                   if(timer != null)
                   {
                       timer.cancel();
                       timer = null;
                       checkIsShow();
                   }
               }
           }
       });
    }
}