public class PatternTutorial {
    public static void main(String[] args) {
        int n = 7;
        int m = 4;
        solidTrianlge(n, m);
        System.out.println(" ");
        hollowTriangle(n, m);
        System.out.println(" ");
        halfTriangle(n, m);
        System.out.println(" ");
        invertedHalfTriangle(n, m);
        System.out.println(" ");
        leftHalfTriangle(n);
        System.out.println(" ");
        halfNumbers(n);
        System.out.println(" ");
        FloydTriangle(n);
        System.out.println(" ");
        _01Triangle(n);
        System.out.println(" ");
        numberPyramid(n);
        System.out.println(" ");
        palindromicNumberPyramid(n);
    }

    static void solidTrianlge(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void hollowTriangle(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void halfTriangle(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void invertedHalfTriangle(int n, int m) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void leftHalfTriangle(int n) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (n - i); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void halfNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void FloydTriangle(int n) {
        int k = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(k + " ");
                k++;
            }
            System.out.println();
        }
    }

    static void _01Triangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((i + j) % 2 == 0 ? 1 : 0);
            }
            System.out.println();
        }
    }

    static void fibonacciTriangle(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(a + " ");
                int next = a + b;
                a = b;
                b = next;
            }
            System.out.println();
        }
    }

    static void numberPyramid(int n) {
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            for (int j = 0; j <= n - i; j++) {
                System.out.print(n - i + 1);
            }
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    static void palindromicNumberPyramid(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = i - 1; j > 1; j--) {
                System.out.print(j);
            }
            for (int j = 1; j < i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
