package com.myarcade.robotgame.instructions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class ReadInstructions implements Function<String[], Stream<String>>{
	
	private final static Logger LOGGER = Logger.getLogger(ReadInstructions.class.getName());

	public Stream<String> apply(String[] args) {
		 switch (args.length) {
         case 0:
             return stdinStream();
         case 1:
             return fileRead(args[0]);
         default:
             LOGGER.severe("Please enter valid arguments. '\n' [Syntax] with one input file or empty");
             return Stream.empty();
     }
		
		
		//return fileRead("./instructionsA.txt");
	}

	private Stream<String> stdinStream() {
		Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();

        System.out.println("Please Enter one command per line and any number of commands.");
        System.out.println("To exit and execute commands, press 'CTRL + D' (Unix) or 'CTRL + Z' + 'Enter' (Windows).");
        System.out.println();

        while (scanner.hasNext()) {
            result.add(scanner.nextLine());
        }

        return result.stream();
	}

	private Stream<String> fileRead(String filePath) {
		try {
            return Files.lines(Paths.get(filePath));
        } catch (IOException e) {
           
            return Stream.empty();
        }	
		
	}
	

}
