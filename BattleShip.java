import java.util.ArrayList;

public class BattleShip {

    static Integer count_battleships(ArrayList<ArrayList<Character>> board) {
        // check for each cell:
        // if it's a X - check if it's a part of a battle ship that we have already
        // counted: check if top and left neighbour was X, if no then increase the count
        // otherwise continue

        int count = 0;
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(0).size(); j++) {
                if (board.get(i).get(j) == 'X') {
                    if ((i == 0 || board.get(i - 1).get(j) == '.') && (j == 0 || board.get(i).get(j - 1) == '.'))
                        count++;
                }

            }
        }
        return count;
    }

}
