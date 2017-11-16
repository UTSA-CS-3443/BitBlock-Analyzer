package parser;

import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritetoFile {

	private List<String> sourceCodeLines = new ArrayList<String>();
	
	
	/**
	 * @param List<String> sourcecode, String path_to_out_file
	 * append the data to that file
	 * 
	 * !!! NEED: check existence of file
	 * 			 prompt user to overwrite
	 * 
	 */
	public WritetoFile(List<String> sourceCodeLines, String outfile) throws IOException
	{
		this.sourceCodeLines = sourceCodeLines;
		Path file = Paths.get(outfile);
		Files.write(file, sourceCodeLines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
	}
	
}
