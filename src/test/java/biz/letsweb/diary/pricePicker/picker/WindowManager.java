package biz.letsweb.diary.pricePicker.picker;

/**
 * Created by toks on 14.02.17.
 */
public class WindowManager {
        private boolean resizable;
        private boolean closable;
        private int defaultWidth;
        private int defaultHeight;

    public WindowManager() {
    }

    public boolean isResizable() {
        return resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    public boolean isClosable() {
        return closable;
    }

    public void setClosable(boolean closable) {
        this.closable = closable;
    }

    public int getDefaultWidth() {
        return defaultWidth;
    }

    public void setDefaultWidth(int defaultWidth) {
        this.defaultWidth = defaultWidth;
    }

    public int getDefaultHeight() {
        return defaultHeight;
    }

    public void setDefaultHeight(int defaultHeight) {
        this.defaultHeight = defaultHeight;
    }

    @Override
    public String toString() {
        return "WindowManager{" +
                "resizable=" + resizable +
                ", closable=" + closable +
                ", defaultWidth=" + defaultWidth +
                ", defaultHeight=" + defaultHeight +
                '}';
    }
}
