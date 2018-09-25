package com.backgroundprocesses;

import com.utilities.RandRateGenerator;

public class ShortPeriodRun extends Thread{
	public void run() {
		RandRateGenerator randRateGenerator=new RandRateGenerator();
		randRateGenerator.generateRandomRates();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
