package mddemo.library.com.model;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月28日16:56:39
 * Description: 定义一个磨具类
 */
public class Todo implements Cloneable, Comparable<Todo> {
    long id;
    boolean complete;
    String text;

    public Todo(long id, String text) {
        this.id = id;
        this.text = text;
        this.complete = false;
    }

    public Todo(long id, String text, boolean complete) {
        this.id = id;
        this.text = text;
        this.complete = complete;
    }

    public long getId() {
        return id;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getText() {
        return text;
    }

    @Override
    public Todo clone()  {
        return new Todo(id, text, complete);
    }

    @Override
    public int compareTo(Todo todo) {
        if (id == todo.getId()) {
            return 0;
        } else if (id < todo.getId()) {
            return -1;
        } else {
            return 1;
        }
    }
}
