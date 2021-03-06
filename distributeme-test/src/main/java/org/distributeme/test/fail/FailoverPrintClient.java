package org.distributeme.test.fail;

import org.distributeme.core.ServiceLocator;

public class FailoverPrintClient {
	public static void main(String[] args) {
		FailableService service = ServiceLocator.getRemote(FailableService.class);
		int counter=0,errorcounter = 0;
		while(true){
			counter++;
			try{
				service.failoverPrint("Hello number "+counter);
			}catch(Exception e){
				errorcounter++;
				System.out.println("Error "+errorcounter+", requests "+counter+" - "+e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
