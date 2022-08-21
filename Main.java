/*
a different computer that just learns instead of analyzing future games.

Similar to neural network. Maybe
it is?

Side effects: It does not care about wins. just so careful about losses.

Coded in java.

By Tom!



You are welcome to modify code.



ALERT: First modify the folder where the network will be stored.
GO CONFIGURE: class configuration
THEN CHANGE: NETWORKFOLDER = "FOLDERLOCATION"
*/



import javax.swing.JFrame; //java frame. remember that Tom.
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class configuration {
    String NETWORKFOLDER = "/home/tom/Learning/";
}

class onpaper {
    functions fun = new functions();
    void outputpaper(int paper[]) {
        String outText = paper[0] + " " + paper[1] + " " +  paper[2] + "\n" + paper[3] + " " + paper[4] + " " + paper[5] + "\n" + paper[6] + " " + paper[7] + " " + paper[8];
        outText = outText.replace('1', 'O');
        outText = outText.replace('2', 'X');
        outText = outText.replace('0', '-');
        System.out.println(outText);
    }
    void ongame(int paper[], String history) {
        if (history.equals("beginO")) {
            //begin game
            Scanner scan = new Scanner(System.in);
            boolean EndGame = false;
            while (!(EndGame)) {
                System.out.println("Your move (no space and 1-9) If input is incorrect the game will end.");
                outputpaper(paper);
                String getuserinput = scan.nextLine();
                if (getuserinput.equals("1")) {
                    if (paper[0]==0) {
                    paper[0] = 1;
                    history = history + ", " + 0;
                    } else {break;}
                } else if (getuserinput.equals("2")) {
                    if (paper[1]==0) {
                    paper[1] = 1;
                    history = history + ", " + 1;
                    } else {break;}
                } else if (getuserinput.equals("3")) {
                    if (paper[2]==0) {
                    paper[2] = 1;
                    history = history + ", " + 2;
                    } else {break;}
                } else if (getuserinput.equals("4")) {
                    if (paper[3]==0) {
                    paper[3] = 1;
                    history = history + ", " + 3;
                    } else {break;}
                } else if (getuserinput.equals("5")) {
                    if (paper[4]==0) {
                    paper[4] = 1;
                    history = history + ", " + 4;
                    } else {break;}
                } else if (getuserinput.equals("6")) {
                    if (paper[5]==0) {
                    paper[5] = 1;
                    history = history + ", " + 5;
                    } else {break;}
                } else if (getuserinput.equals("7")) {
                    if (paper[6]==0) {
                    paper[6] = 1;
                    history = history + ", " + 6;
                    } else {break;}
                } else if (getuserinput.equals("8")) {
                    if (paper[7]==0) {
                    paper[7] = 1;
                    history = history + ", " + 7;
                    } else {break;}
                } else if (getuserinput.equals("9")) {
                    if (paper[8]==0) {
                    paper[8] = 1;
                    history = history + ", " + 8;
                    } else {break;}
                } else {
                    System.out.println("Input incorrect.");
                    break;
                }
                String result = fun.CheckBoard(paper);
                if (result.equals("win")) {
                    EndGame = true;
                    fun.game(paper, history);
                } else if (result.equals("lose")) {
                    EndGame = true;
                    fun.game(paper, history);
                } else if (result.equals("draw")) {
                    EndGame = true;
                    fun.game(paper, history);
                } else {
                    int CPUmove = fun.game(paper, history);
                    if (CPUmove == -1) {
                        break;
                    }
                    paper[CPUmove] = 2;
                    history = history + ", " + CPUmove;
                    String result2 = fun.CheckBoard(paper);
                    if (result2.equals("win")) {
                    EndGame = true;
                    fun.game(paper, history);
                    } else if (result2.equals("lose")) {
                        EndGame = true;
                        fun.game(paper, history);
                    } else if (result2.equals("draw")) {
                        EndGame = true;
                        fun.game(paper, history);
                    }
                }
            }
        }
        //now if computer turn
        if (history.equals("beginX")) {
            //begin game
            Scanner scan = new Scanner(System.in);
            boolean EndGame = false;
            while (!(EndGame)) {
                int CPUmove = fun.game(paper, history);
                if (CPUmove == -1) {
                    break;
                }
                paper[CPUmove] = 2;
                history = history + ", " + CPUmove;
                String result = fun.CheckBoard(paper);
                if (result.equals("win")) {
                EndGame = true;
                fun.game(paper, history);
                } else if (result.equals("lose")) {
                    EndGame = true;
                    fun.game(paper, history);
                } else if (result.equals("draw")) {
                    EndGame = true;
                    fun.game(paper, history);
                } else {
                    System.out.println("Your move (no space and 1-9) If input is incorrect the game will end.");
                    outputpaper(paper);
                    String getuserinput = scan.nextLine();
                    if (getuserinput.equals("1")) {
                        if (paper[0]==0) {
                        paper[0] = 1;
                        history = history + ", " + 0;
                        }
                        else {break;}
                    } else if (getuserinput.equals("2")) {
                        if (paper[1]==0) {
                        paper[1] = 1;
                        history = history + ", " + 1;
                        } else {break;}
                    } else if (getuserinput.equals("3")) {
                        if (paper[2]==0) {
                        paper[2] = 1;
                        history = history + ", " + 2;
                        } else {break;}
                    } else if (getuserinput.equals("4")) {
                        if (paper[3]==0) {
                        paper[3] = 1;
                        history = history + ", " + 3;
                        } else {break;}
                    } else if (getuserinput.equals("5")) {
                        if (paper[4]==0) {
                        paper[4] = 1;
                        history = history + ", " + 4;
                        } else {break;}
                    } else if (getuserinput.equals("6")) {
                        if (paper[5]==0) {
                        paper[5] = 1;
                        history = history + ", " + 5;
                        } else {break;}
                    } else if (getuserinput.equals("7")) {
                        if (paper[6]==0) {
                        paper[6] = 1;
                        history = history + ", " + 6;
                        } else {break;}
                    } else if (getuserinput.equals("8")) {
                        if (paper[7]==0) {
                        paper[7] = 1;
                        history = history + ", " + 7;
                        } else {break;}
                    } else if (getuserinput.equals("9")) {
                        if (paper[8]==0) {
                        paper[8] = 1;
                        history = history + ", " + 8;
                        } else {break;}
                    } else {
                        System.out.println("Input incorrect.");
                        break;
                    }
                    String result2 = fun.CheckBoard(paper);
                    if (result2.equals("win")) {
                        EndGame = true;
                        fun.game(paper, history);
                    } else if (result2.equals("lose")) {
                        EndGame = true;
                        fun.game(paper, history);
                    } else if (result2.equals("draw")) {
                        EndGame = true;
                        fun.game(paper, history);
                    }
                }
            }
        }
        if (history.equals("train")) { 
            //TIME TO TRAIN!
            System.out.println("Starting Training - Random");
            while (true) {
                boolean EndGame = false;
                boolean BeginX = false; //Toogle beginX so it doesnt have to do more checks on history[]. false beginX will assume it is BeginO.
                Random begin = new Random();
                int beginnum = begin.nextInt(2);
                if (beginnum == 1) {history="beginO"; BeginX=false;} else {history="beginX"; BeginX =true;}
                //refresh paper to 0 back.
                for (int v=0; v<9; v++) {
                    paper[v] = 0;
                }
                while (!(EndGame)) {
                    if (BeginX == false) {
                       int getmove = fun.RanBoard(paper);
                        System.out.println("begin: Training (Exit the terminal if you want to stop Training.) O");
                        paper[getmove] = 1;
                        history = history + ", " + getmove;
                        String result = fun.CheckBoard(paper);
                        if (result.equals("win")) {
                            EndGame = true;
                            int wait = fun.game(paper, history);
                            for (int s = 0; s < 9; s++) {
                                paper[s] = 0;                    
                            }
                        } else if (result.equals("lose")) {
                            EndGame = true;
                            int wait = fun.game(paper, history);
                            for (int s = 0; s < 9; s++) {
                                paper[s] = 0;                    
                            }
                        } else if (result.equals("draw")) {
                            EndGame = true;
                            int wait = fun.game(paper, history);
                            for (int s = 0; s < 9; s++) {
                                paper[s] = 0;                    
                            }
                        } else {
                            int CPUmove = fun.game(paper, history);
                            if (CPUmove == -1) {
                                break;
                            }
                            paper[CPUmove] = 2;
                            history = history + ", " + CPUmove;
                            String result2 = fun.CheckBoard(paper);
                            if (result2.equals("win")) {
                                EndGame = true;
                                fun.game(paper, history);
                                for (int s = 0; s < 9; s++) {
                                    paper[s] = 0;                    
                                }
                            } else if (result2.equals("lose")) {
                                EndGame = true;
                                fun.game(paper, history);
                                for (int s = 0; s < 9; s++) {
                                    paper[s] = 0;                    
                                }
                            } else if (result2.equals("draw")) {
                                EndGame = true;
                                fun.game(paper, history);
                                for (int s = 0; s < 9; s++) {
                                    paper[s] = 0;                    
                                }
                            }
                        } 
                    }
                    if (BeginX == true) {
                        System.out.println("begin: Training (Exit the terminal if you want to stop Training.) X");
                        int CPUmove = fun.game(paper, history);
                        if (CPUmove == -1) {
                            break;
                        }
                        paper[CPUmove] = 2;
                        history = history + ", " + CPUmove;
                        String result2 = fun.CheckBoard(paper);
                        if (result2.equals("win")) {
                            EndGame = true;
                            fun.game(paper, history);
                            for (int s = 0; s < 9; s++) {
                                paper[s] = 0;                    
                            }
                        } else if (result2.equals("lose")) {
                            EndGame = true;
                            fun.game(paper, history);
                            for (int s = 0; s < 9; s++) {
                                paper[s] = 0;                    
                            }
                        } else if (result2.equals("draw")) {
                            EndGame = true;
                            fun.game(paper, history);
                            for (int s = 0; s < 9; s++) {
                                paper[s] = 0;                    
                            }
                        } else {
                            int getmove = fun.RanBoard(paper);
                            paper[getmove] = 1;
                            history = history + ", " + getmove;
                            String result = fun.CheckBoard(paper);
                            if (result.equals("win")) {
                                EndGame = true;
                                fun.game(paper, history);
                                for (int s = 0; s < 9; s++) {
                                    paper[s] = 0;                    
                                }
                            } else if (result.equals("lose")) {
                                EndGame = true;
                                fun.game(paper, history);
                                for (int s = 0; s < 9; s++) {
                                    paper[s] = 0;                    
                                }
                            } else if (result.equals("draw")) {
                                EndGame = true;
                                fun.game(paper, history);
                                for (int s = 0; s < 9; s++) {
                                    paper[s] = 0;                    
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

class functions {
    int winint=0;
    int loseint=0;
    int drawint=0;
    int RanBoard(int paper[]) {
        Random ran = new Random();
        int random = ran.nextInt(9);
        if (paper[random] == 0) {
            return random;
        } else {
            return RanBoard(paper);
        }
    }
    public String CheckBoard(int paper[]) {
		// basically check any potential win or potential draw
		// expect to see alot of if statement.
		int plrcpu = 1; // first player 1 then cpu 2.
		int whowon = 0;
		for (int i=0; i < 2; i++) {	
			    if (paper[0] == plrcpu && paper[1] == plrcpu && paper[2] == plrcpu) //top row
			    {
				    //looks like someone won.
				    whowon = plrcpu;
				    continue;
			    } else if (paper[3] == plrcpu && paper[4] == plrcpu && paper[5] == plrcpu)
			    {//middle row
				    whowon = plrcpu;
				    continue;
			    } else if (paper[6] == plrcpu && paper[7] == plrcpu && paper[8] == plrcpu)
			    {//bottom row
				    whowon = plrcpu;
				    continue;
			    }  else if (paper[0] == plrcpu && paper[3] == plrcpu && paper[6] == plrcpu)
			    {//left row
				    whowon = plrcpu;
				    continue;
			    }  else if (paper[1] == plrcpu && paper[4] == plrcpu && paper[7] == plrcpu)
			    {//middle row again
				    whowon = plrcpu;
				    continue;
		            } else if (paper[2] == plrcpu && paper[5] == plrcpu && paper[8] == plrcpu)
			    {//right row
				    whowon = plrcpu;
				    continue;
			    } else if (paper[0] == plrcpu && paper[4] == plrcpu && paper[8] == plrcpu)
			    {//this will end soon, left diagonal row
				    whowon = plrcpu;
				    continue;
			    } else if (paper[2] == plrcpu && paper[4] == plrcpu && paper[6] == plrcpu)
			    {//and finally right diagonal row
				    whowon = plrcpu;
				    continue;
			    }
			    //finally!
			    //oh no, i forgot to check if board is filled.
			    if (!(paper[0]==0 || paper[1]==0 || paper[2]==0 || paper[3]==0 || paper[4]==0 || paper[5]==0 || paper[6]==0 || paper[7]==0 || paper[8]==0)) {
			    // it indeed is a draw.
			    whowon = -1;
			    }
			    plrcpu = plrcpu + 1;
		    //end of loop lets check who won?!
        }
        if (whowon == 1) {
            // no! Player won. i guess we arent that good.
            return "lose";
        } else if (whowon == 2) {
            return "win";
        } else if (whowon == 0) {
            return "continue";
        } else {
            return "draw";
        }

    }
    String write(String history) throws IOException {
        configuration config = new configuration();
        FileWriter write = new FileWriter(config.NETWORKFOLDER+history);
        System.out.println("Saved the file to "+config.NETWORKFOLDER+", The history was: "+history+".");
        write.close();
        return "ok";
    }
    int game(int paper[], String history) {
        System.out.println("TICMAN: Checking board.");
        onpaper op = new onpaper();
        op.outputpaper(paper);
        String status = CheckBoard(paper);
        if (status.equals("draw")) {
            System.out.println("The game is draw. I was expecting it.");
            drawint = drawint + 1;
        } else if (status.equals("lose")) {
            System.out.println("I lost. I learned something.");
            loseint = loseint + 1;
            try {
                String newhistory = history.substring(0,history.length() - 3);
                write(newhistory);                            
            } catch (IOException e) {
               System.out.println("error: Cannot write data.");
            };
        } else if (status.equals("win")) {
            System.out.println("I win.");
            winint = winint + 1;
        } else { 
            System.out.println("Win:" + winint + " | Lose:" + loseint + " | Draw:" + drawint + " | Total: " + (winint + loseint + drawint));
            int getrandomnum = RanBoard(paper);
            //Here is the network!
            configuration config = new configuration();
            File network = new File(config.NETWORKFOLDER);
            //Assuming it is a directory.
            if (network.isDirectory() == true) {
                String netloads[] = network.list();
                    //we got bad move. lets do some checks. we have a list.
                    int badmovescount = 0;
                    for (int c=0; c < netloads.length; c++) {
                        if (netloads[c].equals(history + ", " + 0) || netloads[c].equals(history + ", " + 1) || netloads[c].equals(history + ", " + 2) || netloads[c].equals(history + ", " + 3) || netloads[c].equals(history + ", " + 4) || netloads[c].equals(history + ", " + 5) || netloads[c].equals(history + ", " + 6) || netloads[c].equals(history + ", " + 7) || netloads[c].equals(history + ", " + 8)) {
                            badmovescount++;
                            System.out.println("DEBUG: Bad move found, count: " + badmovescount);
                        }
                    }
                    //now check for avaliablity.
                    int avaliablity = 0;
                    for (int c=0; c < 9; c++) {
                        if (paper[c] == 0) {
                              avaliablity++;                          
                        }
                    }
                    if (badmovescount == avaliablity) {
                        //i see why... Our move were bad. Now we know we made really bad move. Theres no good moves now.
                        System.out.println("I resign. Bad move were made.");
                        try {
                            String newhistory = history.substring(0,history.length() - 3);
                            write(newhistory);                            
                        } catch (IOException e) {
                           System.out.println("ERROR: Cannot write data.");
                        }
                        return -1;
                    }
            //else. We can use fine move then.
                    int goodmove = 0;
                    int drawmove = 0;
                    int badmove = 0;
                    int ranmove = RanBoard(paper);
                    for (int c=0; c<9; c++) {
                        if (paper[c]==0) {
                            int fakepaper[] = new int[9];
                            for (int m=0;m<9;m++) {
                                fakepaper[m] = paper[m];
                            }
                            fakepaper[c] = 2;
                            String result = CheckBoard(fakepaper);
                            if (result.equals("win")) {
                                goodmove = c;
                            }
                            if (result.equals("draw")) {
                                drawmove = c;
                            }
                            if (result.equals("lose")) {
                                badmove = c;
                            }
                        }
                    }
                    if (!(goodmove==0)) {
                        return goodmove;
                    } else {
                        /*Check before doing anything stupid.*/ 
                        boolean Badmove = false;
                        int potentialmove[] = {0,0,0,0,0,0,0,0,0};
                        for (int b=0; b<9;b++) {
                            for (int v = 0; v<netloads.length; v++) {
                                if (netloads[v].equals(history+", "+b)) {
                                    Badmove = true;
                                }
                            }
                            if (Badmove == false && paper[b]==0) {
                                potentialmove[b] = 1;
                            }
                            Badmove=false;
                        }
                        System.out.println("Analysis done. Checking moves.");
                        for (int v=0; v<potentialmove.length; v++) {
                            if (potentialmove[v] == 1) {
                                if ((!(v == badmove)) || (!(v==drawmove))) {
                                    // its a decent move.
                                    return v;
                                }
                            }
                        }
                        //too bad. return draw or lose moves.
                        if (!(drawmove ==0)) {
                            return drawmove;
                        }
                        if (!(badmove ==0)) {
                            return badmove;
                        }
                        return ranmove;
                    }  
            } else {
                System.out.println("ERROR: The folder provided in configuration does not exist.");}
        }
    return -2;}
}

public class Main{
	public static void main(String args[]){ 
        System.out.println("___\n | o  _  _ _   _   _\n | | (_ | | | (_| | |\n");
	    System.out.println("By Tom");    
	    int paper[] = {
		    0,0,0,
		    0,0,0,
		    0,0,0
	    };
        String history="";
	    //we got a paper. lets ask who goes first!
	    System.out.println("Heyo, who start first? O (YOU) or X (COMPUTER) or T (TRAIN Ticman)");
		Scanner us = new Scanner(System.in);
		String input = us.nextLine();
		if (input.equals("O")) {
		    onpaper g = new onpaper();
            history="beginO";
            g.ongame(paper,history);
		} else if (input.equals("X")) {
		    onpaper g = new onpaper();
            history="beginX";
            g.ongame(paper,history);
		} else if (input.equals("T")) {
		    onpaper g = new onpaper();
            history="train";
            g.ongame(paper,history);
		} else {
			//What else could it be?
			System.out.println("Apologies. Script has exited as you provied wrong input.");
		}	//we're done I guess?
	}
}

/*investage resign bad moves and making moves*/
