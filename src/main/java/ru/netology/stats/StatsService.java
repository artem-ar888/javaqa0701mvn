package ru.netology.stats;

public class StatsService {

    // 1.
    public long sumSales(long[] sales) {
        long sumAllSales = 0;
        for (long monthSales : sales) {
            sumAllSales = sumAllSales + monthSales;
        }
        return sumAllSales;
        // return Arrays.stream(sales).sum();
    }

    // 2.
    public long averageMonthlySales(long[] sales) {
        return (long) Math.round((double) sumSales(sales) / sales.length);
    }

    // 3.
    public int maxSalesMonthNumber(long[] sales) {
        int maxMonth = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[maxMonth]) {
                maxMonth = i;
            }
        }
        return ++maxMonth;
    }

    // 4.
    public int minSalesMonthNumber(long[] sales) {
        int minMonth = 0; // номер месяца с минимальными продажами среди просмотренных ранее
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) { // значит, в рассматриваемом i-м месяце продаж меньше
                minMonth = i; // запомним его как минимальный
            }
        }
        return minMonth + 1; // месяца нумеруются с 1, а индексы массива с 0, нужно сдвинуть ответ на 1
    }

    // 5.
    public int amountOfMonthsBelowAverage(long[] sales) {
        int sumMonths = 0;
        long averageSales = averageMonthlySales(sales);
        for (long monthSales : sales) {
            if (monthSales < averageSales) {
                sumMonths++;
            }
        }
        return sumMonths;
    }

    // 6.
    public int amountOfMonthsAboveAverage(long[] sales) {
        int sumMonths = 0;
        long averageSales = averageMonthlySales(sales);
        for (long monthSales : sales) {
            if (monthSales > averageSales) {
                sumMonths++;
            }
        }
        return sumMonths;
    }
}
