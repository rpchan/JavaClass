import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class TransOldTextFile {

	private Formatter outputData;
	
	public void fileOpen()
	{
		try{ 
			outputData = new Formatter ("oldmast.txt");}
		catch (FileNotFoundException e) {
			System.out.println (e.getMessage());
		}
	}//end of public fileOpen

	//this method will add data into the file oldmast.txt
	public void dataAdd()
	{
		//AccountRecord class is created as a separate file 
		AccountRecord accountRecord = new AccountRecord();
		Scanner input = new Scanner (System.in);
		
		System.out.printf("%s", "Enter Account Number, firstName, lastName and Balance");

		while (input.hasNext())
		{
			accountRecord.setAccount(input.nextInt());
			accountRecord.setFirstName(input.next());
			accountRecord.setLastName(input.next());
			accountRecord.setBalance(input.nextDouble());

			outputData.format("%d %s %s%.2f \r\n",
				accountRecord.getAccount(),
				accountRecord.getFirstName(),
				accountRecord.getLastName(),
				accountRecord.getBalance());
			
			System.out.printf("%s", "Enter account Number, firstName, lastName and Balance");
		}//end of while
		
		input.close();
	}//end of dataAdd

	/*public void fileClose()
	{
		if(outputData != null) 
			outputData.close();
	}//end of fileClose()*/
	
} //end of class TransOldTextFile
