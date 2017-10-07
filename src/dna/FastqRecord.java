package dna;
import java.io.BufferedReader;

//
// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
//


public class FastqRecord implements DNARecord 
{
	private String defline;
	private String sequence;
	private String quality;
	
	//
	// Add a precondition check: throw FastqException if the 1st char of the defline is 
	// not '@'. You will have to change the ctor declaration to say that it throws
	// the exception. The exception should contain a useful informative message.
	//
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException
	{
		this.defline = defline;	
		this.sequence = sequence;
		this.quality = quality;
		
		char d = defline.charAt(0);
		if (d != '@')
		{
			throw new RecordFormatException("Bad 1st char in defline in fastq record: saw " + d + " expected @");
		}
		
	}
	
	
	// 
	// Provide the 2 methods that satisfy the interface.
	//
	public String getDefline()
	{
		return defline;
	}
	
	public String getSequence()
	{
		return sequence;
	}

	//
	// Provide an equals() method that checks for deep equality of all 3 instance variables. 
	// When checking string variables, be sure to do it like this:  
	//              this.defline.equals(that.defline) 
	// and not like this:  
	//              this.defline == that.defline
	//
	public boolean equals(Object x)
	{
		FastqRecord that = (FastqRecord)x;
		return this.compareTo(that) == 0;
	}
	
	public int compareTo(FastqRecord x)
	{
		if (this.defline.compareTo(x.defline) == 0)
		{
			if (this.sequence.compareTo(x.sequence) == 0)
			{
				if (this.quality.compareTo(x.quality) == 0)
				{
					return 0;
				}
				else
				{
					return this.quality.compareTo(x.quality);
				}
			}
			else
			{
				return this.sequence.compareTo(x.sequence);
			}
		}
		else
		{
			return this.defline.compareTo(x.defline);
		}	
	}
	

	// Complete this. Return true if quality contains at least one '!' char.
	//
	public boolean qualityIsLow()
	{
		if(this.quality.contains("!"))
		{
			return true;
		}
		return false;
	}
	
	
	//
	// Complete this. Return the sum of the hash codes of defline, sequence, and quality.
	//
	public int hashCode()
	{
		return defline.hashCode() + sequence.hashCode() + quality.hashCode();

	}
}
