package bank.management.system;

import java.awt.*;
import java.awt.print.*;
import javax.swing.*;

public class MiniStatementPrintable implements Printable {

    private final Component component;

    public MiniStatementPrintable(Component component) {
        this.component = component;
    }

    @Override
    public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        component.paint(g2d);
        return PAGE_EXISTS;
    }
}
