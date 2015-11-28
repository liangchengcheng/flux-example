package mddemo.library.com.stores;

import mddemo.library.com.actions.Action;
import mddemo.library.com.dispatcher.Dispatcher;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月28日17:51:41
 * Description:
 */
public abstract class Store {

    final Dispatcher dispatcher;

    protected Store(Dispatcher dispatcher){
        this.dispatcher=dispatcher;
    }

    void emitStoreChange() {
        dispatcher.emitChange(changeEvent());
    }

    abstract StoreChangeEvent changeEvent();

    public abstract void onAction(Action action);

    public interface StoreChangeEvent {}
}
