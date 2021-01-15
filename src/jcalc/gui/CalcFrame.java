package jcalc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import jcalc.TokenMannager;

public class CalcFrame extends JFrame {

	private static final long serialVersionUID = 3339451421592992880L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton backspaceButton;

	public CalcFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);

		JMenuItem aboutMenuItem = new JMenuItem("About");
		helpMenu.add(aboutMenuItem);
		aboutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(CalcFrame.this,
						"This is calc that not working ...", "About",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 10,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 10,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 423,
				SpringLayout.WEST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				TokenMannager tokenMannager = new TokenMannager(textField
						.getText(), textField);
				tokenMannager.execute();
			}
		});

		JButton CButton = new JButton("C");
		sl_contentPane.putConstraint(SpringLayout.NORTH, CButton, 6,
				SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, CButton, -132,
				SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, CButton, 0,
				SpringLayout.EAST, textField);
		contentPane.add(CButton);

		JButton CEButton = new JButton("CE");
		sl_contentPane.putConstraint(SpringLayout.WEST, CEButton, 160,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, CEButton, -15,
				SpringLayout.WEST, CButton);
		sl_contentPane.putConstraint(SpringLayout.NORTH, CEButton, 6,
				SpringLayout.SOUTH, textField);
		contentPane.add(CEButton);

		backspaceButton = new JButton("Backspace");
		sl_contentPane.putConstraint(SpringLayout.NORTH, backspaceButton, 6,
				SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, backspaceButton, -15,
				SpringLayout.WEST, CEButton);
		contentPane.add(backspaceButton);

		JButton plusButton = new JButton("+");
		sl_contentPane.putConstraint(SpringLayout.NORTH, plusButton, 6,
				SpringLayout.SOUTH, CButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, plusButton, 0,
				SpringLayout.EAST, textField);
		contentPane.add(plusButton);

		JButton minusButton = new JButton("-");
		sl_contentPane.putConstraint(SpringLayout.NORTH, minusButton, 6,
				SpringLayout.SOUTH, CButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, minusButton, -6,
				SpringLayout.WEST, plusButton);
		contentPane.add(minusButton);

		JButton PButton = new JButton("*");
		sl_contentPane.putConstraint(SpringLayout.NORTH, PButton, 6,
				SpringLayout.SOUTH, CButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, PButton, -6,
				SpringLayout.WEST, minusButton);
		contentPane.add(PButton);

		JButton divButton = new JButton("/");
		sl_contentPane.putConstraint(SpringLayout.NORTH, divButton, 6,
				SpringLayout.SOUTH, CEButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, divButton, -6,
				SpringLayout.WEST, PButton);
		contentPane.add(divButton);

		JButton button1 = new JButton("1");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button1, 6,
				SpringLayout.SOUTH, plusButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, button1, 0,
				SpringLayout.EAST, textField);
		contentPane.add(button1);

		JButton button2 = new JButton("2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button2, 6,
				SpringLayout.SOUTH, minusButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, button2, 0,
				SpringLayout.WEST, button1);
		contentPane.add(button2);

		JButton button3 = new JButton("3");
		sl_contentPane.putConstraint(SpringLayout.WEST, button3, 0,
				SpringLayout.WEST, PButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button3, 0,
				SpringLayout.SOUTH, button1);
		sl_contentPane.putConstraint(SpringLayout.EAST, button3, 0,
				SpringLayout.WEST, button2);
		contentPane.add(button3);

		JButton button4 = new JButton("4");
		sl_contentPane.putConstraint(SpringLayout.WEST, button4, 0,
				SpringLayout.WEST, divButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button4, 0,
				SpringLayout.SOUTH, button1);
		sl_contentPane.putConstraint(SpringLayout.EAST, button4, 0,
				SpringLayout.WEST, button3);
		contentPane.add(button4);

		JButton button5 = new JButton("5");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button5, 6,
				SpringLayout.SOUTH, button1);
		sl_contentPane.putConstraint(SpringLayout.WEST, button5, 0,
				SpringLayout.WEST, button1);
		sl_contentPane.putConstraint(SpringLayout.EAST, button5, 0,
				SpringLayout.EAST, button1);
		contentPane.add(button5);

		JButton button6 = new JButton("6");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button6, 6,
				SpringLayout.SOUTH, button2);
		sl_contentPane.putConstraint(SpringLayout.WEST, button6, 0,
				SpringLayout.WEST, button2);
		sl_contentPane.putConstraint(SpringLayout.EAST, button6, 0,
				SpringLayout.EAST, button2);
		contentPane.add(button6);

		JButton button7 = new JButton("7");
		sl_contentPane.putConstraint(SpringLayout.WEST, button7, 0,
				SpringLayout.WEST, button3);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button7, 0,
				SpringLayout.SOUTH, button5);
		sl_contentPane.putConstraint(SpringLayout.EAST, button7, 0,
				SpringLayout.EAST, button3);
		contentPane.add(button7);

		JButton button8 = new JButton("8");
		sl_contentPane.putConstraint(SpringLayout.WEST, button8, 0,
				SpringLayout.WEST, button4);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button8, 0,
				SpringLayout.SOUTH, button5);
		sl_contentPane.putConstraint(SpringLayout.EAST, button8, 0,
				SpringLayout.EAST, button4);
		contentPane.add(button8);

		JButton button9 = new JButton("9");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button9, 6,
				SpringLayout.SOUTH, button5);
		sl_contentPane.putConstraint(SpringLayout.WEST, button9, 0,
				SpringLayout.WEST, button5);
		sl_contentPane.putConstraint(SpringLayout.EAST, button9, 0,
				SpringLayout.EAST, button5);
		contentPane.add(button9);

		JButton button0 = new JButton("0");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button0, 6,
				SpringLayout.SOUTH, button6);
		sl_contentPane.putConstraint(SpringLayout.WEST, button0, 0,
				SpringLayout.WEST, button6);
		sl_contentPane.putConstraint(SpringLayout.EAST, button0, 0,
				SpringLayout.EAST, button6);
		contentPane.add(button0);
	}
}
