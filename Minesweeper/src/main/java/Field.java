
public class Field {
    int size;
    int[][] field;
    int mines;

    public Field(int koko,int pommit, int[][] kentta) {
        this.size = koko;
        this.mines = pommit;
        this.field = kentta;
        for (int i = 0; i < kentta.length; i++) {
            for (int j = 0; j < kentta.length; j++) {
                kentta[i][j]=0;
            }
        }
    }
    
    boolean 
    
}
