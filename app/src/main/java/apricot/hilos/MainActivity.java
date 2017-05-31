package apricot.hilos;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText entrada;
    private TextView salida;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = (EditText) findViewById(R.id.entrada);
        salida = (TextView) findViewById(R.id.salida);
    }

    public void calcularOperacion(View view) {
        int n = Integer.parseInt(entrada.getText().toString());
        salida.append(n + "! = ");
        int res = factorial(n);
        salida.append(res + "\n");
        int resp = fibonacci(n);
        salida.append("Fibonacci = " + resp + "\n");
    }

    public int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            SystemClock.sleep(1000);
        }

        return res;

    }

    public int fibonacci(int n) {
        if (n > 1) {
            SystemClock.sleep(1000);
            return (n - 1) + (n - 2);

        } else if (n == 1) {  // caso base
            SystemClock.sleep(1000);
            return 1;
        } else if (n == 0) {  // caso base
            SystemClock.sleep(1000);
            return 0;
        } else { //error
            SystemClock.sleep(1000);
            return -1;
        }
    }


    class MiThread extends Thread {
        private int n, res, resp;

        public MiThread(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            res = factorial(n);
            resp = fibonacci(n);
            salida.append("Factorial: " + res + "\n Fibonacci: " + resp);
        }
    }
}