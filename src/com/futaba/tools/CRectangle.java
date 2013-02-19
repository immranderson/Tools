package com.futaba.tools;

import java.awt.Rectangle;

public class CRectangle {

	/**
	 * @param args
	 */
	
	int UpperLeftx, UpperLefty, LowerRightx, LowerRighty;
	
	public CRectangle(int upperleftx, int upperlefty, int lowerrightx, int lowerrighty)
	{
		this.UpperLeftx = upperleftx;
		this.UpperLefty = upperlefty;
		this.LowerRightx = lowerrightx;
		this.LowerRighty = lowerrighty;
	}
	
	public Rectangle getRectangle()
	{
		return new Rectangle(UpperLeftx, UpperLefty, LowerRightx-UpperLeftx, LowerRighty-UpperLefty);
	}
	
	public static void main(String[] args) {
		
		CRectangle crec = new CRectangle (1,0,4,5);
		System.out.println(crec.getRectangle().height);

	}

}
