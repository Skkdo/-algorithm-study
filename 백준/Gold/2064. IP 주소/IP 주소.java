import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] networkAddressArray = new int[N][32];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(),".");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());
            int fourth = Integer.parseInt(st.nextToken());
            initNetworkAddressArray(first,second,third,fourth,networkAddressArray[i]);
        }

        int[] mask = new int[32];
        makeMask(networkAddressArray,mask);
        int[] minNetworkAddress = new int[32];
        findMinNetworkAddress(networkAddressArray[0],mask,minNetworkAddress);

        String answer1 = stringFormat(minNetworkAddress);
        String answer2 = stringFormat(mask);

        System.out.println(answer1);
        System.out.println(answer2);
    }

    static void initNetworkAddressArray(int first,int second,int third,int fourth, int[] networkAddress){
        toBinary(first,7,networkAddress);
        toBinary(second,15,networkAddress);
        toBinary(third,23,networkAddress);
        toBinary(fourth,31,networkAddress);
    }

    static void toBinary(int decimal, int endIndex, int[] networkAddress ){
        for(int i=0;i<8;i++){
            if(decimal == 0){
                networkAddress[endIndex--] = 0;
                continue;
            }
            networkAddress[endIndex--] = decimal%2;
            decimal /= 2;
        }
    }

    static void makeMask(int[][] networkAddressArray, int[] mask){
        int n = networkAddressArray.length;
        for(int i=0;i<32;i++){
            int check = networkAddressArray[0][i];
            for(int j=1;j<n;j++){
                check += networkAddressArray[j][i];
            }
            if(check==0||check==n){
                mask[i] = 1;
                continue;
            }
            return;
        }
    }

    static void findMinNetworkAddress(int[] networkAddress,int[] mask,int[] minNetworkAddress){
        for(int i=0;i<32;i++){
            if(mask[i]==1){
                minNetworkAddress[i] = networkAddress[i];
            }
        }
    }

    static String stringFormat(int[] networkAddress){
        StringBuilder builder = new StringBuilder();
        int first =  toDecimal(7,networkAddress);
        int second = toDecimal(15,networkAddress);
        int third = toDecimal(23,networkAddress);
        int fourth = toDecimal(31,networkAddress);
        return builder.append(first+".").append(second+".").append(third+".").append(fourth).toString();
    }

    static int toDecimal(int endIndex, int[] networkAddress){
        int binary=1;
        int result = 0;
        for(int i =1;i<=8;i++){
            result += networkAddress[endIndex--] * binary;
            binary *= 2;
        }
        return result;
    }


}