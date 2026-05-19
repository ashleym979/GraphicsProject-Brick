import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BrickLayout {

    private ArrayList<Brick> bricks = new ArrayList<>();
    private int rows = 30;
    private int cols = 40;

    public BrickLayout(String fileName, int cols, boolean dropAllBricks) {

        this.cols = cols;

        ArrayList<String> data = getFileData(fileName);

        System.out.println("Lines loaded: " + data.size());

        for (String line : data) {
            String[] parts = line.split(",");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);

            bricks.add(new Brick(start, end));
        }
    }

    public void fallingBricks() {

        for (Brick b : bricks) {
            if (canMoveDown(b)) {
                b.incrHeight();
            }
        }
    }

    public boolean checkBrickSpot(int r, int c) {

        for (Brick b : bricks) {

            int row = b.getHeight();

            if (r == row && c >= b.getStart() && c <= b.getEnd()) {
                return true;
            }
        }

        return false;
    }

    private boolean canMoveDown(Brick b) {

        int r = b.getHeight();

        if (r >= rows - 1) return false;

        for (Brick other : bricks) {

            if (other == b) continue;

            int or = other.getHeight();

            if (or == r + 1) {

                if (!(b.getEnd() < other.getStart() || b.getStart() > other.getEnd())) {
                    return false;
                }
            }
        }

        return true;
    }

    public void printSnapshot() {

        for (int r = 0; r < rows; r++) {

            StringBuilder sb = new StringBuilder();

            for (int c = 0; c < cols; c++) {

                boolean filled = false;

                for (Brick b : bricks) {

                    if (b.getHeight() == r &&
                            c >= b.getStart() &&
                            c <= b.getEnd()) {

                        filled = true;
                        break;
                    }
                }

                sb.append(filled ? "1 " : "0 ");
            }

            System.out.println(sb);
        }

        System.out.println();
    }

    public ArrayList<String> getFileData(String fileName) {

        File f = new File(fileName);
        Scanner s;

        ArrayList<String> fileData = new ArrayList<>();

        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            return fileData;
        }

        while (s.hasNextLine()) {
            fileData.add(s.nextLine());
        }

        return fileData;
    }

    public void printBrickLayout() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (checkBrickSpot(r, c)) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}