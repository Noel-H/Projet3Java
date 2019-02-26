public class Main {

    static public void main(String... args) {

        //Menu.principalMenu();

        int resultatScanner=4;
        int numberToFind[]= new int[resultatScanner];
        String numberString="";
        int numberInt;
        int j = resultatScanner;
        int g=10;
        int d=1;

        for(int i=0; i < numberToFind.length; i++){
            numberToFind[i]=(int) (Math.random() * 10);
            System.out.println("À l'emplacement " + i +" du tableau nous avons = " + numberToFind[i]);
            String conversion = Integer.toString(numberToFind[i]);
            numberString=numberString+conversion;

        }

        System.out.println(numberString);
        numberInt=Integer.parseInt(numberString);
        System.out.println(numberInt);


        int playerResultat=3211;



        int resultat[]= new int[resultatScanner];
        int resultattest[]= new int[resultatScanner];


        while (j>=0){

        resultattest[j]  = (playerResultat % g)/d;

            System.out.println(resultattest[j]);
    j--;
    g=g*10;
    d=d*10;

}

        //String str = "1";
        //str = str+"2";
        //System.out.println(str);

    }
}