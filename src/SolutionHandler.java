//Osasikemwen Ogieva

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolutionHandler implements ActionListener{
    private final FirstMaze Maze;

    public SolutionHandler(FirstMaze fm) {
        Maze = fm;
    }

    public void actionPerformed(ActionEvent e) {
        MazeSolver ms = new MazeSolver();
        ms.go(Maze);
        ms.getPath();
        StringBuilder s = new StringBuilder();

        for (int i = ms.getPath().size() - 1; i >= 0 ; i--) {
            s.append(ms.getPath().get(i).getIi()).append(" ").append(ms.getPath().get(i).getJj()).append(" then ");
        }

        JOptionPane.showMessageDialog(Maze, s.toString());
    }
}

class SolutionHandler2 implements ActionListener{
    private final SecondMaze Maze;

    public SolutionHandler2(SecondMaze fm) {
        Maze = fm;
    }

    public void actionPerformed(ActionEvent e) {
        MazeSolver2 ms = new MazeSolver2();
        ms.go(Maze);

        ms.getPath();
        StringBuilder s = new StringBuilder();

        for (int i = ms.getPath().size() - 1; i >= 0 ; i--) {
            s.append(ms.getPath().get(i).getIi()).append(" ").append(ms.getPath().get(i).getJj()).append(" then ");
        }
        JOptionPane.showMessageDialog(Maze, s.toString());

    }
}

class SolutionHandler3 implements ActionListener{
    private final ThirdMaze Maze;

    public SolutionHandler3(ThirdMaze fm) {
        Maze = fm;
    }

    public void actionPerformed(ActionEvent e) {
        MazeSolver3 ms = new MazeSolver3();
        ms.go3(Maze);

        ms.getPath();
        StringBuilder s = new StringBuilder();

        for (int i = ms.getPath().size() - 1; i >= 0 ; i--) {
            s.append(ms.getPath().get(i).getIi()).append(" ").append(ms.getPath().get(i).getJj()).append(" then ");
        }
        JOptionPane.showMessageDialog(Maze, s.toString());

    }
}

