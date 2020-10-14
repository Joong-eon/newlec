public class Program
{
  public static void main(String[] args)
  {
    int kor1, kor2, kor3;
    int total;
    float avg;
    float abc;

    kor1 = 50;
    kor2 = 70;
    kor3 = 80;

    total = kor1+ kor2 + kor3;
    avg = total/3.0f;
    abc = total%3.0f;

    System.out.printf("totla is %d\n", total);
    System.out.printf("avg is %f\n", avg);
    System.out.printf("abc is %f\n", abc);
    }
}