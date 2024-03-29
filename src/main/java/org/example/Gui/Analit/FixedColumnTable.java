/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ivan
 */
public class FixedColumnTable  implements ChangeListener, PropertyChangeListener
{
	private JTable main;
	private JTable fixed;
	private JScrollPane scrollPane;

	/*
	 *  Specify the number of columns to be fixed and the scroll pane
	 *  containing the table.
	 */
	public FixedColumnTable(int fixedColumns, JScrollPane scrollPane)
	{
		this.scrollPane = scrollPane;

		main = ((JTable)scrollPane.getViewport().getView());
		main.setAutoCreateColumnsFromModel( false );
		main.addPropertyChangeListener( this );

		//  Use the existing table to create a new table sharing
		//  the DataModel and ListSelectionModel

		int totalColumns = main.getColumnCount();

		fixed = new JTable();
		fixed.setAutoCreateColumnsFromModel( false );
		fixed.setModel( main.getModel() );
		fixed.setSelectionModel( main.getSelectionModel() );
		fixed.setFocusable( false );

		//  Remove the fixed columns from the main table
		//  and add them to the fixed table

		for (int i = 0; i < fixedColumns; i++)
		{
	        TableColumnModel columnModel = main.getColumnModel();
	        TableColumn column = columnModel.getColumn( 0 );
    	    columnModel.removeColumn( column );
			fixed.getColumnModel().addColumn( column );
		}

		//  Add the fixed table to the scroll pane

        fixed.setPreferredScrollableViewportSize(fixed.getPreferredSize());
		scrollPane.setRowHeaderView( fixed );
		scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixed.getTableHeader());

		// Synchronize scrolling of the row header with the main table

		scrollPane.getRowHeader().addChangeListener( this );
	}

	/*
	 *  Return the table being used in the row header
	 */
	public JTable getFixedTable()
	{
		return fixed;
	}
//
//  Implement the ChangeListener
//
	public void stateChanged(ChangeEvent e)
	{
		//  Sync the scroll pane scrollbar with the row header

		JViewport viewport = (JViewport) e.getSource();
		scrollPane.getVerticalScrollBar().setValue(viewport.getViewPosition().y);
	}
//
//  Implement the PropertyChangeListener
//
	public void propertyChange(PropertyChangeEvent e)
	{
		//  Keep the fixed table in sync with the main table

		if ("selectionModel".equals(e.getPropertyName()))
		{
			fixed.setSelectionModel( main.getSelectionModel() );
		}

		if ("model".equals(e.getPropertyName()))
		{
			fixed.setModel( main.getModel() );
		}
	}
    
}
