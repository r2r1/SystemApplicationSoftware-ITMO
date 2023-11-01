// импортируем нужные библиотеки
import java.util.Random;
import static java.lang.Math.*;


public class Main {
    public static void main(String[] args) {

        // ШАГ 1
        // создадим константы, ограничивающие массив "c" минимальным и максимальным значиениями
        final int start_c = 6;
        final int final_c = 17;

        // создадим массив "c", длиной равной количестве чисел между минимальным и максимальным
        int [] c = new int[final_c-start_c + 1];

        // создадим счётчик, чтобы обращаться к ячейкам массива по индексам
        int index_c = 0;

        // переберём в цикле все значения от минимального до максимального (включительно), при этом, раскладывая каждое значение в свою ячейки по индексу
        for (int i = start_c; i <final_c + 1; i++) {
            c[index_c]=i;
            index_c++;
        }

        // ШАГ 2
        // создадим константы минимального и максимального значиения случайных чисел
        final float min = -14.0f;
        final float max = 7.0f;

        // так как длина массива фиксированная, то создадим константу, равную длине массива "x"
        int len_x = 12;

        // создадим массив "c", длиной 12
        double  [] x = new double [len_x+1];
        // создать поток
        Random random = new Random();
        float random_value; // тут будем хранить положительное рандомное значение, которое надо закастомить

        // переберём в цикле все значения от минимального до максимального (включительно), при этом, раскладывая каждое значение в свою ячейки по индексу
        for (int i=0; i<len_x; i++) {
            random_value = random.nextFloat();
            x[i] =  min + random_value * (max - min);
        }
        // ШАГ 3

        // создадим двумерный массив c размером 12*12
        final  int N = 12;
        double  [][] mas = new double [N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j< N; j++){
                // условие 1
                if (c[i] == 11) mas[i][j] = asin(pow(E, cbrt(-(abs(x[j])))));
                // условие 2
                // есть ли c[i] в массиве arr?
                int [] arr = {7, 9, 12, 14, 15, 16};
                boolean chislo_v_massive = false;
                for (int k: arr)
                    if (k == c[i]) {
                        chislo_v_massive = true;
                        break;
                    }
                if (chislo_v_massive) mas[i][j] = cbrt(tan(sin(x[j])));
                    // условие 3
                else mas[i][j] = pow((0.25 * asin((double)2/3 * pow( (x[j]-3.5)/21,2 ))),tan(asin(cos(x[j])))) ;
            }
        }
        // ШАГ 4

        for (int i = 0; i < N; i++) {
            for(int j = 0; j<N; j++){
                System.out.printf("%.3f\t", mas[i][j] );
                System.out.print("  ");
            }
            System.out.print("\n");
        }

    }
}
