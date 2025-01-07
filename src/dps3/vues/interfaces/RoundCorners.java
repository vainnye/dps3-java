package dps3.vues.interfaces;

public interface RoundCorners {
    public int getRoundTopLeft();
    public int getRoundTopRight();
    public int getRoundBottomRight();
    public int getRoundBottomLeft();
    public void setRounds(int roundCorner);
    public void setRounds(int topLeft, int topRight, int bottomRight, int bottomLeft);
    public void setRoundTopLeft(int roundTopLeft);
    public void setRoundTopRight(int roundTopRight);
    public void setRoundBottomRight(int roundBottomRight);
    public void setRoundBottomLeft(int roundBottomLeft);
}
