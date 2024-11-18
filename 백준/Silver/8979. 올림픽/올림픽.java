import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Country {
        int countryNum;
        int gold;
        int silver;
        int bronze;

        Country(int countryNum, int gold, int silver, int bronze) {
            this.countryNum = countryNum;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Country[] countries = new Country[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int countryNum = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            Country country = new Country(countryNum, gold, silver, bronze);
            countries[i] = country;
        }
        sort(countries);
        int rank = getCountryRank(countries, K);
        System.out.println(rank);
    }

    private static int getCountryRank(Country[] countries, int countryNum) {
        int findCountry_gold = -1;
        int findCountry_silver = -1;
        int findCountry_bronze = -1;

        for (int i = 0; i < countries.length; i++) {
            if (countries[i].countryNum == countryNum) {
                findCountry_gold = countries[i].gold;
                findCountry_silver = countries[i].silver;
                findCountry_bronze = countries[i].bronze;
            }
        }
        for (int i = 0; i < countries.length; i++) {
            if (findCountry_gold == countries[i].gold
                    && findCountry_silver == countries[i].silver
                    && findCountry_bronze == countries[i].bronze) {
                return i + 1;
            }
        }
        return -1;
    }

    private static void sort(Country[] countries) {
        for (int i = 0; i < countries.length - 1; i++) {
            for (int j = i + 1; j < countries.length; j++) {
                compare(countries, i, j);
            }
        }
    }

    private static void compare(Country[] countries, int i, int j) {
        Country countryA = countries[i];
        Country countryB = countries[j];

        if (countryA.gold > countryB.gold) {
            return;
        }
        if (countryA.gold < countryB.gold) {
            countries[i] = countryB;
            countries[j] = countryA;
            return;
        }

        if (countryA.silver > countryB.silver) {
            return;
        }
        if (countryA.silver < countryB.silver) {
            countries[i] = countryB;
            countries[j] = countryA;
            return;
        }

        if (countryA.bronze > countryB.bronze) {
            return;
        }
        if (countryA.bronze < countryB.bronze) {
            countries[i] = countryB;
            countries[j] = countryA;
            return;
        }


    }


}