package eulerproject.level4.problem84;


public class Board {

    public static final int FIELDS_COUNT = 40;
    private BoardField[] fieldList = new BoardField[FIELDS_COUNT];
    private int currentPos = 0;

    public Board() {

        fieldList[0] = new BoardField("GO", 0);
        fieldList[1] = new BoardField("A1", 1);
        fieldList[2] = new BoardField("CC1", 2);
        fieldList[3] = new BoardField("A2", 3);

        fieldList[4] = new BoardField("T1", 4);
        fieldList[5] = new BoardField("R1", 5);
        fieldList[6] = new BoardField("B1", 6);
        fieldList[7] = new BoardField("CH1", 7);

        fieldList[8] = new BoardField("B2", 8);
        fieldList[9] = new BoardField("B3", 9);
        fieldList[10] = new BoardField("JAIL", 10);
        fieldList[11] = new BoardField("C1", 11);

        fieldList[12] = new BoardField("U1", 12);
        fieldList[13] = new BoardField("C2", 13);
        fieldList[14] = new BoardField("C3", 14);
        fieldList[15] = new BoardField("R2", 15);

        fieldList[16] = new BoardField("D1", 16);
        fieldList[17] = new BoardField("CC2", 17);
        fieldList[18] = new BoardField("D2", 18);
        fieldList[19] = new BoardField("D3", 19);

        fieldList[20] = new BoardField("FP", 20);
        fieldList[21] = new BoardField("E1", 21);
        fieldList[22] = new BoardField("CH2", 22);
        fieldList[23] = new BoardField("E2", 23);

        fieldList[24] = new BoardField("E3", 24);
        fieldList[25] = new BoardField("R3", 25);
        fieldList[26] = new BoardField("F1", 26);
        fieldList[27] = new BoardField("F2", 27);

        fieldList[28] = new BoardField("U2", 28);
        fieldList[29] = new BoardField("F3", 29);
        fieldList[30] = new BoardField("G2J", 30);
        fieldList[31] = new BoardField("G1", 31);

        fieldList[32] = new BoardField("G2", 32);
        fieldList[33] = new BoardField("CC3", 33);
        fieldList[34] = new BoardField("G3", 34);
        fieldList[35] = new BoardField("R4", 35);

        fieldList[36] = new BoardField("CH3", 36);
        fieldList[37] = new BoardField("H1", 37);
        fieldList[38] = new BoardField("T2", 38);
        fieldList[39] = new BoardField("H2", 39);

    }


    public BoardField move(int step) {
        currentPos = (currentPos + step) % FIELDS_COUNT;
        return currentField();
    }

    public BoardField currentField() {
        return fieldList[currentPos];
    }



}
