    //Osasikemwen Ogieva
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JButton;

//Display Class
public class FirstMaze extends JFrame implements FinalProjectMazes{
    Container contentPane;
    private int buttonCount = 2; //initialized incorrectly. Reading from the file will fix it.
    private Step [][] steps;
    private String title;
    private String spec1;
    private String spec2;
    private String spec3;

    public void SetUp() {

        try {
            readFile();
        }
        catch (FileNotFoundException e) {
            System.out.println("The program can not find the specified file: " + e);
            e.printStackTrace();
        }

        //sets up container and sets layout grid
        contentPane = this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(new GridLayout(buttonCount + 1, buttonCount));
        this.setTitle(title);

        steps = new Step[buttonCount][buttonCount];
        for (int i = 0; i < buttonCount; i++) {
            for (int j = 0; j < buttonCount; j++) {
                //create and add buttons to the container
                //for the start button
                if (i == 0 && j == 0) {
                    steps[i][j] = new Step(i, j, spec1);
                    contentPane.add(steps[i][j]);
                }
                //for the goal button
                else if (i == buttonCount - 1 && j == buttonCount - 1) {
                    steps[i][j] = new Step(i, j, spec2);
                    contentPane.add(steps[i][j]);
                }
                //every other button
                else {
                    steps[i][j] = new Step(i, j, spec3);
                    contentPane.add(steps[i][j]);
                }
            }
        }
        executeAddTransitions();
        Panel();
    }

    public void readFile() throws FileNotFoundException {
        File file = new File("FirstMaze_File");
        Scanner sc = new Scanner(file);

        while (sc.hasNextInt()) {
            buttonCount = sc.nextInt();
        }

        while (sc.hasNextLine()) {
            sc.next();
            title = sc.nextLine();
            spec1 = sc.nextLine();
            spec2 = sc.nextLine();
            spec3 = sc.nextLine();
        }

    }

    public void Panel() {
        JPanel panel = new JPanel();
        panel.setSize(400, 40);
        panel.setLayout(new FlowLayout());
        contentPane.add(panel);

        JButton button = new JButton("Switch Game");
        panel.add(button);
        SwitchHandler h = new SwitchHandler();
        button.addActionListener(h);

        JButton button1 = new JButton("See Solution");
        panel.add(button1);
        SolutionHandler s = new SolutionHandler(this);
        button1.addActionListener(s);
    }

    public void executeAddTransitions() {
        for (int i = 0; i < buttonCount; i++) {
            for (int j = 0; j < buttonCount; j++) {
                steps[i][j].addTransitions(i, j);
            }
        }
    }

    public Step getButton(int a, int b) {
        return steps[a][b];
    }

    public int getButtonCount(){
        return buttonCount;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Button Class: Creates each button.
// Location Class.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    class Step extends JButton implements ActionListener {
        private final int ii; //number of rows
        private final int jj; // and columns
        private final String type;
        private final ArrayList <Step> transitions = new ArrayList<>();
        private final ArrayList <Step> pressed = new ArrayList<>();
        private boolean enabled;

        public Step (int i, int j, String t) {
            super();
            ii = i;
            jj = j;
            type = t;
            this.addActionListener(this);
            if (type.equals("start")) {  //set the start button enabled
                setEnabled(true);
                enabled = true;
            }
            else {
                setEnabled(false);  //set everything else disabled
            }
        }

        public int getIi () {
            return ii;
        }

        public int getJj (){
            return jj;
        }

        public ArrayList<Step> getTransitions() {
            return transitions;
        }

        public void addTransitions(int a, int b) {
            int add = Step.pickN(a, b);

            if (a + add < 7) { //down
                transitions.add(steps[a + add][b]);
            }

            if (a - add >= 0) { //up
                transitions.add(steps[a - add][b]);
            }

            if (b + add < 7) { //right
                transitions.add(steps[a][b + add]);
            }

            if (b - add >= 0) { //left
                transitions.add(steps[a][b - add]);
            }
        }

        public void paintComponent (Graphics g) {
            super.paintComponent(g);
            InscribeButtons(); //inscribe the buttons
        }

        public void InscribeButtons() {
            int a;
            if (type.equals("start")) {   //set "start" text on the start button, and 6
                a = 6;
                setText("Start: " + a);
            }
            else if (type.equals("goal")) {  //set "goal" text on the "goal" button,
                setText("Goal");
            }
            else {
                a = pickN(ii, jj);  //set the appropriate numbers on each button: call pickN
                setText("" + a);
            }
        }

        public static int pickN (int i, int j) {
            if ((i == 0 && j == 4) || (i == 0 && j == 0)) return 6;
            if ((i == 0 && j == 6) || (i == 1 && j == 1) || (i == 3 && j == 5) ||
                (i == 5 && j == 1) || (i == 5 && j == 6)|| (i == 6 && j == 1)) return 5;

            if ((i == 0 && j == 3) || (i == 1 && j == 3)|| (i == 1 && j == 4)|| (i == 1 && j == 5)|| (i == 2 && j == 5)
                || (i == 3 && j == 1)|| (i == 4 && j == 0)|| (i == 4 && j == 1)|| (i == 4 && j == 2) || (i == 4 && j == 6)
                || (i == 5 && j == 2)|| (i == 6 && j == 4) || (i == 6 && j == 5)) return 4;

            if ((i == 0 && j == 1) || (i == 1 && j == 0)|| (i == 2 && j == 0)|| (i == 2 && j == 1)|| (i == 2 && j == 3)
                || (i == 2 && j == 4)|| (i == 3 && j == 0)|| (i == 3 && j == 6)|| (i == 4 && j == 4) || (i == 5 && j == 4)
                || (i == 6 && j == 0)) return 3;

            if ((i == 0 && j == 2) || (i == 0 && j == 5)|| (i == 1 && j == 2)|| (i == 2 && j == 2)|| (i == 2 && j == 6)
                 || (i == 3 && j == 3)|| (i == 3 && j == 4)|| (i == 4 && j == 3)|| (i == 4 && j == 5) || (i == 5 && j == 0)
                 || (i == 5 && j == 3) || (i == 5 && j == 5)|| (i == 6 && j == 2)) return 2;

            if ((i == 1 && j == 6) || (i == 3 && j == 2) || (i == 6 && j == 3)) return 1;

            else return 0;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            pressed.add(this);

            if (enabled){
                for(int i = 0; i < buttonCount; i++){
                    for(int j = 0; j < buttonCount; j++){
                        steps[i][j].setEnabled(false);
                        enabled = false;
                        steps[i][j].setBackground(null);
                    }
                }
                enabled = true ;
                setBackground(Color.DARK_GRAY);

                for (Step transition : transitions) {
                    transition.setEnabled(true);
                    int a = transition.getIi();
                    int b = transition.getJj();
                    steps[a][b].enabled = true;
                }
            }
        }
    }
}