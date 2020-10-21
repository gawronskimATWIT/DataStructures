package List;

public class quizScores {


    public static void main(String[] args) {
        ListInterface <Double> quizScores = new AList <>();
    //    quizScores.removeLowest();
        //quizScores.quizAverage();
    }



    public void removeLowest(AList<Double> quizScores){
        Double lowest = quizScores.getEntry(0);
        for(int i=0; i < quizScores.getLength(); i++){
      if(quizScores.getEntry(i)<lowest){
          lowest = quizScores.getEntry(i);
      }
        }
        quizScores.remove(lowest);
    }

    public double quizAverage(AList<Double> quizScores){
        double average=0;
        for(int i=0; i<quizScores.getLength();i++){
            average= average + quizScores.getEntry(i);
        }
        average = average / quizScores.getLength();

        return average;
    }





}
