package mddemo.library.com.dispatcher;

import android.renderscript.Sampler;

import com.squareup.otto.Bus;

import mddemo.library.com.actions.Action;
import mddemo.library.com.stores.Store;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月28日17:41:56
 * Description:
 */
public class Dispatcher {

    private final Bus bus;
    private static Dispatcher instance;

    public static Dispatcher get(Bus bus){
        if (instance==null){
            instance=new Dispatcher(bus);
        }
        return instance;
    }

    Dispatcher(Bus bus){
        this.bus=bus;
    }

    public void register(final  Object cls){
        bus.register(cls);
    }

    public void unregister(final Object cls){
        bus.unregister(cls);
    }

    public void emitChange(Store.StoreChangeEvent o){
        post(o);
    }

    public void dispatch(String type,Object...data){
        if (isEmpty(type)){
            throw new IllegalArgumentException("Type must not be empty");
        }
        if (data.length%2!=0){
            throw new IllegalArgumentException("Data must be a valid list of key,value pairs");
        }

        Action.Builder actionBuilder=Action.type(type);
        int i=0;
        while(i<data.length){
            String key= (String) data[i++];
            Object value = data[i++];
            actionBuilder.bundle(key,value);
        }
    }

    private boolean isEmpty(String type){
        return  type==null || type.isEmpty();
    }

    private void post(final  Object event){
        bus.post(event);
    }
}
