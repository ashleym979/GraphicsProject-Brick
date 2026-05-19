public class Brick {
    private int start;
    private int end;
    private int height;
    private int length;

    public Brick(int start, int end) {
        this.start = start;
        this.end = end;
        this.height = 0;
        length = end - start;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getLength(){
        return length;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void incrHeight(){
        height ++;
    }

    public int getHeight() {
        return height;
    }

    public String toString(){
        return (start + " " + end + " " + height);
    }
}