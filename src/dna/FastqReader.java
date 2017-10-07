package dna;

import java.io.*;

//
// Reads lines from a BufferedReader and builds a FastqReader.
//


public class FastqReader 
{
	private BufferedReader theBufferedReader;
	
	public FastqReader(BufferedReader br) 
	{
		this.theBufferedReader = br;
	}

	// Returns next record in the file, or null if EOF (end-of-file).
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		// Read the defline from the BufferedReader. Return null if you read null, 
		// indicating end of file.
		String line = theBufferedReader.readLine();
		if (line == null)
		{
			return null;
		}
		
		// Read the next 3 lines from the buffered reader. Construct and return
		// a FastqRecord.
		String line1 = theBufferedReader.readLine();
		String line2 = theBufferedReader.readLine();
		String line3 = theBufferedReader.readLine();
		
		FastqRecord output = new FastqRecord(line, line1, line3);
		return output;
	}
}
