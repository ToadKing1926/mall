package clouddev.com.czy.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by 29737 on 2017/12/21.
 */

public class appConfig
{
    private static final HashMap<String,Object> APP_CONFIGRATION = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS=new ArrayList<>();

    private appConfig()
    {
        APP_CONFIGRATION.put(ConfigType.CONFIG_READY.name(),false);
    }

    private static class Holder
    {
       private static final appConfig INSTANCE = new appConfig();
    }

    public final void configure()
    {
        initIcons();
        APP_CONFIGRATION.put(ConfigType.CONFIG_READY.name(),true);
    }

    public static appConfig getInstance()
    {
        return Holder.INSTANCE;
    }

    public final appConfig setApiHost(String host)
    {
        APP_CONFIGRATION.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    public final appConfig setICON(IconFontDescriptor descriptor)
    {
        ICONS.add(descriptor);
        return this;
    }

    private void checkConfiguration()
    {
        final boolean isReady=(boolean)APP_CONFIGRATION.get(ConfigType.CONFIG_READY.name());
        if(!isReady)
        {
            throw new RuntimeException("配置尚未完成，请检查！");
        }
    }

    private void initIcons()
    {
        if(ICONS.size()>0)
        {
            final Iconify.IconifyInitializer initializer=Iconify.with(ICONS.get(0));
            for(int i=1;i<ICONS.size();i++)
            {
                initializer.with(ICONS.get(i));
            }
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key)
    {
        checkConfiguration();
        return (T)APP_CONFIGRATION.get(key.name());
    }

    final HashMap<String,Object> getAppConfigration()
    {
        return APP_CONFIGRATION;
    }
}