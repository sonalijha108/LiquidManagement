package com.backgroundprocesses;

import java.util.ArrayList;
import java.util.List;

import com.beans.CashFlow;
import com.utilities.RandCashFlowGenerator;

public class DailyRun extends Thread{
	
	public void run() 
	{
		RandCashFlowGenerator randCashFlowGenerator=new RandCashFlowGenerator();
		CashFlow.cashFlows=randCashFlowGenerator.GenerateRandomCashFlow();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

