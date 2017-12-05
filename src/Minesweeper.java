import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Minesweeper {
	private int rows;
	private int cols;
	private int numberMine;
	private String field [][];
	private Boolean isBoom[][];
	private Boolean isOpen[][];
	
	 public Minesweeper(File seedFile) throws FileNotFoundException {
		 	Scanner sc = new Scanner("seed1.txt");
		 	this.rows = sc.nextInt();
		 	this.cols = sc.nextInt();
		 	if(this.cols < 0 || this.rows >10 || this.rows < 0|| this.cols > 10)
		 	{
		 		System.out.println("Cannot create game with" + seedFile +"because it is not formatted correctly.");
		 		System.exit(0);
		 	}
		 	this.numberMine = sc.nextInt();
		 	this.isBoom = new Boolean[rows][cols];
		 	 for(int i = 0;i < rows;i++)
			 { for(int j = 0; j < cols; j++)
					 isBoom[i][j]= false;
			 }
		 		while(sc.hasNextInt())
		 		{
		 		int mineX = sc.nextInt();
		 		int mineY = sc.nextInt();		 		
		 		this.isBoom [mineX][mineY] = true;
		 		}
		 	for(int i = 0; i < rows; i++)
		 		for(int j = 0; j < cols; j++)
		 		{isOpen = new Boolean[rows][cols];
		 			isOpen[i][j] = false;
		 		}
		    } // Minesweeper
	 public Minesweeper(int rows, int cols) {
		 this.rows = rows;
		 this.cols = cols;
		 if(this.cols < 0 || this.cols >10 || this.rows < 0|| this.cols > 10)
		 	{
		 		System.out.println("\nಠ_ಠ says, \"Cannot create a mine field with that many rows and/or columns!\"");
		 		System.exit(0);
		 	}
		 this.isBoom = new Boolean[rows][cols];
		 for(int i = 0;i < rows;i++)
		 { for(int j = 0; j < cols; j++)
				 isBoom[i][j]= false;
		 }
		 this.numberMine = (int)(this.rows*this.cols*0.1);
		if(numberMine == 0)
			numberMine+=1;
		 for(int index  =0; index < this.numberMine;)
		 {	
			int i = (int)(Math.random()*(this.rows-1));
			int j = (int)(Math.random()*(this.cols-1));
					if(!isBoom[i][j]){
						isBoom[i][j] = true;
						index++;
						}
		 }
		 for(int i = 0; i < rows; i++)
		 		for(int j = 0; j < cols; j++)
		 		{isOpen = new Boolean[rows][cols];
		 			isOpen[i][j] = false;}
		 // random mine
			// TODO implement
		    } // Minesweeper
	 public void run() {	
		 	System.out.println("        _");
			System.out.println("  /\\/\\ (_)_ __   ___  _____      _____  ___ _ __   ___ _ __ ");// TODO Auto-generated method stub
			System.out.println(" /    \\| | \'_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|");
			System.out.println("/ /\\/\\ \\ | | | |  __/\\__ \\\\ v  v /  __/  __/ |_) |  __/ |");
			System.out.println("\\/    \\/_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|");
			System.out.println("\t\t\t\t     ALPHA |_| EDITION");
			System.out.println();
			String PositionX = "";
			String PositionY = "";
			boolean gameState = true;
			int round = 0;
			int mPoX = 0;
			int mPoY = 0;
			int score = 0;
			boolean isWin = true;
			
			field = new String[rows][cols];
			for ( int i = 0;i < rows; i++){
				for ( int j =0;j < cols;j++)
					field[i][j] = " ";
			}
			isOpen = new Boolean[rows][cols];
			for ( int i = 0;i < rows; i++){
				for ( int j =0;j < cols;j++)
				{
					isOpen[i][j] = false;
				}
			}
			
			do{
				for ( int i = 0;i < rows; i++){
					System.out.print(	i +" |");
					for ( int j =0;j < cols;j++)
					{	
					System.out.print(" "+ field [i][j]+" |");	
					}
					System.out.println();
					};
					System.out.print("   ");
					for ( int i = 0;i < 1; i++)
					{for ( int j =0;j < cols;j++)
					System.out.print(" "+j + "  ");	}
					System.out.println();
				System.out.print("minesweeper-alpha$ ");
				Scanner sc = new Scanner(System.in);
				String line = sc.nextLine();
				Scanner command = new Scanner(line);
				boolean isCommand = false;
				int countForWin = 0;
				
			if(command.hasNext())
			{
				String wordCommand = command.next();
				if(wordCommand.equals("r") ||wordCommand.equals("reveal")||wordCommand.equals("guess")||wordCommand.equals("g")||wordCommand.equals("mark")||wordCommand.equals("m"))
				  {	
					if(command.hasNextInt())
							{
								mPoX= command.nextInt();
							}
								if(command.hasNextInt())
								{
									mPoY= command.nextInt();
									isCommand = true;
								}
									if(command.hasNext())
									{
										isCommand = false;
									}
						if(isCommand == false)
						{
							System.out.println("\nಠ_ಠ says, \"Command not recognized!\"");
						}
						else if(wordCommand.equals("guess")||wordCommand.equals("g"))
						{
							if(mPoX < 0 || mPoX > rows-1 ||mPoY < 0 || mPoY >cols-1)
							{
								System.out.println("\nಠ_ಠ says, \"Command not recognized!\"");					
							}	
							else
							{
								if(isOpen[mPoX][mPoY])
									{
									 System.out.println("\nಠ_ಠ says, \"Command not recognized!\"");
									}//isOpen field
								else
									{field[mPoX][mPoY] = "?";}
							}
						 }
							else if(wordCommand.equals("mark")||wordCommand.equals("m"))
							{
								 if(mPoX < 0 || mPoX > rows-1 ||mPoY < 0 || mPoY >cols-1)
									{
										System.out.println("\nಠ_ಠ says, \"Command not recognized!\"");					
									}	
								 else{
									 	if(isOpen[mPoX][mPoY])
											{
											 System.out.println("\nಠ_ಠ says, \"Command not recognized!\"");
											}//isOpen field
									 	else
										 	{
											 field[mPoX][mPoY] = "F";
											 if(isBoom[mPoX][mPoY])
											{
											 isOpen[mPoX][mPoY] = true;
											}
										 	}				
								 		}
							}
						else if(wordCommand.equals("r") ||wordCommand.equals("reveal"))
						{
								if(mPoX > rows-1 || mPoY >cols-1 || mPoX< 0|| mPoY<0)
									{
										System.out.println("\nಠ_ಠ says, \"Command not recognized!\"");
									}
								else{
									if(isBoom[mPoX][mPoY])
										{
										gameState = false;
										System.out.println("\nOh no... You revealed a mine!");
										System.out.println("  __ _  __ _ _ __ ___   ___    _____   _____ _ __ ");
										System.out.println(" / _` |/ _` | '_ ` _ \\ / _ \\  / _ \\ \\ / / _ \\ '__|");
										System.out.println("| (_| | (_| | | | | | |  __/ | (_) \\ V /  __/ |   ");
										System.out.println(" \\__, |\\__,_|_| |_| |_|\\___|  \\___/ \\_/ \\___|_|");
										System.out.println(" |___/");
										System.exit(0);
										}//isBoom
									else
										{
										int count = 0;
										for(int i = mPoX -1; i<= mPoX +1; i++)
											{
											for(int j = mPoY -1; j<=mPoY + 1; j++)
												{	
													if (i >= 0 && i < field.length && j >= 0 && j < field.length)
													{
														if (isBoom[i][j])
															count++;
													}
												}					
											}		
											field [mPoX][mPoY] = Integer.toString(count);
											isOpen[mPoX][mPoY] = true;
											
												}	
											}
										}//				
				}//
				else if(wordCommand.equals("quit")||wordCommand.equals("q"))
						{
						System.out.println("ლ(ಠ_ಠლ)");
						System.out.println("Y u NO PLAY MORE? \nBye!");
						gameState = false;
						}//quit command
				else if(wordCommand.equals("help")||wordCommand.equals("h"))
						{
							System.out.println("- Reveal: r/reveal row col");
							System.out.println("-   Mark: m/mark   row col");
							System.out.println("-  Guess: g/guess  row col");
							System.out.println("-   Help: h/help");
							System.out.println("-   Quit: q/quit");
						}//help command
				else
				{
					System.out.println("\nಠ_ಠ says, \"Command not recognized!\"");
				}
					
			
			}// hasNext
			else
			{
				System.out.println("\nಠ_ಠ says, \"Command not recognized!\"");
			}
			for(int i = 0; i < rows; i++)
				for(int j = 0; j < cols; j++)
				{
					if(this.isOpen[i][j] == true)
						countForWin++;
						
				}
				System.out.println(countForWin);
				if(countForWin== cols*rows)
					{
					gameState = false;
					score = (rows * cols)-numberMine - round;
					System.out.println("\n░░░░░░░░░▄░░░░░░░░░░░░░░▄░░░░ \"So Doge\"");
					System.out.println("░░░░░░░░▌▒█░░░░░░░░░░░▄▀▒▌░░░");
					System.out.println("░░░░░░░░▌▒▒█░░░░░░░░▄▀▒▒▒▐░░░ \"Such Score\"");
					System.out.println("░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐░░░");
					System.out.println("░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐░░░ \"Much Minesweeping\"");
					System.out.println("░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌░░░");
					System.out.println("░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒▌░░ \"Wow\"");
					System.out.println("░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐░░");
					System.out.println("░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄▌░");
					System.out.println("░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▌░");
					System.out.println("▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒▐░");
					System.out.println("▐▒▒▐▀▐▀▒░▄▄▒▄▒▒▒▒▒▒░▒░▒░▒▒▒▒▌");
					System.out.println("▐▒▒▒▀▀▄▄▒▒▒▄▒▒▒▒▒▒▒▒░▒░▒░▒▒▐░");
					System.out.println("░▌▒▒▒▒▒▒▀▀▀▒▒▒▒▒▒░▒░▒░▒░▒▒▒▌░");
					System.out.println("░▐▒▒▒▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▒▄▒▒▐░░");
					System.out.println("░░▀▄▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▄▒▒▒▒▌░░");
					System.out.println("░░░░▀▄▒▒▒▒▒▒▒▒▒▒▄▄▄▀▒▒▒▒▄▀░░░ CONGRATULATIONS!");
					System.out.println("░░░░░░▀▄▄▄▄▄▄▀▀▀▒▒▒▒▒▄▄▀░░░░░ YOU HAVE WON!");
					System.out.println("░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▀▀░░░░░░░░ SCORE: " + score);
					}
			round++;
			isWin = true;			
			}
			while(gameState == true);			
			// TODO implement
		    } // run
	
	
	public static void main(String[] args) throws FileNotFoundException{
//		// TODO Auto-generated method stub			
		Minesweeper game = null;
		switch (args.length) {
        // random game
	case 2: 

	    int rows, cols;

	    // try to parse the arguments and create a game
	    try {
		rows = Integer.parseInt(args[0]);
		cols = Integer.parseInt(args[1]);
		game = new Minesweeper(rows, cols);
		break;
	    } catch (NumberFormatException nfe) { 
		// line intentionally left blank
	    } // try
	    // seed file game
	case 1: 
	    String filename = args[0];
	    File file = new File(filename);

	    if (file.isFile()) {
		game = new Minesweeper(file);
		break;
	    } // if    
//        // display usage statement
	default:
	    System.out.println("Usage: java Minesweeper [FILE]");
	    System.out.println("Usage: java Minesweeper [ROWS] [COLS]");
	    System.exit(0);
	} // switch
		//game = new Minesweeper(11,11);
		game.run();

	    } // main


	} // Minesweeper
	


