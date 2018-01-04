package clouddev.mall;

import android.app.Application;
import android.util.Log;

import com.joanzapata.iconify.fonts.FontAwesomeModule;

import org.litepal.LitePal;

import clouddev.com.czy.app.appInit;
import clouddev.com.czy.mall.icon.FontEc;
import clouddev.com.czy.network.interceptor.DebugInterceptor;

/**
 * Created by 29737 on 2017/12/21.
 */

public class MallApp extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        LitePal.initialize(getApplicationContext());//初始化数据库
        appInit.init(this)
                .setApiHost("http://127.0.0.1/")
                .setICON(new FontEc())
                .setICON(new FontAwesomeModule())
                .setIntercepter(new DebugInterceptor("index",R.raw.test))
                .setIntercepter(new DebugInterceptor("sign_up",R.raw.test))
                .setIntercepter(new DebugInterceptor("sign_in",R.raw.test))
                .configure();


    }
}
