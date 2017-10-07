package dna;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RunMe {
   

   public static void main(String[] args) throws IOException 
   {
		File fasta = null;
      File ifile = new File("data/HW4.fastq");
      File parent = ifile.getParentFile();
      fasta = new File(parent, "HW4.fasta");
      FileConverter converter = new FileConverter(ifile, fasta);
      converter.convert();
   }

}

