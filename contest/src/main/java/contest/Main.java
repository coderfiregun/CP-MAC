import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;


public class Main {

    private static final FastScanner fs = new FastScanner();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = fs.nextInt();
        for (int tc = 0; tc < t; tc++) {
            solve(tc);
        }
        out.close();
    }

    private static void solve(int tc) {
        int n = fs.nextInt();
        String s = fs.next();
        int[] firstVis = new int[26];
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            int idx = s.charAt(i) - 'a';
            if (firstVis[idx] == 0) {
                ans += n - i;
                firstVis[idx] = 1;
            }
        }

        out.println(ans);
    }

    static class Pair implements Comparable<Pair> {

        int index, value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int compareTo(Pair o) {
            return Integer.compare(value, o.value);
        }

    }

    static final Random random = new Random();
    static final int mod = 1_000_000_007;

    static void ruffleSort(int[] a) {
        int n = a.length;// shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static long add(long a, long b) {
        return (a + b) % mod;
    }

    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }

    static long mul(long a, long b) {
        return (a * b) % mod;
    }

    static long exp(long base, long exp) {
        if (exp == 0) {
            return 1;
        }
        long half = exp(base, exp / 2);
        if (exp % 2 == 0) {
            return mul(half, half);
        }
        return mul(half, mul(half, base));
    }

    static long[] factorials = new long[2_000_001];
    static long[] invFactorials = new long[2_000_001];

    static void precomputeFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) {
            factorials[i] = mul(factorials[i - 1], i);
        }
        invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
        for (int i = invFactorials.length - 2; i >= 0; i--) {
            invFactorials[i] = mul(invFactorials[i + 1], i + 1);
        }
    }

    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) {
            l.add(i);
        }
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) {
            a[i] = l.get(i);
        }
    }

    static class FastScanner {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

}