/*
 * Copyright (c) 2015 Karl Tauber <karl at jformdesigner dot com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  o Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.markdownwriterfx.options;

import javafx.event.ActionEvent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Window;

/**
 * Options dialog
 *
 * @author Karl Tauber
 */
public class OptionsDialog
	extends Dialog<Void>
{
	public OptionsDialog(Window owner) {
		setTitle("Options");
		initOwner(owner);

		initComponents();

		tabPane.getStyleClass().add(TabPane.STYLE_CLASS_FLOATING);

		DialogPane dialogPane = getDialogPane();
		dialogPane.setContent(tabPane);
		dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

		dialogPane.lookupButton(ButtonType.OK).addEventHandler(ActionEvent.ACTION, e -> {
			save();
			e.consume();
		});

		load();
	}

	private void load() {
		markdownOptionsPane.load();
	}

	private void save() {
		markdownOptionsPane.save();
		Options.save();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		tabPane = new TabPane();
		markdownTab = new Tab();
		markdownOptionsPane = new MarkdownOptionsPane();

		//======== tabPane ========
		{
			tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

			//======== markdownTab ========
			{
				markdownTab.setText("Markdown");
				markdownTab.setContent(markdownOptionsPane);
			}

			tabPane.getTabs().addAll(markdownTab);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private TabPane tabPane;
	private Tab markdownTab;
	private MarkdownOptionsPane markdownOptionsPane;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
