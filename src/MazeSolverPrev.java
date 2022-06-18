//Osasikemwen Ogieva

import java.util.ArrayList;
import java.util.HashMap;

public class MazeSolverPrev {
    FirstMaze fm = new FirstMaze();
    private ArrayList<FirstMaze.Step> toVisit = new ArrayList<>();
    ArrayList<FirstMaze.Step> Visited = new ArrayList<>();
    FirstMaze.Step goal;
    FirstMaze.Step start;
    int stepCount = fm.getButtonCount();

    public MazeSolverPrev() {

    }

    public void go() {
        fm.SetUp();
        goal = fm.getButton(6, 6);
        start = fm.getButton(0, 0);
        solve(start);
    }

    public void solve(FirstMaze.Step start) {
        HashMap<FirstMaze.Step, FirstMaze.Step> backTrack = new HashMap<>();
        backTrack.put(start, null);
        toVisit.add(start);
        Visited.add(start);

        while (!toVisit.isEmpty()) {
            FirstMaze.Step temp = toVisit.remove(0);

            //if temp is the destination, execute reconstructPath
            if (temp.equals(goal)) {
                System.out.println("Goal found");
                printPath(reconstructPath(backTrack, temp));
            }

            else {
                ArrayList<FirstMaze.Step> nextSteps = temp.getTransitions();

                for (int i = 0; i < nextSteps.size(); i++) {
                    if (!inVisited(nextSteps.get(i))) {
                        System.out.println("Not visited");
                        Visited.add(nextSteps.get(i));
                        backTrack.put(nextSteps.get(i), temp);
                        toVisit.add(nextSteps.get(i));
                    }
                }
            }
        }
    }


    public boolean inVisited(FirstMaze.Step x) {
        for (int i = 0; i < Visited.size(); i++) {
            if (Visited.get(i).equals(x)) return true;
        }
        return false;
    }

    public ArrayList<FirstMaze.Step> reconstructPath(HashMap<FirstMaze.Step, FirstMaze.Step> b, FirstMaze.Step goal) {
        ArrayList<FirstMaze.Step> path = new ArrayList<>();
        path.add(goal);
        while (!b.get(goal).equals(start)) {;
            path.add(b.get(goal));
            goal = b.get(goal);
        }
        path.add(start);
        return path;
    }

    public void printPath(ArrayList<FirstMaze.Step> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i).getIi() + " " + path.get(i).getJj());
        }
    }
}
