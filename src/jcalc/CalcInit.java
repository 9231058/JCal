package jcalc;

import jcalc.gui.CalcFrame;

public class CalcInit {

	private static CalcInit calcInit;

	public static CalcInit getInstance() {
		if (calcInit == null) {
			calcInit = new CalcInit();
		}
		return calcInit;
	}

	public void run() {
		CalcFrame calcFrame = new CalcFrame();
		calcFrame.setVisible(true);
	}

}
