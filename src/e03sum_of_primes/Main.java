package e03sum_of_primes;

import java.util.Iterator;

public class Main implements Iterator {
    private int last = 0;
    private boolean[] primes = {false, false, true, true, false, true};

    public boolean isPrime(int n) {
        if (primes.length > n) {
            return primes[n];
        }
        boolean[] _primes = new boolean[n + 1];

        for (int i = 0; i < _primes.length; i++) {
            if (i < primes.length) {
                _primes[i] = primes[i];
            } else {
                _primes[i] = true;
            }
        }
        int max = (int) Math.sqrt(n);
        for (int p = 2; p <= max; p++) {
            if (_primes[p]) {
                if (n % p == 0) {
                    _primes[n] = false;
                }
            }
        }
        primes = _primes;
        return _primes[n];
    }

    private Object nextPrime() {
        last += 1;
        if (isPrime(last)) {
            return last;
        } else {
            return nextPrime();
        }
    }

    @Override
    public boolean hasNext() {
        return true; // always
    }


    @Override
    public Object next() {
        return nextPrime();
    }

    @Override
    public void remove() {
        // do nothing
    }

    public static void main(String[] args) {
        Iterator itr = new Main();
        int primeSum = 0;
        for (int i = 0; i < 1000; i++) {
            primeSum += (Integer) itr.next();
        }
        System.out.println(primeSum);
    }
}
