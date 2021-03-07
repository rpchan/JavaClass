import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Formatter; 

public class TransNewTextFile {
	
	private Formatter outputData;

	public void fileOpen()
	{
		//open text file
		try{
			outputData = new Formatter ("trans.txt");
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	//this method will add data into the file trans.txt
	public void dataAdd()
	{
		TransactionRecord transRecord = new TransactionRecord();

		Scanner input = new Scanner(System.in);
		System.out.printf("%s %s", "Enter account Number, ", "Transaction Amount");

		while (input.hasNext())
		{
			transRecord.setAccount(input.nextInt());
			transRecord.setAmount(input.nextDouble());
			outputData.format("%d %.2f \r\n", transRecord.getAccount(),
						transRecord.getAmount());

			System.out.printf("%s %s", "Enter account Number,  ", "Transaction Amount");
		}
		input.close();
	} //end of dataAdd
	
	/*public void fileClose()
	{
		if (outputData !=null)
			outputData.close();
	} //end of fileClose */

} //end of TransNewTextFile

