/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ivan
 */
public class DateRenderer extends DefaultTableCellRenderer{
    public DateRenderer() {
        super();
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    }

    @Override
    public void setValue(Object value) {
        if ((value != null) && (value instanceof Date)) {
            Date dateValue = (Date) value;
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
           
            value = formatter.format(dateValue);
        }
        super.setValue(value);
    }
    
}
